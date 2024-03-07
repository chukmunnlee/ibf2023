package ibf2023.ssf.day13.controllers;

import java.util.List;
import java.util.LinkedList;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ibf2023.ssf.day13.models.Item;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping
public class CartController {

   // Member
   // Do not do this
   // private List<Item> cart = new LinkedList<>();

   @GetMapping(path = {"/", "/index.html"})
   public ModelAndView getIndex(HttpSession sess) {
      ModelAndView mav = new ModelAndView("cart");
      List<Item> cart = getCart(sess);

      mav.addObject("item", new Item());
      mav.addObject("cart", cart);

      return mav;
   }

   @PostMapping(path="/checkout")
   public String postMethodName(HttpSession sess) {
       //TODO: process POST request
       List<Item> cart = getCart(sess);

       System.out.println(">>>> cart: " + cart);

       // perform checkout
       // destroy the session for the NEXT request
       sess.invalidate();
       
       return "thankyou";
   }
   
   @PostMapping(path="/cart2")
   public ModelAndView postCart2(HttpSession sess,
         @ModelAttribute @Valid Item item , BindingResult bindings) {

      ModelAndView mav = new ModelAndView("cart");

      List<Item> cart = getCart(sess);

      mav.addObject("cart", cart);

      // Syntactic validation
      if (bindings.hasErrors()) 
         mav.addObject("item", item);

      // Semantic validation
      else if ("apple".equals(item.getName())) {
         System.out.printf(">>>> apple error");
         FieldError err = new FieldError("item", "name", "We don't sell apple here");
         bindings.addError(err);
         mav.addObject("item", item);
         System.out.printf(">>>> sem validation item: %s\n", item);

         ObjectError objErr = new ObjectError("globalError", "This error belongs to the form");
         bindings.addError(objErr);

      } else {
         mav.addObject("item", new Item());
         cart.add(item);
      }

      System.out.printf(">>>> item: %s\n", item);

      return mav;
   }
   
   @PostMapping(path="/cart")
   public ModelAndView postCart(@RequestBody MultiValueMap<String, String> form
         , @RequestParam String name, @RequestParam int quantity, @RequestBody String payload) {

      ModelAndView mav = new ModelAndView();
      mav.setViewName("cart");

      // Validate item
      if (quantity <= 0) {
         mav.setStatus(HttpStatusCode.valueOf(400));
         return mav;
      }

      System.out.printf(">>>> name: %s\n", name);
      System.out.printf(">>>> payload: %s\n", payload);
      System.out.printf(">>>> form: %s\n", form);
       
      return mav;
   }

   private List<Item> getCart(HttpSession sess) {
      List<Item> cart = (List<Item>)sess.getAttribute("cart");
      // Check if cart exists, if cart does not exist, then this is a new session
      // Initialize the session
      if (null == cart) {
         cart = new LinkedList<>();
         sess.setAttribute("cart", cart);
      }
      return cart;
   }
   
   
}
