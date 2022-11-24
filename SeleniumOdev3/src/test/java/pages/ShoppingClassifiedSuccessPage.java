package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingClassifiedSuccessPage extends BasePage
{
    public ShoppingClassifiedSuccessPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(css = "[ng-class=\"{'sicily': !addedClassified.list}\"]")
    private WebElement successText;

    public String getTextSuccessPage()
    {
        return successText.getText();
    }

}