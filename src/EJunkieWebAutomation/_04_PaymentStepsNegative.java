package EJunkieWebAutomation;

import Utils.BaseStaticDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _04_PaymentStepsNegative extends BaseStaticDrivers {

    public static void main(String[] args) throws InterruptedException {

        String invalidVerify = "Your card number is invalid.";
        String cardNumber = "1111 1111 1111 1111";
        String email = "test1234@gmail.com";
        String nameOnCArd = "Ninja";
        String phone = "9876543221";
        String MMYY = "0125";
        String CVC = "444";

        driver.get("https://shopdemo.e-junkie.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement addToCart = driver.findElement(By.xpath("//*[@id='products']/div[1]/div/div[2]/a/div/div[2]/button"));
        addToCart.click();

        WebElement iFrame1 = driver.findElement(By.xpath("(//iframe[@class='EJIframeV3 EJOverlayV3'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(iFrame1));
        driver.switchTo().frame(iFrame1);

        WebElement payCredit = driver.findElement(By.cssSelector("button[class='Payment-Button CC']"));
        wait.until(ExpectedConditions.visibilityOf(payCredit));
        payCredit.click();

        WebElement emailInput = driver.findElement(By.cssSelector("input[placeholder='Email']"));
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(email);

        WebElement confirmEmailInput = driver.findElement(By.cssSelector("input[placeholder='Confirm Email']"));
        wait.until(ExpectedConditions.visibilityOf(confirmEmailInput));
        confirmEmailInput.sendKeys(email);

        WebElement nameOnCardInput = driver.findElement(By.cssSelector("input[placeholder='Name On Card']"));
        wait.until(ExpectedConditions.visibilityOf(nameOnCardInput));
        nameOnCardInput.sendKeys(nameOnCArd);

        WebElement phoneInput = driver.findElement(By.xpath("(//input[@placeholder='Optional'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(phoneInput));
        phoneInput.sendKeys(phone);

        //cardFrame
        WebElement iFrameCard = driver.findElement(By.xpath("//*[@id='Stripe-Element']/div/iframe"));
        wait.until(ExpectedConditions.visibilityOf(iFrameCard));
        driver.switchTo().frame(iFrameCard);

        WebElement cardNumberInput = driver.findElement(By.cssSelector("input[placeholder='Card number']"));
        wait.until(ExpectedConditions.visibilityOf(cardNumberInput));
        cardNumberInput.sendKeys(cardNumber);


        WebElement MMYYInput = driver.findElement(By.cssSelector("input[placeholder='MM / YY'][inputmode='numeric']"));
        wait.until(ExpectedConditions.visibilityOf(MMYYInput));
        MMYYInput.sendKeys(MMYY);

        WebElement CVCInput = driver.findElement(By.cssSelector("input[placeholder='CVC'][inputmode='numeric']"));
        wait.until(ExpectedConditions.visibilityOf(CVCInput));
        CVCInput.sendKeys(CVC);

        driver.switchTo().parentFrame();

        WebElement invalidCardWarning = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='SnackBar']/span")));

        String validationOfInvalidCardText = invalidCardWarning.getText();

        if (validationOfInvalidCardText.equals(invalidVerify)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.quit();






    }

}
