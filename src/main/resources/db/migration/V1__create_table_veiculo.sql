CREATE TABLE veiculo (
   id BIGSERIAL PRIMARY KEY,
   proprietario VARCHAR(150) NOT NULL,
   cpf VARCHAR(20) NOT NULL,
   placa VARCHAR(10) NOT NULL,
   marca VARCHAR(100) NOT NULL,
   modelo VARCHAR(150) NOT NULL,
   chassi VARCHAR(50) NOT NULL,
   licenciado BOOLEAN NOT NULL,
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE UNIQUE INDEX uk_veiculo_placa ON veiculo (placa);
CREATE UNIQUE INDEX uk_veiculo_cpf ON veiculo (cpf);
