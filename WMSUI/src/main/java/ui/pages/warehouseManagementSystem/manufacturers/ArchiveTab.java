package ui.pages.warehouseManagementSystem.manufacturers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.suppliers.InformationTab;
import ui.pages.warehouseManagementSystem.suppliers.SuppliersPage;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class ArchiveTab extends ManufacturersPage {
    public static String rowWithTextXpath = "//tr[contains(., '%s')]";
    public static String manufacturerRestoreWithNameXpath = "//tr[contains(., '%s')]//a[contains(@href, '/archive-restore')]";

    @Step("verify Row with text is visible in table - {text}")
    public ArchiveTab verifyManufacturerWithTextIsVisible(String text){
        $x(format(rowWithTextXpath, text)).shouldBe(Condition.visible);
        return new ArchiveTab();
    }

    @Step("archive manufacturer in table using name - {name}")
    public AllManufacturersTab restoreManufacturer(String name) {
        $x(format(manufacturerRestoreWithNameXpath, name)).click();
        Selenide.confirm();
        return new AllManufacturersTab();
    }

    @Step("verify Row with text is NOT visible in table - {text}")
    public ArchiveTab verifyManufacturerWithTextIsNotVisible(String text){
        $x(format(rowWithTextXpath, text)).shouldNotBe(Condition.exist);
        return new ArchiveTab();
    }
}
