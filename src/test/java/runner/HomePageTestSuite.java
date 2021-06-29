package runner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.HomePage;

import java.util.concurrent.TimeUnit;

public class HomePageTestSuite {
    WebDriver driver;
    HomePage homePage;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.get("http://practice.automationtesting.in/");
        driver.manage().window().maximize();
    }
    @Test
    public void TC_1_Verify_Sliders(){
        homePage.preConditions(driver);
        homePage.verifySlidersNumber();
    }

    @Test
    public void TC_2_Verify_Arrivals(){
        homePage.preConditions(driver);
        homePage.verifyArrivalsNumber();
    }

    @Test
    public void TC_3_Verify_ImageShouldNavigate(){
    homePage.preConditions(driver);
    homePage.verifyImageShouldNavigate();
    }

    @Test
    public void TC_4_Verify_Arrival_Image_Description(){
        homePage.preConditions(driver);
        homePage.verifyArrivalImageDescription();
    }

    @Test
    public void TC_5_Verify_Arrival_Image_Reviews(){
        homePage.preConditions(driver);
        homePage.verifyArrivalImageReviews();
    }

    @Test
    public void TC_6_Verify_Arrivals_Images_AddToBasket(){
        homePage.preConditions(driver);
        homePage.verifyArrivalImageAddToBasket();
    }
    @After
    public void closeBroswer() {
        driver.quit();
    }
}
