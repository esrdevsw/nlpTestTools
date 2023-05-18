package NLP_Maven;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

public class Runner {
	
	

	public static void main(String[] args) {
		String text = "The quick brown fox \t jumps over the lazy dog. ";
		text += "Waltz, bad nymph, for quick jigs vex.  (28 letters)\t";
		text += "How vexingly quick daft zebras jump! (30 letters)\t";
		text += "Pack my box with five dozen liquor jugs. (32 letters)";

		System.out.println("Original text: " + text);
		
		System.out.println();
		
		cleaningtext(text);
		
		System.out.println();
		
		cleaningtextGuava(text);
		
		System.out.println();
		
		cleaningtextGuavaCharMatcher(text);
		
		
	}


	private static void cleaningtext(String text) {
		String cleanedText = text.toLowerCase();
		cleanedText = cleanedText.trim();
		cleanedText = cleanedText.replace("\t", " ");
		
		while (cleanedText.contains("  ")) {
			cleanedText = cleanedText.replace("  ", " ");
		}
		
		System.out.println("Cleaned text: " + cleanedText);		
	}
	
	
	private static void cleaningtextGuava(String text) {
		System.out.println("---- Splitter text guava ----");
		Iterable<String> iterator = Splitter.on(CharMatcher.whitespace())
				.omitEmptyStrings()
				.trimResults()
				.split(text);
		
		iterator.forEach(token -> System.out.print(token + " "));
		System.out.println();
	}
	
	private static void cleaningtextGuavaCharMatcher(String text) {
		System.out.println("---- CharMatcher text guava ----");
		String cleanedText = CharMatcher.whitespace().trimAndCollapseFrom(text, ' ');
		
		System.out.println(cleanedText);
	}

}
