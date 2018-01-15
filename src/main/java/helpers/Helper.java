package helpers;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import models.EnglishPrefix;
import models.GermanPrefix;
import models.TurkishPrefix;

public class Helper extends HelperUtils {

	static String checkin, checkout, city, room = null;
	static int index = 0;
	@SuppressWarnings("rawtypes")
	static List<String> parsedInput;
	// keywords contains values in order: city, room, checkin, checkout.
	
	@SuppressWarnings("unchecked")
	public static List<Object> parseInputInEnglish(String input) {
		parsedInput = Arrays.asList(input.split(" "));

		// I would like to to book one room in Sarajevo between 25.05.2018 and 30.05.2018.

		index = parsedInput.indexOf(EnglishPrefix.and.getPrefix());
		checkin = (String) parsedInput.get(index - 1);
		checkout = (String) parsedInput.get(index + 1);
		index = parsedInput.indexOf(EnglishPrefix.in.getPrefix());
		city = (String) parsedInput.get(index + 1);
		index = parsedInput.indexOf(EnglishPrefix.book.getPrefix());
		room = (String) parsedInput.get(index + 1);
		List<Object> keywords = new ArrayList<Object>();
		keywords.add(city);
		keywords.add(convertRoomInEnglish(room));
		keywords.add(stringToDate(checkin));
		keywords.add(stringToDate(checkout));

		return keywords;
	}

	@SuppressWarnings("unchecked")
	public static List<Object> parseInputInGerman(String input) {
		parsedInput = Arrays.asList(input.split(" "));

		index = parsedInput.indexOf(GermanPrefix.und.getPrefix());
		checkin = (String) parsedInput.get(index - 1);
		checkout = (String) parsedInput.get(index + 1);
		index = parsedInput.indexOf(GermanPrefix.in.getPrefix());
		city = (String) parsedInput.get(index + 1);
		index = parsedInput.indexOf(GermanPrefix.zimmer.getPrefix());
		room = (String) parsedInput.get(index - 1);

		// Ich möchte ein Zimmer in Sarajevo zwischen 25.05.2018 und 30.05.2018 buchen.
		List<Object> keywords = new ArrayList<Object>();
		keywords.add(city);
		keywords.add(convertRoomInGerman(room));
		
		keywords.add(stringToDate(checkin));
		keywords.add(stringToDate(checkout));

		return keywords;
	}

	@SuppressWarnings("unchecked")
	public static List<Object> parseInputInTurkish(String input) {
		parsedInput = Arrays.asList(input.split(" "));
		// 25.05.2018 ve 30.05.2018 tarihleri arasinda Sarajevo'da bir oda rezervasyonu yaptirmak istiyorum.

		index = parsedInput.indexOf(TurkishPrefix.ve.getPrefix());
		checkin = (String) parsedInput.get(index - 1);
		checkout = (String) parsedInput.get(index + 1);
		index = parsedInput.indexOf(TurkishPrefix.arasinda.getPrefix());
		city = (String) parsedInput.get(index + 1);
		city = city.substring(0, city.indexOf("'"));
		index = parsedInput.indexOf(TurkishPrefix.oda.getPrefix());
		room = (String) parsedInput.get(index - 1);
		List<Object> keywords = new ArrayList<Object>();
		keywords.add(city);
		keywords.add(convertRoomInTurkish(room));
		keywords.add(stringToDate(checkin));
		keywords.add(stringToDate(checkout));

		return keywords;
	}

}
