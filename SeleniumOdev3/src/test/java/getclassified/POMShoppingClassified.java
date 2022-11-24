package getclassified;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.ClassifiedCategorySelectPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ShoppingClassifiedDetailPage;
import pages.ShoppingClassifiedDopingPage;
import pages.ShoppingClassifiedPhotoSelectlStepPage;
import pages.ShoppingClassifiedPreviewPage;
import pages.ShoppingClassifiedProductPriceStepPage;
import pages.ShoppingClassifiedProductPropertyStepPage;
import pages.ShoppingClassifiedShippingOptionsPage;
import pages.ShoppingClassifiedSuccessPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class POMShoppingClassified extends login.LoginBaseClass
{
    private static final Logger logger = LogManager.getLogger(POMShoppingClassified.class);
    LoginPage loginPage;
    HomePage homePage;
    ClassifiedCategorySelectPage classifiedcategoryselectpage;
    ShoppingClassifiedPhotoSelectlStepPage shoppingclassifiedphotoselectlsteppage;
    ShoppingClassifiedDetailPage shoppingclassifieddetailpage;
    ShoppingClassifiedProductPropertyStepPage shoppingclassifiedproductpropertysteppage;
    ShoppingClassifiedProductPriceStepPage shoppingclassifiedproductpricesteppage;
    ShoppingClassifiedShippingOptionsPage shoppingclassifiedshippingoptionspage;
    ShoppingClassifiedPreviewPage shoppingclassifiedpreviewpage;
    ShoppingClassifiedDopingPage shoppingclassifieddopingpage;
    ShoppingClassifiedSuccessPage shoppingclassifiedsuccesspage;

    @BeforeEach
    public void before()
    {
        loginPage = new LoginPage(driver);
        setCookieToTestbox();
    }

    @Test
    @Tag("GET SHOPPING CLASSIFIED")
    public void testGetShoppingClassified()
    {
        try{
        homePage = loginPage.login();
        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
        //start get shopping classified
        classifiedcategoryselectpage = homePage.clickPostClassifiedButton();
        shoppingclassifiedphotoselectlsteppage = classifiedcategoryselectpage.clickShoppingClassified();

        shoppingclassifieddetailpage = shoppingclassifiedphotoselectlsteppage.clickContinue();

        //enter classified detail
        shoppingclassifieddetailpage.addClassifiedTitleAndDetail();
        shoppingclassifieddetailpage.clickAdressSelect();
        shoppingclassifieddetailpage.clickRulesCheck();
        shoppingclassifiedproductpropertysteppage = shoppingclassifieddetailpage.clickContinue();
        logger.info("İlan detay oluşturuldu");

        //enter product property
        shoppingclassifiedproductpropertysteppage.addProductProperty();
        shoppingclassifiedproductpricesteppage = shoppingclassifiedproductpropertysteppage.clickContinue();
        logger.info("Ürün özellikleri girildi");

        //enter product price
        shoppingclassifiedproductpricesteppage.addClassifiedPrice();
        shoppingclassifiedshippingoptionspage = shoppingclassifiedproductpricesteppage.clickContinue();
        logger.info("Ürün fiyatı girildi");

        //enter shipping options
        shoppingclassifiedshippingoptionspage.clickShippingOptions();
        shoppingclassifiedpreviewpage = shoppingclassifiedshippingoptionspage.clickContinue();
        logger.info("Teslimat seceneği secildi");

        //preview page
        shoppingclassifieddopingpage = shoppingclassifiedpreviewpage.clickContinue();
        logger.info(("Önizleme sayfası görüldü"));

        // don't buy any doping
        shoppingclassifiedsuccesspage = shoppingclassifieddopingpage.clickContinue();

        //Assertion on success page
        Assertions.assertEquals("Tebrikler", shoppingclassifiedsuccesspage.getTextSuccessPage());
        logger.info("Tebrikler ilan girişiniz tamamlandı...");
    }
        catch (Exception exception)
        {
            logger.info("Error message: Test fail");
            File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            logger.info(imageFile.getPath());
        }
    }
}
