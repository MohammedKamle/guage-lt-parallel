package driver;



import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.thoughtworks.gauge.AfterSpec;
import com.thoughtworks.gauge.BeforeSpec;

import io.github.bonigarcia.wdm.WebDriverManager;



public class DriverFactory {

     

   // Get a new WebDriver Instance.
    // There are various implementations for this depending on browser/OS. The
    // required browser/OS can be set as an environment variable.
    // Refer
    // http://getgauge.io/documentation/user/current/managing_environments/README.html

    private static final String username = "";
    private static final String accesskey = "";
    public static final String gridURL = "@hub.lambdatest.com/wd/hub";
    public String status = "passed";

     WebDriver getDriver() {
       
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("version", "latest");
            capabilities.setCapability("platform", "Windows 10");
            capabilities.setCapability("build", "java-gauge-LambdaTe-dsdsd");
            capabilities.setCapability("name", "Sample Gauge Test");
            capabilities.setCapability("network", false); // To enable network logs
            capabilities.setCapability("visual", false); // To enable step by step screenshot
            capabilities.setCapability("console", false); // To capture console logs

            
           // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            try {
                return new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            }
      
    }

    
    
}

