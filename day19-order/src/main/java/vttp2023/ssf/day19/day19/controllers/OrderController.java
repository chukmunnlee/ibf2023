package vttp2023.ssf.day19.day19.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import vttp2023.ssf.day19.day19.Utils;
import vttp2023.ssf.day19.day19.models.Order;
import vttp2023.ssf.day19.day19.services.OrderService;

//@RestController
@Controller
@RequestMapping
public class OrderController {

   @Autowired
   private OrderService orderSvc;

   @PostMapping(path="/api/order" // method resource
         , consumes = MediaType.APPLICATION_JSON_VALUE // Content-Type
         , produces = MediaType.APPLICATION_JSON_VALUE) // Accept
   @ResponseBody
   public ResponseEntity<String> postOrder(@RequestBody String payload) {

      System.out.printf(">>> payload: %s\n", payload);

      Order order = orderSvc.createNewOrder(payload);

      JsonObject resp = Json.createObjectBuilder()
         .add("orderId", order.getOrderId())
         .build();
      return ResponseEntity.ok(resp.toString());
   }
   
}
