package ui;

import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.pages.warehouseManagementSystem.MainPage;
import utilsHelper.DataProvider;
import ui.common.UserActions;

import static ui.models.ArticleGroup.*;
import static utils.Utils.getAbsRandomInt;

public class DeleteLinkedUniqArticleTests extends BaseTest {

    @Test(description = "Try to delete linked uniq article", groups = {"Regression", "Article"})
    public void DeleteLinkedUniqArticle() {
        DataProvider provider = new DataProvider();
        //        =================== Create Group=================
        MainPage mainPage = UserActions.openLoginPage()
                .login(adminUser);

        createGroup(provider);
        createCompany(provider);
        createWarehouse(provider);
        createArticle(provider.articleName_VN, VEHICLE_REGISTRATION_NUMBERS, provider.storageUnit_VN, provider.warehouseName, "123", "2", provider.VN_serialNumberlist);
        createArticle(provider.articleName_TD, TRACKER_DEVICES, provider.storageUnit_TD, provider.warehouseName, "123", "2", provider.TD_serialNumberlist);
        createArticle(provider.articleName_GPS, GPS_TRACKERS, provider.storageUnit_GPS, provider.warehouseName, "123", "1", provider.GPS_serialNumberlist);
        createVehicleRegistrationNumber(provider);
        createTrackerDevices(provider);
        //        =================== DeleteLinkedTrackerDevices=================
        mainPage.openArticles()
                .openArticle(provider.articleName_TD)
                .openActionsTab()
                .openUnicityTab()
                .deleteUniqArticleWithSerialNumber(provider.TD_serialNumberlist.get(0))
                .verifyErrorMessage("Article cannot be deleted. It is used in the group")
                //        =================== DeleteLinkedTrackerDevices=================
                //        =================== DeleteLinkedVEHICLE_REGISTRATION_NUMBERS=================
                .openArticles()
                .openArticle(provider.articleName_VN)
                .openActionsTab()

                .openUnicityTab()
                .deleteUniqArticleWithSerialNumberNoConfirm(provider.VN_serialNumberlist.get(0))
                .verifyErrorMessage("This unique article cannot be deleted as it is currently associated with a group.")
                //        =================== DeleteLinkedVEHICLE_REGISTRATION_NUMBERS=================
                //        =================== DeleteLinked_GPS_Tracer=================
                .openArticles()
                .openArticle(provider.articleName_GPS)
                .openActionsTab()
                .openUnicityTab()
                .deleteUniqArticleWithSerialNumber(provider.GPS_serialNumberlist.get(0))
                .verifyErrorMessage("Article cannot be deleted. It is used in the group");
        //        =================== DeleteLinked_GPS_Tracer=================
    }
}