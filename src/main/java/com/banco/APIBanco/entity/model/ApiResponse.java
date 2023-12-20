package com.banco.APIBanco.entity.model;

import com.banco.APIBanco.entity.util.MessageUtil;
import com.banco.APIBanco.error.ErrorExchangeRate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private boolean error = false;
    private String mensaje = "";
    private int code = -1;
    private Object data = null;
    private ErrorExchangeRate errorExchangeRate = null;

    public ApiResponse createErrorResponseExchangeRate(String errorMessage) {
        this.setError(true);
        this.setMensaje(MessageUtil.BADREQUEST.getKey());
        this.setCode(MessageUtil.BADREQUEST.getCode());
        this.setErrorExchangeRate(new ErrorExchangeRate(errorMessage));
        return this;
    }

    public ApiResponse createSuccessResponseExchangeRate(Object data) {
        this.setMensaje(MessageUtil.CREATED.getKey());
        this.setCode(MessageUtil.CREATED.getCode());
        this.setData(data);
        this.setErrorExchangeRate(null);
        return this;
    }

}
