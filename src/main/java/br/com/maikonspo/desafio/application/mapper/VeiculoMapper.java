package br.com.maikonspo.desafio.application.mapper;

import br.com.maikonspo.desafio.domain.model.Veiculo;
import br.com.maikonspo.desafio.application.dto.VeiculoDTO;

public final class VeiculoMapper {

    private VeiculoMapper() {}

    public static VeiculoDTO toDTO(Veiculo veiculo) {

        if (veiculo == null) return null;

        return new VeiculoDTO(
                veiculo.getId(),
                veiculo.getProprietario(),
                veiculo.getCpf(),
                veiculo.getPlaca(),
                veiculo.getChassi(),
                veiculo.getMarca(),
                veiculo.getModelo(),
                veiculo.isLicenciado()
        );
    }

    public static Veiculo toDomain(VeiculoDTO dto) {

        if (dto == null) return null;

        return new Veiculo(
                dto.id(),
                dto.proprietario(),
                dto.cpf(),
                dto.placa(),
                dto.chassi(),
                dto.marca(),
                dto.modelo(),
                dto.licenciado()
        );
    }


}
