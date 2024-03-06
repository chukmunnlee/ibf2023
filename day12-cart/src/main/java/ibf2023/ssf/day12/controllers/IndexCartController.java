package ibf2023.ssf.day12.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ibf2023.ssf.day12.Utils;
import ibf2023.ssf.day12.models.Item;


@Controller
@RequestMapping
public class IndexCartController {

   //@GetMapping(path={"/", "/index.html", "/cart" })
   public ModelAndView getCart(@RequestParam(defaultValue = "") String item, 
      @RequestParam(defaultValue = "1") int quantity, 
      @RequestParam(defaultValue = "") String _cart) {

      ModelAndView mav = new ModelAndView("cart");
      Item newItem = new Item();

      // New Item
      newItem.setName(item);
      newItem.setQuantity(quantity);

      // name|quantity,name|quantity,...
      List<Item> cart = Utils.deserializeCart(_cart);
      cart.add(newItem);

      String newCart = Utils.serializeCart(cart);
      System.out.printf(">>>> newCart: %s\n", newCart);

      mav.addObject("newCart", newCart);
      mav.addObject("cart", cart);

      return mav;
   }
   
   
}
