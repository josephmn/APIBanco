package com.banco.APIBanco.service;

import com.banco.APIBanco.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    List<Invoice> findAllInvoice();
    Invoice saveInvoice(Invoice invoice);
    Invoice updateInvoice(Long id, Invoice invoice);
    void deleteInvoice(long id);
}
