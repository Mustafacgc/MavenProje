package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day10_DropDown {

    static WebDriver driver; // instance variable

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){
        driver.get("http://amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));

        //Select class'indan nesne uretmeden dropdown uzerinde islem yapamayiz.
        //Eger mulakatta dropdown ile ilgili bir soru gelirse,kesinlikle
        //select class'indan bahsetmeniz gerekiyor.
        Select select = new Select(dropDown);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }

        //Secenegin yazisina gore secim yapabiliriz.
        select.selectByVisibleText("Baby");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }

        //secenegin value attribute'u kullanilarak secim yapilir.
        select.selectByValue("search-alias=automotive-intl-ship");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }

        //Secenegin bulundugu siraya gore secim yapilabilir.
        select.selectByIndex(5);

        //getFirstSelectedOptions - dropdown uzerrinde suanda secili olan
        //webelementi size return eder.
        WebElement secim = select.getFirstSelectedOption();
        System.out.println(secim.getText());

        //getOptions() tum secenekleri List<WebElement> seklinde size return eder.
        List<WebElement> liste = select.getOptions();
        for (WebElement webElement : liste){
            System.out.println(webElement.getText());

        }

        // liste.size() tum seceneklerin toplam sayisini size return eder.
        int toplamSecenekSayisi = liste.size();
        System.out.println("Toplam secim sayisi : "+ toplamSecenekSayisi);


    }
}
