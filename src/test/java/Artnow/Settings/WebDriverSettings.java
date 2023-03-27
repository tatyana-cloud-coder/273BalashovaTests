package Artnow.Settings;

import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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







}
