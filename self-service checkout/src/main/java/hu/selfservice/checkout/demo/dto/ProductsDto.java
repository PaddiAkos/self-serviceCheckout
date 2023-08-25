package hu.selfservice.checkout.demo.dto;

import hu.selfservice.checkout.demo.model.Products;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;

 @Data
 @EqualsAndHashCode(callSuper = true)
public class ProductsDto extends Products {

    @Column(name = "Unit price")
    private Integer UnitPrice;

     @Column(name = "Product_Name",nullable = false)
     private String Name;


}
