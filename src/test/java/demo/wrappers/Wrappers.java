package demo.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
     public static void inputText(WebElement element,String text){
      try{
       element.clear();
       element.sendKeys(text);
        
      }catch (Exception e) {
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

     public static String  getEpochTimeasString(){
        Long epochTime = System.currentTimeMillis()/1000;
        String epochTimeString = String.valueOf(epochTime);
        return epochTimeString;
    }
     
    public static String searchButtonText(ChromeDriver driver, WebElement element){
      try {
        element.submit();
    
    }catch (Exception e) {
        e.printStackTrace();
       }
    return null;
    }

    public static void checkBox(ChromeDriver driver, String checkBoxText){
      try {
          WebElement element = driver.findElement(By.xpath("//div[contains(text(),'" +checkBoxText+"')]"));
          element.click();
      } catch (Exception e) {
       e.printStackTrace();
      }
     }
}
