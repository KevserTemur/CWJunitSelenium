package zzz_kevser;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert01 {


    WebDriver driver;

    @Test
    public void test(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.tutorialsteacher.com/codeeditor?cid=js-1");



       // driver.switchTo().alert().accept();
      //  driver.switchTo().alert().dismiss();
      //  driver.switchTo().alert().getText();
      //  driver.switchTo().alert().sendKeys("selamlar");


        WebElement homeLink = driver.findElement(By.xpath("//a[@title=\"TutorialsTeacher.com Home\"]"));
        homeLink.click();

    }
}
