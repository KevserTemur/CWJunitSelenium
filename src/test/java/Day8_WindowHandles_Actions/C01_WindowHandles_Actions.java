package Day8_WindowHandles_Actions;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.BaseTest;
import java.util.Iterator;
import java.util.Set;


public class C01_WindowHandles_Actions extends BaseTest {


    @Override
    public void tearDown() {
    }

    @Test
    public void newWindow(){


        // https://testproject.io/
        // https://blog.testproject.io/


        driver.get("https://testproject.io/");
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://blog.testproject.io/");

    }

    @Test
    public void newtab(){
        // ana sekmemizden test project açıldı
        driver.get("https://testproject.io/");
        //yeni bir sekme oluşturuldu
        WebDriver newTab = driver.switchTo().newWindow(WindowType.WINDOW);
        // yeni sekmeden amazon a gidildi
        newTab.get("https://www.amazon.com/");
        // aktif tab ın title ı yazdırıldı => aktif tab ımız = yeni oluşturulan tab
        System.out.println(driver.getTitle());
    }

    @Test
    public void handleWindows(){
        // ana sekmemmizde amazon açıldı
        driver.get("https://www.amazon.com/");
        // getWindowHandle()  => getWindowHandles()


        String homePageHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.amazon.com/");

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.google.com/");

        Set<String> handles = driver.getWindowHandles();
       Iterator<String> i = handles.iterator();

       while (i.hasNext()){
           String currentTab = i.next();
           driver.switchTo().window(currentTab);
          // driver.switchTo().window(id)
          // System.out.println(i.next());
           System.out.println(driver.getTitle());

           // 1. yol
        // if (!driver.getWindowHandle().equals(homePageHandle)){
        //     driver.close();
        // }

           //2. yol

           if (!driver.getTitle().contains("Spend"));
           driver.close();
       }
    }
}
