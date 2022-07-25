import Utils.BaseStaticDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class _01_SendKeysBlockAds extends BaseStaticDrivers {
    public static void main(String[] args) {

/*        System.setProperty("webdriver.gecko.driver","C:\\Users\\HPInc\\Documents\\Selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();*/

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

        WaitAndTearDown();

    }
}
