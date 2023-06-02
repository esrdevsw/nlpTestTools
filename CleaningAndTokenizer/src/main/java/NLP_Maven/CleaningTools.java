package NLP_Maven;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

public class CleaningTools implements Cleaning{
	
	public void charMatcherRetention() {
		String retentiontext = CharMatcher.javaDigit()
				.or(CharMatcher.whitespace())
				.or(CharMatcher.javaLowerCase())
				.retainFrom("He is 5 FEET and 6 inches tall");
		System.out.println(retentiontext);
		
	}


	public void cleaningtext(String text) {
		String cleanedText = text.toLowerCase();
		cleanedText = cleanedText.trim();
		cleanedText = cleanedText.replace("\t", " ");
		
		while (cleanedText.contains("  ")) {
			cleanedText = cleanedText.replace("  ", " ");
		}
		
		System.out.println("Cleaned text: " + cleanedText);		
	}
	
	
	public void cleaningtextGuava(String text) {
		System.out.println("---- Splitter text guava ----");
		Iterable<String> iterator = Splitter.on(CharMatcher.whitespace())
				.omitEmptyStrings()
				.trimResults()
				.split(text);
		
		iterator.forEach(token -> System.out.print(token + " "));
		System.out.println();
	}
	
	public void cleaningtextGuavaCharMatcher(String text) {
		System.out.println("---- CharMatcher text guava ----");
		String cleanedText = CharMatcher.whitespace().trimAndCollapseFrom(text, ' ');
		
		System.out.println(cleanedText);
		System.out.println();
	}
}
