package ui.pages.warehouseManagementSystem.storageUnits;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class AllUnitsTab extends UnitsPage {
    public static SelenideElement createNewStorageUnitButton = $x("//button[contains(., 'Create new storage unit')]");
    public static String storageUnitArchiveWithNameXpath = "//tr[contains(., '%s')]//a[contains(@href, '/archive-')]";
    public static String storageUnitWithNameXpath = "//td[contains(., '%s')]";

    @Step("click 'Create new Manufacturer' button")
    public CreateStorageUnitPopup clickCreateNewManufacturerButton() {
        createNewStorageUnitButton.shouldBe(Condition.visible);
        createNewStorageUnitButton.click();
        return new CreateStorageUnitPopup();
    }

    @Step("archive Storage Unit in table using name - {name}")
    public AllUnitsTab archiveStorageUnit(String name) {
        $x(format(storageUnitArchiveWithNameXpath, name)).click();
        Selenide.confirm();
        return this;
    }

    @Step("archive Storage Unit with error in table using name - {name}")
    public UnitArchiveRestrictionsPage archiveStorageUnitWithError(String name) {
        $x(format(storageUnitArchiveWithNameXpath, name)).click();
        Selenide.confirm();
        return new UnitArchiveRestrictionsPage();
    }

    @Step("verify Row with text is visible in table - {text}")
    public AllUnitsTab verifyStorageUnitWithTextIsVisible(String text) {
        $x(format(storageUnitWithNameXpath, text)).shouldBe(Condition.visible);
        return this;
    }

    @Step("verify Row with text is NOT visible in table - {text}")
    public AllUnitsTab verifyStorageUnitWithTextIsNotVisible(String text) {
        $x(format(storageUnitWithNameXpath, text)).shouldNotBe(Condition.exist);
        return this;
    }

    @Step("verify 'alert success' text is - {text}")
    public AllUnitsTab verifyAlertTextIsVisible(String text) {
        super.alertText.shouldHave(text(text));
        return this;
    }
}
