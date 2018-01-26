package helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.CroatianPrefix;
import models.GermanPrefix;
import models.TurkishPrefix;

public class Helper extends HelperUtils {

	static String checkin, checkout, city, room = null;
	static int index = 0;
	static List<String> parsedInput;
	// keywords contains values in order: city, room, checkin, checkout.
	
	public static List<Object> parseInputInCroatian(String input) {
		parsedInput = Arrays.asList(input.split(" "));

		// Želio bih rezervirati jednu sobu u Neumu između 25.05.2018 i 30.05.2018

		index = parsedInput.indexOf(CroatianPrefix.i.getPrefix());
		checkin = (String) parsedInput.get(index - 1);
		checkout = (String) parsedInput.get(index + 1);
		index = parsedInput.indexOf(CroatianPrefix.u.getPrefix());
		city = (String) parsedInput.get(index + 1);
		// in croatian&bosnian, if place preposition is determined by "u" rather than "na", place name ends with "u".
		// e.g.: "u Sarajevu, u Mostaru, u Istanbulu... but... na Otici, na Fakulteta...  
		city = city.substring(0, city.length() - 1);
		index = parsedInput.indexOf(CroatianPrefix.rezervirati.getPrefix());
		room = (String) parsedInput.get(index + 1);
		List<Object> keywords = new ArrayList<Object>();
		keywords.add(city);
		keywords.add(convertRoomInCroatian(room));
		keywords.add(stringToDate(checkin));
		keywords.add(stringToDate(checkout));

		return keywords;
	}

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
