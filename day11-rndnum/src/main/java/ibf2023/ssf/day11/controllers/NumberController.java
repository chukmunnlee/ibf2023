package ibf2023.ssf.day11.controllers;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping(path={ "/", "/index.html" })
public class NumberController {

   @GetMapping
   public String getIndex(Model model) {
      Random rand = new SecureRandom();
      int n = rand.nextInt(31);

      String imgUrl = "/numbers/number%d.jpg".formatted(n);
      model.addAttribute("imgUrl", imgUrl);

      return "number";
   }
}
