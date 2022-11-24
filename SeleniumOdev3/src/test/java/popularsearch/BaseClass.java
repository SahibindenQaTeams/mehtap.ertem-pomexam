package popularsearch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;

import java.util.ArrayList;
import java.util.List;

public class BaseClass
{
    protected WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BaseClass.class);

    @BeforeAll
    public static void beforeall()
    {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeTest()
    {
        driver = new ChromeDriver();

        driver.get("http://sahibinden.com/");

        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        localStorage.setItem("feature_discovery_data",
                "{\"add-to-favorites\":{\"count\":1,\"displayedAt\":1666694107010},\"extended\":true}");

        SessionStorage sessionStorage = ((WebStorage) driver).getSessionStorage();
        sessionStorage.setItem("feature_discovery_displayed", "true");
    }

    public void setCookieToTestbox()
    {
        List<Cookie> cookieList = new ArrayList<>();
        cookieList.add(new Cookie("testBox", "06", ".sahibinden.com", "/", null));
        cookieList.add(new Cookie("tbSite", "x", ".sahibinden.com", "/", null));
        cookieList.forEach(cookie -> driver.manage().addCookie(cookie));

        driver.navigate().refresh();
    }

    @AfterEach
    public void afterTest()
    {
        driver.quit();
        logger.info("ChromeDriver kapatıldı.");

    }
    public void sleep()
    {
        try
        {
            Thread.sleep(3000);
        }

        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

