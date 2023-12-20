package com.banco.APIBanco.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExchangeRateException extends RuntimeException {

    public ExchangeRateException(String message) {
        super(message);
    }
}
