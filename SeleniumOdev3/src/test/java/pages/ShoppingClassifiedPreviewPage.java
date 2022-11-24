package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingClassifiedPreviewPage extends BasePage
{
    public ShoppingClassifiedPreviewPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(css = "[ng-click=='submitClassified()']")
    private WebElement continueButton;

    public ShoppingClassifiedDopingPage clickContinue()
    {
        continueButton.click();
        return new ShoppingClassifiedDopingPage(driver);
    }
}
