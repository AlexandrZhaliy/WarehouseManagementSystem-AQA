package ui;

import org.testng.annotations.Test;
import ui.base.BaseTest;
import utilsHelper.DataProvider;
import ui.common.UserActions;
import ui.models.Orders;
import ui.models.SendArticleType;
import ui.pages.warehouseManagementSystem.MainPage;

import static ui.models.ArticleGroup.VEHICLE_REGISTRATION_NUMBERS;

public class ArchiveTests extends BaseTest {
    @Test(description  = "Suppliers Archive Flow test", groups = {"Regression", "Archive"})
    public void suppliersArchiveFlowTest() {
        DataProvider provider = new DataProvider();
        MainPage mainPage = UserActions.openLoginPage()
                .login(adminUser);

        createGroupSupplier(provider);
        createSupplier(provider);

        mainPage.openSuppliers()
                .openSupplier(provider.supplierName)
                .clickArchiveSupplierButton()
                .verifyAlertTextIsVisible("Supplier archived successfully")
                .openArchiveTab()
                .verifySupplierWithTextIsVisible(provider.supplierName)
                .openArchivedSupplier(provider.supplierName)
                .clickRestoreSupplierButton()
                .verifyAlertTextIsVisible("Supplier restored successfully")
                .verifySupplierWithTextIsVisible(provider.supplierName)
                .openArchiveTab()
                .verifySupplierWithTextIsNotVisible(provider.supplierName);
    }

    @Test(description = "Manufacturers Archive Flow test", groups = {"Regression", "Archive"})
    public void manufacturersArchiveFlowTest() {
        DataProvider provider = new DataProvider();
        MainPage mainPage = UserActions.openLoginPage()
                .login(adminUser);

        createGroupManufacturer(provider);
        createManufacturer(provider);

        mainPage.openManufacturers()
                .archiveManufacturer(provider.manufacturerName)
                .verifyAlertTextIsVisible("Manufacturer archived successfully")
                .verifyManufacturerWithTextIsNotVisible(provider.manufacturerName)
                .openArchiveTab()
                .verifyManufacturerWithTextIsVisible(provider.manufacturerName)
                .restoreManufacturer(provider.manufacturerName)
                .verifyAlertTextIsVisible("Manufacturer was restored successfully.")
                .verifyManufacturerWithTextIsVisible(provider.manufacturerName)
                .openArchiveTab()
                .verifyManufacturerWithTextIsNotVisible(provider.manufacturerName);
    }

    @Test(description = "Storage Unit Archive Base Flow test", groups = {"Regression", "Archive"})
    public void storageUnitArchiveBaseFlowTest() {
        DataProvider provider = new DataProvider();
        UserActions.openLoginPage()
                .login(adminUser)
                .openStorageUnits()
                .clickCreateNewManufacturerButton()
                .storageUnitValue(provider.storageUnit_VN)
                .clickSaveButton()
                .verifyStorageUnitWithTextIsVisible(provider.storageUnit_VN)
                .archiveStorageUnit(provider.storageUnit_VN)
                .verifyAlertTextIsVisible("Unit archived successfully")
                .verifyStorageUnitWithTextIsNotVisible(provider.storageUnit_VN)
                .openArchiveTab()
                .verifyStorageUnitWithTextIsVisible(provider.storageUnit_VN)
                .restoreStorageUnit(provider.storageUnit_VN)
                .verifyAlertTextIsVisible("Unit was restored successfully.")
                .verifyStorageUnitWithTextIsVisible(provider.storageUnit_VN)
                .openArchiveTab()
                .verifyStorageUnitWithTextIsNotVisible(provider.storageUnit_VN);
    }

    @Test(description = "Storage Unit Archive With Article Flow test", groups = {"Regression", "Archive"})
    public void storageUnitArchiveArticleFlowTest() {
        DataProvider provider = new DataProvider();
        MainPage mainPage = UserActions.openLoginPage()
                .login(adminUser);

        createGroup(provider);
        createArticle(provider.articleName_VN, VEHICLE_REGISTRATION_NUMBERS, provider.storageUnit_VN);

        mainPage.openStorageUnits()
                .clickCreateNewManufacturerButton()
                .storageUnitValue(provider.storageUnit_GPS)
                .clickSaveButton()
                .verifyStorageUnitWithTextIsVisible(provider.storageUnit_GPS)

                .archiveStorageUnitWithError(provider.storageUnit_VN)
                .verifyAlertTextIsVisible("Unit cannot be archived. It has existing articles with this unit.")
                .verifyArticleWithTextIsVisible(provider.articleName_VN)
                .openArticles()
                .openArticle(provider.articleName_VN)
                .selectStorageUnit(provider.storageUnit_GPS)
                .saveArticle()

                .openStorageUnits()
                .archiveStorageUnit(provider.storageUnit_VN)
                .verifyAlertTextIsVisible("Unit archived successfully")
                .verifyStorageUnitWithTextIsNotVisible(provider.storageUnit_VN)
                .openArchiveTab()
                .verifyStorageUnitWithTextIsVisible(provider.storageUnit_VN)
                .restoreStorageUnit(provider.storageUnit_VN)
                .verifyAlertTextIsVisible("Unit was restored successfully.")
                .verifyStorageUnitWithTextIsVisible(provider.storageUnit_VN)
                .openArchiveTab()
                .verifyStorageUnitWithTextIsNotVisible(provider.storageUnit_VN);
    }

    @Test(description = "Warehouse Base Archive Flow test", groups = {"Regression", "Archive"})
    public void warehouseArchiveBaseFlowTest() {
        DataProvider provider = new DataProvider();
        MainPage mainPage = UserActions.openLoginPage()
                .login(adminUser);

        createGroup(provider);
        createCompany(provider);
        createWarehouse(provider);

        mainPage.openWarehouses()
                .openWarehouseWithText(provider.warehouseName)
                .archiveWarehouse()
                .verifyAlertTextIsVisible("Warehouse successfully archived")
                .verifyWarehouseWithTextIsNotVisible(provider.warehouseName)
                .openArchiveTab()
                .verifyWarehouseWithTextIsVisible(provider.warehouseName)
                .openWarehouseWithText(provider.warehouseName)
                .restoreWarehouse()
                .verifyAlertTextIsVisible("Warehouse successfully restored")
                .verifyWarehouseWithTextIsVisible(provider.warehouseName)
                .openArchiveTab()
                .verifyWarehouseWithTextIsNotVisible(provider.warehouseName);

    }

    @Test(description = "Warehouse With Articles Archive Flow test", groups = {"Regression", "Archive"})
    public void warehouseArchiveArticlesFlowTest() {
        DataProvider provider = new DataProvider();
        MainPage mainPage = UserActions.openLoginPage()
                .login(adminUser);

        createGroup(provider);
        createCompany(provider);
        createWarehouse(provider);
        createArticle(provider.articleName_VN, VEHICLE_REGISTRATION_NUMBERS, provider.storageUnit_VN, provider.warehouseName, "123");
        createGroup2(provider);
        createCompany2(provider);
        createWarehouse2(provider);


        mainPage.openWarehouses()
                .openWarehouseWithText(provider.warehouseName)
                .archiveWarehouseWithError()
                .verifyAlertTextIsVisible("Warehouse cannot be archived. It has existing articles warehouseManagementSystem level(s)")
                .verifyArticleWithTextIsVisible(provider.articleName_VN);

        mainPage.openOrders()
                .createNewOrder(Orders.TRANSFER_ORDER)
                .selectFromCompany(provider.companyName)
                .selectFromCompanyWarehouse(provider.warehouseName)
                .selectToCompany(provider.companyName2)
                .selectToCompanyWarehouse(provider.warehouseName2)
                .typeDeliveryDate("12.12.2024")
                .clickAddArticlesButton()
                .selectArticle(provider.articleName_VN)
                .selectArticleType(SendArticleType.SEND_ARTICLES)
                .selectArticleAmount("123")
                .clickSaveAndConfirmButton()
                .openOrders()
                .openOrderWithText(provider.companyName)
                .clickDoneButton();

        mainPage.openWarehouses()
                .openWarehouseWithText(provider.warehouseName)
                .archiveWarehouse()
                .verifyAlertTextIsVisible("Warehouse successfully archived")
                .verifyWarehouseWithTextIsNotVisible(provider.warehouseName)
                .openArchiveTab()
                .verifyWarehouseWithTextIsVisible(provider.warehouseName)
                .openWarehouseWithText(provider.warehouseName)
                .restoreWarehouse()
                .verifyAlertTextIsVisible("Warehouse successfully restored")
                .verifyWarehouseWithTextIsVisible(provider.warehouseName)
                .openArchiveTab()
                .verifyWarehouseWithTextIsNotVisible(provider.warehouseName);
    }

    @Test(description = "Company Archive Flow test", groups = {"Regression", "Archive"})
    public void companyArchiveBaseFlowTest() {
        DataProvider provider = new DataProvider();
        MainPage mainPage = UserActions.openLoginPage()
                .login(adminUser);

        createGroup(provider);
        createCompany(provider);

        mainPage.openCompanies()
                .openCompanyWithText(provider.companyName)
                        .archiveCompanyWithError()
                                .verifyAlertTextIsVisible("Company cannot be archived. It has existing warehouses(s):")
                                        .verifyWarehouseWithTextIsVisible(provider.companyWarehouseName);
        mainPage.openWarehouses()
                .openWarehouseWithText(provider.companyWarehouseName)
                .archiveWarehouse();

        mainPage.openCompanies()
                .openCompanyWithText(provider.companyName)
                .archiveCompany()
                .verifyAlertTextIsVisible("Company archived successfully.")
                .verifyCompanyWithTextIsNotVisible(provider.companyName)
                .openArchiveTab()
                .verifyCompanyWithTextIsVisible(provider.companyName)
                .openCompanyWithText(provider.companyName)
                .restoreCompany()
                .verifyAlertTextIsVisible("Company restored successfully.")
                .verifyCompanyWithTextIsVisible(provider.companyName)
                .openArchiveTab()
                .verifyCompanyWithTextIsNotVisible(provider.companyName);
    }
}
