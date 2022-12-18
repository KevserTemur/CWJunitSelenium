package Day4_LocatorsPractice;

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
import java.util.List;


public class C02_CSSPractice {


    //http://the-internet.herokuapp.com/add_remove_elements/
// Click on the "Add Element" button 100 times.
// Write a function that takes a number, and clicks the "Delete" button.
// Given number of times, and then validates that given number of buttons was deleted.
// 1. Method: createButtons(100)
// 2. Method: DeleteButtonsAndValidate()


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
       // driver.quit();
    }


    @Test
    public void cssSelectortest (){

        //site linkimize gidiyoruz
    driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        //createButtons metodu ile 100 defa create elements e tikliyoruz.
    creatElements(100);

        //deleteButtonsAndValidate metodu ile 40 buton silinir ve kontrol edilir
    deleteButtonsAndvalidate(40);

    }

    public void creatElements(int amount){
        WebElement addaelementButton = driver.findElement(By.cssSelector("button[onclick=\"addElement()\"]"));
        for (int i = 0; i<amount; i++){
            addaelementButton.click();
        }
    }


    public void deleteButtonsAndvalidate(int amount){
        List<WebElement> deleteButtonsList = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        int silinmedenOnceDelteButtonSayisi = deleteButtonsList.size(); //100


        //Bizden istenen sayi kadar butonu sileriz
        for (int i = 0; i < amount; i++){
            deleteButtonsList.get(i).click();
        }

        //Silindikten sonraki buton sayisini buluruz
        List<WebElement> deleteButtonsListAfter = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        int silinmedenSonraDeleteButtonSayisi = deleteButtonsListAfter.size(); // 60


        //Ilk sayi ile son yasi arasindaki farki dogrulariz
       Assert.assertEquals(silinmedenOnceDelteButtonSayisi - amount, + silinmedenSonraDeleteButtonSayisi);

    }

}
