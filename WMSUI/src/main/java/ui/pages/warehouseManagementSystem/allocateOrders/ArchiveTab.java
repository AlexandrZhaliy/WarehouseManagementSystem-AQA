package ui.pages.warehouseManagementSystem.allocateOrders;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.storageUnits.AllUnitsTab;
import ui.pages.warehouseManagementSystem.storageUnits.UnitsPage;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class ArchiveTab extends AllocateOrdersPage {
    public static SelenideElement headerText = $x("//h4[contains(., 'Allocate orders (Archive)')]");

    public ArchiveTab verifyOrderWithTextIsVisible(String... text){
        verifyRowIsVisibleWithTexts(text);
        return new ArchiveTab();
    }

    public ArchiveTab verifyOrderWithTextIsNotVisible(String... text){
        verifyRowIsNotVisibleWithTexts(text);
        return new ArchiveTab();
    }
}
