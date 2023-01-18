package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class MyStepdefs {
    private final WebDriver driver;

    public MyStepdefs()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @Given("^Open Web Page$")
    public void openWebPage() {
        System.out.println("Open");
        driver.get("https://app.sekel.tech/login");
    }

    @io.cucumber.java.en.Then("^Print Message$")
    public void printMessage() throws IOException {
        screenShotFunction();
        System.out.println("Test Completed");
    }

    @Then("Edit text fields")
    public void editTextFields() {
        driver.findElement(By.xpath("//input[@placeholder='Please enter email']")).sendKeys("Sunny");
        driver.findElement(By.xpath("//input[@placeholder='Please enter password']")).sendKeys("Vishwakarma");
    }

    public void screenShotFunction() throws IOException {
        int screenCount=0;
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("C:\\Users\\Admin\\OneDrive\\Pictures\\Screenshots\\Automation Screenshots\\"+screenCount+".jpg");
        while (DestFile.exists())
        {
            screenCount=screenCount+1;
            DestFile=new File("C:\\Users\\Admin\\OneDrive\\Pictures\\Screenshots\\Automation Screenshots\\"+screenCount+".jpg");
        }
        FileUtils.copyFile(SrcFile, DestFile);
    }

    @Then("Click Login")
    public void clickLogin() {
        WebElement clickable =driver.findElement(By.xpath("//div[@class='submit flex-vertical-align']//input[1]"));
        clickable.click();
    }

    @Then("Close Browser")
    public void closeBrowser() {
        driver.close();
    }
}
