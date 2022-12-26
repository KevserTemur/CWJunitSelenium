package Day1_SeleniumMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class task04 {

    /*
Invoke Chrome Browser
Navigate to URL: https://clarusway.com/
Navigate to URL: http://amazon.com/
Come back to the Clarusway using the back command.
Again go back to the amazon website using forward command
Refresh the Browser using refresh command.
Close the Browser.

     */
  @Before
    public void before (){
      WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }

  @Test
    public void navigator(){
    WebDriver driver = new ChromeDriver();
    driver.navigate().to("https://clarusway.com/");
    driver.get("http://amazon.com/");
    driver.navigate().back();
    driver.navigate().refresh();
    driver.navigate().refresh();

    driver.close();
  }





}
