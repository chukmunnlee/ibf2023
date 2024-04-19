package ibf2023.paf.day26;

import org.bson.Document;

public class Utils {

	public static String readString(String fieldName, Document doc, String defVal) {
		try {
			return doc.getString(fieldName);
		} catch (Exception ex) {
			return defVal;
		}
	}
	public static Double readDouble(String fieldName, Document doc, Double defVal) {
		try {
			return doc.getDouble(fieldName);
		} catch (Exception ex) {
			return defVal;
		}
	}
}
