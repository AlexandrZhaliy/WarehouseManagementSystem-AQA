package ui.pages.warehouseManagementSystem.allocateOrders;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class AllocateAllOrdersTab extends AllocateOrdersPage {
    public static SelenideElement createNewOrderButton = $x("//a[contains(., 'Create new order')]");
    public static SelenideElement headerText = $x("//h4[contains(., 'Allocate orders')]");



    @Step("click Create New Order button")
    public CreateNewOrderPage clickCreateNewOrderButton(){
        createNewOrderButton.click();
        return new CreateNewOrderPage();
    }

    public AllocateAllOrdersTab verifyOrderWithTextIsVisible(String... text){
        verifyRowIsVisibleWithTexts(text);
        return this;
    }

    @Step("open order in table using name - {name}")
    public CreateNewOrderPage openOrderWithText(String... text){
        $x(getRowWithTextXpath(text)).click();
        return new CreateNewOrderPage();
    }

}
