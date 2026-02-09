package br.com.maikonspo.desafio.presentation.handler;

import br.com.maikonspo.desafio.domain.exception.*;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(DadosObrigatoriosException.class)
    public ResponseEntity<ApiError> dadosObrigatorios(DadosObrigatoriosException ex) {
        return ResponseEntity.badRequest().body(new ApiError(ex.getMessage()));
    }

    @ExceptionHandler({PlacaJaCadastradaException.class, CpfJaCadastradoException.class})
    public ResponseEntity<ApiError> conflito(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiError(ex.getMessage()));
    }

    @ExceptionHandler(FalhaApiExternaException.class)
    public ResponseEntity<ApiError> apiExterna(FalhaApiExternaException ex) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new ApiError(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex) {
        String msg = ex.getBindingResult().getFieldErrors().stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .findFirst()
                .orElse("Dados inválidos");
        return ResponseEntity.badRequest().body(new ApiError(msg));
    }

}
