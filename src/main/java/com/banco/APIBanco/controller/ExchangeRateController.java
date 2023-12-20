package com.banco.APIBanco.controller;

import com.banco.APIBanco.entity.ExchangeRate;
import com.banco.APIBanco.entity.model.ApiResponse;
import com.banco.APIBanco.error.ExchangeRateException;
import com.banco.APIBanco.service.ExchangeRateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/ExchangeRate")
@Tag(name = "Exchange Rate", description = "the exchange rate API")
@SecurityRequirement(name = "APIPichincha")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @Operation(summary = "List Exchange Rate", description = "This can only be done by the user who enters their JWT.")
    @GetMapping("/findAllExchangeRate")
    public List<ExchangeRate> findAllExchangeRate() {
        return exchangeRateService.findAllExchangeRate();
    }

    /*
    @Operation(summary = "Create Exchange Rate", description = "This can only be done by the user who enters their JWT.")
    @PostMapping("/saveExchangeRate")
    public ExchangeRate saveExchangeRate(@RequestBody ExchangeRate exchangeRate) {
        return exchangeRateService.saveExchangeRate(exchangeRate);
    }
    */

    @Operation(summary = "Create Exchange Rate", description = "This can only be done by the user who enters their JWT.")
    @PostMapping("/saveExchangeRate")
    public ApiResponse saveExchangeRate(@RequestBody ExchangeRate exchangeRate) throws ExchangeRateException {
        return exchangeRateService.saveExchangeRate(exchangeRate);
    }

    @Operation(summary = "Update Exchange Rate", description = "This can only be done by the user who enters their JWT.")
    @PutMapping("/updateExchangeRate/{id}")
    public ExchangeRate updateExchangeRate(@PathVariable Long id, @RequestBody ExchangeRate exchangeRate) {
        return exchangeRateService.updateExchangeRate(id, exchangeRate);
    }

    @Operation(summary = "Delete Exchange Rate", description = "This can only be done by the user who enters their JWT.")
    @DeleteMapping("/deleteExchangeRate/{id}")
    public String deleteExchangeRate(@PathVariable Long id) {
        exchangeRateService.deleteExchangeRate(id);
        return "Successfully deleted";
    }
}
