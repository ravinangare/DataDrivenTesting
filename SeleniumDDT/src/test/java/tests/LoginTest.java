package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.ExcelUtils;

public class LoginTest {
	WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");  
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return ExcelUtils.getExcelData("/Users/ravinangare/eclipse-workspace/Utkarshshaa_ws_24/SeleniumDDT/src/test/resources/testData.xlsx", "CustomerData");
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
        driver.findElement(By.name("login")).click();

        // Add validation logic here
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
