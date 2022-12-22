package Day8_WindowHandles_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

import javax.swing.*;

public class C02_Actions extends BaseTest {

    //https://demoqa.com/buttons
    @Test
    public void doubleClick (){
        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));

        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClick).perform();

        Assert.assertTrue(driver.findElement(By.id("doubleClickMessage")).isDisplayed());

    }

    @Test
    public void rightClick (){

        driver.get("https://demoqa.com/buttons");

        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        Actions actions =new Actions(driver);

        actions.contextClick(rightClickBtn).build().perform();

        WebElement rightClickMesssage = driver.findElement(By.id("rightClickMesssage"));
        Assert.assertTrue(rightClickMesssage.isDisplayed());

    }
    @Test
    public void click (){

        driver.get("https://demoqa.com/buttons");
        WebElement clickBtn = driver.findElement(By.xpath(""));
        Actions actions = new Actions(driver);

        actions.click(clickBtn).perform();
        WebElement dynamicClickMessage = driver.findElement(By.id("dynamicClickMessage"));
        Assert.assertTrue(dynamicClickMessage.isDisplayed());

    }

}
