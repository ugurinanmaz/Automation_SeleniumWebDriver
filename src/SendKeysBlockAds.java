import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysBlockAds {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\inanmaz\\OneDrive - HP Inc\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://demoqa.com/text-box");

        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys("Automation");

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("Testing@gmail.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Testing Current Address");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Testing Permanent Address");
        Thread.sleep(2000);
        WebElement submit = driver.findElement(By.id("submit"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down by 2000 pixels
        js.executeScript("window.scrollBy(0,300)");

        submit.click();

        WebElement name = driver.findElement(By.id("name"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement cAddress = driver.findElement((By.cssSelector("#currentAddress.mb-1")));
        WebElement pAddress = driver.findElement((By.cssSelector("#permanentAddress.mb-1")));

        System.out.println(name.getText().substring(name.getText().indexOf(':')+1));
        System.out.println(email.getText().substring(email.getText().indexOf(':')+1));
        System.out.println(cAddress.getText().substring(cAddress.getText().indexOf(':')+1));
        System.out.println(pAddress.getText().substring(pAddress.getText().indexOf(':')+1));

        driver.quit();








    }
}
