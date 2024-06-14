package ui.pages.warehouseManagementSystem.suppliers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.articles.ArticlePage;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class InformationTab extends SupplierPage {
    public static SelenideElement archiveSupplierButton = $x("//a[contains(., 'Archive supplier')]");
    public static SelenideElement restoreSupplierButton = $x("//a[contains(., 'Restore supplier')]");


    @Step("click 'Archive supplier' button")
    public AllSuppliersTab clickArchiveSupplierButton(){
        archiveSupplierButton.shouldBe(Condition.visible);
        archiveSupplierButton.click();
        Selenide.confirm();
        return new AllSuppliersTab();
    }

    @Step("click 'Restore supplier' button")
    public AllSuppliersTab clickRestoreSupplierButton(){
        restoreSupplierButton.shouldBe(Condition.visible);
        restoreSupplierButton.click();
        Selenide.confirm();
        return new AllSuppliersTab();
    }

}
