package ui.pages.warehouseManagementSystem.manufacturers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class AllManufacturersTab extends ManufacturersPage {
    public static SelenideElement createManufacturerButton = $x("//button[contains(., 'Create new manufacturer')]");
    public static String manufacturerAchiveWithNameXpath = "//tr[contains(., '%s')]//a[contains(@href, '/archive-')]";
    public static String manufacturerWithNameXpath = "//td[contains(., '%s')]";

    @Step("click 'Create new Manufacturer' button")
    public CreateManufacturerPopup clickCreateNewManufacturerButton() {
        createManufacturerButton.shouldBe(Condition.visible);
        createManufacturerButton.click();
        return new CreateManufacturerPopup();
    }

    @Step("archive manufacturer in table using name - {name}")
    public AllManufacturersTab archiveManufacturer(String name) {
        $x(format(manufacturerAchiveWithNameXpath, name)).click();
        Selenide.confirm();
        return this;
    }

    @Step("verify Row with text is visible in table - {text}")
    public AllManufacturersTab verifyManufacturerWithTextIsVisible(String text) {
        $x(format(manufacturerWithNameXpath, text)).shouldBe(Condition.visible);
        return this;
    }

    @Step("verify Row with text is NOT visible in table - {text}")
    public AllManufacturersTab verifyManufacturerWithTextIsNotVisible(String text) {
        $x(format(manufacturerWithNameXpath, text)).shouldNotBe(Condition.exist);
        return this;
    }

    @Step("verify 'alert success' text is - {text}")
    public AllManufacturersTab verifyAlertTextIsVisible(String text) {
        super.alertText.shouldHave(text(text));
        return this;
    }
}
