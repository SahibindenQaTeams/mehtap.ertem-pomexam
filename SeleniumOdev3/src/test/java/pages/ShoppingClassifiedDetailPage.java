package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShoppingClassifiedDetailPage extends BasePage
{
    public ShoppingClassifiedDetailPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    //get shopping classified first detail step
    @FindBy(css = "[name='addClassifiedTitle']")
    private WebElement addClassifiedTitle;

    @FindBy(name = "addClassifiedDetail")
    private WebElement classifiedDetailText;

    @FindBy(id = "postRulesCheck")
    private WebElement rulesCheck;

    @FindBy(xpath = "//[@class='add-classified-submit btn btn-strong']")
    private WebElement Continue;

    public void addClassifiedTitleAndDetail()
    {
        addClassifiedTitle.click();
        addClassifiedTitle.sendKeys("Anne bebek ev tekstili yorgan");

        classifiedDetailText.click();
        classifiedDetailText.sendKeys("Anne bebek ev tekstili yorgan");
    }

    public void clickAdressSelect()
    {
        Select qs = new Select(driver.findElement(By.name("quarter")));
        qs.selectByVisibleText("Adalar");

        Select ts = new Select(driver.findElement(By.name("town")));
        ts.selectByVisibleText("Kaşıkadası");
    }

    public void clickRulesCheck()
    {
        rulesCheck.click();
    }

    public ShoppingClassifiedProductPropertyStepPage clickContinue()
    {
        Continue.click();
        return new ShoppingClassifiedProductPropertyStepPage(driver);
    }
}
