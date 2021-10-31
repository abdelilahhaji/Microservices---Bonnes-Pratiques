package com.example.ensetbillingservice.mappers;

import com.example.ensetbillingservice.dto.InvoiceRequestDTO;
import com.example.ensetbillingservice.dto.InvoiceResponseDTO;
import com.example.ensetbillingservice.entities.Invoice;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-30T20:35:10+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
@Component
public class InvoiceMapperImpl implements InvoiceMapper {

    @Override
    public Invoice fromInvoiceRequestDTO(InvoiceRequestDTO invoiceRequestDTO) {
        if ( invoiceRequestDTO == null ) {
            return null;
        }

        Invoice invoice = new Invoice();

        invoice.setAmount( invoiceRequestDTO.getAmount() );
        invoice.setCustomerId( invoiceRequestDTO.getCustomerId() );

        return invoice;
    }

    @Override
    public InvoiceResponseDTO fromInvoice(Invoice invoice) {
        if ( invoice == null ) {
            return null;
        }

        InvoiceResponseDTO invoiceResponseDTO = new InvoiceResponseDTO();

        invoiceResponseDTO.setId( invoice.getId() );
        invoiceResponseDTO.setDate( invoice.getDate() );
        invoiceResponseDTO.setAmount( invoice.getAmount() );
        invoiceResponseDTO.setCustomer( invoice.getCustomer() );

        return invoiceResponseDTO;
    }
}
