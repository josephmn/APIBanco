package com.banco.APIBanco.service.Impl;

import com.banco.APIBanco.entity.Invoice;
import com.banco.APIBanco.repository.InvoiceRepository;
import com.banco.APIBanco.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> findAllInvoice() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice updateInvoice(Long id, Invoice invoice) {
        Invoice invoiceDB = invoiceRepository.findById(id).get();
        if (Objects.nonNull(invoice.getInvoice()) && !"".equalsIgnoreCase(invoice.getInvoice())) {
            invoiceDB.setInvoice(invoice.getInvoice());
        }
        if (invoice.getAmount() != null && invoice.getAmount().compareTo(BigDecimal.ZERO) > 0) {
            invoiceDB.setAmount(invoice.getAmount());
        }
        if (Objects.nonNull(invoice.getSourceCurrency()) && !"".equalsIgnoreCase(invoice.getSourceCurrency())) {
            invoiceDB.setSourceCurrency(invoice.getSourceCurrency());
        }
        if (Objects.nonNull(invoice.getTargetCurrency()) && !"".equalsIgnoreCase(invoice.getTargetCurrency())) {
            invoiceDB.setTargetCurrency(invoice.getTargetCurrency());
        }
        if (invoice.getRate() != null && invoice.getRate().compareTo(BigDecimal.ZERO) > 0) {
            invoiceDB.setRate(invoice.getRate());
        }
        // Actualizar manualmente el campo updateAt
        invoiceDB.setUpdateAt(new Date());
        return invoiceRepository.save(invoiceDB);
    }

    @Override
    public void deleteInvoice(long id) {
        invoiceRepository.deleteById(id);
    }
}
