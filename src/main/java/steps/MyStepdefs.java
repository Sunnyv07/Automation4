package steps;

import com.beust.jcommander.Parameterized;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class MyStepdefs {
    private WebDriver driver;

    public MyStepdefs()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @io.cucumber.java.en.Given("^Open Web Page$")
    public void openWebPage() throws IOException {
        System.out.println("Open");
        driver.get("http://omayo.blogspot.com/");
    }

    @io.cucumber.java.en.Then("^Print Message$")
    public void printMessage() {
        System.out.println("Code Exited");
    }

    @Then("Edit text fields")
    public void editTextFields() throws IOException {
        driver.findElement(By.name("q")).sendKeys("Sunny");
        driver.findElement(By.id("ta1")).sendKeys(("Vishwakarma"));
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("C:\\Users\\Admin\\OneDrive\\Pictures\\Screenshots\\Automation Screenshots\\New Bitmap Image.jpg");
        FileUtils.copyFile(SrcFile, DestFile);
        driver.close();
    }
}
