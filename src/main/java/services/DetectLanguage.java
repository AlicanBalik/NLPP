package services;

import java.util.List;

import com.optimaize.langdetect.LanguageDetector;
import com.optimaize.langdetect.LanguageDetectorBuilder;
import com.optimaize.langdetect.i18n.LdLocale;
import com.optimaize.langdetect.ngram.NgramExtractors;
import com.optimaize.langdetect.profiles.LanguageProfile;
import com.optimaize.langdetect.profiles.LanguageProfileReader;
import com.optimaize.langdetect.text.CommonTextObjectFactories;
import com.optimaize.langdetect.text.TextObject;
import com.optimaize.langdetect.text.TextObjectFactory;

public class DetectLanguage {

	public static String language(String input) throws Exception {
		org.apache.log4j.BasicConfigurator.configure();
		
		if(input.isEmpty()) return null;

		List<LanguageProfile> languageProfiles = new LanguageProfileReader().readAllBuiltIn();

		LanguageDetector languageDetector = LanguageDetectorBuilder.create(NgramExtractors.standard())
				.withProfiles(languageProfiles).build();

		TextObjectFactory textObjectFactory = CommonTextObjectFactories.forDetectingOnLargeText();

		TextObject textObject = textObjectFactory.forText(input);
		com.google.common.base.Optional<LdLocale> lang = languageDetector.detect(textObject);

		String detectedLanguage = lang.toString();
		if(lang.isPresent()) {
			detectedLanguage = detectedLanguage.substring(detectedLanguage.indexOf("(") + 1, detectedLanguage.indexOf(")")); 
		} else {
			throw new Exception("I couldn't detect the language. Don't torture me...");
		}

		return detectedLanguage;

	}

}
