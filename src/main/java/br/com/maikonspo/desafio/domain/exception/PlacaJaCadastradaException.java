package br.com.maikonspo.desafio.domain.exception;

public class PlacaJaCadastradaException extends RuntimeException{
    public PlacaJaCadastradaException(String placa){
        super("Placa já cadastrada: " + placa);
    }
}
