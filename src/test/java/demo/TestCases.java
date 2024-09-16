package demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public void testCase01() throws InterruptedException{
        System.out.println("Start testcase01");
        driver.get("https://www.google.com/");
        driver.navigate().to("https://www.flipkart.com/");
        WebElement searchElement = driver.findElement(By.xpath("//input[@type='text']"));
        Wrappers.inputText(searchElement,"Washing Machine");
        Wrappers.searchButtonText(driver, searchElement);
        Thread.sleep(3000);

        WebElement sortElement = driver.findElement(By.xpath("//span[text()='Sort By']/../div[contains(text(),'Popularity')]"));
         Wrappers.clickonElement(driver, sortElement);
         Thread.sleep(3000);

         List<WebElement> lists = driver.findElements(By.xpath("//div[@class='yKfJKb row']/.. //div[text()<='4']"));
         System.out.println(lists.size());
                
         System.out.println("End testcase01");
         }

     @Test
    public void testCase02() throws InterruptedException{
        System.out.println("Start testcase02");
        driver.get("https://www.flipkart.com/");
        WebElement searchElement = driver.findElement(By.xpath("//input[@type='text']"));
        searchElement.clear();
        Wrappers.inputText(searchElement,"iPhone");
        Wrappers.searchButtonText(driver, searchElement);
        Thread.sleep(3000);
        List<WebElement> productTitles = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
        for(WebElement productTitle:productTitles){
            String titletext = productTitle.getText();
            System.out.println(titletext);

        }
        List<WebElement> discountRateElements = driver.findElements(By.xpath("//div[@class='yKfJKb row']/descendant::div[@class='cN1yYO']/div[1]/div[3]"));
        for(int i=0;i<discountRateElements.size();i++){
            String txtElement = discountRateElements.get(i).getText();
            ArrayList<String> sortinglist1 = new ArrayList<>();
            sortinglist1.add(txtElement);
            Collections.sort(sortinglist1);
            Thread.sleep(2000);
            Collections.reverse(sortinglist1);
            System.out.println(sortinglist1);
        }
        System.out.println("End testcase02");
    }

    @Test
    public void testCase03() throws InterruptedException{
        System.out.println("Start testcase03");
        driver.get("https://www.flipkart.com/");
        WebElement srch2 = driver.findElement(By.xpath("//input[@type='text']"));
        Wrappers.inputText(srch2, "Coffee Mug");
        Wrappers.searchButtonText(driver, srch2);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        // WebElement selectrating = driver.findElement(By.xpath("//div[contains(text(),'4★ & above')]/..//preceding-sibling::div[@class='XqNaEv']"));
        // Wrappers.clickonElement(driver,selectrating);
        Wrappers.checkBox(driver, "4★ & above");
        List<WebElement> Titles = driver.findElements(By.xpath("//a[@class='wjcEIp']"));
        for(WebElement title:Titles){
            String titext = title.getText();
        System.out.println(titext);
        }
        List<WebElement> reviewElement = driver.findElements(By.xpath("//span[@class='Wphh3N']"));
        for(int i=0;i<=5;i++){
            String textele = reviewElement.get(i).getText();
         
        ArrayList<String> sortinglist = new ArrayList<>();
        sortinglist.add(textele);
        Collections.sort(sortinglist);
        Thread.sleep(2000);
        Collections.reverse(sortinglist);
        System.out.println(sortinglist);
       }
       List<WebElement> titleElements = driver.findElements(By.xpath("//div[@class='XQDdHH']"));
       for(int i=0;i<=5;i++){
           String text2 = titleElements.get(i).getAttribute("src");
        
       ArrayList<String> sortinglist2 = new ArrayList<>();
       sortinglist2.add(text2);
       Collections.sort(sortinglist2);
       Thread.sleep(2000);
       Collections.reverse(sortinglist2);
       System.out.println(sortinglist2);

       }
      System.out.println("End testcase03");
    }
    }
