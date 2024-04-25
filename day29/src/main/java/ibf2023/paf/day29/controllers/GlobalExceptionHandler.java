package ibf2023.paf.day29.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class GlobalExceptionHandler {

   Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

   @ExceptionHandler({DataAccessException.class})
   public ModelAndView handleDataAccessException(HttpServletRequest req, DataAccessException ex) {
      return null;
   }
   
}
