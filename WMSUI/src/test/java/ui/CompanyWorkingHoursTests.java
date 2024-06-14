package ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.common.UserActions;
import ui.models.ChecboxState;
import ui.models.DaysOfWeek;
import ui.pages.warehouseManagementSystem.MainPage;
import ui.pages.warehouseManagementSystem.companies.CompanyPage;
import ui.pages.warehouseManagementSystem.companies.WorkingSchemeTab;
import utilsHelper.DataProvider;

import static ui.models.ChecboxState.ACTIVE;
import static ui.models.ChecboxState.INACTIVE;
import static ui.models.DaysOfWeek.*;

public class CompanyWorkingHoursTests extends BaseTest {
    String timeFrom = "07:00";
    String timeTo = "21:00";
    String invalidTimeFrom = "11:00";
    String invalidTimeTo = "09:00";
    String wrongTimeRange = "End time must be later than start time";
    String emptyTimeFrom = "Please select start time";
    String emptyTimeTo = "Please select end time";
    String newTimeFrom = "10:00";
    String newTimeTo = "19:00";


    @Test(description = "C-135 · AC1: Default Setting Working scheme", groups = {"Regression"})
    public void defaultWorkingHoursTest() {
        DataProvider provider = new DataProvider();
        MainPage mainPage = UserActions.openLoginPage()
                .login(adminUser);
        createGroup(provider);
        createCompany(provider);
        mainPage.openCompanies()
                .openCompanyWithText(provider.companyName)
                .openWorkingSchemeTab()
                .verifyTimeFromHasText(MONDAY, timeFrom)
                .verifyTimeToHasText(MONDAY, timeTo)
                .verifyTheToggleStateForDayOfWeek(ACTIVE, MONDAY)
                .verifyTimeFromHasText(DaysOfWeek.TUESDAY, timeFrom)
                .verifyTimeToHasText(DaysOfWeek.TUESDAY, timeTo)
                .verifyTheToggleStateForDayOfWeek(ACTIVE, THURSDAY)
                .verifyTimeFromHasText(WEDNESDAY, timeFrom)
                .verifyTimeToHasText(WEDNESDAY, timeTo)
                .verifyTheToggleStateForDayOfWeek(ACTIVE, WEDNESDAY)
                .verifyTimeFromHasText(THURSDAY, timeFrom)
                .verifyTimeToHasText(THURSDAY, timeTo)
                .verifyTheToggleStateForDayOfWeek(ACTIVE, THURSDAY)
                .verifyTimeFromHasText(DaysOfWeek.FRIDAY, timeFrom)
                .verifyTimeToHasText(DaysOfWeek.FRIDAY, timeTo)
                .verifyTheToggleStateForDayOfWeek(ACTIVE, FRIDAY)
                .verifyTheToggleStateForDayOfWeek(INACTIVE, SATURDAY)
                .verifyTheToggleStateForDayOfWeek(INACTIVE, SUNDAY);
    }

    @Test(description = "C-135 · AC2: Radio button", groups = {"Regression", "AAA"}) //todo AAA it for new test Jenkis job, it will be deleted later
    public void theStateOfRadioButtonTest() {
        DataProvider provider = new DataProvider();
        MainPage mainPage = UserActions.openLoginPage()
                .login(adminUser);
        createGroup(provider);
        createCompany(provider);
        mainPage.openCompanies()
                .openCompanyWithText(provider.companyName)
                .openWorkingSchemeTab()
                .activateWorkingDay(SATURDAY)
                .verifyTimeFromHasText(SATURDAY, timeFrom)
                .verifyTimeToHasText(SATURDAY, timeTo);
    }

    @Test(description = "C-140 · AC6: Invalid Time Range", groups = {"Regression"})
    public void invalidTimeRangeTest() {
        DataProvider provider = new DataProvider();
        MainPage mainPage = UserActions.openLoginPage()
                .login(adminUser);
        createGroup(provider);
        createCompany(provider);
        mainPage.openCompanies()
                .openCompanyWithText(provider.companyName)
                .openWorkingSchemeTab()
                .enterTimeToValue(MONDAY, invalidTimeTo)
                .enterTimeFromValue(MONDAY, invalidTimeFrom)
                .verifyTimeFromHasErrorMessage(MONDAY, wrongTimeRange)
                .enterTimeToValue(MONDAY, invalidTimeTo)
                .verifyTimeToHasErrorMessage(MONDAY, wrongTimeRange);
    }

    @Test(description = "AC7: Missing Time Selection", groups = {"Regression"})
    public void missingTimeSelectionTest() {
        DataProvider provider = new DataProvider();
        MainPage mainPage = UserActions.openLoginPage()
                .login(adminUser);
        createGroup(provider);
        createCompany(provider);
        mainPage.openCompanies()
                .openCompanyWithText(provider.companyName)
                .openWorkingSchemeTab()
                .clearTimeFromValue(TUESDAY)
                .verifyTimeFromHasErrorMessage(TUESDAY, emptyTimeFrom)
                .clearTimeToValue(WEDNESDAY)
                .verifyTimeToHasErrorMessage(WEDNESDAY, emptyTimeTo);
    }

    @Test(description = "C-137: AC3: Save button", groups = {"Regression"})
    public void saveButtonTest() {
        DataProvider provider = new DataProvider();
        MainPage mainPage = UserActions.openLoginPage()
                .login(adminUser);
        createGroup(provider);
        createCompany(provider);
        mainPage.openCompanies()
                .openCompanyWithText(provider.companyName)
                .openWorkingSchemeTab()
                .enterTimeToValue(MONDAY, newTimeFrom)
                .enterTimeToValue(MONDAY, newTimeTo)
                .clickSaveButton()
                .verifySuccessMessageIsVisible()
                .clickCloseButton();
    }

    @Test(description = "C-138 · AC4: Cancel Option", groups = {"Regression"})
    public void cancelButtonTest() {
        DataProvider provider = new DataProvider();
        MainPage mainPage = UserActions.openLoginPage()
                .login(adminUser);
        createGroup(provider);
        createCompany(provider);
        mainPage.openCompanies()
                .openCompanyWithText(provider.companyName)
                .openWorkingSchemeTab()
                .enterTimeFromValue(TUESDAY, newTimeFrom)
                .enterTimeToValue(TUESDAY, newTimeTo)
                .clickCancelButton()
                .verifyTimeToHasText(TUESDAY, timeTo)
                .verifyTimeFromHasText(TUESDAY, timeFrom);
    }
}