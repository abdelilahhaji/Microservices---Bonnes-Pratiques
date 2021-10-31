package com.example.ensetbillingservice.service;

import com.example.ensetbillingservice.dto.InvoiceRequestDTO;
import com.example.ensetbillingservice.dto.InvoiceResponseDTO;
import org.springframework.stereotype.Service;


import java.util.List;


public interface InvoiceService {
    InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO);

    InvoiceResponseDTO getInvoice(String invoiceId);

    List<InvoiceResponseDTO> invoicesByCustomer(String customerId);

    List<InvoiceResponseDTO> allInvoices();
}
