package ibf2023.paf.day26.models;

import org.bson.Document;

import ibf2023.paf.day26.repositories.Constants;

public record BookSummary(String id, String title) { 

	public static BookSummary toBookSummary(Document doc) {
		return new BookSummary(
				doc.getObjectId(Constants.F_ID).toHexString(), 
				doc.getString(Constants.F_TITLE));
	}
}
