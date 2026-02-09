package br.com.maikonspo.desafio.domain.exception;

public class DadosObrigatoriosException extends RuntimeException {
    public DadosObrigatoriosException() {
        super("Dados obrigatórios");
    }
}
