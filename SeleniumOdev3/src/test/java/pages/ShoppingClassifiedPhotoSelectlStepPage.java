package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingClassifiedPhotoSelectlStepPage extends BasePage
{

    public ShoppingClassifiedPhotoSelectlStepPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(xpath = "//[@class='add-classified-submit btn btn-strong']")
    private WebElement continueButton;

    public ShoppingClassifiedDetailPage clickContinue()
    {
        continueButton.click();
        return new ShoppingClassifiedDetailPage(driver);
    }
}
