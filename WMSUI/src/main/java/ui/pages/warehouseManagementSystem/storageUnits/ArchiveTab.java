package ui.pages.warehouseManagementSystem.storageUnits;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class ArchiveTab extends UnitsPage {
    public static String rowWithTextXpath = "//tr[contains(., '%s')]";
    public static String storageUnitRestoreWithNameXpath = "//tr[contains(., '%s')]//a[contains(@href, '/archive-restore')]";

    @Step("verify Row with text is visible in table - {text}")
    public ArchiveTab verifyStorageUnitWithTextIsVisible(String text){
        $x(format(rowWithTextXpath, text)).shouldBe(Condition.visible);
        return new ArchiveTab();
    }

    @Step("archive 'Storage Unit' in table using name - {name}")
    public AllUnitsTab restoreStorageUnit(String name) {
        $x(format(storageUnitRestoreWithNameXpath, name)).click();
        Selenide.confirm();
        return new AllUnitsTab();
    }

    @Step("verify Row with text is NOT visible in table - {text}")
    public ArchiveTab verifyStorageUnitWithTextIsNotVisible(String text){
        $x(format(rowWithTextXpath, text)).shouldNotBe(Condition.exist);
        return new ArchiveTab();
    }
}
