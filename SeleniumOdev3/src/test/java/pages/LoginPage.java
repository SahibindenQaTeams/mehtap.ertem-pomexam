package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{

    public LoginPage(WebDriver webDriver)
    {
        super(webDriver);
    }
    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id= "userLoginSubmitButton")
    private WebElement submitButton;

    public void sendUserName() {
        username.click();
    username.sendKeys("f.esrakose"); }

    public String getTextUserName() { return username.getText(); }

    public void sendPassword() {
        password.click();
        password.sendKeys("password"); }

    public String getPassword()  { return password.getText();}

    public void clickSubmitButton()
    {
        submitButton.click();
    }

    public HomePage login()
    {
        sendUserName();
        sendPassword();
        clickSubmitButton();
        return new HomePage(driver);
    }

}


