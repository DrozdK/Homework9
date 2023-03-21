package tests;

import common.CommonActions;
import helpers.CatalogHelper;
import org.openqa.selenium.WebDriver;

import static common.ConfigSetter.HOLD_BROWSER_OPEN;

public class BaseTestMobile {

    protected WebDriver driver = CommonActions.createDriver("mobile");
    protected CatalogHelper catalogHelperMobile = new CatalogHelper(driver);

    public void close() {
        if (HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}
