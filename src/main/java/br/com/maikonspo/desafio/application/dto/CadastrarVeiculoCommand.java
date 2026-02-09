package br.com.maikonspo.desafio.application.dto;

public record CadastrarVeiculoCommand(
        String proprietario,
        String cpf,
        String placa
) {}
