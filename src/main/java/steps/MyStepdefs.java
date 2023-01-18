package steps;

import com.sun.jdi.connect.spi.TransportService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Capabilities;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    private final WebDriver driver;

    public MyStepdefs()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @Given("^Open Web Page$")
    public void openWebPage() throws IOException {
        System.out.println("Open");
        driver.get("https://app.sekel.tech/login");
    }

    @io.cucumber.java.en.Then("^Print Message$")
    public void printMessage() throws IOException {
        screenShotFunction();
        System.out.println("Code Exited");
    }

    @Then("Edit text fields")
    public void editTextFields() throws IOException {
        driver.findElement(By.xpath("//input[@placeholder='Please enter email']")).sendKeys("Sunny");
        driver.findElement(By.xpath("//input[@placeholder='Please enter password']")).sendKeys("Vishwakarma");
    }

    public void screenShotFunction() throws IOException {
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("C:\\Users\\Admin\\OneDrive\\Pictures\\Screenshots\\Automation Screenshots\\New Bitmap Image1.jpg");
        FileUtils.copyFile(SrcFile, DestFile);
    }

    @Then("Click Login")
    public void clickLogin() {
        WebElement clickable =driver.findElement(By.xpath("//div[@class='submit flex-vertical-align']//input[1]"));
        clickable.click();
    }
}
