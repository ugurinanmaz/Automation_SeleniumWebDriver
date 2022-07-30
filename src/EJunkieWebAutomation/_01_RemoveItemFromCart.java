package EJunkieWebAutomation;

import Utils.BaseStaticDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _01_RemoveItemFromCart {
    public static void main(String[] args) throws InterruptedException {

        String cartItemsAfterAdding="1";
        String cartItemsAfterRemoving="0";

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement addToCart = driver.findElement(By.xpath("//*[@id='products']/div[1]/div/div[2]/a/div/div[2]/button"));
        addToCart.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement iFrame1 = driver.findElement(By.xpath("(//iframe[@class='EJIframeV3 EJOverlayV3'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(iFrame1));
        driver.switchTo().frame(iFrame1);

        WebElement addedCartItem = driver.findElement(By.xpath("//*[@id=\"Overlay\"]/div/div[2]/div/div[2]/div[1]/span"));
        String verifyCartItem = addedCartItem.getText();
        if (verifyCartItem.equals(cartItemsAfterAdding)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        WebElement removeButton = driver.findElement(By.xpath("//button[@class ='Product-Remove']"));
        wait.until(ExpectedConditions.visibilityOf(removeButton));
        removeButton.click();

        WebElement continueShoppingButton = driver.findElement(By.xpath("//button[@class ='Continue-Button Close-Cart']"));
        wait.until(ExpectedConditions.visibilityOf(continueShoppingButton));
        continueShoppingButton.click();

        driver.switchTo().parentFrame();

        WebElement verifyItemAfterRemoving = driver.findElement(By.id("cart_item_nos"));
        wait.until(ExpectedConditions.visibilityOf(verifyItemAfterRemoving));
        String ItemCartTextAfterRemoving = verifyItemAfterRemoving.getText();

        if (ItemCartTextAfterRemoving.equals(cartItemsAfterRemoving)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.quit();
    }
}
