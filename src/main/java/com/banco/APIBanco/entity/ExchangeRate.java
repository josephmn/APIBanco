package com.banco.APIBanco.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "tb_ExchangeRate")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonProperty
    //@NotBlank
    @NotBlank(message = "Please add the sourceCurrency")
    private String sourceCurrency;

    @JsonProperty
    @NotBlank(message = "Please add the targetCurrency")
    private String targetCurrency;

    @JsonProperty
    @NotBlank(message = "Please add the rate")
    private Double rate;

    @CreationTimestamp
    private Date createAt;

    //@Past
    @CreationTimestamp
    private Date updateAt;
}
