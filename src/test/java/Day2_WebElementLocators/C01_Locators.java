package Day2_WebElementLocators;


   import io.github.bonigarcia.wdm.WebDriverManager;
    import org.junit.After;
    import org.junit.Before;
    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;

    public class C01_Locators {

        WebDriver driver;

        @Before
        public void setup(){

            //Driver olusturuldu
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            //LinkedIn sitesine gidildi
            driver.get("https://www.linkedin.com/");

            // driver imiz maximize edildi
            driver.manage().window().maximize();
        }

        @After
        public void tearDown(){

            // driver imiz kapatildi
            //driver.quit();
        }

        @Test
        public void idLocator(){
            // id Locator -> "session_key"

            WebElement email = driver.findElement(By.id("session_key"));
            email.sendKeys("Clarusway selenium dersinden selamlar");

        }

        @Test
        public void nameLocator(){
            // name locator -> "session_password"

            WebElement password = driver.findElement(By.name("session_password"));

            password.sendKeys("Sifre");
        }

        @Test
        public void classLocator(){
            // class locator "input__input"

            WebElement email = driver.findElement(By.className("input__input"));
            email.sendKeys("Class locator test");
        }





    }