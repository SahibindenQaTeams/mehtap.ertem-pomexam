package realestatesearchresult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.HomePage;
import pages.RealEstateClassifiedDetailPage;
import pages.RealEstateResultPage;
import popularsearch.POMPopularSearch;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class RealEstateSearchClass extends popularsearch.BaseClass
{
    HomePage homePage;
    RealEstateResultPage realestateresultpage;
    RealEstateClassifiedDetailPage realestateclassifieddetailpage;
    private static final Logger logger = LogManager.getLogger(POMPopularSearch.class);

    @BeforeEach
    public void before()
    {
        homePage = new HomePage(driver);
        setCookieToTestbox();
    }

    @Test
    @Tag("REAL ESTATE SEARCH RESULT")
    public void testRealEstateSearchPage()
    {
        //search with text
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        try
        {
            homePage.addSearchText();
            sleep();
            realestateresultpage = homePage.clickFindButton();
            logger.info("Waiting for classified list..");
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            Assertions.assertTrue(realestateresultpage.getClassifiedSize() > 0);

            realestateresultpage.clickCityFilter();
            sleep();
            realestateresultpage.addPriceFilter();
            logger.info("Filters are selected");
            realestateresultpage.clickFindButton();

            String firstClassifiedTitle = realestateresultpage.getFirstClassifiedTitle();
            realestateclassifieddetailpage = realestateresultpage.clickFirstClassified();

            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

            String classifiedDetailTitle = realestateclassifieddetailpage.getClassifiedDetailTitle();

            //classified detail title assertion
            Assertions.assertEquals(firstClassifiedTitle, classifiedDetailTitle);
        }
        catch (Exception exception)
        {
            logger.info("Error message: Test fail");
            File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            logger.info(imageFile.getPath());
        }

    }
}
