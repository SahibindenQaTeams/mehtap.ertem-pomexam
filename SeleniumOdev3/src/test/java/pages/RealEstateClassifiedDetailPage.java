package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RealEstateClassifiedDetailPage extends BasePage
{
    public RealEstateClassifiedDetailPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(css = "div[id='classifiedDetail']>div .classifiedDetailTitle")
    private WebElement classifiedTitleInDetail;

    public String getClassifiedDetailTitle()
    {

        return classifiedTitleInDetail.getText();

    }
}
