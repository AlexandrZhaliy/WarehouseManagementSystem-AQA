package ui.pages.warehouseManagementSystem;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.companies.AllCompaniesTab;

import static com.codeborne.selenide.Selenide.$x;

public class InnerMainPage extends warehouseManagementSystemMainPage {
    public static SelenideElement companiesTab = $x("//*[contains(@class, 'secondary-navigation')]//*[contains(@href, '/company-management')]");
    public static SelenideElement usersTab = $x("//*[contains(@href, '/user-management')]");
    public static SelenideElement accessGroupsTab = $x("//*[contains(@href, '/access-groups')]");
    public static SelenideElement logsTab = $x("//*[contains(@href, '/logs')]");
    public static SelenideElement currenciesTab = $x("//*[contains(@href, '/currencies')]");
    public static SelenideElement shippingsTab = $x("//*[contains(@href, '/shippings')]");
    public static SelenideElement manufacturersTab = $x("//*[contains(@href, '/manufacturers')]");
    public static SelenideElement unitsTab = $x("//*[contains(@href, '/unit')]");
    public static SelenideElement groupsTab = $x("//*[contains(@href, '/groups')]");
    public static SelenideElement reasonsTab = $x("//*[contains(@href, '/reasons')]");
    @Step("Open Companies tab")
    public AllCompaniesTab openCompaniesTab(){
        companiesTab.click();
        return new AllCompaniesTab();
    }

}
