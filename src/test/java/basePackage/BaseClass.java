package basePackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.TimeUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

public static Properties properties=new Properties();
public static WebDriver driver;
//Constructor of Base Class
public BaseClass() throws IOException {

    FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\environmentVariables\\Config.properties");
    System.out.println(file.toString());
   // FileInputStream file = new FileInputStream("C:\\Users\\MUKTA\\git\\SatvicMovement\\src\\test\\java\\environmentVariables\\Config.properties");
    //Content root path:src/test/java/environmentVariables/Config.properties
    //"C:\\Users\\MUKTA\\git\\SatvicMovement\\src\\test\\java\\environmentVariables\\Config.properties"
    properties.load(file);
}

public static WebDriver initiate() {


    String browsername=properties.getProperty("browsername");
    //String browsername="Chrome";
    if (browsername.equals("FireFox"))
    {
       // System.setProperty("webdriver.gecko.driver","geckodriver.exe");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    else if (browsername.equals("Chrome"))
    {
       // System.setProperty("webdriver.chrome.driver","src//test//resources//Driver//chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();

        try {
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        } catch (Exception e) {
            System.out.println("Error initializing WebDriver: " + e.getMessage());
        }

    }
    else if (browsername.equals("Edge"))
    {
        //System.setProperty("webdriver.edge.driver","edgedriver.exe");
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
    }
     driver.manage().window().maximize();
     driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS);
     driver.get(properties.getProperty("url"));
     return driver;
    }

}





