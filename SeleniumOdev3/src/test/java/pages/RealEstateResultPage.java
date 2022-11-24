package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RealEstateResultPage extends BasePage
{
    public RealEstateResultPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(css = "li>a.faceted-select")
    private WebElement cityFilter;

    @FindBy(css = ".searchResultsRowClass > tr > td:nth-child(1)")
    private List<WebElement> realEstateSearchResultClassifieds;

    @FindBy(xpath = "//li[@data-id='6']")
    private WebElement selectCity;

    @FindBy(xpath = "//input[@name='price_max']")
    private WebElement maxPriceFilter;

    @FindBy(css = "div>button.btn.btn-block.search-submit")
    private WebElement findButton;

    @FindBy(css = ".searchResultsRowClass > tr > td.searchResultsTitleValue")
    private List<WebElement> getFirstClassifiedTitle;

    public Integer getClassifiedSize()
    {
        return realEstateSearchResultClassifieds.size();
    }

    public void clickCityFilter()
    {
        cityFilter.click();
        selectCity.click();
    }

    public void addPriceFilter()
    {
        maxPriceFilter.click();
        maxPriceFilter.sendKeys("3.000.000");
    }

    public void clickFindButton()
    {
        findButton.click();
    }

    public String getFirstClassifiedTitle()
    {
        return getFirstClassifiedTitle.get(0).getText();

    }

    public RealEstateClassifiedDetailPage clickFirstClassified()
    {
        getFirstClassifiedTitle.get(0).click();
        return new RealEstateClassifiedDetailPage(driver);
    }
}
