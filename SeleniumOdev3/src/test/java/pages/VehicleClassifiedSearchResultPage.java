package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehicleClassifiedSearchResultPage extends BasePage {

    public VehicleClassifiedSearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = ".classifiedDetailTitle h1")
    public WebElement classifiedTitle;

    public String getClassifiedTitle() {
        return classifiedTitle.getText();
    }
}