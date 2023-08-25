package hu.selfservice.checkout.demo.controller;


import hu.selfservice.checkout.demo.dto.CustomerDto;
import hu.selfservice.checkout.demo.dto.ProductsDto;
import hu.selfservice.checkout.demo.model.Costumer;
import hu.selfservice.checkout.demo.model.Products;
import hu.selfservice.checkout.demo.service.impl.SelfServiceChekOutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/f1/users")
@RequiredArgsConstructor
public class CheckoutController {

    private final SelfServiceChekOutService selfServiceChekOutService;


    @GetMapping("/{Products_id}")
    public ResponseEntity<Products> getUserById(@PathVariable(name = "Products_id") Long Products_id) {
        return ResponseEntity.ok(selfServiceChekOutService.findById(Products_id));

    }
    @GetMapping("/CostumerId/{Costumer_id}")
    public ResponseEntity<Costumer> findCostumerById(@PathVariable(name = "Costumer_id") Long CostumerId) {
        return ResponseEntity.ok(selfServiceChekOutService.findCostumerById(CostumerId));


    }
    @GetMapping("/ProductsDTO")
    public ResponseEntity<List<ProductsDto>> getAllUser() {
        return ResponseEntity.ok(selfServiceChekOutService.findAll());



    }

    @GetMapping("/prod/")
    public ResponseEntity<List<CustomerDto>> getUserB4yId() {
        return ResponseEntity.ok(selfServiceChekOutService.find());

    }}











//  @GetMapping("/{EANCode}")
//  public ResponseEntity<Products> getFin(@PathVariable(name = "EANCode") Integer Products_Ean) {
//     return ResponseEntity.ok(selfServiceChekOutService.findByEANCode(Products_Ean));