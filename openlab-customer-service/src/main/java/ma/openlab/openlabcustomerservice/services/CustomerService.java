package ma.openlab.openlabcustomerservice.services;

import ma.openlab.openlabcustomerservice.dto.CustomerRequestDTO;
import ma.openlab.openlabcustomerservice.dto.CustomerResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomer(String id);
    CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    List<CustomerResponseDTO> listCustomers();
}
