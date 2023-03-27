package Artnow.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {

    WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//span[text()='Показать еще...']")
    private WebElement showMore;

    @FindBy (xpath = "//a[text()=' Вышитые картины']")
    private WebElement embroideredPictures;

    @FindBy(xpath = "//a[text()=' Батик']")
    private WebElement batik;

    @FindBy (xpath = "//a[text()=' Ювелирное искусство']")
    private WebElement jewelryArt;

    @FindBy (xpath = "//button[text()='Искать']")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@class='search-bar']")
    private WebElement filter;

    public void openSite() {
        driver.get("https://artnow.ru/");
    }

    public void clickOnShowMore() {
        showMore.click();
    }

    public void goToEmbroideredPictures() {
        embroideredPictures.click();
    }

    public void goToBatik () {
        batik.click();
    }

    public void SearchPictures (String name) {
        filter.sendKeys(name);
        searchButton.click();
     //   wait.until(ExpectedConditions.visibilityOf(searchButton));
    }

    public void goToJewelryArt () {
        jewelryArt.click();
    }




}
