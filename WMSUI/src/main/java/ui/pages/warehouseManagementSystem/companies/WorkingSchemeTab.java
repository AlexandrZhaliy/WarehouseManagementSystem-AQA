package ui.pages.warehouseManagementSystem.companies;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.models.ChecboxState;
import ui.models.DaysOfWeek;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;


public class WorkingSchemeTab extends CompanyPage {
    public static String toggleXpath = "//*[contains(@class, 'switch') and contains(., '%s')]//input[@type='checkbox']";
    public static String timeXpath = "//*[contains(@class, 'toggle') and contains(., '%s')]//following-sibling::div[1]//input[contains(@id, '%s')]";
    public static String timeFromXpath = format(timeXpath, "%s", "time_from");
    public static String timeToXpath = format(timeXpath, "%s", "time_to");
    public static String invalidTimeXpath = "//*[contains(@class, 'toggle') and contains(., '%s')]//following-sibling::div[1]//input[contains(@id, '%s')]/..//*[contains(@class,'invalid-feedback')]";
    public static String invalidTimeFromXpath = format(invalidTimeXpath, "%s", "time_from");
    public static String invalidTimeToXpath = format(invalidTimeXpath, "%s", "time_to");
    public static SelenideElement addWorkingDayButton = $x("//*[contains(@id, 'add-working-day-btn')]");
    public static SelenideElement futureTab = $x("//span[contains(text(),'Future')]");
    public static SelenideElement pastTab = $x("//span[contains(text(),'Past')]");
    public static SelenideElement cancelButton = $x("//button[contains(@class, 'cancel')]");
    public static SelenideElement saveButton = $x("//button[contains(@class, 'save')]");
    public static SelenideElement successfulSaveMessage = $x("//*[contains(@id, 'success')]");
    public static SelenideElement closeButton = $x("//*[contains(@id, 'success')]/button");

    @Step("Verify time from for - {name} has text - {time}")
    public WorkingSchemeTab verifyTimeFromHasText(DaysOfWeek name, String time) {
        $x(format(timeFromXpath, name.getName())).shouldHave(value(time));
        return this;
    }

    @Step("Verify time to for - {name} has text - {time}")
    public WorkingSchemeTab verifyTimeToHasText(DaysOfWeek name, String time) {
        $x(format(timeToXpath, name.getName())).shouldHave(value(time));
        return this;
    }

    @Step("Verify the state of toggle is - {state}, for day of week - {day}")
    public WorkingSchemeTab verifyTheToggleStateForDayOfWeek(ChecboxState state, DaysOfWeek day) {
        if (state.equals(ChecboxState.ACTIVE))
            $x(format(toggleXpath, day.getName())).shouldBe(Condition.selected);
        else
            $x(format(toggleXpath, day.getName())).shouldNotBe(Condition.selected);
        return this;
    }

    @Step("Activate the working day")
    public WorkingSchemeTab activateWorkingDay(DaysOfWeek name) {
        String toggleFormat = String.format(toggleXpath, name.getName());
        if (!$x(toggleFormat).isSelected()) {
            $x(toggleFormat).hover();
            $x(toggleFormat).click();
        }
        return this;
    }

    @Step("Clear the time from - {name} value")
    public WorkingSchemeTab clearTimeFromValue(DaysOfWeek name) {
        $x(format(timeFromXpath, name.getName())).clear();
        return this;
    }

    @Step("enter Time From for - {name} New value - {time}")
    public WorkingSchemeTab enterTimeFromValue(DaysOfWeek name, String time) {
        String timeFromFormat = String.format(timeFromXpath, name.getName());
        $x(timeFromFormat).clear();
        $x(timeFromFormat).setValue(time);
        return this;
    }

    @Step("Clear the time to - {name} value")
    public WorkingSchemeTab clearTimeToValue(DaysOfWeek name) {
        $x(format(timeToXpath, name.getName())).clear();
        return this;
    }

    @Step("enter Time TO for - {name} New value - {time}")
    public WorkingSchemeTab enterTimeToValue(DaysOfWeek name, String time) {
        String timeToFormat = String.format(timeToXpath, name.getName());
        $x(timeToFormat).clear();
        $x(timeToFormat).setValue(time);
        return this;
    }

    @Step("verify the time from for - {name} has text - {message}")
    public WorkingSchemeTab verifyTimeFromHasErrorMessage(DaysOfWeek name, String message) {
        $x(format(invalidTimeFromXpath, name.getName())).shouldHave(text(message));
        return this;
    }

    @Step("verify the time from to - {name} has text - {message}")
    public WorkingSchemeTab verifyTimeToHasErrorMessage(DaysOfWeek name, String message) {
        $x(format(invalidTimeToXpath, name.getName())).shouldHave(text(message));
        return this;
    }

    @Step("Click on Save Button")
    public WorkingSchemeTab clickSaveButton() {
        saveButton.click();
        return this;
    }

    @Step("Verify Success Message is visible")
    public WorkingSchemeTab verifySuccessMessageIsVisible() {
        successfulSaveMessage.shouldBe(visible);
        return this;
    }

    @Step("Click Close Button on success message")
    public WorkingSchemeTab clickCloseButton() {
        closeButton.click();
        successfulSaveMessage.shouldNotBe(visible);
        return this;
    }

    @Step("Click Cancel Button")
    public WorkingSchemeTab clickCancelButton() {
        cancelButton.click();
        return this;
    }
}


