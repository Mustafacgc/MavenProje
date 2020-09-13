package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day10_isDisplayed {

    static WebDriver driver; // instance variable
    @BeforeClass
    public static void setUp(){
        //driver'i kullanilabilir hale getiriyoruz.
        WebDriverManager.chromedriver().setup();
        //driver nesnesini olusturalim.
        driver = new ChromeDriver();
        //driver komutlarini girelim.
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){
        //google.com'a gidiyoruz.
        driver.get("http://google.com");
        WebElement logo = driver.findElement(By.id("hplogo"));

        //eger webelement kullaniciya gosteriliyor ise, TRUE
        //eger webelement kullaniciya gosterilmiyor ise, FALSE
        boolean gorunuyorMu = logo.isDisplayed();

        //testimizin sonucunu bildiriyoruz.
        //eger "gorunuyorMu" TRUE ise testim PASSED(BASARILI)
        //eger "gorunuyorMu" FALSE isE testim FAILED(BASARISIZ)
        Assert.assertTrue(gorunuyorMu);
    }

    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }

}

