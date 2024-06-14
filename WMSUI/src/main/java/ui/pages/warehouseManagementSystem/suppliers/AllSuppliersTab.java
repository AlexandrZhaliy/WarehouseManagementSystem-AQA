package ui.pages.warehouseManagementSystem.suppliers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class AllSuppliersTab extends SuppliersPage {
    public static SelenideElement createSupplierButton = $x("//button[contains(., 'Create supplier')]");
    public static String supplierWithNameXpath = "//td[contains(., '%s')]";

    @Step("click 'Create Supplier' button")
    public CreateSuppliersPopup clickCreateSupplierButton(){
        createSupplierButton.shouldBe(Condition.visible);
        createSupplierButton.click();
        return new CreateSuppliersPopup();
    }

    @Step("open supplier in table using name - {name}")
    public InformationTab openSupplier(String name){
        $x(format(supplierWithNameXpath, name)).click();
        return new InformationTab();
    }

    @Step("verify Row with text is visible in table - {text}")
    public ArchiveTab verifySupplierWithTextIsVisible(String text){
        $x(format(supplierWithNameXpath, text)).shouldBe(Condition.visible);
        return new ArchiveTab();
    }

    @Step("verify 'alert success' text is - {text}")
    public AllSuppliersTab verifyAlertTextIsVisible(String text) {
        super.alertText.shouldHave(text(text));
        return this;
    }
}
