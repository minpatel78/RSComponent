package automationPractice.Utils;

import automationPractice.pages.BasePage;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static automationPractice.pages.BasePage.driver;

public class BrowserFactory extends  BasePage {
    public static void startBrowser()  {
        String path = System.getProperty("user.dir") + "/src/main/resources/";
        if (AutomationConstants.REMOTE_BROWSER == true) {
            DesiredCapabilities caps = DesiredCapabilities.edge();
            caps.setCapability("platform", "Windows 10");
            caps.setCapability("version", "15.15063");
            try {

                driver = new RemoteWebDriver(new URL(AutomationConstants.SELENIUM_GRID_URL), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        else
            {

                System.setProperty("webdriver.chrome.driver", path + "chromedriver.exe");
                driver = new ChromeDriver();

        }

        driver.get(AutomationConstants.baseURL);
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

    }

    public static void stopBrowser() {
        if (driver != null) {
         driver.close();
         driver.quit();
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {

            BrowserFactory.startBrowser();
        }
        return driver;
    }
}
