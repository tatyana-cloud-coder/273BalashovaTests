package Artnow.Settings;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class WebDriverSettings {
    public static WebDriver webDriver;

    @Parameters("browser")
    @BeforeMethod
    public void start(@Optional String browser) {
        if (browser == null || browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\drivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            webDriver = new ChromeDriver(options);
        } else if(browser.equalsIgnoreCase("firefox")) {
            webDriver = new FirefoxDriver();
        }
    }

    @AfterMethod
    public void finish() {
        webDriver.quit();
    }

    @AfterMethod
    public void catchFailure(ITestResult result) {
        if (!result.isSuccess()) {
            takeScreenshot();
        }
    }

    @Attachment(value = "Screenshot")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }








}
