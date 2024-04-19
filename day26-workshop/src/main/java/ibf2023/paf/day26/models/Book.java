package ibf2023.paf.day26.models;

import org.bson.Document;

import ibf2023.paf.day26.Utils;
import ibf2023.paf.day26.repositories.Constants;

public class Book {
	private String id;
	private int bookId;
	private String title;
	private String authors;
	private float avgRating;
	private String language;
	private int numPages;

	public void setId(String id) { this.id = id; }
	public String getId() { return id; }

	public void setBookId(int bookId) { this.bookId = bookId; }
	public int getBookId() { return bookId; }

	public void setTitle(String title) { this.title = title; }
	public String getTitle() { return title; }

	public void setAuthors(String authors) { this.authors = authors; }
	public String getAuthors() { return authors; }

	public void setAverageRating(float avgRating) { this.avgRating = avgRating; }
	public float getAverageRating() { return avgRating; }

	public void setLanguage(String language) { this.language = language; }
	public String getLanguage() { return language; }

	public void setPages(int numPages) { this.numPages = numPages; }
	public int getPages() { return numPages; }

	public static Book toBook(Document doc) {
		Book book = new Book();
		book.setId(doc.getObjectId(Constants.F_ID).toHexString());
		book.setBookId(doc.getInteger(Constants.F_BOOKID));
		book.setTitle(doc.getString(Constants.F_TITLE));
		book.setAuthors(doc.getString(Constants.F_AUTHORS));
		book.setAverageRating(
				Utils.readDouble(Constants.F_AVERAGE_RATING, doc, 0.0).floatValue());
		book.setLanguage(
				Utils.readString(Constants.F_LANGUAGE, doc, "eng"));
		book.setPages(Utils.readDouble(Constants.F_PAGES, doc, 0.0).intValue());
		return book;
	}

	@Override
	public String toString() {
		return "Book[id=%s, bookID=%d, title=%s, authors=%s, avg_rating=%f, language=%s, pages=%d]"
			.formatted(id, bookId, title, authors, avgRating, language, numPages);
	}
}
