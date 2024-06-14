package ui.pages.warehouseManagementSystem.suppliers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.google.common.collect.Streams;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.installationOrders.ApproveInstallationOrderPage;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class FilesTab extends SuppliersPage{
    public static SelenideElement addFileButton = $x("//button[contains(., 'Add file')]");
    public static SelenideElement browseInput = $x("//input[contains(@id, 'filecreatemodel-file')]");
    public static SelenideElement removeButton = $x("//button[contains(., 'Remove')]");
    public static SelenideElement uploadButton = $x("//button[contains(., 'Upload')]");
    public static String fileTitleInput = "//input[contains(@title, '%s')]";

    @Step("upload file")
    public FilesTab uploadFile() {
        addFileButton.click();
        browseInput.uploadFile(new File(filePath));
        uploadButton.click();
        return this;
    }

    @Step("upload file and verify file name and removing file")
    public FilesTab verifyUploadedFile() {
        addFileButton.click();
        browseInput.uploadFile(new File(filePath));
        $x(format(fileTitleInput, Arrays.stream(filePath.split("/")).reduce((first, second) -> second).get())).shouldBe(Condition.visible);
        $x(format(fileTitleInput, Streams.findLast(Arrays.stream(filePath.split("/"))).get())).shouldBe(Condition.visible);
        removeButton.shouldBe(Condition.visible);
        removeButton.click();
        removeButton.shouldBe(Condition.hidden);
        $x(format(fileTitleInput, Streams.findLast(Arrays.stream(filePath.split("/"))).get())).shouldBe(Condition.hidden);
        browseInput.uploadFile(new File(filePath));
        uploadButton.click();
        return this;
    }
}
