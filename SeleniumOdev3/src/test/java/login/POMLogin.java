package login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.LoginPage;

import java.io.File;

public class POMLogin extends LoginBaseClass
{
    private static final Logger logger = LogManager.getLogger(POMLogin.class);
    LoginPage loginPage;

    @BeforeEach
    public void before()
    {
        loginPage = new LoginPage(driver);
        setCookieToTestbox();
    }

    @Test
    @Tag("LOGIN")
    public void testLogin()
    {
        try
        {
            loginPage.sendUserName();
            String userName = loginPage.getTextUserName();
            logger.info("Kullanici adi = " + userName);

            loginPage.sendPassword();
            String password = loginPage.getPassword();
            logger.info("Şifre= " + password);

            loginPage.clickSubmitButton();
            logger.info("Success login");

        }
        catch (Exception exception)
        {
            logger.info("Error message: Test fail");
            File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            logger.info(imageFile.getPath());
        }
    }
}



