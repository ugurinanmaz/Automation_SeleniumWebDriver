import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _03_SearchAndBack {
    public static void main(String[] args) throws InterruptedException {



        System.setProperty("webdriver.chrome.driver","C:\\Users\\inanmaz\\OneDrive - HP Inc\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String searchText = "teddy bear";

        driver.get("https://www.snapdeal.com/");

        WebElement searchBar = driver.findElement(By.id("inputValEnter"));
        searchBar.sendKeys(searchText);
        //Thread.sleep(3000);
        driver.findElement(By.cssSelector(".searchTextSpan")).click();

        WebElement searchCountLocator = driver.findElement(By.cssSelector("#searchMessageContainer > div > span"));
        String searchCountText =  searchCountLocator.getText();
        System.out.println("searchCountText = " + searchCountText);
        //Thread.sleep(3000);

        String strUrl = driver.getCurrentUrl();
        System.out.println("Current Page URL = " + strUrl);
        ///Thread.sleep(3000);
        //WebElement clickSnapDeal = driver.findElement(By.cssSelector("img[title='Snapdeal'][class='notIeLogoHeader aspectRatioEqual sdLogo cur-pointer']"));
        WebElement clickSnapDeal = driver.findElement(By.cssSelector(".notIeLogoHeader.aspectRatioEqual.sdLogo.cur-pointer"));
        clickSnapDeal.click();

        String strUrl2 = driver.getCurrentUrl();
        System.out.println("Home Page URL = " + strUrl2);

        driver.navigate().back();
        //Thread.sleep(3000);
        WebElement currentValue = driver.findElement(By.id("inputValEnter"));
        //Thread.sleep(3000);
        String currentValueText = currentValue.getAttribute("value");
        System.out.println(currentValueText);
        //Thread.sleep(5000);

        if (searchText.equals(currentValueText)){
            System.out.println("Passed!");
        }else {
            System.out.println("Failed!");
        }

        driver.quit();







    }
}