package utils;

import logging.ReporterManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.lang.reflect.Method;


public class BaseTest {
    public ReporterManager reporter;
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected ThreadLocal<String> testName = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)
    public void beforeWithData(Object[] data, Method method) {
        logger.info("Start of BaseTest @BeforeMethod: {}", method.getName());
        reporter = ReporterManager.Instance;
        reporter.startReporting(method, data);
        logger.info("End of BaseTest @BeforeMethod");
    }

    @AfterMethod(alwaysRun = true)
    public void endTest(ITestResult testResult, Method method) {
        logger.info("Start of BaseTest @AfterMethod");
        // do stuff
        logger.info("End of BaseTest @AfterMethod");
    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        logger.info("Start of BaseTest @BeforeSuite");
//        logger.info("CONFIG_DATA in BaseTest");
//        logger.info("qTest integration: {}", System.getProperty("qTest"));
//        logger.info("Config: {}", System.getProperty("config"));
//        logger.info("Groups: {}", System.getProperty("groups"));
//        logger.info("browserstack.config: {}", System.getProperty("browserstack.config"));
        logger.info("End of BaseTest @BeforeSuite");
    }

    @AfterSuite(alwaysRun = true)
    public void flushReporter() {
        logger.info("Start of BaseTest @AfterSuite");
        // do stuff
        logger.info("End of BaseTest @AfterSuite");
    }


}
