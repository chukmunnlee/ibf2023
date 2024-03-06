package ibf2023.ssf.day12.controllers;

//import java.util.LinkedList;
//import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path="/pizza")
public class PizzaController {

	@GetMapping
	public String getPizza(
			@RequestParam MultiValueMap<String, String> orderForm) {

		System.out.println("===================================\n");

		/*
		List<String> value = orderForm.computeIfAbsent("abc", 
				(key) -> {
					return List.of("abc");
				});
		*/

		for (String ctrlName: orderForm.keySet())
			System.out.printf("key: %s, values: %s\n", 
					ctrlName, orderForm.get(ctrlName));

		return "redirect:/";
	}
}
