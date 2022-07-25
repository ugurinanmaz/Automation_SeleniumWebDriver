import Utils.BaseStaticDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class _03_SearchAndBack extends BaseStaticDrivers {
    public static void main(String[] args) throws InterruptedException {

/*        System.setProperty("webdriver.gecko.driver","C:\\Users\\HPInc\\Documents\\Selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();*/

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        String searchText = "teddy bear";

        driver.get("https://www.snapdeal.com/");

        WebElement searchBar = driver.findElement(By.id("inputValEnter"));
        searchBar.sendKeys(searchText);

        driver.findElement(By.cssSelector(".searchTextSpan")).click();

        WebElement searchCountLocator = driver.findElement(By.cssSelector("#searchMessageContainer > div > span"));
        String searchCountText =  searchCountLocator.getText();
        System.out.println("searchCountText = " + searchCountText);

        String strUrl = driver.getCurrentUrl();
        System.out.println("Current Page URL = " + strUrl);

        WebElement clickSnapDeal = driver.findElement(By.cssSelector("img[title='Snapdeal'][class='notIeLogoHeader aspectRatioEqual sdLogo cur-pointer']"));
//        WebElement clickSnapDeal = driver.findElement(By.cssSelector(".notIeLogoHeader.aspectRatioEqual.sdLogo.cur-pointer"));
        clickSnapDeal.click();

        String strUrl2 = driver.getCurrentUrl();
        System.out.println("Home Page URL = " + strUrl2);

        driver.navigate().back();

        WebElement currentValue = driver.findElement(By.id("inputValEnter"));
        String currentValueText = currentValue.getAttribute("value");
        //System.out.println(currentValueText);

        if (searchText.equals(currentValueText)){
            System.out.println("Passed!");
        }else {
            System.out.println("Failed!");
        }

        WaitAndTearDown();

    }
}
