package ui.pages.warehouseManagementSystem.articles;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Selenide.$x;

public class UpdateUniqueArticlePopup extends UnicityTab {
    public static SelenideElement serialNumberInput = $x("//input[@id='uniquearticle-serial_number']");
    public static SelenideElement codeInput = $x("//input[@id = 'uniquearticle-code']");
    public static SelenideElement saveEditedUniqueArticleButton = $x("//*[@id = 'updateUniqueArticleForm']//button[contains (., 'Save')]");

    @Step("Fill Unique Article Serial Number - {serialNumber}")
    public UpdateUniqueArticlePopup fillUniqueArticleSerialNumber(String serialNumber) {
        serialNumberInput.sendKeys(serialNumber);
        return this;
    }

    @Step("Fill Unique Article Code - {code}")
    public UpdateUniqueArticlePopup fillUniqueArticleCode(String code) {
        codeInput.sendKeys(code);
        return this;
    }

    @Step("Save changes in Unique Article")
    public UnicityTab clickOnSaveEditedUniqueArticleButton(){
        saveEditedUniqueArticleButton.click();
        saveEditedUniqueArticleButton.shouldBe(hidden);
        return new UnicityTab();
    }
}