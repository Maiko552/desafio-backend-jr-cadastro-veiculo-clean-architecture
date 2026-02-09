package br.com.maikonspo.desafio.infra.persistence.adapter;

import br.com.maikonspo.desafio.domain.gateway.VeiculoGateway;
import br.com.maikonspo.desafio.domain.model.Veiculo;
import br.com.maikonspo.desafio.infra.persistence.entities.VeiculoEntity;
import br.com.maikonspo.desafio.application.mapper.VeiculoEntityMapper;
import br.com.maikonspo.desafio.infra.persistence.jpa.JpaVeiculoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class VeiculoRepositoryAdapter implements VeiculoGateway {

    private final JpaVeiculoRepository jpa;

    public VeiculoRepositoryAdapter(JpaVeiculoRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public boolean existsByPlaca(String placa) {
        return jpa.existsByPlaca(placa);
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return jpa.existsByCpf(cpf);
    }

    @Override
    @Transactional
    public Veiculo save(Veiculo veiculo) {
        VeiculoEntity entity = VeiculoEntityMapper.toEntity(veiculo);
        VeiculoEntity salvo = jpa.save(entity);
        return VeiculoEntityMapper.toDomain(salvo);
    }
}
