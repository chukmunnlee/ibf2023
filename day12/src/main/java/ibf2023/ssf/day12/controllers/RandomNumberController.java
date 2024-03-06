package ibf2023.ssf.day12.controllers;

import java.security.SecureRandom;
import java.util.Random;

import javax.print.attribute.standard.Media;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(path="/rnd")
public class RandomNumberController {

   // GET /rnd/
   @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
   public String getRandom(Model model) {
      Random rand = new SecureRandom();
      int value = rand.nextInt(1, 11);
      boolean odd = (value % 2) > 0;

      model.addAttribute("rndNum", value);
      model.addAttribute("odd", odd);

      // templates/numbers.html
      return "numbers";
   }

   @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseBody
   public ResponseEntity<String> getMethodName() {
      return ResponseEntity.ok("{\"rnd\": 45}");
   }
}
