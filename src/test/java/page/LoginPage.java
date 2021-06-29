package page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageFactory {
    WebDriver driver;

    public LoginPage(WebDriver drive) {
        this.driver = drive;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@id='main-nav']//a[contains(text(),'My Account')]")
    WebElement myAccountMenu;
    @FindBy(xpath = "//input[@id='username']")
    WebElement txtUserName;
    @FindBy(xpath = "//input[@id='password']")
    WebElement txtPassword;
    @FindBy(xpath = "//input[@type ='submit' and @name = 'login']")
    WebElement btnLogin;
    @FindBy(xpath = "//nav[@class='woocommerce-MyAccount-navigation']//a[contains(text(),'Dashboard')]")
    WebElement dashboard;

    public void clickMyAccountMenu() {
        myAccountMenu.click();
    }

    public void login(String userName, String password) {
        inputUserName(userName);
        inputPassword(password);
        clickLoginButton();

    }

    public void inputUserName(String userName) {
        txtUserName.clear();
        txtUserName.sendKeys(userName);
    }

    public void inputPassword(String password) {
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        btnLogin.click();
    }

    public void verifyLoginPass() {
        Assert.assertTrue(dashboard.isDisplayed());
    }
}
