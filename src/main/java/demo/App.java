package demo;
import java.net.MalformedURLException;


public class App {
    public void getGreeting() throws InterruptedException, MalformedURLException {
        System.out.println("Hello Autmation Wizards!");
        // TestCases tests = new TestCases;
        //  tests.testCase01();

        //  // end testcase
        //  tests.endTest();
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        new App().getGreeting();
    }
}
