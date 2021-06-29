package runner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.LoginPage;

public class LoginPageTestSuite {
    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get("http://practice.automationtesting.in/");
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Login_Success() {
        loginPage.clickMyAccountMenu();
        loginPage.login("nhailtk@gmail.com", "nhailtk@123");
        loginPage.verifyLoginPass();
    }

    @After
    public void closeBroswer() {
        driver.quit();
    }
}
