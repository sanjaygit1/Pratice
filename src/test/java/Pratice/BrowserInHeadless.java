package Pratice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserInHeadless {

	public static void main(String[] args) {
		//Start
		//server
	 Playwright play = Playwright.create();
		
	 //launching browser headed mode
	Browser browser = play.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
	
	//headless mode
//	Browser browser = play.webkit().launch();
	Page page = browser.newPage();
	page.navigate("https://www.amazon.in/");
	
	//get URL
	String URL = page.url();
	System.out.println(URL);
	
	//getTitle
	String Title = page.title();
	System.out.println(Title);
	
	//close browser
	browser.close();
	
	//close server
	play.close();
	}

}
