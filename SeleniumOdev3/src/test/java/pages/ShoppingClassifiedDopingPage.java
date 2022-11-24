package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingClassifiedDopingPage extends BasePage
{

    public ShoppingClassifiedDopingPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(css ="[ng-click=='submit()']")
    private WebElement continueButton;

    public ShoppingClassifiedSuccessPage clickContinue()
    {
        continueButton.click();
        return new ShoppingClassifiedSuccessPage(driver);
    }
}
