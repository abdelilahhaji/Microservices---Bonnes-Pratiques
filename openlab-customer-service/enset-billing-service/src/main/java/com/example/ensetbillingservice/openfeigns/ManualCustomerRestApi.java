package com.example.ensetbillingservice.openfeigns;

import com.example.ensetbillingservice.entities.Customer;
import feign.Contract;
import feign.Feign;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Import(FeignClientsConfiguration.class)
public class ManualCustomerRestApi {
    private CustomerRestApi customerRestApi;

    public ManualCustomerRestApi(Contract contract) {
        this.customerRestApi = Feign.builder()
                .contract(contract)
                .decoder((response, type) -> new Customer())
                .target(CustomerRestApi.class, "http://localhost:8082");
       }
    @GetMapping(path = "/api/customers/{id}")
    public Customer getCustomer(@PathVariable(name = "id") String id){
        return customerRestApi.getCustomer(id);
    }
    @GetMapping(path = "/api/customers")
    public List<Customer> allCustomers(){
        return null;
    };
}


