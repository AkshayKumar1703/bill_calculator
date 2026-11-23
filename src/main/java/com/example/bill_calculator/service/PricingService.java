package com.example.bill_calculator.service;

import com.example.bill_calculator.model.Cart;
import com.example.bill_calculator.model.Item;

public class PricingService {
  public double calculatePrice(Cart cart) {
    double totalPrice = 0.0;
    for (Item items : cart.getItems()) {
        totalPrice = totalPrice + items.getPrice();
    }
    if (totalPrice > 100) {
      totalPrice = applyDiscount(totalPrice);
      return totalPrice;
    }
    return totalPrice;
  }

  public double applyDiscount(double totalPrice) {
    double discountedPrice = 0.0;
    discountedPrice = totalPrice - (totalPrice * 0.10);
    return discountedPrice;
  }
}
