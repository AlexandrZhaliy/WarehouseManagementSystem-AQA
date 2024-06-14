package ui.pages.warehouseManagementSystem.companies;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class AllCompaniesTab extends CompaniesPage {
    public static SelenideElement createOwnCompanyButton = $x("//button[contains(., 'Create own Company')]");
    public static String companyWithNameXpath = "//td[contains(., '%s')]";


    @Step("click Create Company Button")
    public CreateOwnCompanyPopup clickCreateCompanyButton(){
        createOwnCompanyButton.click();
        return new CreateOwnCompanyPopup();
    }

    @Step("open Company in table using name - {name}")
    public InformationTab openCompanyWithText(String name){
        $x(format(companyWithNameXpath, name)).click();
        return new InformationTab();
    }

    @Step("verify Row with text is NOT visible in table - {text}")
    public AllCompaniesTab verifyCompanyWithTextIsNotVisible(String text) {
        $x(format(companyWithNameXpath, text)).shouldNotBe(Condition.exist);
        return this;
    }

    @Step("verify Row with text is visible in table - {text}")
    public AllCompaniesTab verifyCompanyWithTextIsVisible(String text) {
        $x(format(companyWithNameXpath, text)).shouldBe(Condition.exist);
        return this;
    }

    @Step("verify 'alert success' text is - {text}")
    public AllCompaniesTab verifyAlertTextIsVisible(String text) {
        super.alertText.shouldHave(text(text));
        return this;
    }
}
