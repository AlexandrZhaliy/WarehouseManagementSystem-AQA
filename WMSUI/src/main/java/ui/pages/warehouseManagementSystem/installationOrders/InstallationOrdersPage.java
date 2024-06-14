package ui.pages.warehouseManagementSystem.installationOrders;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class InstallationOrdersPage extends warehouseManagementSystemMainPage {
    public static SelenideElement archiveTab = $x("//*[contains(@class, 'secondary-navigation')]//*[contains(@href, '/installation-orders/archive')]");


    @Step("click on Archive tab")
    public InstallationOrdersArchiveTab openArchiveTab(){
        archiveTab.click();
        InstallationOrdersArchiveTab.headerText.shouldBe(Condition.visible);
        return new InstallationOrdersArchiveTab();
    }
}
