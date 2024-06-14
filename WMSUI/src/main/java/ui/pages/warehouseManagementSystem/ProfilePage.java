package ui.pages.warehouseManagementSystem;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage extends warehouseManagementSystemMainPage{
    public static SelenideElement logoutButton = $x("//a[contains(., 'Log out')]");
    @Step("Click on Logout")
    public LoginPage clickLogout() {
        logoutButton.click();
        return new LoginPage();
    }
}
