package br.com.maikonspo.desafio.domain.gateway;

import br.com.maikonspo.desafio.domain.model.Veiculo;

public interface VeiculoGateway{
    Veiculo save(Veiculo veiculo);
    boolean existsByPlaca(String placa);
    boolean existsByCpf(String cpf);
}
