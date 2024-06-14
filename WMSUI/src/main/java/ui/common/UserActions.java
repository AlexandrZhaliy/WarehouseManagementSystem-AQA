package ui.common;

import io.qameta.allure.Step;
import ui.pages.WarehouseManagementSystem.LoginPage;
import ui.pages.WarehouseManagementSystem.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static ui.enums.WebEnvProperties.ENV_URL;

public class UserActions {

    @Step("Open Login page")
    public static LoginPage openLoginPage() {
        open(ENV_URL.getValue() + "/site/login");
        return new LoginPage();
    }

    @Step("Open Main page")
    public static MainPage openMainPage() {
        open(ENV_URL.getValue());
        return new MainPage();
    }

}
