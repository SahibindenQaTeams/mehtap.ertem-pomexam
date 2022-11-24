package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClassifiedCategorySelectPage extends BasePage
{
    public ClassifiedCategorySelectPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(css = "span[ng-bind='category.label'] and [contains(text(),'İkinci El ve Sıfır Alışveriş')]")
    private WebElement shoppingClassified;

    public ShoppingClassifiedPhotoSelectlStepPage clickShoppingClassified()
    {
        shoppingClassified.click();
        return new ShoppingClassifiedPhotoSelectlStepPage(driver);
    }
}
