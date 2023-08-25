package hu.selfservice.checkout.demo.dto;

import hu.selfservice.checkout.demo.model.ShoppingCart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderRequest {

    private ShoppingCart shoppingCart;


}

