package ibf2023.ssf.day11.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController {

   @RequestMapping(path="/error")
   public String handleError() {
       return "redirect:/";
   }
   
}
