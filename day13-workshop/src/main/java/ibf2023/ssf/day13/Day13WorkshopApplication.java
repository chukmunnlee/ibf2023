package ibf2023.ssf.day13;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day13WorkshopApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Day13WorkshopApplication.class, args);
	}

	@Override
	public void run(String... args) {
		for (String a: args)
			System.out.printf(">>> a: %s\n", a);
	}

}
