package ma.openlab.openlabcustomerservice.repositories;

import ma.openlab.openlabcustomerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
