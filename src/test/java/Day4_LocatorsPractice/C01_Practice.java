package Day4_LocatorsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Practice {


    //Navigate to website  https://testpages.herokuapp.com/styled/index.html
// Under the ORIGINAL CONTENTS
// Click on Alerts
// Print the URL
// Navigate back
// Print the URL
// Click on Basic Ajax
// Print the URL
// Enter value  20 and Enter
// And then verify Submitted Values is displayed open page
// Close driver.


    WebDriver driver;

    @Before
    public void setup(){
        // driver ile ilgili her türlü initial (başlangıç) işlemleri burada yapılır.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

    }

    @After
    public void tearDown(){
        // test sonrasında driver kapatmak (varsa raporları dosyalamak) için kullanılır
        driver.quit();
    }



    @Test
    public void test(){
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement alertsLink = driver.findElement(By.xpath("//a[@id='alerts']"));
        alertsLink.click();

        String alertsUrl = driver.getCurrentUrl();
        System.out.println(alertsUrl);

        driver.navigate().back();

        String homeUrl =driver.getCurrentUrl();
        System.out.println(homeUrl);

        WebElement basicAjaxLink = driver.findElement(By.id("basicajax"));
        basicAjaxLink.click();

        String basicAjaxUrl = driver.getCurrentUrl();
        System.out.println(basicAjaxUrl);

        driver.findElement(By.id("lteq30")).sendKeys("20" + Keys.ENTER);

        WebElement submittedValuestext = driver.findElement(By.xpath("//p[text()='Submitted Values']"));
        Assert.assertTrue(submittedValuestext.isDisplayed());

    }




}
