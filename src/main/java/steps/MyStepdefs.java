package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MyStepdefs {
    private final WebDriver driver;
    private final Properties p;

    public MyStepdefs() throws IOException {
        WebDriverManager.chromedriver().setup(); //Driver Initialization
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        p=new Properties();
        File f=new File("C:\\Users\\Admin\\IdeaProjects\\Automation3\\src\\main\\resources\\Test Data\\user.properties");
        FileInputStream fin=new FileInputStream(f);
        p.load(fin);
    }
    
    @Given("^Opening Web Page$")
    public void openWebPage()
    {
        System.out.println("Open Web Page"); //Console message
        driver.get(p.getProperty("url")); //Opening Webpage

        //Checking whether webpage opened successfully or not
        WebElement Expected_Input= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]"));
        String s= "Please enter email";
        try{
            Assert.assertEquals(s,Expected_Input.getAttribute("placeholder"));
        }catch (AssertionError e){
            System.out.println("Username Field not Present");
        }
        System.out.println(p.getProperty("username"));
    }

    @io.cucumber.java.en.Then("^Print Message$")
    public void printMessage() throws IOException
    {
        screenShotFunction(); // Screenshot function call to take screenshot
        System.out.println("Test Completed"); // Console message
    }

    public void screenShotFunction() throws IOException
    {
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

    @Then("Click Submit")
    public void clickSubmit() {
        WebElement clickable =driver.findElement(By.xpath("//div[@class='submit flex-vertical-align']//input[1]"));
        clickable.click();
    }

    @Then("Close Browser")
    public void closeBrowser() {
        driver.close();
    }

    @Then("Enter username and password")
    public void enterUsernameAndPassword() {
        driver.findElement(By.xpath("//input[@placeholder='Please enter email']")).sendKeys(p.getProperty("username"));
        driver.findElement(By.xpath("//input[@placeholder='Please enter password']")).sendKeys(p.getProperty("password"));
    }

    @Then("Enter OTP")
    public void enterOTP() {

    }

    @Then("Navigate to HP")
    public void navigateToHP() {
        
    }

    @Then("Select Brand HP{int}")
    public void selectBrandHP(int arg0) {

    }

    @Then("Click on Lead Management")
    public void clickOnLeadManagement() {

    }

    @Then("Click Lead Task Management")
    public void clickLeadTaskManagement() {

    }

    @Then("Click on Call lead Radio button")
    public void clickOnCallLeadRadioButton() {
    }
}
