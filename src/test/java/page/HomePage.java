package page;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder;
import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage extends PageFactory {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //WebElement shopMenu = driver.findElement(By.xpath("//ul[@id='main-nav']//li[@id='menu-item-40']"));
    @FindBy(xpath = "//ul[@id='main-nav']//li[@id='menu-item-40']")
    WebElement shopMenu;

    @FindBy(xpath = "//div[@id='content']//a[contains(text(),'Home')]")
    WebElement homeMenuButton;

    @FindBy(xpath = "//div[@data-slide-duration='0']//img")
    List<WebElement> sliders;

    @FindBy(xpath = "//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']//img")
    List<WebElement> arrivals;

    @FindBy(xpath = "(//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']//img)[1]")
    WebElement arrival1;

    @FindBy(xpath = "//button[@type = 'submit' and contains(text(), 'Add to basket')]")
    WebElement btnAddToBasket;

    @FindBy(xpath = "//li[@class='description_tab active']")
    WebElement descriptionTab;

    @FindBy(xpath = "//div[@id='tab-description']//p[contains(text(),'The Selenium WebDriver Recipes book')]")
    WebElement arrival_Image_Description;

    @FindBy(xpath = "//li[@class='reviews_tab']")
    WebElement reviewsTab;

    @FindBy(xpath = "//div[@id='comments']//h2[contains(text(),'Reviews')]")
    WebElement arrival_Image_Reviews;

    @FindBy(xpath = "//span[contains(text(),'1 item')]")
    WebElement item;

    @FindBy(xpath = "//span[contains(text(),'₹500.00')]")
    WebElement price;


    public void clickShopMenu() {
        shopMenu.click();
    }

    public void clickHomeMenuButton() {
        homeMenuButton.click();
    }

    public void preConditions(WebDriver driver1) {
        clickShopMenu();
        driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        clickHomeMenuButton();
    }

    public void verifySlidersNumber() {
        Assert.assertEquals(3, sliders.size());
    }

    public void verifyArrivalsNumber() {
        Assert.assertEquals(3, arrivals.size());
    }

    public void clickArrival1() {
        arrival1.click();
    }

    public void verifyImageShouldNavigate() {
        clickArrival1();
        Assert.assertTrue(btnAddToBasket.isDisplayed());
    }

    public void verifyArrivalImageDescription() {
        clickArrival1();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        descriptionTab.click();
        Assert.assertTrue(arrival_Image_Description.isDisplayed());
    }

    public void verifyArrivalImageReviews() {
        clickArrival1();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        reviewsTab.click();
        Assert.assertTrue(arrival_Image_Reviews.isDisplayed());
    }

    public void clickAddToBasket() {
        btnAddToBasket.click();
    }

    public void verifyArrivalImageAddToBasket() {
        clickArrival1();
        clickAddToBasket();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertTrue(item.isDisplayed());
        Assert.assertTrue(price.isDisplayed());
    }

}
