package ui;

import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.common.UserActions;
import ui.pages.warehouseManagementSystem.MainPage;
import utilsHelper.DataProvider;
import static ui.models.ArticleGroup.VEHICLE_REGISTRATION_NUMBERS;

public class CreateNewWarehouseManagementSystemTest extends BaseTest {

    @Test(description = "Create new Warehouse Management System", groups = {"Regression", "Article"})
    public void createNewWarehouseManagementSystemTest() {
        DataProvider provider = new DataProvider();

        // =================== Login ===================
        MainPage mainPage = UserActions.openLoginPage().login(adminUser);

        // =================== Create new warehouseManagementSystem Control ===================
        createGroup(provider);
        createCompany(provider);
        createWarehouse(provider);
        createArticle(provider.articleName_VN, VEHICLE_REGISTRATION_NUMBERS, provider.storageUnit_VN, provider.warehouseName, "1000");

        // =================== Open warehouseManagementSystem Control Tab ===================
        mainPage.openArticles()
                .openArticle(provider.articleName_VN)
                .openwarehouseManagementSystemTab()
                .clickEditButton()
                .typeMinimumQuantityInputwarehouseManagementSystem("999")
                .typeCriticalQuantityInputwarehouseManagementSystem("998")
                .selectWarehousewarehouseManagementSystem(provider.warehouseName)
                .clickSaveButton()
                .createdNewwarehouseManagementSystemMessage("New warehouseManagementSystem control created successfully.")
                .clickAddWarehouseButton()
                .typeModalMinimumQualitywarehouseManagementSystem("999")
                .typeModalCriticalQualitywarehouseManagementSystem("998")
                .selectWarehousewarehouseManagementSystemModal(provider.warehouseName)
                .modalAddButtonClick()
                .createdNewwarehouseManagementSystemMessage("New warehouseManagementSystem control created successfully.");
    }
}
