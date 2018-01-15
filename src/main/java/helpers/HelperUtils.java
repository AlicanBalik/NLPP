package helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import models.EnglishPrefix;
import models.GermanPrefix;
import models.TurkishPrefix;

public class HelperUtils {
	
	public static LocalDate stringToDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH);
		LocalDate d = LocalDate.parse(date, formatter);
		
		return d;
	}

	public static Integer convertRoomInTurkish(String room) {

		if (room.equals(TurkishPrefix.one.getPrefix())) {
			return 1;
		} else if (room.equals(TurkishPrefix.two.getPrefix())) {
			return 2;
		} else if (room.equals(TurkishPrefix.three.getPrefix())) {
			return 3;
		} else if (room.equals(TurkishPrefix.four.getPrefix())) {
			return 4;
		} else {
			return 5;
		}
	}

	public static Integer convertRoomInEnglish(String room) {

		if (room.equals(EnglishPrefix.one.getPrefix())) {
			return 1;
		} else if (room.equals(EnglishPrefix.two.getPrefix())) {
			return 2;
		} else if (room.equals(EnglishPrefix.three.getPrefix())) {
			return 3;
		} else if (room.equals(EnglishPrefix.four.getPrefix())) {
			return 4;
		} else {
			return 5;
		}
	}

	public static Integer convertRoomInGerman(String room) {

		if (room.equals(GermanPrefix.one.getPrefix())) {
			return 1;
		} else if (room.equals(GermanPrefix.two.getPrefix())) {
			return 2;
		} else if (room.equals(GermanPrefix.three.getPrefix())) {
			return 3;
		} else if (room.equals(GermanPrefix.four.getPrefix())) {
			return 4;
		} else {
			return 5;
		}
	}
}
