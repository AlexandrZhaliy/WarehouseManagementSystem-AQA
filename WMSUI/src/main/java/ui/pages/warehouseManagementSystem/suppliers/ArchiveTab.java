package ui.pages.warehouseManagementSystem.suppliers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.articles.ArchivePage;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class ArchiveTab extends SuppliersPage{
    public static String rowWithTextXpath = "//tr[contains(., '%s')]";
    @Step("verify Row with text is visible in table - {text}")
    public ArchiveTab verifySupplierWithTextIsVisible(String text){
        $x(format(rowWithTextXpath, text)).shouldBe(Condition.visible);
        return new ArchiveTab();
    }

    @Step("open archived supplier in ArchiveTab using name - {name}")
    public InformationTab openArchivedSupplier(String name){
        $x(format(rowWithTextXpath, name)).click();
        return new InformationTab();
    }

    @Step("verify Row with text is NOT visible in table - {text}")
    public ArchiveTab verifySupplierWithTextIsNotVisible(String text){
        $x(format(rowWithTextXpath, text)).shouldNotBe(Condition.exist);
        return new ArchiveTab();
    }
}
