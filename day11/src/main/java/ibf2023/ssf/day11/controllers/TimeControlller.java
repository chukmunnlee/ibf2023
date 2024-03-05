package ibf2023.ssf.day11.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



// GET /time

@Controller
@RequestMapping(path="/time")
public class TimeControlller {

   @GetMapping(path={ "/dayofweek", "/dow" })
   public String getDayOfWeek(Model model) {

      System.out.println(">>>> GET /time/dayofweek");

      DateFormat formatter = new SimpleDateFormat("EEEE");
      Date date = new Date();
      String dayofweek = formatter.format(date);

      model.addAttribute("dow", dayofweek);

      return "dayofweek";
   }

   @GetMapping
   public String getTime(Model model) {

      System.out.println(">>>> GET /time");
      String currTime = (new Date()).toString();

      model.addAttribute("time", currTime);

      return "time";
   }
   
}
