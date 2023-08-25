package hu.selfservice.checkout.demo.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Costumer")
@ToString
@EqualsAndHashCode
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Costumer_id", nullable = false, unique = true)
    private Long Costumer;

    @Column(name = "Money")
    private Integer Money;

    @Column(name = "Discount")
    private Integer Discount;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ShoppingCart_id", referencedColumnName = "ShoppingCart_id")
    private hu.selfservice.checkout.demo.model.ShoppingCart ShoppingCart;






}
