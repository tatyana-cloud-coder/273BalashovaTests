package Artnow.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmbroideredPicturesPage {

    WebDriver driver;
    private WebDriverWait wait;

    public EmbroideredPicturesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//label[text()=' Городской пейзаж']/input")
    private WebElement cityShape;

    @FindBy(xpath = "//button[text()='Применить']")
    private WebElement applyButton;

    public void checkCityShape () {
        cityShape.click();
    }

    public void clickOnApplyButton () {
        applyButton.click();
    }
}
