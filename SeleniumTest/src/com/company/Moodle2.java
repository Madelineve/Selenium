package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.sql.SQLException;
import java.time.*;
import java.util.concurrent.TimeUnit;

public class Moodle2{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        long startTime = System.nanoTime();


       // System.setProperty("webdriver.gecko.driver", "E:\\My_projects\\Magister\\geckodriver-v0.26.0-win64\\geckodriver.exe");

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        String data[] = new String[5];
        String LastStep = "Step 0.";
       /* WebElement element = driver.findElement(By.xpath("//input[@name='emailid']"));
        element.sendKeys("abc@gmail.com");*/


        //WebDriver driver = new FirefoxDriver();

        WebDriver driver = new ChromeDriver();


        Boolean b1 = false;
        try {

            int i= 1;
            LastStep = "Step " + i + " otwarcie strony";
            driver.get("https://moodle1.cs.pollub.pl/");
            TimeUnit.SECONDS.sleep(3);

            driver.manage().window().maximize();

            i++;
            LastStep = "Step " + i + " wpisz login ********";
            WebElement button = driver.findElement(By.id("login_username"));
            button.sendKeys("**********");

            //  TimeUnit.SECONDS.sleep(3);

            i++;
            LastStep = "Step " + i + " wpisz hasło";
            button = driver.findElement(By.id("login_password"));
            button.sendKeys("***********");

            //   TimeUnit.SECONDS.sleep(10);
            i++;
            LastStep = "Step " + i + " klik zaloguj";
            button = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/section[2]/aside/section[1]/div/div/form/div[4]/input"));
            button.click();

            TimeUnit.SECONDS.sleep(1);

            i++;
            LastStep = "Step " + i + " klik ikona wiadomosci";
            button = driver.findElement(By.xpath("//*[@id=\"nav-message-popover-container\"]"));
            button.click();

            TimeUnit.SECONDS.sleep(1);

            i++;
            LastStep = "Step " + i + " klik kontakt \"Magdalena Ewa Psujek\"";
            button = driver.findElement(By.xpath("//h3[contains(text(),'Magdalena Ewa Psujek')]"));
            button.click();

            TimeUnit.SECONDS.sleep(1);


            i++;
            LastStep = "Step " + i + " wpisz wiadomosc";
            button = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/section/div/div/div/div/div/div[2]/div[3]/div[1]/div[1]/textarea"));
            button.sendKeys("to jest wiadomość testowa");

            i++;
            LastStep = "Step " + i + " klik wyślij";
            button = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/section/div/div/div/div/div/div[2]/div[3]/div[1]/div[2]/button"));
            button.click();

            i++;
            LastStep = "Step " + i + " klik wyloguj";
            button = driver.findElement(By.xpath("/html/body/footer/div/div[2]/a[2]"));
            button.click();




            i++;
            LastStep = "Step " + i + " wpisz login ***********";
            button = driver.findElement(By.id("login_username"));
            button.sendKeys("***********");

            //  TimeUnit.SECONDS.sleep(3);

            i++;
            LastStep = "Step " + i + " wpisz hasło";
            button = driver.findElement(By.id("login_password"));
            button.sendKeys("************");

            //   TimeUnit.SECONDS.sleep(10);
            i++;
            LastStep = "Step " + i + " klik zaloguj";
            button = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/section[2]/aside/section[1]/div/div/form/div[4]/input"));
            button.click();

            TimeUnit.SECONDS.sleep(1);

            i++;
            LastStep = "Step " + i + " klik ikona wiadomosci";
            button = driver.findElement(By.xpath("//*[@id=\"nav-message-popover-container\"]"));
            button.click();

            TimeUnit.SECONDS.sleep(1);

            i++;
            LastStep = "Step " + i + " klik kontakt \"Aleksandra Joanna Radzik\"";
            button = driver.findElement(By.xpath("//h3[contains(text(),'Aleksandra Joanna Radzik')]"));
            button.click();


            i++;
            LastStep = "Step " + i + " sprawdz czy dostarczono wiadomosc";
            b1 = driver.findElement(By.xpath("//p[contains(text(),'to jest wiadomość testowa')]")).isDisplayed();

            System.out.println("result  " + b1);

            TimeUnit.SECONDS.sleep(1);

            i++;
            LastStep = "Step " + i + " klik modyfikuj";
            button = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/section/div/div/div/div/div/div[2]/div[1]/div[5]/button[1]"));
            button.click();

            TimeUnit.SECONDS.sleep(1);

            i++;
            LastStep = "Step " + i + "zaznacz wiadomosc";
            button = driver.findElement(By.xpath("//p[contains(text(),'to jest wiadomość testowa')]"));
            button.click();

            TimeUnit.SECONDS.sleep(1);

            i++;
            LastStep = "Step " + i + "usun wiadomosc";
            button = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/section/div/div/div/div/div/div[2]/div[3]/div[2]/button"));
            button.click();

            i++;
            LastStep = "Step " + i + " klik wyloguj";
            button = driver.findElement(By.xpath("/html/body/footer/div/div[2]/a[2]"));
            button.click();
            driver.close();

        } catch (Exception e) {
            driver.close();
            b1=false;
            System.out.println("result false   "+LastStep);
        }
        long endTime = System.nanoTime();
        long timeElapsed = (endTime - startTime)/1000000000;
        data[0] = "9";
        if(b1) data[1] = "1";
        else data[1] = "0";
        data[2] = "" +timeElapsed;
        data[3] = "" + LocalDateTime.now();
        data[4] = LastStep;

        DatabaseConnection.insertData(data);

    }



}
