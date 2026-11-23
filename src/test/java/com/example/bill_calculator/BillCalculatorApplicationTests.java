package com.example.bill_calculator;

import com.example.bill_calculator.model.Cart;
import com.example.bill_calculator.model.Item;
import com.example.bill_calculator.service.PricingService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BillCalculatorApplicationTests {

  PricingService service = new PricingService();

  @Test
  void testPriceAbove100() {
    List<Item> items = new ArrayList<>();
    items.add(new Item(1, 50.0));
    items.add(new Item(2, 110.0));
    items.add(new Item(3, 500.0));
    items.add(new Item(4, 50.0));

    Cart cart = new Cart(items);
    double actualPrice = service.calculatePrice(cart);

    assertEquals(639.0, actualPrice, 0.0001);
  }

  @Test
  void testPriceBelow100() {
    List<Item> items = new ArrayList<>();
    items.add(new Item(1, 50.0));
    items.add(new Item(2, 30.0));

    Cart cart = new Cart(items);
    double actualPrice = service.calculatePrice(cart);

    assertEquals(80.0, actualPrice, 0.0001);
  }

  @Test
  void testPriceExactly100() {
    List<Item> items = new ArrayList<>();
    items.add(new Item(1, 50.0));
    items.add(new Item(2, 50.0));

    Cart cart = new Cart(items);
    double actualPrice = service.calculatePrice(cart);

    assertEquals(100.0, actualPrice, 0.0001);
  }

  @Test
  void testEmptyCart() {
    List<Item> items = new ArrayList<>();
    Cart cart = new Cart(items);
    double actualPrice = service.calculatePrice(cart);

    assertEquals(0.0, actualPrice, 0.0001);
  }
}