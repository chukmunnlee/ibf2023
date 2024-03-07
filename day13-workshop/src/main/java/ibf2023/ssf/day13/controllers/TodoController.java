package ibf2023.ssf.day13.controllers;

import java.util.List;
import java.util.LinkedList;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import ibf2023.ssf.day13.models.Todo;

import static ibf2023.ssf.day13.Constants.*;

@Controller
@RequestMapping
public class TodoController {

   @GetMapping(path = { "/", "/index.html" })
   public ModelAndView getIndex(HttpSession sess) {

      ModelAndView mav = new ModelAndView("todo");
      mav.addObject(F_TODO, new Todo());
      mav.addObject(F_TODOS, getTasks(sess));

      return mav;
   }

   @PostMapping(path = "/todo")
   public ModelAndView postTodo(HttpSession sess, 
         @RequestBody @ModelAttribute @Valid Todo todo, BindingResult bindings) {

      ModelAndView mav = new ModelAndView("todo");

      List<Todo> todos = getTasks(sess);
      mav.addObject(F_TODOS, todos);

      if (bindings.hasErrors())
         mav.addObject(F_TODO, todo);
      else {
         todos.add(todo);
         mav.addObject(F_TODO, new Todo());
         // POST-redirect-GET
         mav.setViewName("redirect:/");
      }

      return mav;
   }

   private List<Todo> getTasks(HttpSession sess) {
      List<Todo> todos = (List<Todo>)sess.getAttribute(F_TODOS);
      if (null == todos) {
         todos = new LinkedList<>();
         sess.setAttribute(F_TODOS, todos);
      }
      return todos;
   }
}