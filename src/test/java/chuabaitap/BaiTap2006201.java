package chuabaitap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import page.HomePage;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BaiTap2006201 {
    WebDriver driver;
    HomePage homePage;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://practice.automationtesting.in/");
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Verify_Sliders(){
//        WebElement shopMenu = driver.findElement(By.xpath("//ul[@id='main-nav']//li[@id='menu-item-40']"));
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        shopMenu.click();
//        WebElement homeMenuButton = driver.findElement(By.xpath("//div[@id='content']//a[contains(text(),'Home')]"));
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        Wait wait = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5,TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
//        wait.until(ExpectedConditions.visibilityOf(homeMenuButton));
//        homeMenuButton.click();
//        List<WebElement> sliders = driver.findElements(By.xpath("//div[@data-slide-duration='0']//img"));
//        Assert.assertEquals(3, sliders.size());
        homePage.clickShopMenu();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.clickHomeMenuButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.verifySlidersNumber();
    }
    @After
    public void closeBroswer() {
        driver.quit();
    }
}
