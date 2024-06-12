package org.example;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Faker faker = new Faker();


        // Open the webpage
        driver.get("https://staging.a-d.com.au/new-apartments-developments/vic/moonee-ponds-3039/thomas-street");
        driver.manage().window().fullscreen();

        // Locate and fill the form fields and submit it 20 times
        for (int i = 1; i < 20; i++) {
            // Generate valid data
            String fullName = faker.name().fullName();
            String email = faker.internet().emailAddress();
            String phoneNumber = generatePhoneNumber();
            // Find the input field and fill it with some data
            WebElement enquireButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("span.mat-button-wrapper"))));
            enquireButton.click();
            Thread.sleep(1000);
            WebElement formField =  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("enquirerFrom"))));
            WebElement nameField =  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("[formcontrolname='name'"))));
            WebElement emailField = driver.findElement(By.cssSelector("[formcontrolname='email']"));
            WebElement phoneField = driver.findElement(By.id("phone"));
            WebElement postCode = driver.findElement(By.name("postCode"));
            Select buyerType =new Select(driver.findElement(By.name("buyerType")));
            Select priceRange = new Select(driver.findElement(By.name("priceRange")));
            Select buyingDuration = new Select(driver.findElement(By.name("buyingDuration")));
            Select contactMethod = new Select(driver.findElement(By.name("contactMethod")));
            Select selectPreApproval = new Select(driver.findElement(By.name("selectPreApproval")));
            WebElement scheduleInspection = driver.findElement(By.name("scheduleInspection"));
            WebElement priceInformation = driver.findElement(By.name("priceInformation"));
            WebElement requestFloorPlans = driver.findElement(By.name("requestFloorPlans"));
            WebElement brochure = driver.findElement(By.name("brochure"));
            WebElement messageLink = driver.findElement(By.cssSelector(".add-message-toggle"));
            WebElement messageField = driver.findElement(By.name("message"));
            WebElement submitButton = formField.findElement(By.cssSelector(".enquiry-submit"));
            // Fill the form fields

            nameField.clear();
            nameField.sendKeys(fullName);

            emailField.clear();
            emailField.sendKeys(email);

            phoneField.clear();
            phoneField.sendKeys(phoneNumber);

            postCode.clear();
            postCode.sendKeys(generatePostCode());

            buyerType.selectByIndex(generateRandomNumber(1,6));
            priceRange.selectByIndex(generateRandomNumber(1,13));
            buyingDuration.selectByIndex(generateRandomNumber(1,5));
            contactMethod.selectByIndex(generateRandomNumber(1,3));
            selectPreApproval.selectByIndex(generateRandomNumber(1,2));

            scheduleInspection.click();
            priceInformation.click();
            requestFloorPlans.click();
            brochure.click();
            messageLink.click();
            messageField.sendKeys(fullName +" functionality test_iteration_no "+ i );
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            // Submit the form
            submitButton.click();
            Thread.sleep(3000);
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".sms-close"))));
            closeButton.click();
            Thread.sleep(3000);
        }

        // Close the browser
        driver.quit();
    }

    private static int generateRandomNumber(int min, int max) {
        Random rand = new Random();
        return  rand.nextInt((max - min) + 1) + min;
    }

    private static String generatePostCode() {
        Random rand = new Random();
        StringBuilder postCode = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            int digit = rand.nextInt(9); // Generates a random number between 0 and 9
            postCode.append(digit);
        }
        return  postCode.toString();
    }

    public static String generatePhoneNumber() {
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder("4");
        phoneNumber.append("2");
        // Generate 8 additional random digits
        for (int i = 2; i <=8; i++) {
            int digit = random.nextInt(10); // Generates a random number between 0 and 9
            phoneNumber.append(digit);
        }

        return phoneNumber.toString();
    }
}