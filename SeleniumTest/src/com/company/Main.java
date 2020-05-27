package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.sql.SQLException;
import java.time.*;
import java.util.concurrent.TimeUnit;

public class Main{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        long startTime = System.nanoTime();


        System.setProperty("webdriver.gecko.driver", "E:\\My_projects\\Magister\\geckodriver-v0.26.0-win64\\geckodriver.exe");
        String data[] = new String[5];
        String LastStep = "Step 0.";
       /* WebElement element = driver.findElement(By.xpath("//input[@name='emailid']"));
        element.sendKeys("abc@gmail.com");*/


        WebDriver driver = new FirefoxDriver();


        Boolean b1 = false;
        try {


            LastStep = "Step 1. otwarcie strony";
            driver.get("https://moodle.cs.pollub.pl/");
            TimeUnit.SECONDS.sleep(3);

            LastStep = "Step 2. klik jezyk";
            WebElement button = driver.findElement(By.xpath("/html/body/div[1]/nav/ul[1]/li[5]/a"));
            button.click();

          //  TimeUnit.SECONDS.sleep(3);


            LastStep = "Step 3. klik eng";
            button = driver.findElement(By.xpath("/html/body/div[1]/nav/ul[1]/li[5]/div/a[2]"));
            button.click();

         //   TimeUnit.SECONDS.sleep(10);

            LastStep = "Step 4. spradz czy zmieniony";
            b1 = driver.findElement(By.xpath("//h5[contains(text(),'Login')]")).isDisplayed();

            System.out.println("result  " + b1);
            driver.close();

        } catch (Exception e) {
            driver.close();
            System.out.println("result false");
        }
        long endTime = System.nanoTime();
        long timeElapsed = (endTime - startTime)/1000000000;
        data[0] = "8";
        if(b1) data[1] = "1";
        else data[1] = "0";
        data[2] = "" +timeElapsed;
        data[3] = "" + LocalDateTime.now();
        data[4] = LastStep;

        DatabaseConnection.insertData(data);

    }



}
