package NLP_Maven;

import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupExtractingWeb {

	public static void main(String[] args) {

		try {
			//String url = "https://simple.wikipedia.org/wiki/Main_Page";
			//File file = new File(url);
			File file = new File("sample.html");
			Document document = Jsoup.parse(file, "UTF-8", "");
			
			String title = document.title();
			System.out.println("Title: " + title);
			
			System.out.println("--Body--");
			Elements element = document.select("body");
			System.out.println(element.text());
			
			System.out.println("--Links--");
			Elements links = document.select("a[href]");
			for (Element link : links) {
				System.out.println(link.attr("href") + " >> " + link.text());
			}
			
			System.out.println("--Images--");
			Elements images = document.select("img[src$=.jpg]");
			for (Element image : images) {
				System.out.println(image);
			}
			
			
			
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
