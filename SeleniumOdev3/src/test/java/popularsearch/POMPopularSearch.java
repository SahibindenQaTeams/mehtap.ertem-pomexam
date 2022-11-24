package popularsearch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.HomePage;
import pages.PopularSearchResultPage;

import java.io.File;


public class POMPopularSearch extends BaseClass
{
    HomePage homePage;
    private static final Logger logger = LogManager.getLogger(POMPopularSearch.class);

    @BeforeEach
    public void before()
    {
        homePage = new HomePage(driver);
        setCookieToTestbox();
    }

    @Tag("POPULAR_SEARCH")
    @ParameterizedTest
    @CsvSource({"0", "1", "2", "3", "4"})
    public void testPopularSearch(String index)
    {
        try
        {
            driver.manage().addCookie(new Cookie("VISITOR_INFO1_LIVE", "true"));
            driver.navigate().refresh();
            HomePage homePage = new HomePage(driver);
            String categoryNameInHomePage = homePage.getTextCategory(Integer.parseInt(index));
            PopularSearchResultPage popularSearchResultPage = homePage.clickCategory(Integer.parseInt(index));
            logger.info(categoryNameInHomePage + " basıldı");

            String categoryNameInPopularSearch = popularSearchResultPage.getTextLeftMenuItem();
            Assertions.assertEquals(categoryNameInHomePage, categoryNameInPopularSearch);
        }
        catch (Exception exception)
        {
            logger.info("Error message: Test fail");
            File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            logger.info(imageFile.getPath());
        }
    }
}
