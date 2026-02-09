package br.com.maikonspo.desafio.domain.model.valueobject;

public record VeiculoInfo(
        String marca,
        String modelo,
        String chassi,
        boolean licenciado
) {}
