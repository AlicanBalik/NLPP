package services;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dao.ReservationDAO;
import helpers.Helper;
import models.Languages;
import models.ListResult;

public class GlobalService extends DetectLanguage {

	private static Helper helpers;

	private static ReservationDAO reservationDAO;

	private static List<Object> keywords = null;
	// // city, room, checkin, checkout.

	@SuppressWarnings("static-access")
	public static void process(String input) throws Exception {

		String detectedLanguage = language(input);

		if (null != detectedLanguage) {

			if (detectedLanguage.equals(Languages.English.getPrefix())) {
				// do english thing
				log("english");
				keywords = helpers.parseInputInEnglish(input);
			} else if (detectedLanguage.equals(Languages.German.getPrefix())) {
				// do german thing
				log("german");
				keywords = helpers.parseInputInGerman(input);
			} else if (detectedLanguage.equals(Languages.Turkish.getPrefix())) {
				// do turkish thing
				log("turkish");
				keywords = helpers.parseInputInTurkish(input);
			} else {
				throw new Exception("Unknown language... Booomm");
			}

			List<ListResult> list = reservationDAO.showAccommodations(keywords);
			displayResult(list);

		} else {
			System.err.print("Sorry. I couldn't detect your language...");
		}
	}

	public static void displayResult(List<ListResult> list) throws IOException {
		int roomChoice = (Integer) keywords.get(1);
		// // id, count, roomName, price, capacity, name, address
		for(int i = 0; i < 50; i++) System.out.println();

		String r = list.size() > 1 ? "rooms" : "room";
		if (list.size() > 0) {
//			Map.Entry<Object, ListResult> entry = map.entrySet().iterator().next();
//			ListResult l = entry.getValue();
			ListResult l = list.get(0);
			log("Okay. I got a result...\nI found " + list.size() + " " + r + " just for you...");
			log("**********************");
			log("Accommodation:");
			log("Name: " + l.getName() + "  " + l.getRank() + "*");
			log("Address: " + l.getAddress());
			log("-------------------------------------------");
			for (int i = 0; i < list.size(); i++) {
				l = list.get(i); 					// count is always bigger than 1. NO need grammar validation
				log((i+1) + ".: Room type " + (i + 1) + ": (There are " + l.getCount() + " rooms available for this room type)");
				log("Name: " + l.getRoomName());
				log("Guest number: " + l.getCapacity() + " "
						+ (roomChoice == l.getCapacity() ? "**Best match for you!**" : ""));
				log("Price: " + l.getPrice() + "BAM");
				log("\n\n\n");
			}
			log("-------------------------------------------");
			log("Which book do you want to book?");
			System.err.println("Warning: Once you type a number from numpad, the sytem will immediately book the room");
			Scanner reader = new Scanner(System.in);
			String input = reader.nextLine().toLowerCase();
			String firstCharacter = input.substring(0, 1);
			int selection = Integer.valueOf(firstCharacter) - 1;
			if(null != list.get(selection)) {
				l = list.get(selection);
				log("You reserved " + l.getRoomName() + " for the dates between " + keywords.get(2) + " and " + keywords.get(3));
				log((Integer)keywords.get(1) * l.getPrice() + "BAM has been taken from your account.");
			}

		} else {
			System.err.println("SORRY... I couldn't find any result regarding your wish. I'm out.");
		}
	}

	public static void log(String str) {
		System.out.println(str);
	}
}
