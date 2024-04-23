package org.example.listeners;

import com.relevantcodes.extentreports.LogStatus;
import org.example.constant.enumValues.LogsType;
import org.example.report.ExtentReportManager;
import org.example.util.LoggerUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LogListener implements ITestListener {



        /**
         * Gets the test name.
         *
         * @param result the result
         * @return the test name
         */
        public String getTestName(ITestResult result) {
            return result.getTestName() != null ? result.getTestName()
                    : result.getMethod().getConstructorOrMethod().getName();
        }

        /**
         * Gets the test description.
         *
         * @param result the result
         * @return the test description
         */
        public String getTestDescription(ITestResult result) {
            return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
        }

        @Override
        public void onTestStart(ITestResult result) {
            LoggerUtil.log(getTestName(result) + ": Test started");
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            LoggerUtil.log(getTestName(result) + " : Test Passed");
        }

        @Override
        public void onTestFailure(ITestResult result) {
            Throwable t = result.getThrowable();
            String cause = "";
            if (t != null)
                cause = t.getMessage();
            LoggerUtil.getLogger().fatal(getTestName(result) + " : Test Failed : " + cause);
        }

        @Override
        public void onTestSkipped(ITestResult result) {
            LoggerUtil.log(getTestName(result) + " : Test Skipped");
        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        }

        @Override
        public void onStart(ITestContext context) {
        }

        @Override
        public void onFinish(ITestContext context) {
        }

    public static void reportLog ( LogsType logType , String message ) {

        if (logType == LogsType.ERROR) {
            ExtentReportManager.getCurrentTest ( ).log ( LogStatus.ERROR ,message);
            LoggerUtil.getLogger().error ( message );

            LoggerUtil.getLogger().info(message);
        } else if (logType == LogsType.INFO) {
            ExtentReportManager.getCurrentTest ( ).log ( LogStatus.INFO , message );
            LoggerUtil.getLogger().info ( message );

            LoggerUtil.getLogger().info(message);
        }
    }
}
