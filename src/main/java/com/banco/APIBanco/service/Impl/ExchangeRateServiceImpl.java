package com.banco.APIBanco.service.Impl;

import com.banco.APIBanco.entity.ExchangeRate;
import com.banco.APIBanco.entity.model.ApiResponse;
import com.banco.APIBanco.entity.util.MessageUtil;
import com.banco.APIBanco.error.ErrorExchangeRate;
import com.banco.APIBanco.error.ExchangeRateException;
import com.banco.APIBanco.repository.ExchangeRateRepository;
import com.banco.APIBanco.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Autowired
    ExchangeRateRepository exchangeRateRepository;
    ApiResponse apiResponse = new ApiResponse();

    @Override
    public List<ExchangeRate> findAllExchangeRate() {
        return exchangeRateRepository.findAll();
    }

    @Override
    public ApiResponse saveExchangeRate(ExchangeRate exchangeRate) throws ExchangeRateException {
        // Filtros
        if (exchangeRate == null) {
            return apiResponse.createErrorResponseExchangeRate("ExchangeRate object is null.");
        }

        if (exchangeRate.getSourceCurrency() == null || exchangeRate.getSourceCurrency().isEmpty()) {
            return apiResponse.createErrorResponseExchangeRate("Source Currency property is empty or does not exist.");
        }

        if (exchangeRate.getTargetCurrency() == null || exchangeRate.getTargetCurrency().isEmpty()) {
            return apiResponse.createErrorResponseExchangeRate("Target Currency property is empty or does not exist.");
        }

        if (exchangeRate.getRate() == null || exchangeRate.getRate().compareTo(BigDecimal.ZERO.doubleValue()) == 0) {
            //throw new ExchangeRateException("Rate property is empty");
            return apiResponse.createErrorResponseExchangeRate("Rate property is empty, does not exist or equal 0.");
        }
        // Guardamos
        var savedExchangeRate = exchangeRateRepository.save(exchangeRate);
        return apiResponse.createSuccessResponseExchangeRate(savedExchangeRate);
    }

    @Override
    public ExchangeRate updateExchangeRate(Long id, ExchangeRate exchangeRate) {
        ExchangeRate exchangeRateDB = exchangeRateRepository.findById(id).get();
        if (Objects.nonNull(exchangeRate.getSourceCurrency()) && !"".equalsIgnoreCase(exchangeRate.getSourceCurrency())) {
            exchangeRateDB.setSourceCurrency(exchangeRate.getSourceCurrency());
        }
        if (Objects.nonNull(exchangeRate.getTargetCurrency()) && !"".equalsIgnoreCase(exchangeRate.getTargetCurrency())) {
            exchangeRateDB.setTargetCurrency(exchangeRate.getTargetCurrency());
        }
        if (exchangeRate.getRate() != null && exchangeRate.getRate().compareTo(BigDecimal.ZERO.doubleValue()) > 0) {
            exchangeRateDB.setRate(exchangeRate.getRate());
        }
        // Actualizar manualmente el campo updateAt
        exchangeRateDB.setUpdateAt(new Date());

        return exchangeRateRepository.save(exchangeRateDB);
    }

    @Override
    public void deleteExchangeRate(Long id) {
        exchangeRateRepository.deleteById(id);
    }
}
