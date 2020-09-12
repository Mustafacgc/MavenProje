package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day08_IlkOrnek {
    //neden burada tanimladik?
    //Cunku, diger methodlardan da, yani tum methodlardan bu nesneye erismek isriyoruz.
    //Cunku, findElement gibi methodlari ister istemez test'lerin icinde kullanacagiz.
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){
        //Google.com'a gidecegim.
        // Sayfanin title'na bakacagim. Google kelimesi geciyorsa,test basarili.
        driver.get("https://google.com");

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2(){
        driver.get("https://amazon.com");

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDown(){ driver.quit();


    }
}
