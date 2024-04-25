package ibf2023.paf.day29;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ibf2023.paf.day29.repositories.GamesRepository;

@SpringBootApplication
public class Day29Application implements CommandLineRunner {

	@Autowired
	private GamesRepository gamesRepo;

	public static void main(String[] args) {
		SpringApplication.run(Day29Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (Document doc: gamesRepo.findGameByName("carcassonne")) {
			//System.out.printf(">>> %d, %s\n", doc.getInteger("_id"), doc.getString("name"));
			System.out.printf(">> %s\n", doc);
		}

		System.exit(0);
	}

}
