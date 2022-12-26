package Day1_SeleniumMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


/*
→ Create main method
→ Set Path
→ Create chrome driver
→ Open google home page: https://www.google.com
→ Get Title on page
→ Get Current URL on page
→ Close/Quit the browse
 */

public class task03 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.google.com");
        String title = driver.getTitle();
        if (title.equals("Google")) {
            System.out.println("PASSED");
        }else
         System.out.println("FAİLED");

        driver.close();
    }


}
