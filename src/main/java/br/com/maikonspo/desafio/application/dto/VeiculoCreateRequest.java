package br.com.maikonspo.desafio.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record VeiculoCreateRequest(
        @NotBlank(message = "proprietario é obrigatório")
        @Size(max = 150, message = "proprietario deve ter no máximo 150 caracteres")
        String proprietario,

        @NotBlank(message = "cpf é obrigatório")
        @Pattern(
                regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}",
                message = "cpf deve estar no formato 000.000.000-00"
        )
        String cpf,

        @NotBlank(message = "placa é obrigatória")
        @Pattern(
                regexp = "^[A-Z]{3}\\d{4}$|^[A-Z]{3}\\d[A-Z]\\d{2}$",
                message = "placa inválida (ex: ABC1234 ou ABC1D23)"
        )
        String placa
) {}
