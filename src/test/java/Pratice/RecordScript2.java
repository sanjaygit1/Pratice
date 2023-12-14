package Pratice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RecordScript2 {


  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      // Open new page
      Page page = context.newPage();
      // Go to https://www.amazon.in/
      page.navigate("https://www.amazon.in/");
      // Click [placeholder="Search\ Amazon\.in"]
      page.locator("[placeholder=\"Search\\ Amazon\\.in\"]").click();
      // Fill [placeholder="Search\ Amazon\.in"]
      page.locator("[placeholder=\"Search\\ Amazon\\.in\"]").fill("nike");
      // Click input:has-text("Go")
      // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://www.amazon.in/s?k=nike&crid=2HCUG6JBVWKG3&sprefix=nike%2Caps%2C208&ref=nb_sb_noss_1"), () ->
      page.waitForNavigation(() -> {
        page.locator("input:has-text(\"Go\")").click();
      });
      // assert page.url().equals("https://www.amazon.in/s/ref=nb_sb_noss_1?url=search-alias%3Daps&field-keywords=nike&crid=2HCUG6JBVWKG3&sprefix=nike%2Caps%2C208");
      // Click img[alt="Nike\ Mens\ Downshifter\ 12\ Running"]
      // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://www.amazon.in/Nike-Downshifter-White-DK-Grey-Pure-Platinum/dp/B0B56ZGFJ9/ref=sr_1_1?crid=2HCUG6JBVWKG3&keywords=nike&nsdOptOutParam=true&qid=1696348027&sprefix=nike%2Caps%2C208&sr=8-1"), () ->
      page.waitForNavigation(() -> {
        Page page1 = page.waitForPopup(() -> {
          page.locator("img[alt=\"Nike\\ Mens\\ Downshifter\\ 12\\ Running\"]").click();
        });
      });
//      // Go to https://www.amazon.in/Nike-Downshifter-White-DK-Grey-Pure-Platinum/dp/B0B56ZGFJ9/ref=sr_1_1?crid=2HCUG6JBVWKG3&keywords=nike&nsdOptOutParam=true&qid=1696348027&sprefix=nike%2Caps%2C208&sr=8-1&th=1&psc=1
//      page1.navigate("https://www.amazon.in/Nike-Downshifter-White-DK-Grey-Pure-Platinum/dp/B0B56ZGFJ9/ref=sr_1_1?crid=2HCUG6JBVWKG3&keywords=nike&nsdOptOutParam=true&qid=1696348027&sprefix=nike%2Caps%2C208&sr=8-1&th=1&psc=1");
//      // Click ._bXVsd_container_GMk6b.sbx-desktop.sbx-no-js ._bXVsd_content_2rsXy ._bXVsd_customImageContainer_1pyvS .a-spacing-none ._bXVsd_image_1pfbQ >> nth=0
//      // page1.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://www.amazon.in/stores/page/8E1D8834-4832-4F89-8DCD-52D2ED813DF5/?_encoding=UTF8&store_ref=SB_A102314634K22SPBZF5RD&pd_rd_plhdr=t&aaxitk=8c44924fbe5aa3377c22f441e0ca0126&hsa_cr_id=4367580970502&lp_asins=B09R3V65NP%2CB0B51HT5D7&lp_query=nike&lp_slot=desktop-arbies&lp_page_asin=B0B56ZGFJ9&pd_rd_i=ad2&ref_=sbx_be_dp_arbies_mblsd_mb1_ls&pd_rd_w=BL2SQ&content-id=amzn1.sym.10aba3b8-8c03-498c-b35e-af7f77145388&pf_rd_p=10aba3b8-8c03-498c-b35e-af7f77145388&pf_rd_r=Z23KW08Q9QRWKD586HKN&pd_rd_wg=SYUsO&pd_rd_r=eee95201-5d21-475f-9a27-ae5a5f854387"), () ->
//      page1.waitForNavigation(() -> {
//        page1.locator("._bXVsd_container_GMk6b.sbx-desktop.sbx-no-js ._bXVsd_content_2rsXy ._bXVsd_customImageContainer_1pyvS .a-spacing-none ._bXVsd_image_1pfbQ").first().click();
//      });
    }
  }

}
