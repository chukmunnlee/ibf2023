package ibf2023.paf.day23;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ibf2023.paf.day23.models.BoardgameSummary;
import ibf2023.paf.day23.repositories.BoardgameRepository;

@SpringBootApplication
public class Day23Application implements CommandLineRunner {

	@Autowired
	BoardgameRepository boardgameRepo;

	public static void main(String[] args) {
		SpringApplication.run(Day23Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String query = "%carcassonne%";
		List<BoardgameSummary> results = boardgameRepo.getBoardgameStatistics(query);
		for (BoardgameSummary b: results)
			System.out.printf(">>>> %s\n", b);
	}

}
