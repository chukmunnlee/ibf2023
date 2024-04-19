package ibf2023.paf.day26;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ibf2023.paf.day26.repositories.BooksRepository;
import ibf2023.paf.day26.models.Book;
import ibf2023.paf.day26.models.BookSummary;

@SpringBootApplication
public class Day26Application implements CommandLineRunner {

	@Autowired
	private BooksRepository booksRepo;

	public static void main(String[] args) {
		SpringApplication.run(Day26Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		for (BookSummary s: booksRepo.searchBooksByTitle("harry")) {
			System.out.printf("\nSummary: %s\n", s);
			Optional<Book> opt = booksRepo.findBookById(s.id());
			System.out.printf("Book: %s\n", opt.get());
		}
		System.exit(0);
		*/
	}

}
