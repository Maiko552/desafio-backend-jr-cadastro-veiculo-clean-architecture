package br.com.maikonspo.desafio.infra.persistence.jpa;

import br.com.maikonspo.desafio.infra.persistence.entities.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaVeiculoRepository extends JpaRepository<VeiculoEntity, Long> {
    boolean existsByPlaca(String placa);
    boolean existsByCpf(String cpf);
}
