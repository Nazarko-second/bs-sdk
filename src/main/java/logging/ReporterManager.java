//package logging;
//
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//import com.relevantcodes.extentreports.NetworkMode;
//import configuration.ProjectConfiguration;
//import configuration.SessionManager;
//import datasources.FileManager;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import java.io.*;
//import java.lang.reflect.Method;
//import java.util.HashMap;
//import java.util.Map;
//
//public class ReporterManager {
//
//
//    private static ReporterManager instance;
//    public static ReporterManager Instance = (instance != null) ? instance : new ReporterManager();
//    private static Map<Long, ExtentTest> testThread = new HashMap<Long, ExtentTest>();
//
//
//    ReporterManager() {
//    }
//
//    private static ExtentReports extent;
//
//    private static final Logger logger = LoggerFactory.getLogger(ReporterManager.class);
//
//    public static String REPORT_FILE_LOCATION = FileManager.OUTPUT_DIR + File.separator + "Report" + (ProjectConfiguration.isPropertySet("Jenkins") ? "" : SessionManager.getSessionID()) + ".html";
//
//    private synchronized static ExtentReports getInstance() {
//        logger.info("getInstance() in ReporterManager");
//        if (extent == null) {
//            logger.info("Report creation: " + REPORT_FILE_LOCATION);
//            extent = new ExtentReports(REPORT_FILE_LOCATION, true, NetworkMode.ONLINE);
//        }
//        return extent;
//    }
//
//    public void startReporting(Method m, Object[] data) {
//        logger.info("startReporting() in ReporterManager");
//        logger.info("Started test '" + m.getName() + "'");
//        startTest(m, "Test name", "Test description");
////        ExtentReports report = getInstance();
//    }
//
//    public void info(String details) {
//        logger.info(String.valueOf(details));
//        if (report() != null)
//            report().log(LogStatus.INFO, String.valueOf(details).replace("\n", "<br>"));
//    }
//
//    public synchronized static ExtentTest report() {
//        ExtentTest report = null;
//
//        //get report from thread pool
//        Long threadID = Thread.currentThread().getId();
//        if (testThread.containsKey(threadID)) {
//            report = testThread.get(threadID);
//        }
//        return report;
//    }
//
//    public synchronized Map<Long, ExtentTest> startTest(Method m, String testName, String testDescription) {
//        logger.info("startTest() in ReporterManager");
//        Long threadID = Thread.currentThread().getId();
//        ExtentTest test = getInstance().startTest(testName, testDescription);
//        testThread.put(threadID, test);
//        return testThread;
//    }
//}