package Pratice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RecordScript {
	
		  public static void main(String[] args) {
		    try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		      BrowserContext context = browser.newContext();
		      // Open new page
		      Page page = context.newPage();
		      // Go to https://www.facebook.com/
		      page.navigate("https://www.facebook.com/");
		      // Click [data-testid="open-registration-form-button"]
		      // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://www.facebook.com/"), () ->
		      page.waitForNavigation(() -> {
		        page.locator("[data-testid=\"open-registration-form-button\"]").click();
		      });
		      // Select 20
		      page.locator("[aria-label=\"Day\"]").selectOption("20");
		      // Select 11
		      page.locator("[aria-label=\"Month\"]").selectOption("11");
		      // Select 2020
		      page.locator("[aria-label=\"Year\"]").selectOption("2020");
		   
		  }
		}
}
