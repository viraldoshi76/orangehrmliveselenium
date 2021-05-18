package orangehrmlive;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OrangeLiveHrmSelenium {

    WebDriver driver;

    @Before
    public void setUp() {
        String baseUrl = "https://opensource-demo.orangehrmlive.com/";//variable is initalised with url
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();//object create to execute method
        driver.manage().window().maximize();//maximize the window
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//to give time to open the browser
        driver.get(baseUrl);//it will open the url
    }

    @Test
    public void verifyUserEnterTheText(){
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        driver.findElement(By.xpath("//a[@id='welcome']")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
    }
}
