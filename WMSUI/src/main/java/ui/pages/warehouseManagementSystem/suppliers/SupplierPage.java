package ui.pages.warehouseManagementSystem.suppliers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;
import ui.pages.warehouseManagementSystem.articles.ActionsTab;
import ui.pages.warehouseManagementSystem.articles.StatisticTab;
import ui.pages.warehouseManagementSystem.articles.UnicityTab;

import static com.codeborne.selenide.Selenide.$x;

public class SupplierPage extends warehouseManagementSystemMainPage {

    public static SelenideElement informationTab = $x("//*[contains(@class, 'secondary-navigation')]//a[contains(., 'Information')]");
    public static SelenideElement filesTab = $x("//*[contains(@class, 'secondary-navigation')]//a[contains(., 'Files')]");
    @Step("Open 'Files' tab")
    public FilesTab openFilesTab(){
        filesTab.click();
        return new FilesTab();
    }
    @Step("Open 'Information' tab")
    public InformationTab openInformationTab(){
        informationTab.click();
        return new InformationTab();
    }


}
