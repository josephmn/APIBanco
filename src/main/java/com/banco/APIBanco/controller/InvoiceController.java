package com.banco.APIBanco.controller;

import com.banco.APIBanco.entity.Invoice;
import com.banco.APIBanco.service.InvoiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Invoice")
@Tag(name = "Invoice", description = "the invoice API")
@SecurityRequirement(name = "APIPichincha")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    //@Operation(summary = "List Invoice", description = "This can only be done by the logged in user.", tags = { "Auth" })
    // -> cuando le asignas tags = { "Auth" } este se asigna la bloque de controller

    @Operation(summary = "List Invoice", description = "This can only be done by the user who enters their JWT.")
    @GetMapping("/findAllInvoice")
    public List<Invoice> findAllInvoice() {
        return invoiceService.findAllInvoice();
    }

    @Operation(summary = "Create Invoice", description = "This can only be done by the user who enters their JWT.")
    @PostMapping("/saveInvoice")
    public Invoice saveInvoice(@RequestBody Invoice invoice) {
        return invoiceService.saveInvoice(invoice);
    }

    @Operation(summary = "Update Invoice", description = "This can only be done by the user who enters their JWT.")
    @PutMapping("/updaInvoice")
    public Invoice updaInvoice(@PathVariable Long id, @RequestBody Invoice invoice) {
        return invoiceService.updateInvoice(id, invoice);
    }

    @Operation(summary = "Delete Invoice", description = "This can only be done by the user who enters their JWT.")
    @DeleteMapping("/deleInvoice")
    public String deleInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
        return "Successfully deleted";
    }
}
