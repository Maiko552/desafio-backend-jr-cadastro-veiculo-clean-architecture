package br.com.maikonspo.desafio.application.mapper;

import br.com.maikonspo.desafio.domain.model.Veiculo;
import br.com.maikonspo.desafio.infra.persistence.entities.VeiculoEntity;

public final class VeiculoEntityMapper {

    private VeiculoEntityMapper() {}

    public static VeiculoEntity toEntity(Veiculo veiculo) {
        if (veiculo == null) return null;

        VeiculoEntity entity = new VeiculoEntity();
        entity.setId(veiculo.getId());
        entity.setProprietario(veiculo.getProprietario());
        entity.setCpf(veiculo.getCpf());
        entity.setPlaca(veiculo.getPlaca());
        entity.setChassi(veiculo.getChassi());
        entity.setMarca(veiculo.getMarca());
        entity.setModelo(veiculo.getModelo());
        entity.setLicenciado(veiculo.isLicenciado());

        return entity;
    }

    public static Veiculo toDomain(VeiculoEntity entity) {
        if (entity == null) return null;

        return new Veiculo(
                entity.getId(),
                entity.getProprietario(),
                entity.getCpf(),
                entity.getPlaca(),
                entity.getChassi(),
                entity.getMarca(),
                entity.getModelo(),
                entity.isLicenciado()
        );
    }
}
