package vttp2023.ssf.day19.day19.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import vttp2023.ssf.day19.day19.Utils;
import vttp2023.ssf.day19.day19.models.Order;

@Service
public class OrderService {

   public Order createNewOrder(String json) {
      // Generate orderId
      String orderId = UUID.randomUUID().toString().substring(0, 8);
      Order order = Utils.toOrder(orderId, json);
      // Save order to database
      return order;
   }
   
}
