package Artnow.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    WebDriver driver;
    private WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void checkContainsFirstPictureInputName (String Name) {
        Boolean factResult = false;
        List <WebElement> Pictures = driver.findElements(By.xpath("//img[@class = 'bubu']"));
        if (Pictures.get(0).getAttribute("alt").contains(Name)) {
            factResult = true;
        }
        Assert.assertEquals(true, factResult);
    }



}

