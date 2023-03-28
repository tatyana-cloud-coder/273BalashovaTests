package Artnow.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class JewerlyArtPage {

    WebDriver driver;
    private WebDriverWait wait;

    public JewerlyArtPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy (xpath = "//div[@id='CartButton1100221']")
    private WebElement costButton;

    @FindBy(xpath = "//button[@onClick='sendCartForm();']")
    private WebElement backetButton;

    public void addToBacket (int number) {
        List <WebElement> products = driver.findElements(By.xpath("//div[@class='oclick']"));
        products.get(number).click();

     // costButton.click();
    }

    public void goToBacket () {
        backetButton.click();
    }

    public String getSrcOfFirstProduct(int number) {
        List <WebElement> products = driver.findElements(By.xpath("//img[@class='bubu']"));
        return products.get(number).getAttribute("src");
    }

    public String getCostOfFirstProduct(int number) {
        List <WebElement> products = driver.findElements(By.xpath("//meta[@itemprop='price']"));
        return products.get(number).getAttribute("content");
    }

}
