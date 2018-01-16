package services;

import java.util.List;

import dao.ReservationDAO;
import helpers.Helper;
import models.Languages;

public class GlobalService extends DetectLanguage {
	
	private static Helper helpers;
	
	private static ReservationDAO reservationDAO;
	
	@SuppressWarnings("static-access")
	public static void process(String input) throws Exception {

		String detectedLanguage = language(input);

		if (null != detectedLanguage) {

			List<Object> keywords = null;

			if (detectedLanguage.equals(Languages.English.getPrefix())) {
				// do english thing
				System.out.println("english");
				keywords = helpers.parseInputInEnglish(input);
			} else if (detectedLanguage.equals(Languages.German.getPrefix())) {
				// do german thing
				System.out.println("german");
				keywords = helpers.parseInputInGerman(input);
			} else if (detectedLanguage.equals(Languages.Turkish.getPrefix())) {
				// do turkish thing
				System.out.println("turkish");
				keywords = helpers.parseInputInTurkish(input);
			} else {
				System.err.println("Well... "
						+ "You speak good but I cannot understand what you say. Type your wish in English, German or Turkish.");
			}
			
			
			
			// keywords contains values in order: city, room, checkin, checkout.
			//asdkasldk
			for(int i = 0; i < keywords.size(); i++) {
				System.out.println(keywords.get(i));
			}
			
			reservationDAO.getDataFromDB();
			
			
		} else {
			System.err.print("Sorry. I couldn't detect your language...");
		}
	}
}
