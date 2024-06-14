package ui.pages.warehouseManagementSystem;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.base.BasePage;
import ui.pages.warehouseManagementSystem.accessGroups.AccessControlPage;
import ui.pages.warehouseManagementSystem.accessGroups.EditPermissionsPage;
import ui.pages.warehouseManagementSystem.allocateOrders.AllocateAllOrdersTab;
import ui.pages.warehouseManagementSystem.articles.MainArticlesPage;
import ui.pages.warehouseManagementSystem.companies.AllCompaniesTab;
import ui.pages.warehouseManagementSystem.groups.GroupsTab;
import ui.pages.warehouseManagementSystem.installationOrders.InstallationOrdersAllOrdersTab;
import ui.pages.warehouseManagementSystem.manufacturers.AllManufacturersTab;
import ui.pages.warehouseManagementSystem.orders.AllOrdersTab;
import ui.pages.warehouseManagementSystem.reports.ReportsPage;
import ui.pages.warehouseManagementSystem.storageUnits.AllUnitsTab;
import ui.pages.warehouseManagementSystem.suppliers.AllSuppliersTab;
import ui.pages.warehouseManagementSystem.trackerDevices.GroupTrackerDevicesPage;
import ui.pages.warehouseManagementSystem.installationKits.InstallationKitsPage;
import ui.pages.warehouseManagementSystem.vehicleRegistrationNumber.VehicleRegistrationNumberPage;
import ui.pages.warehouseManagementSystem.warehouses.AllWarehousesTab;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class warehouseManagementSystemMainPage extends BasePage {
    public static SelenideElement menuButton = $x("//*[@id='headerControlMenu']");
    public static SelenideElement profileButton = $x("//a[text()='Profile']");
    public static SelenideElement settingsButton = $x("//*[@id='headerControlSettings']");
    public static SelenideElement settingsContent = $x("//*[@id='settingsDesktopContent' and contains(@class, 'active')]");
    public static SelenideElement warehousesButton = $x("//*[@href='/warehouses']");
    public static SelenideElement accessGroupsButton = $x("//*[@id='settingsDesktopContent' and contains(@class, 'active')]//*[contains(@href, '/access-groups')]");
    public static SelenideElement articlesButton = $x("//*[@href='/articles']");
    public static SelenideElement suppliersButton = $x("//*[@href='/supplier']");
    public static SelenideElement storageUnitsButton = $x("//*[@href='/unit']");
    public static SelenideElement manufacturersButton = $x("//*[@href='/manufacturer']");
    public static SelenideElement companiesButton = $x("//*[contains(@href, '/company-management') or contains(@href, '/company')]");
    public static SelenideElement groupsButton = $x("//*[@id='settingsDesktopContent']//*[@href='/groups']");
    public static SelenideElement ordersButton = $x("//*[@href='/orders']");
    public static SelenideElement registrationNumberButton = $x("//*[@href='/vehicle-registration-number']");
    public static SelenideElement trackerDevicesButton = $x("//*[@href='/tracker-devices']");
    public static SelenideElement installationKitsButton = $x("//*[@href='/installation-kits']");
    public static SelenideElement allocateOrdersButton = $x("//*[@href='/allocate-orders']");
    public static SelenideElement reportsButton = $x("//*[@href='/report']");
    public static SelenideElement installationOrdersButton = $x("//*[@href='/installation-orders/index']");
    public static String rowWithTextXpath = "//tr[contains(., '%s')]";
    public static String titleWithNameXpath = "//h4[contains(., '%s')]";
    public static String filePath = "src/test/resources/files/test.png";

    @Step("verify row with texts is present in table - {text}")
    public warehouseManagementSystemMainPage verifyRowIsVisibleWithTexts(String... text) {
        $x(getRowWithTextXpath(text)).shouldBe(Condition.visible);
        return this;
    }

    @Step("Verify title using name - {name}")
    public EditPermissionsPage verifyTitle(String name) {
        $x(format(titleWithNameXpath, name)).shouldBe(visible);
        return new EditPermissionsPage();
    }

    @Step("verify row with texts is NOT present in table - {text}")
    public warehouseManagementSystemMainPage verifyRowIsNotVisibleWithTexts(String... text) {
        $x(getRowWithTextXpath(text)).shouldNotBe(Condition.visible);
        return this;
    }

    public String getRowWithTextXpath(String... text) {
        String rowWithTextXpath = format(warehouseManagementSystemMainPage.rowWithTextXpath, text[0]);
        if (text.length > 1) {
            for (int i = 1; i < text.length; i++) {
                rowWithTextXpath = rowWithTextXpath.replace("]", format(" and contains(., '%s')]", text[i]));
            }
        }
        return rowWithTextXpath;
    }

    @Step("Click on Menu in header")
    public warehouseManagementSystemMainPage clickMenu() {
        menuButton.click();
        return this;
    }

    @Step("Click on Profile in header")
    public ProfilePage clickProfile() {
        profileButton.click();
        return new ProfilePage();
    }

    @Step("Click on Installation Orders block")
    public InstallationOrdersAllOrdersTab clickInstallationOrders() {
        installationOrdersButton.click();
        return new InstallationOrdersAllOrdersTab();
    }

    @Step("Click on Groups in header block")
    public GroupsTab clickGroups() {
        groupsButton.shouldBe(Condition.visible).click();
        return new GroupsTab();
    }

    @Step("Click on Storage Units in header block")
    public AllUnitsTab clickStorageUnits() {
        storageUnitsButton.shouldBe(Condition.visible).click();
        return new AllUnitsTab();
    }

    @Step("Click on Orders in header block")
    public AllOrdersTab clickOrders() {
        ordersButton.click();
        return new AllOrdersTab();
    }

    @Step("Click on Settings in header")
    public warehouseManagementSystemMainPage clickSettings() {
        settingsButton.shouldBe(Condition.visible).click();
        Selenide.sleep(1000);
        if (!settingsContent.isDisplayed()) {
            settingsButton.click();
            settingsContent.shouldBe(Condition.visible);
        }
        return this;
    }

    @Step("Click on Warehouses in header block")
    public AllWarehousesTab clickWarehouses() {
        warehousesButton.click();
        return new AllWarehousesTab();
    }

    @Step("Click on 'Articles' in header block")
    public MainArticlesPage clickArticles() {
        articlesButton.click();
        return new MainArticlesPage();
    }

    @Step("Click on 'Access Groups' in header block")
    public AccessControlPage clickAccessGroups() {
        accessGroupsButton.click();
        return new AccessControlPage();
    }

    @Step("Click on Suppliers in header block")
    public AllSuppliersTab clickSuppliers() {
        suppliersButton.click();
        return new AllSuppliersTab();
    }

    @Step("Click on Manufacturers in header block")
    public AllManufacturersTab clickManufacturers() {
        manufacturersButton.click();
        return new AllManufacturersTab();
    }

    @Step("Click on Companies in header block")
    public AllCompaniesTab clickCompanies() {
        companiesButton.shouldBe(Condition.visible).click();
        return new AllCompaniesTab();
    }

    @Step("Click on Vehicle Registration Number in header block")
    public VehicleRegistrationNumberPage clickRegistrationNumbers() {
        registrationNumberButton.click();
        return new VehicleRegistrationNumberPage();
    }

    @Step("Click on Tracker Devices in header block")
    public GroupTrackerDevicesPage clickTrackerDevices() {
        trackerDevicesButton.click();
        return new GroupTrackerDevicesPage();
    }

    @Step("Click on Installation Kits in header block")
    public InstallationKitsPage clickInstallationKits() {
        installationKitsButton.click();
        return new InstallationKitsPage();
    }

    @Step("Click on Allocate Orders in header block")
    public AllocateAllOrdersTab clickAllocateOrders() {
        allocateOrdersButton.click();
        return new AllocateAllOrdersTab();
    }

    @Step("Click on Reports in header block")
    public ReportsPage clickReports() {
        reportsButton.click();
        return new ReportsPage();
    }

    public GroupsTab openGroups() {
        clickSettings();
        return clickGroups();
    }

    public AllUnitsTab openStorageUnits() {
        clickSettings();
        return clickStorageUnits();
    }

    public AllManufacturersTab openManufacturers() {
        clickSettings();
        return clickManufacturers();
    }

    public AccessControlPage openAccessGroups() {
        clickSettings();
        return clickAccessGroups();
    }

    public AllSuppliersTab openSuppliers() {
        clickMenu();
        return clickSuppliers();
    }

    public AllOrdersTab openOrders() {
        clickMenu();
        return clickOrders();
    }

    public ReportsPage openReports() {
        clickMenu();
        return clickReports();
    }

    public InstallationOrdersAllOrdersTab openInstallationOrders() {
        clickMenu();
        return clickInstallationOrders();
    }

    public AllocateAllOrdersTab openAllocateOrders() {
        clickMenu();
        return clickAllocateOrders();
    }

    public InstallationKitsPage openInstallationKits() {
        clickMenu();
        return clickInstallationKits();
    }

    public GroupTrackerDevicesPage openTrackerDevices() {
        clickMenu();
        return clickTrackerDevices();
    }

    public VehicleRegistrationNumberPage openVehicleRegistrationNumber() {
        clickMenu();
        return clickRegistrationNumbers();
    }

    public AllCompaniesTab openCompanies() {
        clickSettings();
        return clickCompanies();
    }

    public AllWarehousesTab openWarehouses() {
        clickMenu();
        return clickWarehouses();
    }

    public MainArticlesPage openArticles() {
        clickMenu();
        return clickArticles();
    }
}
