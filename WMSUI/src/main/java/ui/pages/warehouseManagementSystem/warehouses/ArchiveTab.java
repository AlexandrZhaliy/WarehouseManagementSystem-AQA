package ui.pages.warehouseManagementSystem.warehouses;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class ArchiveTab extends WarehousesPage {
    public static String rowWithTextXpath = "//td[contains(., '%s')]";

    @Step("verify Row with text is visible in table - {text}")
    public ArchiveTab verifyWarehouseWithTextIsVisible(String text){
        $x(format(rowWithTextXpath, text)).shouldBe(Condition.visible);
        return new ArchiveTab();
    }

    @Step("open warehouse in table using name - {name}")
    public ReportTab openWarehouseWithText(String name){
        $x(format(rowWithTextXpath, name)).click();
        return new ReportTab();
    }

    @Step("verify Row with text is NOT visible in table - {text}")
    public ArchiveTab verifyWarehouseWithTextIsNotVisible(String text){
        $x(format(rowWithTextXpath, text)).shouldNotBe(Condition.exist);
        return new ArchiveTab();
    }

}