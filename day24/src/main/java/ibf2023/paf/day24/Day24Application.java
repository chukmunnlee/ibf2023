package ibf2023.paf.day24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ibf2023.paf.day24.services.AccountsException;
import ibf2023.paf.day24.services.AccountsService;

@SpringBootApplication
public class Day24Application implements CommandLineRunner {

	@Autowired
	private AccountsService accountsSvc;

	public static void main(String[] args) {
		SpringApplication.run(Day24Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		try {
			accountsSvc.fundsTransfer("1234", "abcd", 200);
		} catch (AccountsException ex) {
			System.out.printf(">>>> error: %s\n".formatted(ex.getMessage()));
		}

		System.exit(0);

	}
}
