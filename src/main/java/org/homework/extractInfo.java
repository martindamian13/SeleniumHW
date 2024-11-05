package org.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class extractInfo {
    public static void main(String[] args) {
        // setup ChromeDriver
        WebDriver driver = new ChromeDriver();

        try{
            driver.get("https://demo.applitools.com/");

            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement submitButton = driver.findElement(By.id("log-in"));

            usernameField.sendKeys("Martin");
            passwordField.sendKeys("12345");
            submitButton.click();

            // Recibir datos de la pantalla e imprimirlos
            WebElement totalBalance = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div[2]/div/div/div/div[1]/div[2]/span[1]"));
            WebElement creditAvailable = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div[2]/div/div/div/div[2]/div[2]"));
            System.out.println("Total balance: " + totalBalance.getText() + " Credit available: " + creditAvailable.getText());

            for (int i = 1; i <= 5; i++){
                WebElement description = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[2]/div/div/table/tbody/tr["+ i +"]/td[3]/span"));
                WebElement status = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[2]/div/div/table/tbody/tr["+ i +"]/td[1]/span[2]"));
                WebElement Amount = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[2]/div/div/table/tbody/tr["+ i +"]/td[5]/span"));
                System.out.println("Description: " + description.getText() + " | Status: " + status.getText() + " | Amount: " + Amount.getText());
            }

        } finally {
            driver.quit();
        }
    }
}
