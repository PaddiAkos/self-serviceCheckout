package hu.selfservice.checkout.demo.service.impl.impl;


import hu.selfservice.checkout.demo.dto.CustomerDto;
import hu.selfservice.checkout.demo.dto.ProductsDto;
import hu.selfservice.checkout.demo.model.Costumer;
import hu.selfservice.checkout.demo.model.Products;
import hu.selfservice.checkout.demo.repository.CostumerRepository;
import hu.selfservice.checkout.demo.repository.ProductsRepository;
import hu.selfservice.checkout.demo.repository.ShoppingCartRepository;
import hu.selfservice.checkout.demo.service.impl.SelfServiceChekOutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class DataServiceImpl implements SelfServiceChekOutService {


    private final ProductsRepository productsRepository;

    private final CostumerRepository costumerRepository;

    private final ShoppingCartRepository shoppingCartRepository;


    public DataServiceImpl(ProductsRepository productsRepository, CostumerRepository costumerRepository, ShoppingCartRepository shoppingCartRepository) {
        this.productsRepository = productsRepository;
        this.costumerRepository = costumerRepository;
        this.shoppingCartRepository = shoppingCartRepository;
    }


    public int UnitPrice(int price, int quentity) {

        int UnitPrice = price * quentity;


        return UnitPrice;
    }

    public int Amount(List<Products> productsList) {


        int xyz = 0;

        for (Products products : productsList) {

            int Amount2 = products.getQuantity() * products.getPrice();

            xyz += Amount2;

        }
        return xyz;
    }
    public double AmountAfterDiscount (int Amount , int Discount ){

        double x = Amount;

        double y = x / 100;

        double z = y * Discount;

        double result = Amount - z;

        return result;


     }
    @Override
    public List<ProductsDto> findAll() {


        List<Products> productsList = productsRepository.findAll();

        return productsList.stream()
                .map(products -> {
                    ProductsDto productsDto = new ProductsDto();
                    productsDto.setUnitPrice(UnitPrice(products.getPrice(), products.getQuantity()));
                    productsDto.setName(products.getName());
                    productsDto.setPrice(products.getPrice());
                    productsDto.setQuantity(products.getQuantity());
                    productsDto.setEANCode(products.getEANCode());

                    return productsDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Products findById(Long ProductId) {
        return productsRepository.findById(ProductId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Costumer findCostumerById(Long CostumerId) {
        return costumerRepository.findById(CostumerId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<CustomerDto> find() {


        List<Costumer> Costumer5 = costumerRepository.findAll();


        return Costumer5.stream()
                .map(costumer -> {

                    CustomerDto customerDto = new CustomerDto();
                    customerDto.setAmount(Amount(costumer.getShoppingCart().getProducts()));
                    customerDto.setProducts(costumer.getShoppingCart().getProducts());
                    customerDto.setDiscount(costumer.getDiscount());
                    customerDto.setAmountAfterDiscount(AmountAfterDiscount(Amount(costumer.getShoppingCart().getProducts()),costumer.getDiscount()));
                    return customerDto;
                })
                .collect(Collectors.toList());

    }
}

   // @Override
   //    List<Products> products = productsRepository.findAll();
   //   for (Products product : products) {
   //      if (Objects.equals(product.getEANCode(), EANcode)) {
   //         return product;
   //      }
   //    }
   //    return null;
   //
   // }