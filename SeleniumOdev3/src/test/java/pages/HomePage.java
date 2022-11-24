package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage
{

    public HomePage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(css = "[title='Otomobil']")
    private WebElement otomobil;

    @FindBy(xpath = "//div[@class='uiBox most'][1]//li")
    private List<WebElement> popularCategoryElements;

    @FindBy(xpath = "//[@class='btn btn-modern new-classified ng-binding']")
    private WebElement postClassifiedButton;

    @FindBy(xpath = "//button[@value='Ara']")
    private WebElement findButton;

    @FindBy(id = "searchText")
    private WebElement searchText;

    @FindBy(css = "ul.ui-autocomplete>:nth-of-type(1)")
    private WebElement realEstateOption;

    public void clickOtomobil()
    {
        otomobil.click();
    }

    public String getTextCategory(int index)
    {
        return popularCategoryElements.get(index).getText();
    }

    public PopularSearchResultPage clickCategory(int index)
    {
        popularCategoryElements.get(index).click();
        return new PopularSearchResultPage(this.driver);
    }

    public  ClassifiedCategorySelectPage clickPostClassifiedButton()
    {
        postClassifiedButton.click();
        return new ClassifiedCategorySelectPage(driver);
    }

    public void addSearchText()
    {
        searchText.click();
        searchText.sendKeys("3+1 daire");
    }

    public RealEstateResultPage clickFindButton()
    {
        findButton.click();
        return new RealEstateResultPage(driver);
    }
}
