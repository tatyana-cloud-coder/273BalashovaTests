package Artnow.Settings;

import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebDriverSettings {
    public static ChromeDriver chromeDriver;
    public static ChromeOptions options;
    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\drivers\\chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        chromeDriver = new ChromeDriver(options);
    }

    @After
    public void finish() {
        chromeDriver.quit();
    }

    @AfterMethod
    public void catchFailure(ITestResult result) {
        if (!result.isSuccess()) {
            takeScreenshot();
        }
    }

    @Attachment(value = "Screenshot")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.BYTES);
    }








}
