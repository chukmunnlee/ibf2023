package ibf2023.paf.day29.controllers;

import java.util.logging.Logger;

//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping
public class IndexController {

   private Logger logger = Logger.getLogger(IndexController.class.getName());
   //private Logger logger = LoggerFactory.getLogger(IndexController.class);
   //org.slf4j.Logger logger = LoggerFactory.getLogger(IndexController.class);

   @GetMapping({"/", "/index.html"})
   public String getIndex() {
      logger.info(">>>> INFO in index.html");
      logger.warning(">>>> this is a warning");
       return "index";
   }
   
}
