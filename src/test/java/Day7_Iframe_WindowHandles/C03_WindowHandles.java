package Day7_Iframe_WindowHandles;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class C03_WindowHandles extends BaseTest {


//    Go to URL: https://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/
//    Print the existing windowHandles ids by clicking all the links on the page.
//    Click on the links that open a new page.
//    Close other pages other than the home page.
//    Set the driver back to the main page.

    @Test
      public void windowHandle(){


        driver.get("https://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/");

    String  homePageId = driver.getWindowHandle();

        List<WebElement> links = (List<WebElement>) driver.findElement(By.xpath("//a[@target='_blank']"));
         links.get(0).click();
         links.get(1).click();

        Set<String> window = driver.getWindowHandles();

        Iterator<String> iterator = window.iterator();

        while (iterator.hasNext()){
            if (iterator.next().equals(homePageId)){
                continue;
            }
            driver.close();
        }

    }






}
