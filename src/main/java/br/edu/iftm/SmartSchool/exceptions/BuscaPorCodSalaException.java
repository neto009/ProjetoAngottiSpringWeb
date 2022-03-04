package br.edu.iftm.SmartSchool.exceptions;

public class BuscaPorCodSalaException extends Exception{

    public BuscaPorCodSalaException(String id){
        super("Codigo de sala nao encontrada " + id);
    }
}
