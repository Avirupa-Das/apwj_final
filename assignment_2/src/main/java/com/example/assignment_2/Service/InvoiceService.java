package com.example.assignment_2.Service;
import com.example.assignment_2.Entity.Invoice;
import com.example.assignment_2.Repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    public InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }
    public List<Invoice> getAll() {
        return invoiceRepository.getAll();
    }

    public List<Invoice> getByUserId(int userId) {
        return invoiceRepository.getByUserId(userId);
    }

    public void generateInvoice(Invoice invoice) {
        invoiceRepository.generateInvoice(invoice);
    }

}
