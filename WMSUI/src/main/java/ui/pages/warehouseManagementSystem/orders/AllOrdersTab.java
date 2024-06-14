package ui.pages.warehouseManagementSystem.orders;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.models.Orders;
import ui.pages.warehouseManagementSystem.warehouses.ReportTab;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class AllOrdersTab extends OrdersPage {
    public static SelenideElement createNewOrderButton = $x("//button[contains(@id, 'dropdownMenuButton')]");
    public static String orderOptionWithText = "//a[contains(@class, 'dropdown-item') and contains(., '%s')]";
    public static String orderWithNameXpath = "//td[contains(., '%s')]";


    @Step("Create new order - {order}")
    public CreateNewOrderPage createNewOrder(Orders order) {
        createNewOrderButton.click();
        $x(format(orderOptionWithText, order.getName())).click();
        return new CreateNewOrderPage();
    }

    @Step("open order in table using name - {name}")
    public InformationTab openOrderWithText(String name){
        $x(format(orderWithNameXpath, name)).click();
        return new InformationTab();
    }

}
