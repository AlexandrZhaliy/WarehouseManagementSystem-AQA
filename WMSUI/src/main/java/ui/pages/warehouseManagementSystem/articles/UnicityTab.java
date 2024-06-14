package ui.pages.warehouseManagementSystem.articles;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class UnicityTab extends ArticlePage {
    public static SelenideElement warehouseInput = $x("//span[contains(@id, 'uniquearticlecreateform-warehouse_id')]");
    public static SelenideElement articlesCountInput = $x("//*[contains(@id, 'uniquearticlecreateform-articles_count')]");
    public static SelenideElement autogenerateCheckbox = $x("//*[contains(@id, 'uniquearticlecreateform-auto_generate_code')]");
    public static SelenideElement saveButton = $x("//button[contains(text(), 'Save')]");
    public static SelenideElement archiveButton = $x("//a[contains(text(), 'Archive')]");
    public static SelenideElement headerText = $x("//*[contains(@id, 'moduleTitle') and contains(., 'Unique articles')]");
    public static SelenideElement uniqueArticleSerialNumberSearchInput = $x("//*[@id='uniqueArticleSearchForm']//*[contains(@id, '-uniquearticlesearch-unique_article_serial')]");
    public static SelenideElement serialNumberDropdownSearchInput = $x("//input[contains(@class, 'search')]");
    public static SelenideElement uniqueArticleSerialNumberSearchInputClear = $x("//span[contains(@id, '-uniquearticlesearch-unique_article_serial-container')]//*[contains(@class, 'clear')]");
    public static SelenideElement uniqueArticleCodeSearchInput = $x("//*[@id='uniqueArticleSearchForm']//*[contains(@id, '-uniquearticlesearch-unique_article_code')]");
    public static SelenideElement codeDropdownSearchInput = $x("//input[contains(@class, 'search')]");
    public static SelenideElement uniqueArticleCodeSearchInputClear = $x("//span[contains(@id, '-uniquearticlesearch-unique_article_code-container')]//*[contains(@class, 'clear')]");
    public static SelenideElement alertTextForSerialNumberField = $x("//*[contains (@id, '-uniquearticlesearch-unique_article_serial-results')]//*[contains(@class, 'results')]");
    public static SelenideElement alertTextForCodeField = $x("//*[contains (@id, '-uniquearticlesearch-unique_article_code-results')]//*[contains(@class, 'result')]");
    public static SelenideElement alertTextForTable = $x("//*[contains (@class, 'table')]//*[contains (@class, 'empty')]");
    public static ElementsCollection serialNumbers = $$x("//table//td[2]");
    public static ElementsCollection codes = $$x("//table//td[3]");
    public static String updateUniqueArticleButton = "//tr[contains(., '%s')]//*[@title='Update unique article']";
    public static String uniqueArticleRowWithSerialNumberXpath = "//tr[contains(., '%s')]";
    public static String uniqueArticleRowWithCodeXpath = "//tr[contains(., '%s')]";
    public static String deleteUniqArticleWithTextXpath = "//tr[contains(., '%s')]//a[contains(@href, '/delete')]";
    public static SelenideElement errorMessageDeleteLinkedArticle = $x("//*[contains(@id, 'error') or contains(@id, 'warning')]");

    @Step("delete Uniq Article with serial number - {text}")
    public UnicityTab deleteUniqArticleWithSerialNumber(String text) {
        $x(format(deleteUniqArticleWithTextXpath, text)).click();
        Selenide.confirm();
        return this;
    }

    @Step("delete Uniq Article with serial number no confirm modal - {text}")
    public UnicityTab deleteUniqArticleWithSerialNumberNoConfirm(String text) {
        $x(format(deleteUniqArticleWithTextXpath, text)).click();
        return this;
    }

    @Step("Verify error message is visible with text: {expectedText}")
    public UnicityTab verifyErrorMessage(String expectedText) {
        errorMessageDeleteLinkedArticle.shouldHave(Condition.exactText(expectedText));
        return this;
    }

    public UnicityTab verifyRowIsVisibleWithTexts(String... text) {
        super.verifyRowIsVisibleWithTexts(text);
        return this;
    }

    @Step("click Archive button")
    public ArchivePage clickArchiveButton() {
        archiveButton.click();
        ArchivePage.headerText.shouldBe(visible);
        return new ArchivePage();
    }

    @Step("Select articlesCount - {articlesCount}")
    public UnicityTab selectArticlesCount(String articlesCount) {
        articlesCountInput.sendKeys(articlesCount);
        return this;
    }

    @Step("Type warehouse - {warehouse}")
    public UnicityTab selectWarehouse(String warehouse) {
        selectInAutocomplete(warehouseInput, warehouse);
        return this;
    }

    @Step("click Autogenerate button")
    public UnicityTab clickAutogenerateCheckbox() {
        autogenerateCheckbox.click();
        return this;
    }

    @Step("click Save button")
    public UnicityTab clickSaveButton() {
        saveButton.click();
        Selenide.sleep(2000);
        return this;
    }

    @Step("Save Serial numbers into map - {list}")
    public UnicityTab saveNumbers(List<String> list) {
        list.addAll(serialNumbers.asDynamicIterable().stream().map(SelenideElement::getText).collect(Collectors.toList()));
        return this;
    }

    @Step("Click On Edit Unique Article button for uniq with serial number - {serialNumber}")
    public UpdateUniqueArticlePopup clickOnUpdateUniqueArticleButton(String serialNumber) {
        $x(String.format(updateUniqueArticleButton, serialNumber)).click();
        return new UpdateUniqueArticlePopup();
    }

    public UnicityTab verifyRowIsNotVisibleWithTexts(String... text) {
        super.verifyRowIsNotVisibleWithTexts(text);
        return this;
    }

    //      ================= Unique Article Serial Number field methods =================
    public UnicityTab verifyUniqueArticleSerialNumberSearchInputIsVisible() {
        uniqueArticleSerialNumberSearchInput.shouldBe(visible);
        return this;
    }

    @Step("Search Unique Article by valid serial number - {serialNumber}")
    public UnicityTab searchUnicityArticleByValidSerialNumber(String serialNumber) {
        selectInAutocomplete(uniqueArticleSerialNumberSearchInput, serialNumber);
        return this;
    }

    @Step("Verify Search Results have text - {serialNumber}")
    public UnicityTab verifySearchResultsInUniqueArticlesTableHasSerialNumberText(String serialNumber) {
        $x(String.format(uniqueArticleRowWithSerialNumberXpath, serialNumber)).shouldBe(visible);
        return this;
    }

    @Step("Search Unique Article by invalid serial number - {text}")
    public UnicityTab searchUnicityArticleByInvalidSerialNumber(String text) {
        uniqueArticleSerialNumberSearchInput.click();
       serialNumberDropdownSearchInput.sendKeys(text);
        return this;
    }

    @Step("verify 'alert' text is - {text}")
    public UnicityTab verifyAlertTextIsVisibleForSerialNumberField(String text) {
        alertTextForSerialNumberField.shouldHave(Condition.text(text));
        return this;
    }

    @Step("Clear Unique Article Serial Number field")
    public UnicityTab clickUniqueArticleSerialNumberSearchInputClear() {
        uniqueArticleSerialNumberSearchInputClear.click();
        return this;
    }

    //      ================= Unique Article Code field methods =================
    public UnicityTab verifyUniqueArticleCodeSearchInputIsVisible() {
        uniqueArticleCodeSearchInput.shouldBe(visible);
        return this;
    }

    @Step("Search Unique Article by valid code - {code}")
    public UnicityTab searchUnicityArticleByValidCode(String code) {
        selectInAutocomplete(uniqueArticleCodeSearchInput, code);
        return this;
    }

    @Step("Verify Search Results have text - {code}")
    public UnicityTab verifySearchResultsInUniqueArticlesTableHasCodeText(String code) {
        $x(String.format(uniqueArticleRowWithCodeXpath, code)).shouldBe(visible);
        return this;
    }

    @Step("Search Unique Article by invalid code - {text}")
    public UnicityTab searchUnicityArticleByInvalidCode(String text) {
        uniqueArticleCodeSearchInput.click();
        codeDropdownSearchInput.type(text);
        return this;
    }

    @Step("Clear Unique Article Code field")
    public UnicityTab clickUniqueArticleCodeSearchInputClear() {
        uniqueArticleCodeSearchInputClear.click();
        return this;
    }

    @Step("verify 'alert' text is - {text}")
    public UnicityTab verifyAlertTextIsVisibleForCodeField(String text) {
        alertTextForCodeField.shouldHave(text(text));
        return this;
    }

    //      ================= No results in table =================
    @Step("Verify Search Results have no results for non-corresponding Serial Number and Code")
    public UnicityTab verifyNoSearchResultsInTable() {
        alertTextForTable.shouldBe(visible);
        return this;
    }
}