package ui;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.common.UserActions;
import ui.pages.warehouseManagementSystem.MainPage;
import utilsHelper.DataProvider;

import static ui.models.ArticleGroup.VEHICLE_REGISTRATION_NUMBERS;

public class UniqueArticlesSearchTests extends BaseTest {

    @Test(description = "Edit and Search Unique Article by Serial Number and Code - positive flow", groups = {"Regression", "Article"})
    public void searchUniqueArticleBySerialNumberAndCodePositiveFlow() {

        //      ================= Create unique article =================
        DataProvider provider = new DataProvider();
        MainPage mainPage = UserActions.openLoginPage()
                .login(adminUser);

        createGroup(provider);
        createCompany(provider);
        createWarehouse(provider);

        createArticle(provider.articleName_VN, VEHICLE_REGISTRATION_NUMBERS, provider.storageUnit_VN, provider.warehouseName, "123", "2", provider.VN_serialNumberlist);

        //      ================= Add specific serial number and specific code to unique article =================
        mainPage.openArticles()
                .openArticle(provider.articleName_VN)
                .openUnicityTab()
                .saveNumbers(provider.VN_serialNumberlist)
                .clickOnUpdateUniqueArticleButton(provider.VN_serialNumberlist.get(1))
                .fillUniqueArticleCode(provider.uniqArticleCode)
                .clickOnSaveEditedUniqueArticleButton()

                //      ================= Verify unique article serial number and code fields presence =================
                .verifyUniqueArticleSerialNumberSearchInputIsVisible()
                .verifyUniqueArticleCodeSearchInputIsVisible()

                //      ================= Search unique articles by Serial Number and Code =================
                .searchUnicityArticleByValidSerialNumber(provider.VN_serialNumberlist.get(1))
                .verifySearchResultsInUniqueArticlesTableHasSerialNumberText(provider.VN_serialNumberlist.get(1))
                .searchUnicityArticleByValidCode(provider.uniqArticleCode)
                .verifySearchResultsInUniqueArticlesTableHasCodeText(provider.uniqArticleCode)

                //      ================= Clear Serial Number and Code fields =================
                .clickUniqueArticleSerialNumberSearchInputClear()
                .clickUniqueArticleCodeSearchInputClear();
    }

        @Test(description = "Search Unique Article by Serial Number and Code - negative flow", groups = {"Regression","Article"})
        public void searchUniqueArticleBySerialNumberAndCodeNegativeFlow() {

            //      ================= Create unique article =================
            DataProvider provider = new DataProvider();
            MainPage mainPage = UserActions.openLoginPage()
                    .login(adminUser);

            String firstCode = provider.uniqArticleCode;
            String secondCode = provider.uniqArticleCode + "qwe";
            String noResultsFound = "No results found";

            createGroup(provider);
            createCompany(provider);
            createWarehouse(provider);

            createArticle(provider.articleName_VN, VEHICLE_REGISTRATION_NUMBERS, provider.storageUnit_VN, provider.warehouseName, "123", "2", provider.VN_serialNumberlist);

            //      ================= Add specific serial number and specific code to unique article =================
            mainPage.openArticles()
                    .openArticle(provider.articleName_VN)
                    .openUnicityTab()
                    .clickOnUpdateUniqueArticleButton(provider.VN_serialNumberlist.get(0))
                    .fillUniqueArticleCode(firstCode)
                    .clickOnSaveEditedUniqueArticleButton()
                    .clickOnUpdateUniqueArticleButton(provider.VN_serialNumberlist.get(1))
                    .fillUniqueArticleCode(secondCode)
                    .clickOnSaveEditedUniqueArticleButton()

            //      ================= Search unique articles by invalid Serial Number and  invalid Code =================
                    .searchUnicityArticleByInvalidSerialNumber("qwerty")
                    .verifyAlertTextIsVisibleForSerialNumberField(noResultsFound)
                    .searchUnicityArticleByInvalidCode("asdfgh")
                    .verifyAlertTextIsVisibleForCodeField(noResultsFound)

            //      ================= Search unique articles by invalid Serial Number and valid Code =================
                    .searchUnicityArticleByValidSerialNumber(provider.VN_serialNumberlist.get(0))
                    .verifySearchResultsInUniqueArticlesTableHasSerialNumberText(provider.VN_serialNumberlist.get(0))
                    .searchUnicityArticleByValidCode(secondCode)
                    .verifyNoSearchResultsInTable();
    }
}