package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

import static constants.Constant.Url.ONLINER_START_PAGE;
import static enums.CatalogItems.*;
import static enums.SubCatalogItems.*;
import static enums.SubCatalogItems.NETWORK_EQUIPMENT;
import static pages.BasePage.open;

public class CatalogMobileAdaptationTests extends BaseTestMobile{

    static Logger log = Logger.getLogger(CatalogMobileAdaptationTests.class);
    SoftAssert softly = new SoftAssert();

    @BeforeTest
    public void openCatalogPage() {
        open(ONLINER_START_PAGE);
        log.info("MOBILE - Open onliner start page");
        driver.findElement(catalogHelperMobile.CATALOG_BUTTON).click();
        log.info("MOBILE - Click to the catalog button");
    }

    @Test(groups = "catalogTestsMobile")
    public void shouldCheckCatalogItems() {
        //given
        ArrayList<String> items = new ArrayList<>();
        items.add(ELECTRONIC.getText());
        items.add(COMPUTERS.getText());
        items.add(HOUSEHOLD_APPLIANCE.getText());
        items.add(FOR_EVERY_DAY.getText());
        items.add(BUILDIND_AND_REPAIR.getText());
        items.add(HOME_AND_GARDEN.getText());
        items.add(AUTO_AND_MOTO.getText());
        items.add(BEAUTY_AND_SPORT.getText());
        items.add(CHILDREN_AND_MOTHERS.getText());
        //then
        softly.assertEquals(catalogHelperMobile.getCatalogItems(), items);
        log.info("MOBILE - Got the list of categories from start page and compared it with the requirements");
    }

    @Test(groups = "catalogTestsMobile")
    public void shouldCheckComponentsSubdirectory() {
        //given
        int id= 2;
        //when
        catalogHelperMobile.chooseCatalogItem(id);
        log.info("MOBILE - Moved to the computers and networks catalog");
        catalogHelperMobile.chooseComputerSubdirectory(ACCESSORIES.getText());
        log.info("MOBILE - Moved to the accessories subdirectory");
        //then
        softly.assertTrue(driver.findElements(catalogHelperMobile.COMPONENT_SUBDIRECTORY_ITEM_NAMES).stream().allMatch(WebElement :: isDisplayed));
        log.info("MOBILE - Checked that each subdirectory element has a field 'Name'");
        softly.assertTrue(driver.findElements(catalogHelperMobile.COMPONENT_SUBDIRECTORY_ITEM_PRODUCTS).stream().allMatch(WebElement::isDisplayed));
        log.info("MOBILE - Checked that each subdirectory element has a field 'Products'");
        softly.assertTrue(driver.findElements(catalogHelperMobile.COMPONENT_SUBDIRECTORY_ITEM_PRICE).stream().allMatch(WebElement::isDisplayed));
        log.info("MOBILE - Checked that each subdirectory element has a field 'Price'");
        softly.assertAll();
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser() {
        close();
    }
}