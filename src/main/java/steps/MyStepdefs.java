package steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs {
    @io.cucumber.java.en.Given("^Open Web Page$")
    public void openWebPage() {
        System.out.println("Open");
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://omayo.blogspot.com/");
        driver.findElement(By.name("q")).sendKeys("Sunny");
        driver.close();
    }

    @io.cucumber.java.en.Then("^Print Message$")
    public void printMessage() {
        System.out.println("Code Exited");
    }
}
