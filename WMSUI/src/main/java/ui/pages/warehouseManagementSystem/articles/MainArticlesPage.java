package ui.pages.warehouseManagementSystem.articles;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class MainArticlesPage extends warehouseManagementSystemMainPage {
    public static SelenideElement createNewArticleButton = $x("//a[contains(., 'Create new article')]");
    public static String articleWithNameXpath = "//td[contains(., '%s')]";


    @Step("click 'Create new article' button")
    public CreateNewArticlePage clickCreateNewArticleButton(){
        createNewArticleButton.click();
        return new CreateNewArticlePage();
    }

    @Step("open article in table using name - {name}")
    public InformationTab openArticle(String name){
        $x(format(articleWithNameXpath, name)).click();
        return new InformationTab();
    }
}
