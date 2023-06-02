package NLP_Maven;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

public class Runner {
	
	

	public static void main(String[] args) {
		CleaningTools ct = new CleaningTools();
		
		String text = "The quick brown fox \t jumps over the lazy dog. ";
		text += "Waltz, bad nymph, for quick jigs vex.  (28 letters)\t";
		text += "How vexingly quick daft zebras jump! (30 letters)\t";
		text += "Pack my box with five dozen liquor jugs. (32 letters)";

		System.out.println("Original text: " + text);
		
		System.out.println();
		
		
		ct.cleaningtext(text);
		
		System.out.println();
		
		
		ct.cleaningtextGuava(text);
		
		System.out.println();
		
		
		ct.cleaningtextGuavaCharMatcher(text);
		
		
		ct.charMatcherRetention();
		
	}


	

}
