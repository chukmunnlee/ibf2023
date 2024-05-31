package server.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.json.Json;
import jakarta.json.JsonObject;

@Controller
//@RequestMapping
public class StartupController {

	@PostMapping(path="/startup")
	public ModelAndView postStartup(@RequestParam String message) {

		ModelAndView mav = new ModelAndView("main");

		System.out.printf(">>> message: %s\n", message);

		JsonObject payload = Json.createObjectBuilder()
			.add("message", message)
			.build();

		mav.addObject("initData", payload.toString());

		return mav;
	}
}
