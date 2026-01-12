package com.maria.controle_gastos_backend.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id) {
         super("Resource not found id " + id );
    }
}
