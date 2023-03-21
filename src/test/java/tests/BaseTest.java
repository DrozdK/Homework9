package tests;

import common.CommonActions;
import helpers.CatalogHelper;
import org.openqa.selenium.WebDriver;

import static common.ConfigSetter.HOLD_BROWSER_OPEN;

public class BaseTest {

    protected  WebDriver driver = CommonActions.createDriver();
    protected CatalogHelper catalogHelper = new CatalogHelper(driver);

    public void close() {
        if(HOLD_BROWSER_OPEN)
        {
            driver.quit();
        }
    }
}
