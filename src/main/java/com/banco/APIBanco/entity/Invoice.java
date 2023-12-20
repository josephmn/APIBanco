package com.banco.APIBanco.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="tb_Invoice")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String invoice;
    private BigDecimal amount;
    private BigDecimal rate;
    private String sourceCurrency;
    private String targetCurrency;
    @CreationTimestamp
    private Date createAt;
    @CreationTimestamp
    private Date updateAt;
}
