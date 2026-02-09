package br.com.maikonspo.desafio.domain.usecase.contract;

import br.com.maikonspo.desafio.application.dto.CadastrarVeiculoCommand;
import br.com.maikonspo.desafio.domain.model.Veiculo;

public interface SalvarVeiculoUsecase {
   Veiculo execute(CadastrarVeiculoCommand cmd);
}
