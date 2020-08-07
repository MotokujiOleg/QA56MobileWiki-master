package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CurrentArticlePageHelper;
import pages.SearchPageHelper;
import tests.TestBase;

import java.net.MalformedURLException;
import java.net.URL;

public class SearchTests extends TestBase {
    SearchPageHelper searchPage;
    CurrentArticlePageHelper articleSeleniumSoftware;

    @BeforeMethod
    public void initTests(){
        searchPage = PageFactory.initElements(driver, SearchPageHelper.class);

        articleSeleniumSoftware= new CurrentArticlePageHelper(driver, "Selenium (software)");
        searchPage.waitUntilPageIsLoaded();
    }

    @Test
    public void wikiTest(){

        Assert.assertEquals("Search Wikipedia", searchPage.getSearchFieldText());
    }

    @Test
    public void searchArticle(){

        searchPage.enterSearchText("Selenium");
        Assert.assertTrue(searchPage.existArticleInSearchResult("Selenium (software)") );

    }

    @Test
    public void searchArticleAndOpen(){
        searchPage.enterSearchText("Selenium");
        searchPage.openArticle("Selenium (software)");
        articleSeleniumSoftware.waitUntilPageIsLoaded();
        Assert.assertTrue(articleSeleniumSoftware.isOpenedCorrectly());

    }


}
