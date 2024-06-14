package ui;

import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.common.UserActions;
import ui.pages.warehouseManagementSystemMainPage;
import ui.pages.warehouseManagementSystem.reports.WarehousesTab;
import utilsHelper.DataProvider;

public class ReportsTests extends BaseTest {
    @Test(description = "Report Warehouse Flow test", groups = {"Regression", "Report"})
    public void reportWarehouseFlowTest() {
        DataProvider provider = new DataProvider();
        MainPage mainPage = UserActions.openLoginPage()
                .login(adminUser);

        createGroup(provider);
        createCompany(provider);
        createWarehouse(provider);

        mainPage.openReports()
                .openWarehousesTab()
                .createWarehouseReport(provider.warehouseName)
                .verifyRowIsVisibleWithTexts(provider.warehouseName, "In queue")
                .refreshPage(WarehousesTab.class)
                .verifyRowIsVisibleWithTexts(provider.warehouseName, "Done", "Download Excel File")
                .verifyDownloadedFileWithTextHasName("warehouse_report_", provider.warehouseName, "Done", "Download Excel File");
    }

    @Test(description = "Report Order Flow test", groups = {"Regression", "Report"})
    public void reportOrderFlowTest() {
        DataProvider provider = new DataProvider();
        MainPage mainPage = UserActions.openLoginPage()
                .login(adminUser);

        createGroup(provider);
        createCompany(provider);
        createWarehouse(provider);

        mainPage.openReports()
                .openOrdersTab()
                .createOrdersReport(provider.warehouseName)
                .verifyRowIsVisibleWithTexts(provider.warehouseName, "In queue")
                .refreshPage(WarehousesTab.class)
                .verifyRowIsVisibleWithTexts(provider.warehouseName, "Done", "Download Excel File")
                .verifyDownloadedFileWithTextHasName("orders_report_", provider.warehouseName, "Done", "Download Excel File");

    }

    @Test(description = "Report Installation Order Flow test", groups = {"Regression", "Report"})
    public void reportInstallationOrderFlowTest() {
        DataProvider provider = new DataProvider();
        MainPage mainPage = UserActions.openLoginPage()
                .login(adminUser);

        createGroup(provider);
        createCompany(provider);
        createWarehouse(provider);

        mainPage.openReports()
                .openInstallationOrdersTab()
                .createInstallationOrdersReport(provider.warehouseName)
                .verifyRowIsVisibleWithTexts(provider.warehouseName, "In queue")
                .refreshPage(WarehousesTab.class)
                .verifyRowIsVisibleWithTexts(provider.warehouseName, "Done", "Download Excel File")
                .verifyDownloadedFileWithTextHasName("installation_orders_report_", provider.warehouseName, "Done", "Download Excel File");

    }
}
