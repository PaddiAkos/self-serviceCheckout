package hu.selfservice.checkout.demo.repository;

import hu.selfservice.checkout.demo.model.Costumer;
import hu.selfservice.checkout.demo.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerRepository extends JpaRepository<Costumer, Long> {
}
