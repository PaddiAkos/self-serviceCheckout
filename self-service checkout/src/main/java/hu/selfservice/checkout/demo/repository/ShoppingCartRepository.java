package hu.selfservice.checkout.demo.repository;

import hu.selfservice.checkout.demo.dto.OrderResponse;
import hu.selfservice.checkout.demo.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {



    @Query("SELECT new hu.selfservice.checkout.demo.dto.OrderResponse(u.CartName , M.Name) FROM ShoppingCart u JOIN u.products M")
    public List<OrderResponse> getJoinInformation();

}
