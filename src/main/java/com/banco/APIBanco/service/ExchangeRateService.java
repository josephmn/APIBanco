package com.banco.APIBanco.service;

import com.banco.APIBanco.entity.ExchangeRate;
import com.banco.APIBanco.entity.model.ApiResponse;
import com.banco.APIBanco.error.ExchangeRateException;

import java.util.List;

public interface ExchangeRateService {
    List<ExchangeRate> findAllExchangeRate();
    ApiResponse saveExchangeRate(ExchangeRate exchangeRate) throws ExchangeRateException;
    ExchangeRate updateExchangeRate(Long id, ExchangeRate exchangeRate);
    void deleteExchangeRate(Long id);
}
