package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingClassifiedShippingOptionsPage extends BasePage
{
    public ShoppingClassifiedShippingOptionsPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(css = " span[class='empty-span']")
    private WebElement faceToFaceShipping;

    @FindBy(xpath = "//[@class='add-classified-submit btn btn-strong']")
    private WebElement continueButton;

    public void clickShippingOptions()
    {
        faceToFaceShipping.click();
    }

    public ShoppingClassifiedPreviewPage clickContinue()
    {
        continueButton.click();
        return new ShoppingClassifiedPreviewPage(driver);
    }
}
