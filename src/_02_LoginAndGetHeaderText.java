import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _02_LoginAndGetHeaderText {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\inanmaz\\OneDrive - HP Inc\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

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

        driver.quit();






    }
}
