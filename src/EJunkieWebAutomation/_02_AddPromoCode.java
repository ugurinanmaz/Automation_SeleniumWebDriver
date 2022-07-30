package EJunkieWebAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _02_AddPromoCode {


    public static void main(String[] args) throws InterruptedException {

        String invalidVerify = "Invalid promo code";

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://shopdemo.e-junkie.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement addToCart = driver.findElement(By.xpath("//*[@id='products']/div[1]/div/div[2]/a/div/div[2]/button"));
        addToCart.click();

        WebElement iFrame1 = driver.findElement(By.xpath("(//iframe[@class='EJIframeV3 EJOverlayV3'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(iFrame1));
        driver.switchTo().frame(iFrame1);

        WebElement addPromoButton = driver.findElement(By.cssSelector("button[class='Apply-Button " +
                "Show-Promo-Code-Button']"));
        addPromoButton.click();

        WebElement promoInput = driver.findElement(By.cssSelector("input[class='Promo-Code-Value']"));
        promoInput.sendKeys("123456789");

        WebElement applyPromoButton = driver.findElement(By.cssSelector("button[class='Promo-Apply']"));
        applyPromoButton.click();

        Thread.sleep(2000);

        WebElement invalidPromo = driver.findElement(By.cssSelector("div[id='SnackBar']>span"));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[id='SnackBar']>span")));
        String invalidPromoText = invalidPromo.getText();

        System.out.println(invalidPromoText);

        if (invalidPromoText.equals(invalidVerify)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        driver.quit();
    }
}
