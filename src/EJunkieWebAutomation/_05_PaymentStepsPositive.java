package EJunkieWebAutomation;

import Utils.BaseStaticDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _05_PaymentStepsPositive extends BaseStaticDrivers {

    public static void main(String[] args) {


        String confirmation = "your order is confirmed. Thank you!";
        String cardNumber = "4242 4242 4242 4242";
        String email = "test1234@gmail.com";
        String nameOnCArd = "Ninja";
        String phone = "9876543221";
        String MMYY = "1222";
        String CVC = "000";

        driver.get("https://shopdemo.e-junkie.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

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
        //cardframe end

        //switchTo back frame
        driver.switchTo().parentFrame();

        WebElement payButton = driver.findElement(By.cssSelector("button[class='Pay-Button']"));
        wait.until(ExpectedConditions.visibilityOf(payButton));
        payButton.click();

        //switchTo homepage
        driver.switchTo().defaultContent();

        WebElement confirmationMessage = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=' your order is confirmed. Thank you!']")));

        String confirmationMessageText = confirmationMessage.getText();

        if (confirmationMessageText.equals(confirmation)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.quit();

    }
}
