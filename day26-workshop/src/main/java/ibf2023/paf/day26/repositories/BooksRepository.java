package ibf2023.paf.day26.repositories;

import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import ibf2023.paf.day26.models.Book;
import ibf2023.paf.day26.models.BookSummary;

@Repository
public class BooksRepository {

	@Autowired
	private MongoTemplate template;

	/*
	 * db.books.find({
	 * 	title: { $regex: 'title', $options: 'i' }
	 * })
	 * .projection({ title: 1 })
	 * .sort({ title: 1 })
	 */
	public List<BookSummary> searchBooksByTitle(String title) {
		Criteria criteria = Criteria.where(Constants.F_TITLE)
			.regex(title, "i");
		Query query = Query.query(criteria)
			.with(Sort.by(Sort.Direction.ASC, Constants.F_TITLE));
		query.fields().include(Constants.F_TITLE);

		return template.find(query, Document.class, Constants.C_BOOKS)
				.stream()
				.map(BookSummary::toBookSummary)
				.toList();
	}

	/*
	 * db.books.findOne({ _id: ObjectId('id') })
	 */
	public Optional<Book> findBookById(String id) {
		Criteria criteria = Criteria.where(Constants.F_ID).is(new ObjectId(id));

		Query query = Query.query(criteria);

		Document result = template.findOne(query, Document.class, Constants.C_BOOKS);
		if (null == result)
			return Optional.empty();

		return Optional.of(Book.toBook(result));
	}
}
