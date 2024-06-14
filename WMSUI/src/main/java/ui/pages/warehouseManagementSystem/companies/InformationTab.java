package ui.pages.warehouseManagementSystem.companies;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouses.WarehouseArchiveRestrictionsPage;

import static com.codeborne.selenide.Selenide.$x;

public class InformationTab extends CompanyPage {
    public static SelenideElement archiveCompanyButton = $x("//a[contains(., 'Archive company')]");
    public static SelenideElement restoreCompanyButton = $x("//a[contains(., 'Restore company')]");


    @Step("click 'Archive company' button")
    public AllCompaniesTab archiveCompany(){
        archiveCompanyButton.shouldBe(Condition.visible);
        archiveCompanyButton.click();
        Selenide.confirm();
        return new AllCompaniesTab();
    }

    @Step("archive warehouse with error")
    public CompanyArchiveRestrictionsPage archiveCompanyWithError() {
        archiveCompanyButton.click();
        Selenide.confirm();
        return new CompanyArchiveRestrictionsPage();
    }

    @Step("click 'Restore company' button")
    public AllCompaniesTab restoreCompany(){
        restoreCompanyButton.shouldBe(Condition.visible);
        restoreCompanyButton.click();
        Selenide.confirm();
        return new AllCompaniesTab();
    }

}
