package hu.selfservice.checkout.demo.dto;

import hu.selfservice.checkout.demo.model.Costumer;
import hu.selfservice.checkout.demo.model.Products;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDto extends Costumer  {

    private Integer Discount;

    private List<Products> products;

    private Integer Amount;

    private double AmountAfterDiscount;





}
