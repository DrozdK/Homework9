package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

import static constants.Constant.Url.ONLINER_START_PAGE;
import static enums.CatalogItems.*;
import static enums.SubCatalogItems.*;
import static pages.BasePage.open;

public class CatalogTests extends BaseTest {

    static Logger log = Logger.getLogger(CatalogTests.class);

    SoftAssert softly = new SoftAssert();

    @BeforeMethod
    public void openCatalogPage() {
        open(ONLINER_START_PAGE);
        log.info("Open onliner start page");
        driver.findElement(catalogHelper.CATALOG_BUTTON).click();
        log.info("Click to the catalog button");
    }

    @Test(priority = 3, groups = "catalogTests")
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
        softly.assertEquals(catalogHelper.getCatalogItems(), items);
        log.info("Got the list of categories from start page and compared it with the requirements");
    }

    @Test(priority = 1, groups = "catalogTests")
    public void shouldCheckComputerCatalog() {
        //given
        int id= 2;
        ArrayList<String> items = new ArrayList<>();
        items.add(LAPTOPS_COMPUTERS_MONITORS.getText());
        items.add(ACCESSORIES.getText());
        items.add(DATA_STORAGE.getText());
        items.add(NETWORK_EQUIPMENT.getText());
        //when
        catalogHelper.chooseCatalogItem(id);
        log.info("Moved to the computers and networks catalog");
        //then
        softly.assertTrue(driver.findElement(catalogHelper.COMPUTER_ITEMS).isDisplayed());
        log.info("Checked that the computers and networks catalog menu is displayed");
        softly.assertTrue(catalogHelper.getItemsFromComputersBlock().containsAll(items));
        log.info("Got the list of subcategories from computers and networks catalog and compared it with the requirements");
        softly.assertAll();
    }

    @Test(priority = 2, groups = "catalogTests")
    public void shouldCheckComponentsSubdirectory() {
        //given
        int id = 2;
        //when
        catalogHelper.chooseCatalogItem(id);
        log.info("Moved to the computers and networks catalog");
        catalogHelper.chooseComputerSubdirectory(ACCESSORIES.getText());
        log.info("Moved to the accessories subdirectory");
        //then
        softly.assertTrue(driver.findElements(catalogHelper.COMPONENT_SUBDIRECTORY_ITEM_NAMES).stream().allMatch(WebElement::isDisplayed));
        log.info("Checked that each subdirectory element has a field 'Name'");
        softly.assertTrue(driver.findElements(catalogHelper.COMPONENT_SUBDIRECTORY_ITEM_PRODUCTS).stream().allMatch(WebElement::isDisplayed));
        log.info("Checked that each subdirectory element has a field 'Products'");
        softly.assertTrue(driver.findElements(catalogHelper.COMPONENT_SUBDIRECTORY_ITEM_PRICE).stream().allMatch(WebElement::isDisplayed));
        log.info("Checked that each subdirectory element has a field 'Price'");
        softly.assertAll();
    }

    @AfterClass(groups = "catalogTests", alwaysRun = true)
    public void closeBrowser() {
        close();
    }
}