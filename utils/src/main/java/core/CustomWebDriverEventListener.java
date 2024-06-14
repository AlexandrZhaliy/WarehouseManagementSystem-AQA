package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverListener;
import utils.Logger;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class CustomWebDriverEventListener implements WebDriverListener {

    @Override
    public void beforeClick(WebElement element) {
        Logger.log(format("Clicking on {%s}", $(element)));
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        if (keysToSend == null) Logger.log(format("Clear input in {%s}.", $(element)));
        else
            Logger.log(format("Input text {%s} in {%s}.", Arrays.toString(keysToSend), $(element)));
    }
}
