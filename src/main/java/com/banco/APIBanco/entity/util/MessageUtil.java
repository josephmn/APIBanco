package com.banco.APIBanco.entity.util;

import lombok.Getter;

@Getter
public enum MessageUtil {

    OK("Successful process", 200), //Proceso exitoso
    CREATED("Successful creation", 201), //Creación exitosa
    UPDATE("Successful update", 200), //Actualización exitosa
    DELETED("Successful removal", 200), //Eliminación exitosa
    BADREQUEST("There was an error in your request", 400), //Hubo un error en su petición
    NOTFOUND("There are no records", 404), //No existen registros
    INTERNALERROR("Internal server error", 500), //Error interno en el servidor
    CONFLICT("There was a conflict in your request", 409), //Hubo un conflicto en su petición
    ;

    private String key;
    private int code;

    MessageUtil(String key, int code) {
        this.key = key;
        this.code = code;
    }
}
