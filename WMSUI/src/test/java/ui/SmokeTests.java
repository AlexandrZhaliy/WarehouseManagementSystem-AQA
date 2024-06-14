package ui;

import org.testng.annotations.Test;
import ui.base.BaseTest;
import utilsHelper.DataProvider;
import ui.common.UserActions;
import ui.models.*;
import ui.pages.WarehouseManagementSystem.MainPage;
import ui.pages.WarehouseManagementSystem.installationKits.InstallationKitsPage;

import static ui.models.ArticleGroup.*;
import static ui.models.ArticleStatus.*;
import static ui.pages.warehouseManagementSystem.warehouses.ReportTab.DEPRECIATE_UNIQUE_ARTICLES;
import static ui.pages.warehouseManagementSystem.warehouses.ReportTab.TRANSFER_UNIQUE_ARTICLES;
import static utils.Utils.getAbsRandomInt;

public class SmokeTests extends BaseTest {
    @Test(description = "Smoke Main Flow test", groups = {"Smoke", "Regression"})
    public void smokeMainFlowTest() {
        DataProvider provider = new DataProvider();
        //        =================== Create Group=================
        UserActions.openLoginPage()
                .login(adminUser)
                .openGroups()
                .clickCreateNewGroupButton()
                .groupName(provider.companyGroup)
                .type(GroupType.COMPANIES.getName())
                .clickSubmitButton()
                .selectGroupType(GroupType.WAREHOUSES.getName())
                .clickCreateNewGroupButton()
                .groupName(provider.warehousesGroup)
                .clickSubmitButton()
                //        =================== Create Group=================
                //        =================== Create Company=================
                .openCompanies()
                .clickCreateCompanyButton()
                .companyName(provider.companyName)
                .companyEmail("companyEmail@email.com")
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
                .clickCreateButton()
                //                =================== Create Company=================
                //                =================== Create Warehouse=================
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
                .saveWarehouseCreation()
                //        =================== Create Warehouse=================

                //        =================== Create Article - VEHICLE_REGISTRATION_NUMBERS=================
                .openArticles()
                .clickCreateNewArticleButton()
                .articleName(provider.articleName_VN)
                .moduleNumber(String.valueOf(getAbsRandomInt()))
                .selectGroup(CENTRAL_GOVERNMENT)
                .addStorageUnit(provider.storageUnit_VN)
                .selectStorageUnit(provider.storageUnit_VN)
                .saveNewArticle()
                //        =================== Create Article - VEHICLE_REGISTRATION_NUMBERS=================
                //        =================== Add amount Article - VEHICLE_REGISTRATION_NUMBERS=================
                .openArticle(provider.articleName_VN)
                .openActionsTab()
                .warehouseName(provider.warehouseName)
                .amountNumber("123")
                .selectStatus(DONE)
                .clickSubmitButton()
                //        =================== Add amount Article - VEHICLE_REGISTRATION_NUMBERS=================
                //        =================== Unicity Article - VEHICLE_REGISTRATION_NUMBERS=================

                .openUnicityTab()
                .selectWarehouse(provider.warehouseName)
                .clickAutogenerateCheckbox()
                .selectArticlesCount("2")
                .clickSaveButton()
                .saveNumbers(provider.VN_serialNumberlist)
                //        =================== Unicity Article - VEHICLE_REGISTRATION_NUMBERS=================

                //        =================== Create Article - TRACKER_DEVICES=================
                .openArticles()
                .clickCreateNewArticleButton()
                .articleName(provider.articleName_TD)
                .moduleNumber(String.valueOf(getAbsRandomInt()))
                .selectGroup(ArticleGroup.TRACKER_DEVICES)
                .addStorageUnit(provider.storageUnit_TD)
                .selectStorageUnit(provider.storageUnit_TD)
                .saveNewArticle()
                //        =================== Create Article - TRACKER_DEVICES=================
                //        =================== Add amount Article - TRACKER_DEVICES=================
                .openArticle(provider.articleName_TD)
                .openActionsTab()
                .warehouseName(provider.warehouseName)
                .amountNumber("123")
                .selectStatus(DONE)
                .clickSubmitButton()
                //        =================== Add amount Article - TRACKER_DEVICES=================
                //        =================== Unicity Article - TRACKER_DEVICES=================

                .openUnicityTab()
                .selectWarehouse(provider.warehouseName)
                .clickAutogenerateCheckbox()
                .selectArticlesCount("2")
                .clickSaveButton()
                .saveNumbers(provider.TD_serialNumberlist)
                //        =================== Unicity Article - TRACKER_DEVICES=================

                //        =================== Create Article - GPS_TRACKERS=================
                .openArticles()
                .clickCreateNewArticleButton()
                .articleName(provider.articleName_GPS)
                .moduleNumber(String.valueOf(getAbsRandomInt()))
                .selectGroup(ArticleGroup.GPS_TRACKERS)
                .addStorageUnit(provider.storageUnit_GPS)
                .selectStorageUnit(provider.storageUnit_GPS)
                .saveNewArticle()
                //        =================== Create Article - GPS_TRACKERS=================
                //        =================== Add amount Article - GPS_TRACKERS=================
                .openArticle(provider.articleName_GPS)
                .openActionsTab()
                .warehouseName(provider.warehouseName)
                .amountNumber("123")
                .selectStatus(DONE)
                .clickSubmitButton()
                //        =================== Add amount Article - GPS_TRACKERS=================
                //        =================== Unicity Article - GPS_TRACKERS=================

                .openUnicityTab()
                .selectWarehouse(provider.warehouseName)
                .clickAutogenerateCheckbox()
                .selectArticlesCount("1")
                .clickSaveButton()
                .saveNumbers(provider.GPS_serialNumberlist)
                //        =================== Unicity Article - GPS_TRACKERS=================
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
                .saveVehicleRegistrationNumber(provider)
                //        =================== InstallationKits=================
                //        =================== Allocate Order=================
                .openAllocateOrders()
                .clickCreateNewOrderButton()
                .typeApplicationReferenceNumber()
                .selectServiceType(TypeOfService.FIRST_TIME_REGISTRATION.getName())
                .typeTin("1234567890")
                .typeVin(provider.vinNumber)
                .selectWarehouse(provider.warehouseName)
                .selectRegistrationPlateCategory(CENTRAL_GOVERNMENT.getName())
                .selectVehicleType(VehicleType.VEHICLE)
                .selectFrontPlateShape(PlateShape.SQUARE)
                .selectRearPlateShape(PlateShape.SQUARE)
                .selectRegistrationPlate(provider.vehicleRegistrationNumber)
                .clickAllocateButton()

                .openInstallationOrders()
                .openOrderWithText(provider.warehouseName)
                .selectFrontPlate(provider.VN_serialNumberlist.get(0))
                .selectRearPlate(provider.VN_serialNumberlist.get(1))
                .selectGpsTracker(provider.GPS_serialNumberlist.get(0))
                .clickSaveAndContinueButton()

                .selectFrontPlateImg()
                .selectRearPlateImg()
                .clickSubmitButton()

                .verifyOrderWithTextIsNotVisible(provider.warehouseName)
                .openArchiveTab()
                .verifyOderWithTextIsVisible(provider.warehouseName)
                //        =================== Allocate Order=================
                .openArticles()
                .openArticle(provider.articleName_VN)
                .openUnicityTab()
                .clickArchiveButton()
                .verifyArticleWithTextIsVisible(provider.VN_serialNumberlist.get(0))
                .verifyArticleWithTextIsVisible(provider.VN_serialNumberlist.get(1))

                .openArticles()
                .openArticle(provider.articleName_TD)
                .openUnicityTab()
                .clickArchiveButton()
                .verifyArticleWithTextIsVisible(provider.TD_serialNumberlist.get(0))
                .verifyArticleWithTextIsVisible(provider.TD_serialNumberlist.get(1))

                .openArticles()
                .openArticle(provider.articleName_GPS)
                .openUnicityTab()
                .clickArchiveButton()
                .verifyArticleWithTextIsVisible(provider.GPS_serialNumberlist.get(0));
    }

    @Test(description = "Smoke Order Depreciate Send Article Flow test", groups = {"Smoke", "Regression"})
    public void smokeOrderDepreciateSendArticleFlowTest() {
        DataProvider provider = new DataProvider();
        MainPage mainPage = UserActions.openLoginPage()
                .login(adminUser);

        createGroup(provider);
        createCompany(provider);
        createWarehouse(provider);
        createArticle(provider.articleName_VN, VEHICLE_REGISTRATION_NUMBERS, provider.storageUnit_VN, provider.warehouseName, "123");

        mainPage.openOrders()
                .createNewOrder(Orders.DEPRECIATE_ORDER)
                .selectFromCompany(provider.companyName)
                .selectFromCompanyWarehouse(provider.warehouseName)
                .typeDeliveryDate("12.12.2024")
                .clickAddArticlesButton()
                .selectArticle(provider.articleName_VN)
                .selectArticleType(SendArticleType.SEND_ARTICLES)
                .selectArticleAmount("1")
                .clickSaveAndConfirmButton()

                .openWarehouses()
                .openWarehouseWithText(provider.warehouseName)
                .verifyTotalAmountIs("123")
                .verifyTotalReservedAmountIs("-1")

                .openOrders()
                .openOrderWithText(provider.companyName)
                .clickDepreciatedButton()

                .openWarehouses()
                .openWarehouseWithText(provider.warehouseName)
                .verifyTotalAmountIs("122")
                .verifyTotalReservedAmountIs("0");
    }

    @Test(description = "Smoke Order Depreciate Send Uniq Article Flow test", groups = {"Smoke", "Regression"})
    public void smokeOrderDepreciateSendUniqArticleFlowTest() {
        DataProvider provider = new DataProvider();
        MainPage mainPage = UserActions.openLoginPage()
                .login(adminUser);

        createGroup(provider);
        createCompany(provider);
        createWarehouse(provider);
        createArticle(provider.articleName_VN, VEHICLE_REGISTRATION_NUMBERS, provider.storageUnit_VN, provider.warehouseName, "123", "2", provider.VN_serialNumberlist);

        mainPage.openOrders()
                .createNewOrder(Orders.DEPRECIATE_ORDER)
                .selectFromCompany(provider.companyName)
                .selectFromCompanyWarehouse(provider.warehouseName)
                .clickAddArticlesButton()
                .selectArticle(provider.articleName_VN)
                .selectArticleType(SendArticleType.SEND_SPECIFIC_UNIQUE_ARTICLES)
                .selectUniqArticle(provider.VN_serialNumberlist.get(0))
                .clickSaveAndConfirmButton()

                .openWarehouses()
                .openWarehouseWithText(provider.warehouseName)
                .verifyTotalAmountIs("123")
                .verifyTotalReservedAmountIs("-1")
                .verifyRowIsVisibleWithTexts(DEPRECIATE_UNIQUE_ARTICLES, provider.VN_serialNumberlist.get(0), NEW.getName())

                .openArticles()
                .openArticle(provider.articleName_VN)
                .openUnicityTab()
                .verifyRowIsVisibleWithTexts(provider.warehouseName, ACTIVE.getName())

                .openOrders()
                .openOrderWithText(provider.companyName)
                .clickDepreciatedButton()

                .openWarehouses()
                .openWarehouseWithText(provider.warehouseName)
                .verifyTotalAmountIs("122")
                .verifyTotalReservedAmountIs("0")
                .verifyRowIsVisibleWithTexts(DEPRECIATE_UNIQUE_ARTICLES, provider.VN_serialNumberlist.get(0), DONE.getName())

                .openArticles()
                .openArticle(provider.articleName_VN)
                .openUnicityTab()
                .verifyRowIsNotVisibleWithTexts(provider.warehouseName, provider.VN_serialNumberlist.get(0))
                .clickArchiveButton()
                .verifyArticleWithTextIsVisible(provider.VN_serialNumberlist.get(0), INACTIVE.getName());

    }

    @Test(description = "Smoke Order Transfer Send Article Flow test", groups = {"Smoke", "Regression"})
    public void smokeOrderTransferSendArticleFlowTest() {
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
                .selectArticleAmount("1")
                .clickSaveAndConfirmButton()

                .openWarehouses()
                .openWarehouseWithText(provider.warehouseName)
                .verifyTotalAmountIs("123")
                .verifyTotalReservedAmountIs("-1")

                .openWarehouses()
                .openWarehouseWithText(provider.warehouseName2)
                .verifyTotalAmountIs("0")
                .verifyTotalReservedAmountIs("1")

                .openOrders()
                .openOrderWithText(provider.companyName)
                .clickDoneButton()

                .openWarehouses()
                .openWarehouseWithText(provider.warehouseName)
                .verifyTotalAmountIs("122")
                .verifyTotalReservedAmountIs("0")

                .openWarehouses()
                .openWarehouseWithText(provider.warehouseName2)
                .verifyTotalAmountIs("1")
                .verifyTotalReservedAmountIs("0");
    }

    @Test(description = "Smoke Order Transfer Send Uniq Article Flow test", groups = {"Smoke", "Regression"})
    public void smokeOrderTransferSendUniqArticleFlowTest() {
        DataProvider provider = new DataProvider();
        MainPage mainPage = UserActions.openLoginPage()
                .login(adminUser);

        createGroup(provider);
        createCompany(provider);
        createWarehouse(provider);
        createArticle(provider.articleName_VN, VEHICLE_REGISTRATION_NUMBERS, provider.storageUnit_VN, provider.warehouseName, "123", "2", provider.VN_serialNumberlist);
        createGroup2(provider);
        createCompany2(provider);
        createWarehouse2(provider);

        mainPage.openOrders()
                .createNewOrder(Orders.TRANSFER_ORDER)
                .selectFromCompany(provider.companyName)
                .selectFromCompanyWarehouse(provider.warehouseName)
                .selectToCompany(provider.companyName2)
                .selectToCompanyWarehouse(provider.warehouseName2)
                .typeDeliveryDate("12.12.2024")
                .clickAddArticlesButton()
                .selectArticle(provider.articleName_VN)
                .selectArticleType(SendArticleType.SEND_SPECIFIC_UNIQUE_ARTICLES)
                .selectUniqArticle(provider.VN_serialNumberlist.get(0))
                .clickSaveAndConfirmButton()

                .openWarehouses()
                .openWarehouseWithText(provider.warehouseName)
                .verifyTotalAmountIs("123")
                .verifyTotalReservedAmountIs("-1")
                .verifyRowIsVisibleWithTexts(TRANSFER_UNIQUE_ARTICLES, provider.VN_serialNumberlist.get(0), NEW.getName())

                .openWarehouses()
                .openWarehouseWithText(provider.warehouseName2)
                .verifyTotalAmountIs("0")
                .verifyTotalReservedAmountIs("1")
                .verifyRowIsVisibleWithTexts(TRANSFER_UNIQUE_ARTICLES, provider.VN_serialNumberlist.get(0), NEW.getName())

                .openArticles()
                .openArticle(provider.articleName_VN)
                .openUnicityTab()
                .verifyRowIsVisibleWithTexts(provider.warehouseName, provider.warehouseName2)

                .openOrders()
                .openOrderWithText(provider.companyName)
                .clickDoneButton()

                .openWarehouses()
                .openWarehouseWithText(provider.warehouseName)
                .verifyTotalAmountIs("122")
                .verifyTotalReservedAmountIs("0")
                .verifyRowIsVisibleWithTexts(TRANSFER_UNIQUE_ARTICLES, provider.VN_serialNumberlist.get(0), DONE.getName())

                .openWarehouses()
                .openWarehouseWithText(provider.warehouseName2)
                .verifyTotalAmountIs("1")
                .verifyTotalReservedAmountIs("0")
                .verifyRowIsVisibleWithTexts(TRANSFER_UNIQUE_ARTICLES, provider.VN_serialNumberlist.get(0), DONE.getName())

                .openArticles()
                .openArticle(provider.articleName_VN)
                .openUnicityTab()
                .verifyRowIsVisibleWithTexts(provider.warehouseName2);

    }

    @Test(description = "Smoke Order Transfer InstallationKit Flow test", groups = {"Smoke", "Regression"})
    public void smokeOrderTransferInstallationKitFlowTest() {
        DataProvider provider = new DataProvider();
        MainPage mainPage = UserActions.openLoginPage()
                .login(adminUser);

        createGroup(provider);
        createCompany(provider);
        createWarehouse(provider);
        createArticle(provider.articleName_VN, VEHICLE_REGISTRATION_NUMBERS, provider.storageUnit_VN, provider.warehouseName, "123", "2", provider.VN_serialNumberlist);
        createArticle(provider.articleName_TD, TRACKER_DEVICES, provider.storageUnit_TD, provider.warehouseName, "123", "2", provider.TD_serialNumberlist);
        createArticle(provider.articleName_GPS, GPS_TRACKERS, provider.storageUnit_GPS, provider.warehouseName, "123", "1", provider.GPS_serialNumberlist);
        createInstallationKit(provider);

        createGroup2(provider);
        createCompany2(provider);
        createWarehouse2(provider);

        mainPage.openOrders()
                .createNewOrder(Orders.TRANSFER_ORDER)
                .selectFromCompany(provider.companyName)
                .selectFromCompanyWarehouse(provider.warehouseName)
                .selectToCompany(provider.companyName2)
                .selectToCompanyWarehouse(provider.warehouseName2)
                .typeDeliveryDate("12.12.2024")
                .clickAddInstallationKitButton()
                .selectInstallationKitNumber(InstallationKitsPage.installationKitNumber)
                .clickSaveAndConfirmButton()

                .openWarehouses()
                .openWarehouseWithText(provider.warehouseName)
                .verifyTotalAmountIs("369")
                .verifyTotalReservedAmountIs("-5")
                .verifyRowIsVisibleWithTexts(TRANSFER_UNIQUE_ARTICLES, provider.VN_serialNumberlist.get(0), NEW.getName())
                .verifyRowIsVisibleWithTexts(TRANSFER_UNIQUE_ARTICLES, provider.VN_serialNumberlist.get(1), NEW.getName())
                .verifyRowIsVisibleWithTexts(TRANSFER_UNIQUE_ARTICLES, provider.TD_serialNumberlist.get(0), NEW.getName())
                .verifyRowIsVisibleWithTexts(TRANSFER_UNIQUE_ARTICLES, provider.TD_serialNumberlist.get(1), NEW.getName())
                .verifyRowIsVisibleWithTexts(TRANSFER_UNIQUE_ARTICLES, provider.GPS_serialNumberlist.get(0), NEW.getName())

                .openWarehouses()
                .openWarehouseWithText(provider.warehouseName2)
                .verifyTotalAmountIs("0")
                .verifyTotalReservedAmountIs("5")
                .verifyRowIsVisibleWithTexts(TRANSFER_UNIQUE_ARTICLES, provider.VN_serialNumberlist.get(0), NEW.getName())
                .verifyRowIsVisibleWithTexts(TRANSFER_UNIQUE_ARTICLES, provider.VN_serialNumberlist.get(1), NEW.getName())
                .verifyRowIsVisibleWithTexts(TRANSFER_UNIQUE_ARTICLES, provider.TD_serialNumberlist.get(0), NEW.getName())
                .verifyRowIsVisibleWithTexts(TRANSFER_UNIQUE_ARTICLES, provider.TD_serialNumberlist.get(1), NEW.getName())
                .verifyRowIsVisibleWithTexts(TRANSFER_UNIQUE_ARTICLES, provider.GPS_serialNumberlist.get(0), NEW.getName())

                .openOrders()
                .openOrderWithText(provider.companyName)
                .clickDoneButton()

                .openWarehouses()
                .openWarehouseWithText(provider.warehouseName)
                .verifyTotalAmountIs("364")
                .verifyTotalReservedAmountIs("0")
                .verifyRowIsVisibleWithTexts(TRANSFER_UNIQUE_ARTICLES, provider.VN_serialNumberlist.get(0), DONE.getName())
                .verifyRowIsVisibleWithTexts(TRANSFER_UNIQUE_ARTICLES, provider.VN_serialNumberlist.get(1), DONE.getName())
                .verifyRowIsVisibleWithTexts(TRANSFER_UNIQUE_ARTICLES, provider.TD_serialNumberlist.get(0), DONE.getName())
                .verifyRowIsVisibleWithTexts(TRANSFER_UNIQUE_ARTICLES, provider.TD_serialNumberlist.get(1), DONE.getName())
                .verifyRowIsVisibleWithTexts(TRANSFER_UNIQUE_ARTICLES, provider.GPS_serialNumberlist.get(0), DONE.getName())
                .openWarehouses()
                .openWarehouseWithText(provider.warehouseName2)
                .verifyTotalAmountIs("5")
                .verifyTotalReservedAmountIs("0")
                .verifyRowIsVisibleWithTexts(TRANSFER_UNIQUE_ARTICLES, provider.VN_serialNumberlist.get(0), DONE.getName())
                .verifyRowIsVisibleWithTexts(TRANSFER_UNIQUE_ARTICLES, provider.VN_serialNumberlist.get(1), DONE.getName())
                .verifyRowIsVisibleWithTexts(TRANSFER_UNIQUE_ARTICLES, provider.TD_serialNumberlist.get(0), DONE.getName())
                .verifyRowIsVisibleWithTexts(TRANSFER_UNIQUE_ARTICLES, provider.TD_serialNumberlist.get(1), DONE.getName())
                .verifyRowIsVisibleWithTexts(TRANSFER_UNIQUE_ARTICLES, provider.GPS_serialNumberlist.get(0), DONE.getName());
    }

    @Test(description = "Smoke Order Purchase Flow test", groups = {"Smoke", "Regression"})
    public void smokeOrderPurchaseFlowTest() {
        DataProvider provider = new DataProvider();
        MainPage mainPage = UserActions.openLoginPage()
                .login(adminUser);

        createGroupSupplier(provider);
        createSupplier(provider);

        createGroup(provider);
        createCompany(provider);
        createWarehouse(provider);
        createArticle(provider.articleName_VN, VEHICLE_REGISTRATION_NUMBERS, provider.storageUnit_VN, provider.warehouseName, "123", "2", provider.VN_serialNumberlist);

        mainPage.openOrders()
                .createNewOrder(Orders.PURCHASE_ORDER)
                .selectFromCompany(provider.supplierName)
                .selectToCompany(provider.companyName)
                .selectToCompanyWarehouse(provider.warehouseName)
                .typeDeliveryDate("12.12.2024")
                .clickAddArticlesButton()
                .selectArticle(provider.articleName_VN)
                .selectArticleAmount("123")
                .clickSaveAndConfirmButton()

                .openArticles()
                .openArticle(provider.articleName_VN)
                .openStatisticTab()
                .verifyTotalAmountIs("123")
                .verifyTotalReservedAmountIs("123")

                .openOrders()
                .openOrderWithText(provider.companyName)
                .clickReceivedButton()

                .openArticles()
                .openArticle(provider.articleName_VN)
                .openStatisticTab()
                .verifyTotalAmountIs("246");
    }

    @Test(description = "C-209 · Marking of defect in installation order", groups = {"Regression"})
    public void c209MarkingOfDefectInInstallationOrder() {
        DataProvider provider = new DataProvider();
        DataProvider provider2 = new DataProvider();
        MainPage mainPage = UserActions.openLoginPage()
                .login(adminUser);

        createGroup(provider);
        createCompany(provider);
        createWarehouse(provider);
        createArticle(provider.articleName_VN, CENTRAL_GOVERNMENT, provider.storageUnit_VN, provider.warehouseName, "123", "2", provider.VN_serialNumberlist);
        createArticle(provider.articleName_TD, TRACKER_DEVICES, provider.storageUnit_TD, provider.warehouseName, "123", "2", provider.TD_serialNumberlist);
        createArticle(provider.articleName_GPS, GPS_TRACKERS, provider.storageUnit_GPS, provider.warehouseName, "123", "1", provider.GPS_serialNumberlist);
        createInstallationKit(provider);

        createGroup(provider2);
        createCompany(provider2);
        createWarehouse(provider2);
        createArticle(provider2.articleName_VN, CENTRAL_GOVERNMENT, provider2.storageUnit_VN, provider2.warehouseName, "123", "2", provider2.VN_serialNumberlist);
        createArticle(provider2.articleName_TD, TRACKER_DEVICES, provider2.storageUnit_TD, provider2.warehouseName, "123", "2", provider2.TD_serialNumberlist);
        createArticle(provider2.articleName_GPS, GPS_TRACKERS, provider2.storageUnit_GPS, provider2.warehouseName, "123", "1", provider2.GPS_serialNumberlist);
        createInstallationKit(provider2);

        mainPage.openAllocateOrders()
                .clickCreateNewOrderButton()
                .typeApplicationReferenceNumber()
                .selectServiceType(TypeOfService.FIRST_TIME_REGISTRATION.getName())
                .typeTin("1234567890")
                .typeVin(provider.vinNumber)
                .selectWarehouse(provider.warehouseName)
                .selectRegistrationPlateCategory(CENTRAL_GOVERNMENT.getName())
                .selectVehicleType(VehicleType.VEHICLE)
                .selectFrontPlateShape(PlateShape.SQUARE)
                .selectRearPlateShape(PlateShape.SQUARE)
                .selectRegistrationPlate(provider.vehicleRegistrationNumber)
                .clickAllocateButton()

                .openInstallationOrders()
                .openOrderWithText(provider.warehouseName)
                .selectFrontPlate(provider.VN_serialNumberlist.get(0))
                .selectRearPlate(provider.VN_serialNumberlist.get(1))
                .selectGpsTracker(provider.GPS_serialNumberlist.get(0))
                .clickReportDefectButton()
                .openArchiveTab()
                .verifyOderWithTextIsVisible(provider.vinNumber)

                .openAllocateOrders()
                .verifyOrderWithTextIsVisible(provider.vinNumber, "draft", "Draft")
                .openArchiveTab()
                .verifyOrderWithTextIsVisible(provider.vinNumber, "Defected")
                .openAllOrdersTab()
                .openOrderWithText(provider.vinNumber, "draft", "Draft")
                .selectWarehouse(provider2.warehouseName)
                .selectRegistrationPlateCategory(CENTRAL_GOVERNMENT.getName())
                .selectVehicleType(VehicleType.VEHICLE)
                .selectFrontPlateShape(PlateShape.SQUARE)
                .selectRearPlateShape(PlateShape.SQUARE)
                .selectRegistrationPlate(provider2.vehicleRegistrationNumber)
                .clickAllocateButton()
                .verifyOrderWithTextIsVisible(provider.vinNumber, "Allocated");
    }

}
