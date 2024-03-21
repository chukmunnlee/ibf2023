package vttp2023.ssf.day19.day19;

import java.io.StringReader;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import vttp2023.ssf.day19.day19.models.Item;
import vttp2023.ssf.day19.day19.models.Order;

public class Utils {

   public static Order toOrder(String orderId, String json) {

      JsonReader reader = Json.createReader(new StringReader(json));
      JsonObject payload = reader.readObject();

      Order order = new Order(orderId);
      order.setName(payload.getString("name"));
      order.setEmail(payload.getString("email"));
      order.setRush(payload.getBoolean("rush", false));
      order.setComments(payload.getString("comments", ""));

      List<Item> items = payload.getJsonArray("items").stream()
         .map(v -> v.asJsonObject())
         .map(v -> {
            Item item = new Item();
            item.setItem(v.getString("item"));
            item.setQuantity(v.getInt("quantity"));
            return item;
         })
         .toList();
      order.setItems(items);

      return order;
   }
   
}
