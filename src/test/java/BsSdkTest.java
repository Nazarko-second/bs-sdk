import configuration.SetupConfiguration;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class BsSdkTest {

    private static final String BS_USER = "nazardovhoshyya_7xTzMr";
    private static final String BS_KEY = "9LcPkawe8ipxfQpQcG4L";
    private static final String BS_CONNECTION_URL = "https://" + BS_USER + ":" + BS_KEY  + "@hub-cloud.browserstack.com/wd/hub";

    static WebDriver driver;
    @Test(testName = "Test name here",
            groups = {"smoke"})
    public static void TestOne() {

        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        Map<String, Object> profile = new HashMap<>();
        Map<String, Object> contentSettings = new HashMap<>();
        contentSettings.put("geolocation", 2);
        profile.put("managed_default_content_settings", contentSettings);
        chromePrefs.put("profile", profile);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--disable-gpu");
        options.setExperimentalOption("prefs", chromePrefs);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("buildTag", "Test Tag");
        browserstackOptions.put("sessionName", "Test Session Name");
        browserstackOptions.put("projectName", "Test Project Name");
        browserstackOptions.put("seleniumVersion", "4.25.0");
        capabilities.setCapability("bstack:options", browserstackOptions);

        try {
            driver = new RemoteWebDriver(new URL(BS_CONNECTION_URL), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Oops");
            return;
        }

        System.out.println("SAMPLE:" + SetupConfiguration.SAMPLE);

        driver.get("https://www.google.com/");
//        System.out.println("CONFIG_DATA inside test");
//        System.out.println("Property file: " + System.getProperty("config"));
//        System.out.println("qTest integration: " + System.getProperty("qTest"));
//        System.out.println("Config: " + System.getProperty("config"));
//        System.out.println("Groups: " + System.getProperty("groups"));
//        System.out.println("browserstack.config: " + System.getProperty("browserstack.config"));
//        System.out.println("BuildUrl: " + System.getProperty("buildUrl"));
//        System.out.println("Browser: " + System.getProperty("browser"));
//        System.out.println("Windows: " + System.getProperty("os"));

    }

    @AfterTest
    void teardown() {
        driver.quit();
    }


}
