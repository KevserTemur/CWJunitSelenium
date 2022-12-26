package Day1_SeleniumMaven;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class task05  {

    /*
    Go to Amazon homepage.
Do the following tasks by creating 3 different test methods.
1- Test if the URL contains Amazon.
2- Test if the title does not contain Facebook.
3- Test that the Amazon logo appears in the upper left corner
     */

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @After
    public void after (){
        driver.quit();
    }

    @Test
    public void test1 (){
        driver.get("https://www.amazon.com/");
        String Url = driver.getCurrentUrl();
        Assert.assertTrue(Url.contains("amazon"));
    }
    @Test
    public void test2 (){
        driver.get("https://www.amazon.com/");
        String title = driver.getTitle();
        Assert.assertTrue(!title.contains("Facebook"));
    }
    @Test
    public void test3 (){
        WebElement logo = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
        Assert.assertTrue(logo.isDisplayed());

    }
}
