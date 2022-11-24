package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopularSearchResultPage extends BasePage
{
    public PopularSearchResultPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(css = "#search_cats ul li:last-of-type h2")
    public WebElement leftMenuItem;

    public String getTextLeftMenuItem()
    {
        return leftMenuItem.getText();
    }
}
