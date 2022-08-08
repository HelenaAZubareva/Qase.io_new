package Ui.base;

import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j2
public class TestListener implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {
        log.info("-----{} - status Started-----", iTestResult.getName());
    }

    public void onTestSuccess(ITestResult iTestResult) {
        log.info("-----{} - status Success-----", iTestResult.getName());
    }

    public void onTestFailure(ITestResult iTestResult) {
        log.info("-----{} - status Failure-----", iTestResult.getName());
    }

    public void onTestSkipped(ITestResult iTestResult) {
        log.info("-----{} - status Skipped-----", iTestResult.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        log.info("-----{} - status Success-----", iTestResult.getName());
    }

    public void onTestFailedWithTimeout(ITestResult iTestResult) {
        log.info("-----{} - status Failure-----", iTestResult.getName());
    }

    public void onStart(ITestContext context) {
        log.info("-----On Start " + context.getStartDate() + "-----");
    }

    public void onFinish(ITestContext context) {
        log.info("-----On Finish " + context.getEndDate() + "-----");
    }

}
