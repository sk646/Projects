package demo.wrappers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
     
      public static void enterText(WebElement element ,String text){
        try {
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
      }
      
      public static void radioButton(ChromeDriver driver, String radioButtonText){
       try {
           WebElement element = driver.findElement(By.xpath("//span[contains(@class,'OvPDhc') and contains(text(),'" +radioButtonText+"')]/../../..//div[@class='vd3tt']"));
           element.click();
       } catch (Exception e) {
        e.printStackTrace();
       }
      }

      public static void checkBox(ChromeDriver driver, String checkBoxText){
        try {
            WebElement element = driver.findElement(By.xpath("//span[contains(@class,'n5vBHf ') and contains(text(),'" +checkBoxText+"')]/../../preceding-sibling::div[contains(@id,'i')]"));
            element.click();
        } catch (Exception e) {
         e.printStackTrace();
        }
       }

       public static void dropDownClick(ChromeDriver driver, String dropDownText){
        try {
            WebElement element = driver.findElement(By.xpath("//div[contains(@class,'QXL7Te')]//span[text()='"+dropDownText+"']"));
            // Select dropdown = new Select(element);
            // dropdown.selectByVisibleText("Mr");
            element.click();
            
        } catch (Exception e) {
         e.printStackTrace();
        }
       }

       public static void clickonElement(ChromeDriver driver, WebElement element){
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",element);
        } catch (Exception e) {
         e.printStackTrace();
        }
       }

     public static String getdatrSevenDaysago(){
        LocalDate currentDate = LocalDate.now();
        LocalDate dateminus7days = currentDate.minusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM//yyyy");
        String formattedDate = dateminus7days.format(formatter);
        return formattedDate;
     }


    public static String  getEpochTimeasString(){
        Long epochTime = System.currentTimeMillis()/1000;
        String epochTimeString = String.valueOf(epochTime);
        return epochTimeString;
    }

}
