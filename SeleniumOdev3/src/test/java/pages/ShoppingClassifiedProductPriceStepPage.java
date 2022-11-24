package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingClassifiedProductPriceStepPage extends BasePage
{

    public ShoppingClassifiedProductPriceStepPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(css = "[name='addClassifiedPrice']")
    private WebElement classifiedPrice;

    @FindBy(xpath = "//[@class='add-classified-submit btn btn-strong']")
    private WebElement continueButton;

    public void addClassifiedPrice()
    {
        classifiedPrice.click();
        classifiedPrice.sendKeys("1000");
    }

    public ShoppingClassifiedShippingOptionsPage clickContinue()
    {
        continueButton.click();
        return new ShoppingClassifiedShippingOptionsPage(driver);
    }

}
