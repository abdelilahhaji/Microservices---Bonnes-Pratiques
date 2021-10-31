package ma.openlab.openlabcustomerservice.web;

import ma.openlab.openlabcustomerservice.dto.CustomerRequestDTO;
import ma.openlab.openlabcustomerservice.dto.CustomerResponseDTO;
import ma.openlab.openlabcustomerservice.entities.Customer;
import ma.openlab.openlabcustomerservice.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(path = "/api")
public class CustomerRestApi {
    private final CustomerService customerService;
    public CustomerRestApi(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping(path = "/customers")
    public List<CustomerResponseDTO> allCustomers(){
        return customerService.listCustomers();
    }
    @PostMapping(path = "/customers")
    public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRequestDTO){
        customerRequestDTO.setId(UUID.randomUUID().toString());
        return customerService.save(customerRequestDTO);
    }
    @GetMapping(path = "/customers/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable String id){
    return customerService.getCustomer(id);
    }
}
