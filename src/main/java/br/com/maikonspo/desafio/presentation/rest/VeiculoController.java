package br.com.maikonspo.desafio.presentation.rest;


import br.com.maikonspo.desafio.application.dto.CadastrarVeiculoCommand;
import br.com.maikonspo.desafio.application.dto.VeiculoCreateRequest;
import br.com.maikonspo.desafio.application.dto.VeiculoDTO;
import br.com.maikonspo.desafio.application.mapper.VeiculoMapper;
import br.com.maikonspo.desafio.domain.model.Veiculo;
import br.com.maikonspo.desafio.domain.usecase.contract.SalvarVeiculoUsecase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final SalvarVeiculoUsecase salvarVeiculosUsecase;

    public VeiculoController(SalvarVeiculoUsecase salvarVeiculosUsecase) {
        this.salvarVeiculosUsecase = salvarVeiculosUsecase;
    }


    @PostMapping
    public ResponseEntity<VeiculoDTO> salvar(@Valid @RequestBody VeiculoCreateRequest req) {
        CadastrarVeiculoCommand cmd = new CadastrarVeiculoCommand(
                req.proprietario(), req.cpf(), req.placa()
        );
        Veiculo salvo = salvarVeiculosUsecase.execute(cmd);
        return ResponseEntity.status(201).body(VeiculoMapper.toDTO(salvo));
    }


}
