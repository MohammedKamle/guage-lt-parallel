package driver;

import com.thoughtworks.gauge.AfterSpec;

import com.thoughtworks.gauge.BeforeSpec;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    
 
    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    private static final String username = "";
    private static final String accesskey = "";
   
    public String status = "passed";

    // Initialize a webDriver instance of required browser
    // Since this does not have a significance in the application's business domain, the BeforeSuite hook is used to instantiate the webDriver
    @BeforeSpec
    public void initializeDriver() throws MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("version", "latest");
            capabilities.setCapability("platform", "Windows 10");
            capabilities.setCapability("build", "java-gauge-lambdatest-parallel");
            capabilities.setCapability("name", "Sample Gauge Test");
            capabilities.setCapability("network", false); // To enable network logs
            capabilities.setCapability("visual", false); // To enable step by step screenshot
            capabilities.setCapability("console", false); // To capture console logs
            
             threadLocalDriver.set(new RemoteWebDriver(new URL("https://"+username+":"+accesskey+"@hub.lambdatest.com/wd/hub"), capabilities));

             threadLocalDriver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
    }

    // Close the webDriver instance
    @AfterSpec
    public void closeDriver(){

        threadLocalDriver.get().quit();
    }

}
