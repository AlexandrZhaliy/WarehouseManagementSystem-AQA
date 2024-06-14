package core;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.*;

import java.io.File;
import java.util.List;

import static java.lang.String.format;

@Log4j
public class TestListener implements ITestListener, IInvokedMethodListener {

    @SneakyThrows
    public void onTestFailure(ITestResult result) {
        String msg = format("TEST:'%s' - FAILED", desc(result));
        log.error(ExceptionUtils.getStackTrace(result.getThrowable()));
        logMessage(msg);
        attachLog(result);
    }

    @Override
    public void onTestStart(ITestResult result) {
        String msg = String.format("START: '%s'", desc(result));
        logMessage(msg);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String msg = String.format("TEST: '%s' - PASSED", desc(result));
        logMessage(msg);
        attachLog(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String msg = String.format("TEST: '%s' - SKIPPED", desc(result));
        logMessage(msg);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub

    }

    @Attachment(value = "{screenshotName}", type = "image/png")
    private byte[] saveScreenshot(String screenshotName) throws Exception {
        File screenshot = Screenshots.takeScreenShotAsFile();
        FileUtils.copyFile(screenshot, new File("target\\allure-results\\screenshots\\" + screenshot.getName()));
        return Files.toByteArray(screenshot);
    }

    @Attachment(value = "DETAILS")
    private String attachLog(ITestResult testResult) {
        List<String> out = Reporter.getOutput(testResult);
        String res = "";
        for (String line : out) {
            res += format("%s", line);
        }
        return res;
    }

    private void logMessage(String msg) {
        log.info(StringUtils.repeat('#', msg.length() + 20));
        log.info(String.format("######### %s #########", msg));
        log.info(StringUtils.repeat('#', msg.length() + 20));
    }

    private String desc(ITestResult result) {
        return result.getMethod().getDescription().isEmpty() ? result.getMethod().getMethodName() : result.getMethod().getDescription();
    }
}
