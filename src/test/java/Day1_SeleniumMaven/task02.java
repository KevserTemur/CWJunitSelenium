package Day1_SeleniumMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class task02 {

    /*
    → Go to the Amazon URL : https://www.amazon.com/
→ Print the position and size of the page.
→ Adjust the position and size of the page as desired.
→ Test that the page is in the position and size you want.
→ Close the page
     */
    @Test
    public void  task02 () {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());

        driver.manage().window().setPosition(new Point(80,100));
        System.out.println(driver.manage().window().getPosition());
        driver.manage().window().setSize(new Dimension(200,250));
        System.out.println(driver.manage().window().getSize());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.close();



    }
}
