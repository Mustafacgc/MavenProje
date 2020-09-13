package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day10_isDisplayedOrnek {
    /*
    titleTest      => Sayfa basliginin "Best" icerdigini(contains) dogrulayin
    LogoTest       => BestBuy logosonun goruntulenip goruntulenmedigini dogrulayin.
    mexicoLinkText => Linkin goruntulenip goruntulenmedigini dogrulayin
     */

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
    }

    @Before
            public  void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://bestbuy.com");
        }

   @After
   public void afterMethod(){
        driver.quit();
        }

    @Test
    public void titleTest(){
        String sayfaBasligi = driver.getTitle();
        boolean bestKelimesiniIceriyorMu = sayfaBasligi.contains("Best"); // true ya da false
        Assert.assertTrue(bestKelimesiniIceriyorMu);
    }

    @Test
    public void logoTest(){
        WebElement logo = driver.findElement(By.className("logo"));
        boolean logoGorunuyorMu = logo.isDisplayed(); // true false
        Assert.assertTrue(logoGorunuyorMu);

    }

    @Test
    public void mexiconLinkText(){
        //<a href="https://www.bestbuy.com.mx/">
        //<img src="https://www.bestbuy.com/~assets/bby/_intl/landing_page/images/maps/mexico.svg" alt="Mexico">
        //<h4>Mexico</h4>
        //</a>
        WebElement mexiconLinki = driver.findElement(By.partialLinkText("Mexico"));
        boolean linkGorunuyorMu = mexiconLinki.isEnabled();
        Assert.assertTrue(linkGorunuyorMu);
    }


    @AfterClass
    public static void tearDown(){

    }
}
