package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.lang.reflect.Method;


public class BaseUITest extends BaseTest{

    private static final Logger logger = LoggerFactory.getLogger(BaseUITest.class);

    @BeforeMethod(alwaysRun = true)
    public void beforeWithData(Object[] data, Method method) {
        logger.info("Start of BeforeMethod in Base UI Test");
        super.beforeWithData(data, method);
        logger.info("CONFIG_DATA in BaseUITest");
        logger.info("qTest integration: {}", System.getProperty("qTest"));
        logger.info("Config: {}", System.getProperty("config"));
        logger.info("Groups: {}", System.getProperty("groups"));
        logger.info("browserstack.config: {}", System.getProperty("browserstack.config"));
        logger.info("End of BeforeMethod in Base UI Test");
    }

    @AfterMethod(alwaysRun = true)
    public void endTest(ITestResult testResult, Method method) {
        logger.info("Start of AfterMethod in Base UI Test");
        // do stuff
        super.endTest(testResult, method);
        logger.info("End of AfterMethod in Base UI Test");
    }

}
