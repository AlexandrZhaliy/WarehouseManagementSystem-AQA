package ui.pages.warehouseManagementSystem.orders;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;
import ui.pages.warehouseManagementSystem.articles.ActionsTab;
import ui.pages.warehouseManagementSystem.articles.UnicityTab;

import static com.codeborne.selenide.Selenide.$x;

public class OrderPage extends warehouseManagementSystemMainPage {

    public static SelenideElement informationTab = $x("//*[contains(@class, 'secondary-navigation')]//a[contains(., 'Information')]");

    @Step("Open 'Information' tab")
    public InformationTab openInformationTab(){
        informationTab.click();
        return new InformationTab();
    }
}
