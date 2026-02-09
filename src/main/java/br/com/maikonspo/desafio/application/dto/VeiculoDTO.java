package br.com.maikonspo.desafio.application.dto;

public record VeiculoDTO(
        Long id,
        String proprietario,
        String cpf,
        String placa,
        String chassi,
        String marca,
        String modelo,
        boolean licenciado
) {
}
