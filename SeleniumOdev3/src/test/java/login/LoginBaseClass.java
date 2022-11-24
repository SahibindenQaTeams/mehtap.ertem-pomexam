package login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.ArrayList;
import java.util.List;

public class LoginBaseClass
{
    protected WebDriver driver;
    private static final Logger logger = LogManager.getLogger(LoginBaseClass.class);

    @BeforeAll
    public static void beforeall()
    {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeTest()
    {
        driver = new ChromeDriver();
        driver.get("https://secure.sahibinden.com/giris");
    }

    public void setCookieToTestbox()
    {
        List<Cookie> cookieList = new ArrayList<>();
        cookieList.add(new Cookie("testBox", "06", ".sahibinden.com", "/", null));
        cookieList.add(new Cookie("tbSite", "x", ".sahibinden.com", "/", null));
        cookieList.add(new Cookie("VISITOR_INFO1_LIVE", "true"));
        cookieList.forEach(cookie -> driver.manage().addCookie(cookie));

        driver.navigate().refresh();
    }

    @AfterEach
    public void afterTest()
    {
        driver.quit();
        logger.info("ChromeDriver kapatıldı.");

    }
}
