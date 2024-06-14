package ui.pages.warehouseManagementSystem;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.models.User;
import ui.pages.base.BasePage;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class LoginPage extends BasePage {
    private SelenideElement emailInput = $x("//*[@id='loginform-email']");
    private SelenideElement passwordInput = $x("//*[@id='loginform-password']");
    private SelenideElement signInButton = $x("//button[@type='submit']");

    @Step("Click login button")
    public LoginPage clickSignIn() {
        signInButton.shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Login into warehouseManagementSystem - {user}")
    public MainPage login(User user) {
        emailInput.shouldBe(Condition.visible).sendKeys(user.email);
        passwordInput.shouldBe(Condition.visible).sendKeys(user.password);
        clickSignIn();
        return new MainPage();
    }

}