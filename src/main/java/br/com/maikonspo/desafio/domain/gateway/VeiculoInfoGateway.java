package br.com.maikonspo.desafio.domain.gateway;

import br.com.maikonspo.desafio.domain.model.valueobject.VeiculoInfo;

public interface VeiculoInfoGateway {
    VeiculoInfo obterPorPlaca(String placa);
}
