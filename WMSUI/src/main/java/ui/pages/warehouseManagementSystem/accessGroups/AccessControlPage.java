package ui.pages.warehouseManagementSystem.accessGroups;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class AccessControlPage extends warehouseManagementSystemMainPage {

    public static String permisisonBtnWithRoleName = "//tr[contains(.,'%s')]//button[2]";
    public static SelenideElement createNewRoleButton = $x("//a[contains(., 'Create new role')]");
    public static SelenideElement paginationDropdawn = $x("//button[contains(@class,'btn-size')]");
    public static String paginationListXpath = "//li[contains(@class,'options__item') and contains(.,'%s')]";

    @Step("Select in pagination how displayed elements in page - {count}")
    public AccessControlPage selectPaginationHowElementDisplayedInPage(int count){
        paginationDropdawn.click();
        $x(format(paginationListXpath,count)).click();
        return this;
    }

    @Step("click 'Create new role' Button")
    public CreateNewRolePage clickCreateNewRoleButton(){
        createNewRoleButton.click();
        return new CreateNewRolePage();
    }

    @Step("Click 'edit' button for role {name}")
    public EditPermissionsPage openEditPage(String name){
        $x(format(permisisonBtnWithRoleName, name)).click();
        return new EditPermissionsPage();
    }
}
