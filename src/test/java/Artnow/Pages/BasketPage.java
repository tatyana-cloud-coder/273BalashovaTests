package Artnow.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasketPage {
    WebDriver driver;
    private WebDriverWait wait;

    public BasketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void reviewBasket (String src, String cost) {
        Boolean factResult = false;
        List <WebElement> products = driver.findElements(By.xpath("//div[@class='c_row']"));
        for (WebElement product: products) {
            if (product.findElement(By.xpath("//img[@class='c_photo']")).getAttribute("src").equals(src)) {
                if (product.findElement(By.xpath("//div[@class='price']")).getText().replace(" руб.", "").equals(cost)) {
                    factResult = true;
                    break;
                }
            }
        }
        Assert.assertEquals(true, factResult);
    }



}
