package Artnow.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FavoritePage {

    WebDriver driver;
    private WebDriverWait wait;

    public FavoritePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void reviewFavorite(String Name) {
        Boolean factResult = false;
        List<WebElement> Pictures = driver.findElements(By.xpath("//img[@class='bubu']"));
        for (WebElement picture: Pictures) {
            if (picture.getAttribute("src").equals(Name))  {
                factResult = true;
                break;
            }
        }
        Assert.assertEquals(true, factResult);
    }


}
