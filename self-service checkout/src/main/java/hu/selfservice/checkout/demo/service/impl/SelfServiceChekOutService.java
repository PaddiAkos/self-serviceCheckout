package hu.selfservice.checkout.demo.service.impl;

import hu.selfservice.checkout.demo.dto.CustomerDto;
import hu.selfservice.checkout.demo.dto.ProductsDto;
import hu.selfservice.checkout.demo.model.Costumer;
import hu.selfservice.checkout.demo.model.Products;

import java.util.List;

public interface SelfServiceChekOutService {

    List<ProductsDto> findAll();


    Products findById(Long ProductId);

    Costumer findCostumerById(Long CostumerId);

    List<CustomerDto> find ();









}
