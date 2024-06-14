package ui.pages.warehouseManagementSystem.installationOrders;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class InstallationOrdersArchiveTab extends InstallationOrdersPage {
    public static String rowWithTextXpath = "//tr[contains(., '%s')]";
    public static SelenideElement headerText = $x("//h4[contains(., 'Installation orders (Archive)')]");

    @Step("verify Row with text is visible - {text}")
    public InstallationOrdersArchiveTab verifyOderWithTextIsVisible(String text){
        $x(format(rowWithTextXpath, text)).shouldBe(Condition.visible);
        return new InstallationOrdersArchiveTab();
    }
}
