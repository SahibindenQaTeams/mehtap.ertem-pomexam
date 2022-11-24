package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends BasePage{

    public CategoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(className = "all-classifieds-link")
    private WebElement allClassifiedLink;

    public void clickAllClassifiedLink(){
        allClassifiedLink.click();
    }
}
