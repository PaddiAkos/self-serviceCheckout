package hu.selfservice.checkout.demo;

import hu.selfservice.checkout.demo.model.Costumer;
import hu.selfservice.checkout.demo.model.Products;
import hu.selfservice.checkout.demo.model.ShoppingCart;
import hu.selfservice.checkout.demo.repository.CostumerRepository;
import hu.selfservice.checkout.demo.repository.ProductsRepository;
import hu.selfservice.checkout.demo.repository.ShoppingCartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}



	@Bean
	CommandLineRunner run(ProductsRepository productsRepository, ShoppingCartRepository shoppingCartRepository , CostumerRepository costumerRepository) {
		return args -> {


			log.trace("buying/1");

			Products Milk = new Products();
			Milk.setName("Milk");
			Milk.setPrice(100);
			Milk.setEANCode(12345);
			Milk.setQuantity(10);


			Products Bread = new Products();
			Bread.setName("Bread");
			Bread.setPrice(150);
			Bread.setEANCode(9999);
			Bread.setQuantity(10);

			Products salami = new Products();
			salami.setName("Salami");
			salami.setPrice(200);
			salami.setEANCode(12344);
			salami.setQuantity(10);


			List<Products> shoppingcart1 = new ArrayList<>();
			shoppingcart1.add(Bread);
			shoppingcart1.add(Milk);


			ShoppingCart shoppingCart = new ShoppingCart();
			shoppingCart.setProducts(shoppingcart1);
			shoppingCart.setAmount(11);
			shoppingCart.setCartName("fX12");


			Costumer costumer = new Costumer();
			costumer.setDiscount(10);
			costumer.setMoney(1000);
			costumer.setShoppingCart(shoppingCart);

			costumerRepository.save(costumer);


			/////////////////////////////////////////////

			log.trace("buying/2");

			List<Products> shoppingcartTRY = new ArrayList<>();
			shoppingcartTRY.add(salami);


			ShoppingCart shoppingCart123 = new ShoppingCart();
			shoppingCart123.setProducts(shoppingcartTRY);
			shoppingCart123.setAmount(12);
			shoppingCart123.setCartName("fX13");


			Costumer costumer3 = new Costumer();
			costumer3.setDiscount(10);
			costumer3.setMoney(1000);
			costumer3.setShoppingCart(shoppingCart123);

			costumerRepository.save(costumer3);
			shoppingCartRepository.save(shoppingCart123);
			productsRepository.save(Bread);
			productsRepository.save(Milk);
			productsRepository.save(salami);


		};
	}
}



