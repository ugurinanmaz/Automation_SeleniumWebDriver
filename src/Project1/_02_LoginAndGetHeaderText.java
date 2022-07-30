package Project1;

import Utils.BaseStaticDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _02_LoginAndGetHeaderText extends BaseStaticDrivers {
    public static void main(String[] args) {


/*        System.setProperty("webdriver.gecko.driver","C:\\Users\\HPInc\\Documents\\Selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();*/


        driver.get("https://demo.applitools.com/");

        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys(" ttechno@gmail.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(" techno123.");

        WebElement login = driver.findElement(By.id("log-in"));
        login.click();

        WebElement header = driver.findElement(By.id("time"));
        String headerText = header.getText();
        String strUrl = driver.getCurrentUrl();

        System.out.println("headerText = " + headerText);

        System.out.println("strUrl = " + strUrl);

        WaitAndTearDown();

    }
}
