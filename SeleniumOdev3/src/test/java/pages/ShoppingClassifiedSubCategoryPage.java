package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingClassifiedSubCategoryPage extends BasePage
{
    public ShoppingClassifiedSubCategoryPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(xpath = "//[@class='recommended-category']")
    private WebElement recommendedCategory;

    @FindBy(xpath = "//[@class='add-classified-submit btn btn-strong']")
    private WebElement Continue;

    public void clickRecommendedCategory()
    {
        recommendedCategory.click();
    }

    public void clickContinue()
    {
        Continue.click();
    }
}
