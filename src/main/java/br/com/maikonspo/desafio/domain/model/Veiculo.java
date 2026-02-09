package br.com.maikonspo.desafio.domain.model;


public class Veiculo {
    private Long id;
    private String proprietario;
    private String cpf;
    private String placa;
    private String chassi;
    private String marca;
    private String modelo;
    private boolean licenciado;


    public Veiculo(Long id, String proprietario, String cpf, String placa, String chassi, String marca, String modelo, boolean licenciado) {
        this.id = id;
        this.proprietario = proprietario;
        this.cpf = cpf;
        this.placa = placa;
        this.chassi = chassi;
        this.marca = marca;
        this.modelo = modelo;
        this.licenciado = licenciado;
    }

    public Long getId() {
        return id;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isLicenciado() {
        return licenciado;
    }

    public void setIslicenciado(boolean licenciado) {
        this.licenciado = licenciado;
    }
}
