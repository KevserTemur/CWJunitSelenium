package Day9_JSEScroll_Cookies_Files;

import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.BaseTest;

import java.util.Set;

public class C4_Cookies extends BaseTest {

    @Test
    public void cookies (){
/*
Go to URL: https://kitchen.applitools.com/ingredients/cookie
Get Cookie.
Find the total number of cookies.
Print all the cookies.
Add Cookie.
Edit Cookie.
Delete Cookie.
Delete All Cookies.
 */
    driver.get("https://kitchen.applitools.com/ingredients/cookie");

        System.out.println("test get cookie");
        Cookie cookie = driver.manage().getCookieNamed("protein");
        Assert.assertEquals("chicken", cookie.getValue());

        Set<Cookie> allCookies = driver.manage().getCookies();
        int numofCookies = allCookies.size();
        System.out.println("numofCookies = " + numofCookies);

        for (Cookie each: allCookies) {
            System.out.println("each cookie : "+ each);
            System.out.println("each cookie name : "+ each.getName());
            System.out.println("each cookie değerleri : "+ each.getValue());
        }

        System.out.println("add cookie");
        Cookie cookie1 = new Cookie("fruit", "apple");
        driver.manage().addCookie(cookie1);
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("cookies sayısı : " + cookies.size());

        System.out.println("edit cookie");
        Cookie editedCookie = new Cookie(cookie1.getName(), "mango");
        driver.manage().addCookie(editedCookie);
        Assert.assertEquals(editedCookie.getValue(), driver.manage().getCookieNamed(cookie1.getValue()));
        System.out.println(driver.manage().getCookieNamed(cookie1.getValue()));

    }

    @Test
    public void deleteCookies (){
        driver.get("https://kitchen.applitools.com/ingredients/cookie");
        System.out.println("delete cookies");
        Cookie addedCookie = new Cookie("drinks", "ayran");
        driver.manage().addCookie(addedCookie);
        driver.manage().deleteCookie(addedCookie);
        Assert.assertNull("cookie halen var", driver.manage().getCookieNamed(addedCookie.getName()));

    }
}
