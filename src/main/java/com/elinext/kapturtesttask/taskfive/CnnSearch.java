/**
 * 
 */
package com.elinext.kapturtesttask.taskfive;

import java.io.IOException;
import java.util.logging.Level;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * @author Артем
 *
 */
public class CnnSearch {

	public static void main(String[] args) throws IOException, InterruptedException {
		java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);

		WebClient webClient = new WebClient(BrowserVersion.CHROME);
		webClient.getOptions().setJavaScriptEnabled(true);
		webClient.getOptions().setThrowExceptionOnScriptError(false);

		HtmlPage page = webClient.getPage("https://cnn.com");
		System.out.println("LoadingPage...");
		webClient.waitForBackgroundJavaScript(10000);

		Document doc = Jsoup.parse(page.asXml());
		doc.body().select("noscript").remove();
		Elements elements = doc.body().getElementsContainingOwnText("Trump");
		for (Element el : elements) {
			System.out.println(el.text());
		}

		webClient.close();
	}

}
