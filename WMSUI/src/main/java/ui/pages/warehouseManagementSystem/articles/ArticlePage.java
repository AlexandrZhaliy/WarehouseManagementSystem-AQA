package ui.pages.warehouseManagementSystem.articles;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class ArticlePage extends warehouseManagementSystemMainPage {

    public static String tab = "//*[contains(@class, 'secondary-navigation')]//a[contains(@href, '%s')]";
    public static SelenideElement actionsTab = $x("//*[contains(@class, 'secondary-navigation')]//a[contains(., 'Actions')]");
    public static SelenideElement unicityTab = $x(format(tab, "/unicity"));
    public static SelenideElement statisticTab = $x(format(tab, "/statistic"));
    public static SelenideElement informationTab = $x(format(tab, "/information"));
    public static SelenideElement warehouseManagementSystemTab =  $x(format(tab, "/warehouseManagementSystem-control"));

    @Step("Open warehouseManagementSystem control tab")
    public warehouseManagementSystemTab openwarehouseManagementSystemTab() {
        warehouseManagementSystemTab.click();
        verifyTitle("warehouseManagementSystem Control");
        return new warehouseManagementSystemTab();
    }

    @Step("Open Actions tab")
    public ActionsTab openActionsTab(){
        actionsTab.click();
        return new ActionsTab();
    }
    @Step("Open Statistic tab")
    public StatisticTab openStatisticTab(){
        statisticTab.click();
        if (!StatisticTab.headerText.isDisplayed()) {unicityTab.click();}
        StatisticTab.headerText.shouldBe(Condition.visible);
        return new StatisticTab();
    }
    @Step("Open Unicity tab")
    public UnicityTab openUnicityTab(){
        unicityTab.click();
        //TODO find reason why in HEADLESS mode we need doubleclick
        if (!UnicityTab.headerText.isDisplayed()) {unicityTab.click();}
        UnicityTab.headerText.shouldBe(Condition.visible);
        return new UnicityTab();
    }

}
