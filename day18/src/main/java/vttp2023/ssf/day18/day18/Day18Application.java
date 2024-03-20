package vttp2023.ssf.day18.day18;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vttp2023.ssf.day18.day18.models.User;
import vttp2023.ssf.day18.day18.services.HttpbinService;

@SpringBootApplication
public class Day18Application implements CommandLineRunner {

	@Autowired
	private HttpbinService httpbinSvc;

	public static void main(String[] args) {
		SpringApplication.run(Day18Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//httpbinSvc.postByUrlEncodedForm(new User("barney", "barney@gmail.com"));
		httpbinSvc.postByJson(new User("barney", "barney@gmail.com"));

		System.exit(0);
	}

}
