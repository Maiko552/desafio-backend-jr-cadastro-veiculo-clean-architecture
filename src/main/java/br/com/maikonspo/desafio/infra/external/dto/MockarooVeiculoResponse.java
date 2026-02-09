package br.com.maikonspo.desafio.infra.external.dto;

public record MockarooVeiculoResponse(
        String marca,
        String modelo,
        String chassi,
        Boolean licenciado
) {}
