package ui.pages.warehouseManagementSystem.articles;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.installationOrders.InstallationOrdersPage;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class ArchivePage extends ArticlePage {
    public static String rowWithTextXpath = "//tr[contains(., '%s')]";
    public static SelenideElement headerText = $x("//h4[contains(., 'Unique articles (Archive)')]");

    public ArchivePage verifyArticleWithTextIsVisible(String... text){
        super.verifyRowIsVisibleWithTexts(text);
        return new ArchivePage();
    }
}
