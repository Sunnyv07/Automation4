package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
        driver.get(p.getProperty("staging_url")); //Opening Webpage

        //Checking whether webpage opened successfully or not
        WebElement Actual_Input= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]"));
        String Expected_Input= "Please enter email";
        try{
            Assert.assertEquals(Expected_Input,Actual_Input.getAttribute("placeholder"));
        }catch (AssertionError e){
            System.out.println("Username Field not Present");
        }
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
        ///html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/input[1] otp input box
        ///html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/input[1] submit button
    }

    @Then("Navigate to HP")
    public void navigateToHP() {
        WebElement mouse=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[21]"));
        mouse.click();
    }

    @Then("Select Brand HPotwoo")
    public void selectBrandHPotwoo() {
        WebElement mouse= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[2]"));
        mouse.click();
    }

    @Then("Click on Lead Management")
    public void clickOnLeadManagement() {
        WebElement mouse= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[9]/div[1]/div[2]"));
        mouse.click();
    }

    @Then("Click on Call Leads")
    public void clickOnCallLeads() {
        WebElement mouse = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[9]/div[2]/div[1]/div[1]/div[1]/a[1]/div[1]"));
        mouse.click();

        //Checking whether entered page call leads or not
        WebElement Actual_text= driver.findElement(By.xpath("//span[normalize-space()='- Call Leads']"));
        String Expected_text="Call Leads";
        try
        {
            Assert.assertEquals(Expected_text,Actual_text.getAttribute("name"));
        }catch (AssertionError e)
        {
            System.out.println("Incorrect Page");
        }
    }

    @Then("Click on Filter Button")
    public void clickOnFilterButton() {
        WebElement mouse= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/a[1]/*[name()='svg'][1]/*[name()='path'][1]"));
        mouse.click();
        // filter button

        ///html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]/span[1] hover input field
        ///html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]/div[1]/a[1]/span[1] hover city
        ///html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]/div[1]/a[1]/div[1]/a[2]/span[1] agra city
        ///html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/a[2] apply button
    }

    @Then("Click on Form Leads")
    public void clickOnFormLeads() {
        WebElement mouse = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[9]/div[2]/div[1]/div[1]/div[2]/a[1]/div[1]"));
        mouse.click();
    }

    @Then("Click on Export Button")
    public void clickOnExportButton() {
        WebElement mouse= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/a[2]/*[name()='svg'][1]/*[name()='path'][1]"));
        mouse.click();
    }

    @Then("Return count of Initialize") //Counting initialize count from downloaded file
    public void returnCountOfInitialize() throws IOException {
        File F= new File("C:\\Users\\Admin\\Downloads\\call-leads.csv");
        FileInputStream fin = new FileInputStream(F);
        Workbook a= new XSSFWorkbook(fin);
        for (Sheet sheet:a)
        {
            int firstRow=sheet.getFirstRowNum();
            int lastRow=sheet.getLastRowNum();
            for (int index=firstRow+1;index<=lastRow;index++)
            {
                Row row=sheet.getRow(index);
                for (int cellIndex = row.getFirstCellNum(); cellIndex < row.getLastCellNum(); cellIndex++) {
                    Cell cell = row.getCell(cellIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    printCellValue(cell);
                }
            }
        }
    }
    public static void printCellValue(Cell cell) //function to read values of cell from Excel sheet
    {
        CellType cellType = cell.getCellType().equals(CellType.FORMULA)
                ? cell.getCachedFormulaResultType() : cell.getCellType();
        if (cellType.equals(CellType.STRING)) {
            System.out.print(cell.getStringCellValue() + " | ");
        }
        if (cellType.equals(CellType.NUMERIC)) {
            if (DateUtil.isCellDateFormatted(cell)) {
                System.out.print(cell.getDateCellValue() + " | ");
            } else {
                System.out.print(cell.getNumericCellValue() + " | ");
            }
        }
        if (cellType.equals(CellType.BOOLEAN)) {
            System.out.print(cell.getBooleanCellValue() + " | ");
        }
    }

    @Then("Click on Export Button for Form Leads")
    public void clickOnExportButtonForFormLeads() {
        WebElement mouse= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/a[2]/*[name()='svg'][1]"));
        mouse.click();
        WebElement mouse1=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/a[2]/div[1]/a[1]"));
        mouse1.click();
    }
}