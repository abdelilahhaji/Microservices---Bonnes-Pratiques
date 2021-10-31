package com.example.ensetbillingservice.service;

import com.example.ensetbillingservice.CustomerNotFoundException;
import com.example.ensetbillingservice.dto.InvoiceRequestDTO;
import com.example.ensetbillingservice.dto.InvoiceResponseDTO;
import com.example.ensetbillingservice.entities.Customer;
import com.example.ensetbillingservice.entities.Invoice;
import com.example.ensetbillingservice.mappers.InvoiceMapper;
import com.example.ensetbillingservice.openfeigns.CustomerRestApi;
import com.example.ensetbillingservice.repositories.InvoiceRepository;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@EnableFeignClients
public class InvoiceServiceImpl implements InvoiceService{

    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    private CustomerRestApi customerRestApi;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository,
                              InvoiceMapper invoiceMapper,
                              CustomerRestApi customerRestApi) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.customerRestApi = customerRestApi;
    }

    @Override
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO)  {
        /*
        Verification de l'integrite referentille Invoice /Customer
        */
        Customer customer = null;
        try {
            customer = customerRestApi.getCustomer(invoiceRequestDTO.getCustomerId());
        } catch (Exception exception) {
            throw new CustomerNotFoundException("Customer Not Found");
        }
        Invoice invoice = invoiceMapper.fromInvoiceRequestDTO(invoiceRequestDTO);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());

        Invoice savedInvoice = invoiceRepository.save(invoice);
        savedInvoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(savedInvoice);
    }

    @Override
    public InvoiceResponseDTO getInvoice(String invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId).get();
        Customer customer = customerRestApi.getCustomer(invoice.getCustomerId());
        invoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> invoicesByCustomer(String customerId) {
        List<Invoice> invoices = invoiceRepository.findInvoicesByCustomerId(customerId);
        invoices.forEach(invoice -> {
            Customer customer = customerRestApi.getCustomer(invoice.getCustomerId());
            invoice.setCustomer(customer);
        });
        return invoices.stream()
                .map(invoice -> invoiceMapper.fromInvoice(invoice))
                .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceResponseDTO> allInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
        invoices.forEach(invoice -> {
            Customer customer = customerRestApi.getCustomer(invoice.getCustomerId());
            invoice.setCustomer(customer);
        });
        return invoices.stream()
                .map(invoice -> invoiceMapper.fromInvoice(invoice))
                .collect(Collectors.toList());
    }
}
