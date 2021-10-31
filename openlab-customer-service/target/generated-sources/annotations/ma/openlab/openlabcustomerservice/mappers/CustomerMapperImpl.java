package ma.openlab.openlabcustomerservice.mappers;

import javax.annotation.Generated;
import ma.openlab.openlabcustomerservice.dto.CustomerRequestDTO;
import ma.openlab.openlabcustomerservice.dto.CustomerResponseDTO;
import ma.openlab.openlabcustomerservice.entities.Customer;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-30T20:04:53+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerResponseDTO customerToCustomerResponseDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();

        customerResponseDTO.setId( customer.getId() );
        customerResponseDTO.setName( customer.getName() );
        customerResponseDTO.setEmail( customer.getEmail() );

        return customerResponseDTO;
    }

    @Override
    public Customer customerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO) {
        if ( customerRequestDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerRequestDTO.getId() );
        customer.setName( customerRequestDTO.getName() );
        customer.setEmail( customerRequestDTO.getEmail() );

        return customer;
    }
}
