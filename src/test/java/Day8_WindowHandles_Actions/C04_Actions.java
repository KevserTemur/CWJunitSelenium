package Day8_WindowHandles_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C04_Actions extends BaseTest {

    //https://rangeslider.js.org/

    @Test
    public void dragAndDropOffSet (){

        driver.get("https://rangeslider.js.org/");

        WebElement slider = driver.findElement(By.xpath("//div[@class=\"rangeslider__handle\"]"));

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, 300, 0).perform();

    }

    @Test
    public void vertial(){

    }

    // https://www.amazon.com/
}
