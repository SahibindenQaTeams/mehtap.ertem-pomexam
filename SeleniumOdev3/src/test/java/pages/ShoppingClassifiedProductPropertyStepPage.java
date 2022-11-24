package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShoppingClassifiedProductPropertyStepPage extends BasePage
{

    public ShoppingClassifiedProductPropertyStepPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(xpath = "//[@class='add-classified-submit btn btn-strong']")
    private WebElement continueButton;

    public void addProductProperty()
    {
        Select brand = new Select(driver.findElement(By.cssSelector("select[name='a2690']")));
        brand.selectByVisibleText("Adorablebaby");

        Select condition = new Select(driver.findElement(By.cssSelector("select[name='condition']")));
        condition.selectByVisibleText("Sıfır");
    }

    public ShoppingClassifiedProductPriceStepPage clickContinue()
    {
        continueButton.click();
        return new ShoppingClassifiedProductPriceStepPage(driver);
    }
}
