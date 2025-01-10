package driver;

import com.thoughtworks.gauge.Step;

import org.openqa.selenium.By;


public class StepImplementation extends DriverFactory{

    // private  WebDriver driver;

    // public StepImplementation() {
    //     this.driver = new DriverFactory().getDriver();
    // }

    @Step("Go to Gauge Get Started Page")
    public void gotoGetStartedPage() throws InterruptedException {
        threadLocalDriver.get().findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        threadLocalDriver.get().findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        threadLocalDriver.get().findElement(By.name("li3")).click();
    }

    @Step("Ensure installation instructions are available")
    public void ensureInstallationInstructionsAreAvailable() throws InterruptedException {
        System.out.println("Checking Another Box");
        threadLocalDriver.get().findElement(By.name("li4")).click();

        threadLocalDriver.get().findElement(By.id("sampletodotext")).sendKeys(" List Item 6");
        threadLocalDriver.get().findElement(By.xpath("//*[@id = 'addbutton']")).click();

    }

    @Step("Open the Gauge homepage")
    public void implementation1() {
       
        threadLocalDriver.get().get("https://lambdatest.github.io/sample-todo-app/");
        
}
}