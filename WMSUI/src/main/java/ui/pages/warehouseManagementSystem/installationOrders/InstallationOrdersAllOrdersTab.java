package ui.pages.warehouseManagementSystem.installationOrders;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class InstallationOrdersAllOrdersTab extends InstallationOrdersPage {
    public static String rowWithTextXpath = "//tr[contains(., '%s')]";

    @Step("open order with - {text}")
    public InstallationOrderPage openOrderWithText(String text){
        $x(format(rowWithTextXpath, text)).click();
        return new InstallationOrderPage();
    }

    @Step("verify Row with text is not visible - {text}")
    public InstallationOrdersAllOrdersTab verifyOrderWithTextIsNotVisible(String text){
        $x(format(rowWithTextXpath, text)).shouldNotBe(Condition.exist);
        return new InstallationOrdersAllOrdersTab();
    }
}
