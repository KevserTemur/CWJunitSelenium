package Day6_DropDown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class homework_alerts {

/*
Go to URL: http://demo.automationtesting.in/Alerts.html
Click "Alert with OK" and click 'click the button to display an alert box:’
Accept Alert(I am an alert box!) and print alert on console.
Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
Cancel Alert  (Press a Button !)
Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
And then sendKeys «BootcampCamp» (Please enter your name)
Finally print on console this message "Hello BootcampCamp How are you today" assertion these message.
 */

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void Alert(){
      //  Go to URL: http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

      //  Click "Alert with OK" and click 'click the button to display an alert box:’
        WebElement alertWithOK = driver.findElement(By.xpath("(//a[@class='analystic'])[1]"));
       driver.findElement(By.cssSelector("#OKTab .btn.btn-danger")).click();

        //  Accept Alert(I am an alert box!) and print alert on console.
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //  Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
        WebElement alertWithOKCancel = driver.findElement(By.xpath("(//a[@class='analystic'])[2]"));
        alertWithOKCancel.click();
        driver.findElement(By.cssSelector("#CancelTab .btn.btn-primary")).click();

      //  Cancel Alert  (Press a Button !)
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

      //  Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
        WebElement alertWithTextBox = driver.findElement(By.xpath("(//a[@class='analystic'])[3]"));
        alertWithTextBox.click();
        driver.findElement(By.className("btn-info")).click();

      //  And then sendKeys «BootcampCamp» (Please enter your name)
        alert.sendKeys("BootcampCamp");
        alert.accept();

      //  Finally print on console this message "Hello BootcampCamp How are you today" assertion these message.
        Assert.assertTrue(driver.findElement(By.id("demo1")).getText().equals("Hello BootcampCamp How are you today"));

    }
}
