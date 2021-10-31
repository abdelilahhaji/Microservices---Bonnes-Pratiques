package ma.openlab.openlabcustomerservice;

import ma.openlab.openlabcustomerservice.dto.CustomerRequestDTO;
import ma.openlab.openlabcustomerservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class OpenlabCustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenlabCustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerService customerService){
        return args -> {
          customerService.save(new CustomerRequestDTO("C1", "Abdelilah", "abdelhajji6@gmail.com"));
          customerService.save(new CustomerRequestDTO("C2", "Youssef", "youssef@gmail.com"));

        };
    }
}
