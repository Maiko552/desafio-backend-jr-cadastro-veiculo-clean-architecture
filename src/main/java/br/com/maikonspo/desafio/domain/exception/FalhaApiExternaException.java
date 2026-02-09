package br.com.maikonspo.desafio.domain.exception;

public class FalhaApiExternaException extends RuntimeException {
    public FalhaApiExternaException(Throwable cause) {
        super("Falha ao consultar API externa", cause);
    }
}
