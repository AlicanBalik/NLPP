package alican.nlp;

import java.io.*;
import java.util.Scanner;

import services.GlobalService;

public class Root extends GlobalService {

	public static void main(String[] args) throws Exception {

		try {
			Scanner reader = new Scanner(System.in);
			String input;
			
			// I would like to book one room in Neum between 25.05.2018 and 30.05.2018.
			// Ich möchte ein Zimmer in Neum zwischen 25.05.2018 und 30.05.2018 buchen.
			// 25.05.2018 ve 30.05.2018 tarihleri arasinda Neum'da bir oda rezervasyonu yaptirmak istiyorum.

//			do {
				System.out.println("Welcome to the Automated Booking System.\n(.. a good message here ..)");
				input = reader.nextLine();
				
				process(input.toLowerCase());

//			} while (!input.equals("end") || !input.equals("exit"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
