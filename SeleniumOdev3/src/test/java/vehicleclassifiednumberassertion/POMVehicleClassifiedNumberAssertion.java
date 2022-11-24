package vehicleclassifiednumberassertion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.CategoryPage;
import pages.HomePage;
import pages.VehicleClassifiedSearchResultPage;
import pages.VehicleSearchResultPage;

import java.io.File;

public class POMVehicleClassifiedNumberAssertion extends VehicleBaseClass
{

    HomePage homePage;
    CategoryPage categoryAutomobilePage;
    VehicleSearchResultPage vehicleSearchResultPage;
    VehicleClassifiedSearchResultPage vehicleclassifiedsearchresultpage;
    private static final Logger logger = LogManager.getLogger(POMVehicleClassifiedNumberAssertion.class);

    @BeforeEach
    public void before()
    {
        homePage = new HomePage(driver);
        categoryAutomobilePage = new CategoryPage(driver);
        vehicleSearchResultPage = new VehicleSearchResultPage(driver);

        setCookieToTestbox();
    }

    @Test
    @Tag("VEHICLE CLASSIFIED NUMBER ASSERTION")
    public void testVehicleClassifiedNumberAssertion()
    {

        driver.manage().addCookie(new Cookie("VISITOR_INFO1_LIVE", "true"));
        driver.navigate().refresh();

        try
        {
            homePage.clickOtomobil();
            logger.info("Otomobil tıklandı.");
            categoryAutomobilePage.clickAllClassifiedLink();
            logger.info("Tüm ilanlar seçildi.");

            Assertions.assertTrue(vehicleSearchResultPage.getClassifiedSize() > 0);

            String title = vehicleSearchResultPage.getFirstClassifiedTitle();
            String KM = vehicleSearchResultPage.getFirstClassifiedKM();
            String price = vehicleSearchResultPage.getFirstClassifiedPrice();

            System.out.println(title);
            System.out.println(KM);
            System.out.println(price);

            vehicleSearchResultPage.clickFirstClassified();

            String classifiedTitle = vehicleclassifiedsearchresultpage.getClassifiedTitle();

            Assertions.assertEquals(title, classifiedTitle);
        }
        catch (Exception exception)
        {
            logger.info("Error message: Test fail");
            File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            logger.info(imageFile.getPath());
        }
    }
}