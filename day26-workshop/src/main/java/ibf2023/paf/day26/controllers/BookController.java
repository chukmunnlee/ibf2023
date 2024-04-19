package ibf2023.paf.day26.controllers;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ibf2023.paf.day26.repositories.BooksRepository;
import ibf2023.paf.day26.models.Book;

@Controller
@RequestMapping
public class BookController {

	@Autowired
	private BooksRepository booksRepo;

	@GetMapping(path="/search")
	public ModelAndView search(@RequestParam String title) {

		ModelAndView mav = new ModelAndView("books-list");
		mav.addObject("booksSummary", booksRepo.searchBooksByTitle(title));

		return mav;
	}

	@GetMapping(path="/book/{id}")
	public ModelAndView getBookById(@PathVariable String id) {
		ModelAndView mav = new ModelAndView();
		Optional<Book> opt = booksRepo.findBookById(id);
		if (opt.isEmpty()) {
			mav.setStatus(HttpStatusCode.valueOf(404));
			mav.setViewName("not-found");
			mav.addObject("id", id);
		} else {
			mav.setStatus(HttpStatusCode.valueOf(200));
			mav.setViewName("book-details");
			mav.addObject("book", opt.get());
		}
		return mav;
	}
}
