package hu.selfservice.checkout.demo.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Products")
@ToString
@EqualsAndHashCode
public class Products {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Products_id", nullable = false, unique = true)
    private Long Products_id;

    @Column(name = "Product_Name",nullable = false)
    private String Name;

    @Column(name = "Price",nullable = false)
    private Integer Price;

    @Column(name = "EANCode",nullable = false)
    private Integer EANCode;

    @Column(name = "quantity")
    private Integer Quantity;






}
