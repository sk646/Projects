package demo;

import java.time.Duration;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
    @Test
     public void testCase01() throws InterruptedException {
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform?pli=1");
        WebElement nameText = driver.findElement(By.xpath("//input[@type='text']"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(nameText));
        System.out.println("wait 1");
        Wrappers.enterText(nameText, "Crio Learner"); 
       Thread.sleep(2000);
       
       WebElement practAutoElement = driver.findElement(By.xpath("//textarea[@aria-label='Your answer']"));
    //    practAutoElement.sendKeys("I want to be the best QA Engineer! 1710572021'' where 1710572021 is variable - needs to be the current epoch time");
      String practiceAutomationTextarea ="I want to be the best QA Engineer!";
      String epochTimeString = Wrappers.getEpochTimeasString();
      Thread.sleep(2000);
      Wrappers.enterText(practAutoElement,practiceAutomationTextarea+" "+epochTimeString);
      Thread.sleep(2000);
      System.out.println("wait 3");
      //Select radioButton as per Automation experience
       Wrappers.radioButton(driver,"0 - 2");
       Thread.sleep(3000);
       //Select checkBox for skillsets
       Wrappers.checkBox(driver,"Selenium");
       Wrappers.checkBox(driver,"Java");
       Wrappers.checkBox(driver,"TestNG");
       Thread.sleep(3000);
       
       //click on dropdown
       WebElement dropdowElement = driver.findElement(By.xpath("//div[contains(@class,'DEh1R')]"));
       Thread.sleep(3000);
       System.out.println("wait 4");
       Wrappers.clickonElement(driver,dropdowElement);
       Thread.sleep(3000);
       WebElement textElement = driver.findElement(By.xpath("(//span[text()='Mr'])[2]"));
       Actions keydown = new Actions(driver);
       keydown.moveToElement(textElement).click().perform(); 

    //   System.out.println("wait 5");
   
    //   Wrappers.dropDownClick(driver,"Mr");

      //Enter 7 days before date
      WebElement inputdateElement = driver.findElement(By.xpath("//input[@type='date']"));
      String sevendaysAgoDate = Wrappers.getdatrSevenDaysago();
      Thread.sleep(3000);
      Wrappers.enterText(inputdateElement, sevendaysAgoDate);

      //Enter current time in HH::MM format
      WebElement housElement = driver.findElement(By.xpath("//input[@aria-label='Hour']"));
      WebElement minuteElement = driver.findElement(By.xpath("//input[@aria-label='Minute']"));
      WebElement submitbtn = driver.findElement(By.xpath("//span[text()='Submit']"));

      Wrappers.enterText(housElement, "22");
      Wrappers.enterText(minuteElement, "44");
      Wrappers.clickonElement(driver, submitbtn);
      Thread.sleep(3000);
      System.out.println("wait 7");

      //thanks message confirmation
      WebElement successmsgElement = driver.findElement(By.xpath("//div[@class='vHW8K']"));
      String expectedSuccessmsg = "Thanks for your response, Automation Wizard!";
      Assert.assertEquals(successmsgElement.getText().trim(),expectedSuccessmsg);

     }

}