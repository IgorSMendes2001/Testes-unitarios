package br.com.igor.api.resources.exceptions;

public class DataIntegrityViolationException extends RuntimeException{
    public DataIntegrityViolationException(String message){
        super(message);
    }
}
