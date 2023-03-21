package common;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static common.ConfigSetter.PLATFORM_AND_BROWSER;
import static constants.Constant.Device.IPHONE_XR_DEVICE;
import static constants.Constant.TimeoutVariable.EXPLICIT_WAIT;
import static constants.Constant.TimeoutVariable.IMPLICIT_WAIT;

public class CommonActions {

    public static WebDriver createDriver(String type) {
        BasicConfigurator.configure();
        WebDriver driver = null;
        switch(type) {
            case "web":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "mobile":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                Map<String, String> props = new HashMap<>();
                props.put("deviceName", IPHONE_XR_DEVICE);
                options.setExperimentalOption("mobileEmulation", props);
                driver = new ChromeDriver(options);
                break;
            default:
                Assert.fail("Incorrect platform or browser name: " + PLATFORM_AND_BROWSER);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(EXPLICIT_WAIT, TimeUnit.SECONDS );
        return driver;
    }
}
