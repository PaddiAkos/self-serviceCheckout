package hu.selfservice.checkout.demo.model;

import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ShoppingCart")
@ToString
@EqualsAndHashCode
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShoppingCart_id", nullable = false, unique = true)
    private Long ShoppingCart;


    @Column(name = "TotalPrice")
    private Integer Amount;


    @NotBlank
    @Column(name = "Cart_Name")
    private String CartName;


    @OneToMany(targetEntity = Products.class, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "ShoppingCart_id")
    private List<Products> products;




}
