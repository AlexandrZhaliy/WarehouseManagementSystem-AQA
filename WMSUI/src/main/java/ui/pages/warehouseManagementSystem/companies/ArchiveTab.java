package ui.pages.warehouseManagementSystem.companies;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouses.ReportTab;
import ui.pages.warehouseManagementSystem.warehouses.WarehousesPage;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class ArchiveTab extends CompaniesPage {
    public static String rowWithTextXpath = "//tr[contains(., '%s')]";

    @Step("verify Row with text is visible in table - {text}")
    public ArchiveTab verifyCompanyWithTextIsVisible(String text){
        $x(format(rowWithTextXpath, text)).shouldBe(Condition.visible);
        return new ArchiveTab();
    }

    @Step("open warehouse in table using name - {name}")
    public InformationTab openCompanyWithText(String name){
        $x(format(rowWithTextXpath, name)).click();
        return new InformationTab();
    }

    @Step("verify Row with text is NOT visible in table - {text}")
    public ArchiveTab verifyCompanyWithTextIsNotVisible(String text){
        $x(format(rowWithTextXpath, text)).shouldNotBe(Condition.exist);
        return new ArchiveTab();
    }
}
