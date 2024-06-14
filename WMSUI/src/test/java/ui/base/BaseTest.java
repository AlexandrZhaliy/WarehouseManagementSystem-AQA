package ui.base;

import baseTest.AbstractBaseTest;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import core.TestListener;
import core.WDriverManager;
import ui.enums.WebEnvProperties;
import helpers.SetPropertiesHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;
import ui.models.*;
import ui.pages.warehouseManagementSystem.MainPage;
import utils.Utils;
import utilsHelper.DataProvider;

import java.io.File;
import java.util.List;
import java.util.Objects;

import static core.WDriverManager.*;
import static ui.enums.WebEnvProperties.*;
import static utils.Utils.getAbsRandomInt;
import static utils.Utils.getRandomEmail;


@Listeners({TestListener.class})
public class BaseTest extends AbstractBaseTest {

    public User adminUser;

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        Selenide.closeWindow();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        Selenide.closeWebDriver();
    }
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        SelenideLogger.addListener("AllureSelenide",  new AllureSelenide().screenshots(true).savePageSource(false));
    }
    @BeforeClass(alwaysRun = true)
    public void beforeSuite() {
        SetPropertiesHelper.init(WebEnvProperties.class, "warehouseManagementSystemUi");
        generateUsers();
        WDriverManager.setupDriver();
//        addListener(Boolean.parseBoolean(STEP_LOGGER_ENABLE.getValue())); //todo need fix for 7v Selenide
    }

    private void generateUsers() {
        adminUser = new User(MAIN_USER.getValue(), MAIN_USER_PASSWORD.getValue());
    }

    @AfterSuite
    public static void closeBrowser() {
        if (!HOLD_BROWSER_OPEN) {
            Selenide.closeWebDriver();
        }
    }

    /**
     * A static initialization block in order to clean the folders with reports and screenshots before build starts
     */
    public void deleteReportFolder() {
        File allureResults = new File("target/allure-results");
        if (allureResults.isDirectory()) {
            for (File item : Objects.requireNonNull(allureResults.listFiles())) {
                item.delete();
            }
        }
        if (CLEAR_REPORTS_DIR) {
            File reports = new File("build/reports/tests/");
            if (reports.isDirectory()) {
                for (File item : Objects.requireNonNull(reports.listFiles())) {
                    item.delete();
                }
            }
        }
        File downloads = new File("builds/downloads/");
        if (downloads.isDirectory()) {
            for (File item : Objects.requireNonNull(downloads.listFiles())) {
                item.delete();
            }
        }
    }

    public void createGroup(utilsHelper.DataProvider provider) {
        new MainPage()
                .openGroups()
                .clickCreateNewGroupButton()
                .groupName(provider.companyGroup)
                .type(GroupType.COMPANIES.getName())
                .clickSubmitButton()
                .selectGroupType(GroupType.WAREHOUSES.getName())
                .clickCreateNewGroupButton()
                .groupName(provider.warehousesGroup)
                .clickSubmitButton();
    }

    public void createGroupSupplier(utilsHelper.DataProvider provider) {
        new MainPage()
                .openGroups()
                .clickCreateNewGroupButton()
                .groupName(provider.supplierGroupName)
                .type(GroupType.SUPPLIERS.getName())
                .clickSubmitButton();
    }

    public void createGroupManufacturer(utilsHelper.DataProvider provider) {
        new MainPage()
                .openGroups()
                .clickCreateNewGroupButton()
                .groupName(provider.manufacturerGroupName)
                .type(GroupType.MANUFACTURERS.getName())
                .clickSubmitButton();
    }

    public void createManufacturer(utilsHelper.DataProvider provider) {
        new MainPage()
                .openManufacturers()
                .clickCreateNewManufacturerButton()
                .manufacturerName(provider.manufacturerName)
                .manufacturerGroup(provider.manufacturerGroupName)
                .clickSaveButton();
    }

    public void createGroup2(utilsHelper.DataProvider provider) {
        new MainPage()
                .openGroups()
                .clickCreateNewGroupButton()
                .groupName(provider.companyGroup2)
                .type(GroupType.COMPANIES.getName())
                .clickSubmitButton()
                .selectGroupType(GroupType.WAREHOUSES.getName())
                .clickCreateNewGroupButton()
                .groupName(provider.warehousesGroup2)
                .clickSubmitButton();
    }

    public void createSupplier(utilsHelper.DataProvider provider) {
        new MainPage()
                .openSuppliers()
                .clickCreateSupplierButton()
                .supplierName(provider.supplierName)
                .supplierEmail("companyEmail@email.com")
                .supplierOrgNumber("45345435")
                .supplierAddress(Utils.getRandomString())
                .supplierZip("123456")
                .supplierCity("City")
                .supplierCountry("Bulgaria")
                .supplierGroup(provider.supplierGroupName)
                .clickCreateButton();
    }

    public void createCompany(utilsHelper.DataProvider provider) {
        new MainPage()
                .openCompanies()
                .clickCreateCompanyButton()
                .companyName(provider.companyName)
                .companyEmail(getRandomEmail())
                .companyOrgNumber("45345435")
                .companyAddress("Address")
                .companyZip("123456")
                .companyCity("City")
                .companyCountry("Bulgaria")
                .companyGroup(provider.companyGroup)

                .warehouseName(provider.companyWarehouseName)
                .warehouseType("Central")
                .warehouseEmail("warehouseEmail@email.com")
                .warehouseAddress("Address")
                .warehouseZip("123456")
                .warehouseCity("City")
                .warehouseNumber("4353466")
                .warehouseGroup(provider.warehousesGroup)
                .clickCreateButton();
    }

    public void createCompany2(utilsHelper.DataProvider provider) {
        new MainPage()
                .openCompanies()
                .clickCreateCompanyButton()
                .companyName(provider.companyName2)
                .companyEmail("companyEmail@email.com")
                .companyOrgNumber("45345435")
                .companyAddress("Address")
                .companyZip("123456")
                .companyCity("City")
                .companyCountry("Bulgaria")
                .companyGroup(provider.companyGroup2)

                .warehouseName(provider.companyWarehouseName2)
                .warehouseType("Central")
                .warehouseEmail("warehouseEmail@email.com")
                .warehouseAddress("Address")
                .warehouseZip("123456")
                .warehouseCity("City")
                .warehouseNumber("4353466")
                .warehouseGroup(provider.warehousesGroup2)
                .clickCreateButton();
    }
    public void createWarehouse(utilsHelper.DataProvider provider) {
        new MainPage()
                .openWarehouses()
                .clickOnCreateWarehouse()
                .warehouseName(provider.warehouseName)
                .warehouseType(WarehousesType.INSTALLATION_WAREHOUSE)
                .warehouseEmail("warehouseEmail@email.com")
                .warehouseAddress("WAddress")
                .warehouseZip("123456")
                .warehouseCity("City")
                .warehouseNumber("4321")
                .warehouseGroup(provider.warehousesGroup)
                .warehouseCompany(provider.companyName)
                .saveWarehouseCreation();
    }

    public void createWarehouse2(utilsHelper.DataProvider provider) {
        new MainPage()
                .openWarehouses()
                .clickOnCreateWarehouse()
                .warehouseName(provider.warehouseName2)
                .warehouseType(WarehousesType.INSTALLATION_WAREHOUSE)
                .warehouseEmail("warehouseEmail@email.com")
                .warehouseAddress("WAddress")
                .warehouseZip("123456")
                .warehouseCity("City")
                .warehouseNumber("4321")
                .warehouseGroup(provider.warehousesGroup2)
                .warehouseCompany(provider.companyName2)
                .saveWarehouseCreation();
    }

    public void createArticle(String articleName, ArticleGroup articleGroup, String storageUnit, String warehouseName, String articlesAmount, String uniqArticlesAmount, List<String> serialNumberlist) {
        //        =================== Create Article - VEHICLE_REGISTRATION_NUMBERS=================
        new MainPage()
                .openArticles()
                .clickCreateNewArticleButton()
                .articleName(articleName)
                .moduleNumber(String.valueOf(getAbsRandomInt()))
                .selectGroup(articleGroup)
                .addStorageUnit(storageUnit)
                .selectStorageUnit(storageUnit)
                .saveNewArticle()
                //        =================== Create Article - VEHICLE_REGISTRATION_NUMBERS=================
                //        =================== Add amount Article - VEHICLE_REGISTRATION_NUMBERS=================
                .openArticle(articleName)
                .openActionsTab()
                .warehouseName(warehouseName)
                .amountNumber(articlesAmount)
                .selectStatus(ArticleStatus.DONE)
                .clickSubmitButton()
                //        =================== Add amount Article - VEHICLE_REGISTRATION_NUMBERS=================
                //        =================== Unicity Article - VEHICLE_REGISTRATION_NUMBERS=================
                .openUnicityTab()
                .selectWarehouse(warehouseName)
                .clickAutogenerateCheckbox()
                .selectArticlesCount(uniqArticlesAmount)
                .clickSaveButton()
                .saveNumbers(serialNumberlist);
    }

    public void createArticle(String articleName, ArticleGroup articleGroup, String storageUnit, String warehouseName, String articlesAmount) {
        //        =================== Create Article - VEHICLE_REGISTRATION_NUMBERS=================
        new MainPage()
                .openArticles()
                .clickCreateNewArticleButton()
                .articleName(articleName)
                .moduleNumber(String.valueOf(getAbsRandomInt()))
                .selectGroup(articleGroup)
                .addStorageUnit(storageUnit)
                .selectStorageUnit(storageUnit)
                .saveNewArticle()
                //        =================== Create Article - VEHICLE_REGISTRATION_NUMBERS=================
                //        =================== Add amount Article - VEHICLE_REGISTRATION_NUMBERS=================
                .openArticle(articleName)
                .openActionsTab()
                .warehouseName(warehouseName)
                .amountNumber(articlesAmount)
                .selectStatus(ArticleStatus.DONE)
                .clickSubmitButton();
    }

    public void createArticle(String articleName, ArticleGroup articleGroup, String storageUnit) {
        //        =================== Create Article - VEHICLE_REGISTRATION_NUMBERS=================
        new MainPage()
                .openArticles()
                .clickCreateNewArticleButton()
                .articleName(articleName)
                .moduleNumber(String.valueOf(getAbsRandomInt()))
                .selectGroup(articleGroup)
                .addStorageUnit(storageUnit)
                .selectStorageUnit(storageUnit)
                .saveNewArticle();
        //        =================== Create Article - VEHICLE_REGISTRATION_NUMBERS=================
    }

    public void createVehicleRegistrationNumber(DataProvider dataProvider) {
        //        =================== VehicleRegistrationNumber=================
        new MainPage()
                .openVehicleRegistrationNumber()
                .clickCreateNewRegNumberButton()
                .selectFrontPlate(dataProvider.VN_serialNumberlist.get(0))
                .selectRearPlate(dataProvider.VN_serialNumberlist.get(1))
                .typeRegistrationNumber("UU " + getAbsRandomInt(5))
                .clickLinkButton();
        //        =================== VehicleRegistrationNumber=================
    }

    public void createTrackerDevices(DataProvider dataProvider) {
        //        =================== TrackerDevices=================
        new MainPage()
                .openTrackerDevices()
                .clickCreateNewGroupButton()
                .selectFrontBleTracker(dataProvider.TD_serialNumberlist.get(0))
                .selectRearBleTracker(dataProvider.TD_serialNumberlist.get(1))
                .selectGpsTracker(dataProvider.GPS_serialNumberlist.get(0))
                .clickLinkButton();
        //        =================== TrackerDevices=================

    }
    public void createInstallationKit(DataProvider provider) {
        new MainPage()
                //        =================== VehicleRegistrationNumber=================
                .openVehicleRegistrationNumber()
                .clickCreateNewRegNumberButton()
                .selectFrontPlate(provider.VN_serialNumberlist.get(0))
                .selectRearPlate(provider.VN_serialNumberlist.get(1))
                .typeRegistrationNumber("UU " + getAbsRandomInt(5))
                .clickLinkButton()
                //        =================== VehicleRegistrationNumber=================
                //        =================== TrackerDevices=================
                .openTrackerDevices()
                .clickCreateNewGroupButton()
                .selectFrontBleTracker(provider.TD_serialNumberlist.get(0))
                .selectRearBleTracker(provider.TD_serialNumberlist.get(1))
                .selectGpsTracker(provider.GPS_serialNumberlist.get(0))
                .clickLinkButton()
                //        =================== TrackerDevices=================
                //        =================== InstallationKits=================
                .openInstallationKits()
                .clickCreateNewKitButton()
                .selectFrontPlate(provider.VN_serialNumberlist.get(0))
                .selectRearPlate(provider.VN_serialNumberlist.get(1))
                .selectGpsTracker(provider.GPS_serialNumberlist.get(0))
                .selectFrontBleTracker(provider.TD_serialNumberlist.get(0))
                .selectRearBleTracker(provider.TD_serialNumberlist.get(1))
                .clickSaveButton()
                .saveInstallationKitNumber(provider.warehouseName)
                .saveVehicleRegistrationNumber(provider);
        //        =================== InstallationKits=================
    }


}
