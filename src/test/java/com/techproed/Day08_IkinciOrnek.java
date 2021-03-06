package com.techproed;

import com.google.gson.stream.JsonToken;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day08_IkinciOrnek {
    //neden burada tanimladik?
    //Cunku, diger methodlardan da, yani tum methodlardan bu nesneye erismek isriyoruz.
    //Cunku, findElement gibi methodlari ister istemez test'lerin icinde kullanacagiz.
    static WebDriver driver;

    @BeforeClass // class calismaya baslayinca calisacak
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass // class calismayi bitirince calisacak
    public static void tearDown(){
        driver.quit();

    }

    @Before// her test methodundan once calisacak.
    public void testtenOnce(){
        driver.get("https://google.com");

    }

    @After// her test methodundan sonra calisacak.
    public void testtenSonra(){
        WebElement sonucSayisi = driver.findElement(By.id("result-stats"));
        System.out.println(sonucSayisi.getText());

    }

    @Test
    public void test1(){
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        aramaKutusu.sendKeys("elma");
        aramaKutusu.submit();

    }

    @Test
    public void test2(){
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        aramaKutusu.sendKeys("samsung kulaklik");
        aramaKutusu.submit();

    }

    @Test
    public void test3(){
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        aramaKutusu.sendKeys("calisma sandalyesi");
        aramaKutusu.submit();

    }




}
