package ui.pages.warehouseManagementSystem.reports;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ArticlesTab extends ReportsPage{
    public static SelenideElement headerText = $x("//h4[contains(., 'Articles Reports')]");

}
