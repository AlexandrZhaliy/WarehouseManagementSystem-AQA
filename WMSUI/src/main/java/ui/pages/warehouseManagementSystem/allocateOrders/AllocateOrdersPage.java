package ui.pages.warehouseManagementSystem.allocateOrders;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;
import ui.pages.warehouseManagementSystem.installationKits.CreateInstallationKitPage;
import ui.pages.warehouseManagementSystem.installationOrders.InstallationOrdersArchiveTab;

import static com.codeborne.selenide.Selenide.$x;

public class AllocateOrdersPage extends warehouseManagementSystemMainPage {
    public static SelenideElement archiveTab = $x("//*[contains(@class, 'secondary-navigation')]//*[contains(@href, '/allocate-orders/archive')]");
    public static SelenideElement allOrdersTab = $x("//*[contains(@class, 'secondary-navigation')]//*[contains(@href, '/allocate-orders')]");


    @Step("click on Archive tab")
    public ArchiveTab openArchiveTab(){
        archiveTab.click();
        ArchiveTab.headerText.shouldBe(Condition.visible);
        return new ArchiveTab();
    }
    @Step("click on All Orders tab")
    public AllocateAllOrdersTab openAllOrdersTab(){
        allOrdersTab.click();
        AllocateAllOrdersTab.headerText.shouldBe(Condition.visible);
        return new AllocateAllOrdersTab();
    }


}
