package com.techproed;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day08_BeforeAfterClass {

    @BeforeClass // bu annotationa sahip method ger class calismadan once calisir.
    public static void setUp() {
        System.out.println("setup calisti.");
    }

    @Test
    public void test1(){
        System.out.println("Test 1 calisti. ");
    }

    @Test
    public void test2() {
        System.out.println("Test 2 calisti. ");

    }

    @AfterClass // bu annotationa sahip method her classtaki tester calistirildiktan sonra calisiri.
    public static void tearDown(){
        System.out.println("tearDown calisti. ");
    }

}
