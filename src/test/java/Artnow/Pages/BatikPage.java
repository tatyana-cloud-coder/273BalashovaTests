package Artnow.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BatikPage {
    WebDriver driver;
    private WebDriverWait wait;

    public BatikPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy (css = "div[data-id='1101014']")
    private WebElement Heart;

    @FindBy (css = "img[alt='Избранное']")
    private WebElement Favorite;

    public void addToFavorite () {
        Heart.click();
    }

    public void goToFavorite () {
        Favorite.click();
    }

    public String getSrcOfFavoritePicture() {
        List<WebElement> ListOfPictures = driver.findElements(By.xpath("//img[@class = 'bubu']"));
        return ListOfPictures.get(0).getAttribute("src");
    }


}
