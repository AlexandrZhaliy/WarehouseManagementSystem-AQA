package ui.pages.warehouseManagementSystem.companies;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;

import static com.codeborne.selenide.Selenide.$x;

public class CompanyPage extends warehouseManagementSystemMainPage {
    public static SelenideElement informationTab = $x("//*[contains(@class, 'secondary-navigation')]//a[contains(@href, '/information')]");
    public static SelenideElement workingSchemeTab = $x("//*[contains(@class, 'secondary-navigation')]//a[contains(@href, '/working-scheme')]");

    @Step("Open Working Scheme")
    public WorkingSchemeTab openWorkingSchemeTab() {
        workingSchemeTab.click();
        return new WorkingSchemeTab();
    }
}
