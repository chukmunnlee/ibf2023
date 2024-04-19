package ibf2023.paf.day26;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ibf2023.paf.day26.repositories.TVShowRepository;

@SpringBootApplication
public class Day26Application implements CommandLineRunner {

	@Autowired
	private TVShowRepository tvShowsRepo;

	public static void main(String[] args) {
		SpringApplication.run(Day26Application.class, args);
	}

	@Override
	public void run(String... args) {

		System.out.println("\n\n\n==================");
		// for (Document doc: tvShowsRepo.findShowsByName("and")) {
		// 	String name = doc.getString("name");
		// 	List<String> genres = doc.getList("genres", String.class);
		// 	//System.out.printf("name: %s, genres: %s\n", name, genres);
		// 	System.out.printf(">> doc: %s\n", doc.toJson());
		// }

		System.out.printf("Numebr of english shows: %d\n"
				, tvShowsRepo.countShowsByLanguage("english"));

		System.out.printf("Type of shows with an average rating of gte 7: %s\n"
				, tvShowsRepo.getTypesByRating(7f));
		System.exit(0);
	}

}
