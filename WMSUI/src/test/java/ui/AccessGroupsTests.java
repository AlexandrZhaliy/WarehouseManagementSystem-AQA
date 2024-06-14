package ui;

import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.common.UserActions;

import static ui.models.CategoryTitles.ALLOCATE_ORDERS;
import static utils.Utils.getRandomString;

public class AccessGroupsTests extends BaseTest {
    @Test(description = "Accsess Group base test", groups = {"Regression", "AccessGroups"})
    public void accessGroupBaseTest() {
        UserActions.openLoginPage()
                .login(adminUser)
                        .openAccessGroups()
                                .clickCreateNewRoleButton()
                                        .name(getRandomString())
                                                .description(getRandomString())
                                                        .clickCreateAndConfigureButton()
                .clickArticlesFullAccessButton()
                .clickAllocateOrdersFullAccessButton()
                .clickSaveChangesButton();
    }

   @Test(description = "Verify not selected checkbox in section", groups={"Regression", "AccessGroup"})
   public void verifyNotSelectedCheckbox(){
        String nameRole ;

       UserActions.openLoginPage()
               .login(adminUser)
               .openAccessGroups()
               .clickCreateNewRoleButton()
               .name(nameRole="A"+getRandomString())
               .description(getRandomString())
               .clickCreateAndConfigureButton()
               .openAccessGroups()
               .selectPaginationHowElementDisplayedInPage(100)
               .openEditPage(nameRole)
               .verifyAllCheckboxesAreNotSelectedInSection(ALLOCATE_ORDERS);
   }

   @Test(description = "Verify selected checkbox in section", groups={"Regression", "AccessGroup"})
   public void verifySelectedCheckboxInSection() {
       String nameRole;

       UserActions.openLoginPage()
               .login(adminUser)
               .openAccessGroups()
               .clickCreateNewRoleButton()
               .name(nameRole="A"+getRandomString())
               .description(getRandomString())
               .clickCreateAndConfigureButton()
               .openAccessGroups()
               .selectPaginationHowElementDisplayedInPage(100)
               .openEditPage(nameRole)
               .selectCategory(ALLOCATE_ORDERS)
               .verifyAllCheckboxesAreSelectedInSection(ALLOCATE_ORDERS);
   }

    @Test(description = "Verify category search", groups={"Regression", "AccessGroup"})
    public void verifySearchCategory(){
        String nameRole;

        UserActions.openLoginPage()
                .login(adminUser)
                .openAccessGroups()
                .clickCreateNewRoleButton()
                .name(nameRole="A"+getRandomString())
                .description(getRandomString())
                .clickCreateAndConfigureButton()
                .openAccessGroups()
                .selectPaginationHowElementDisplayedInPage(100)
                .openEditPage(nameRole)
                .typeSearchTitleByCategoryField(ALLOCATE_ORDERS.getName())
                .verifySearchResultsInCategoryListHasText("Allocate Orders");
    }

    @Test(description = "Verify full access", groups={"Regression", "AccessGroup"})
    public void verifyFullAccess(){
        String nameRole;

        UserActions.openLoginPage()
                .login(adminUser)
                .openAccessGroups()
                .clickCreateNewRoleButton()
                .name(nameRole="A"+getRandomString())
                .description(getRandomString())
                .clickCreateAndConfigureButton()
                .openAccessGroups()
                .selectPaginationHowElementDisplayedInPage(100)
                .openEditPage(nameRole)
                .verifyTitleMainPage("Category")
                .selectFullAccess(ALLOCATE_ORDERS)
                .verifyCheckboxIsSelectedFullAccess(ALLOCATE_ORDERS)
                .clickSaveBtn()
                .verifySuccessEditPermissionMessage();
    }

    @Test(description = "Verify reset selected category", groups={"Regression", "AccessGroup"})
    public void verifyResetSelectedCategory(){
        String nameRole;

        UserActions.openLoginPage()
                .login(adminUser)
                .openAccessGroups()
                .clickCreateNewRoleButton()
                .name(nameRole="A"+getRandomString())
                .description(getRandomString())
                .clickCreateAndConfigureButton()
                .openAccessGroups()
                .selectPaginationHowElementDisplayedInPage(100)
                .openEditPage(nameRole)
                .selectCategory(ALLOCATE_ORDERS)
                .resetSelectedCategory()
                .verifyAllCheckboxesAreNotSelectedInSection(ALLOCATE_ORDERS);
    }

    @Test(description = "Verify Role patterns count number", groups={"Regression", "AccessGroup"})
    public void verifyRolePatternsCountNumber(){
        String nameRole;

        UserActions.openLoginPage()
                .login(adminUser)
                .openAccessGroups()
                .clickCreateNewRoleButton()
                .name(nameRole="A"+getRandomString())
                .description(getRandomString())
                .clickCreateAndConfigureButton()
                .openAccessGroups()
                .selectPaginationHowElementDisplayedInPage(100)
                .openEditPage(nameRole)
                .openRolePatternsDropdawn()
                .searchRoleInRolePatternSearchField(nameRole)
                .selectRoleInRolePatternsDropdawnList(nameRole)
                .verifySelectedRoleInRolePatternsDropdawnList(nameRole)
                .verifyRolePatternCounter("1");
    }

    @Test(description = "Verify Category count number", groups={"Regression", "AccessGroup"})
    public void verifyCategoryCountNumber(){
        String nameRole;

        UserActions.openLoginPage()
                .login(adminUser)
                .openAccessGroups()
                .clickCreateNewRoleButton()
                .name(nameRole="A"+getRandomString())
                .description(getRandomString())
                .clickCreateAndConfigureButton()
                .openAccessGroups()
                .selectPaginationHowElementDisplayedInPage(100)
                .openEditPage(nameRole)
                .selectCategory(ALLOCATE_ORDERS)
                .verifyCategoryCounter("1");
    }
}
