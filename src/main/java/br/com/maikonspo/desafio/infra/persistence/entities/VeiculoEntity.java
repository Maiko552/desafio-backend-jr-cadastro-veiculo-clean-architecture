package br.com.maikonspo.desafio.infra.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "veiculo")
public class VeiculoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150)
    private String proprietario;
    @Column(nullable = false, length = 20)
    private String cpf;
    @Column(nullable = false, length = 10)
    private String placa;
    @Column(nullable = false, length = 50)
    private String chassi;
    @Column(nullable = false, length = 100)
    private String marca;
    @Column(nullable = false, length = 150)
    private String modelo;
    @Column(nullable = false)
    private boolean licenciado;
}
