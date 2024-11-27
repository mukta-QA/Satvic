package basePackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

   // FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\environmentVariables\\Config.properties");
    FileInputStream file = new FileInputStream("C:\\Users\\MUKTA\\git\\SatvicMovement\\src\\test\\java\\environmentVariables\\Config.properties");
    //Content root path:src/test/java/environmentVariables/Config.properties
    //"C:\\Users\\MUKTA\\git\\SatvicMovement\\src\\test\\java\\environmentVariables\\Config.properties"
    properties.load(file);
}
//driver path
    //maximize pageload,
public static void initiate() {
    //if browser = chrome then webdriver.chrome.driver;
    // elseif(browser = firefox  then webdriver.gecko.driver;
    //elseif(browser = edge then webdriver.edge.driver;

    String browsername=properties.getProperty("browser");
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
    }
    else if (browsername.equals("Edge"))
    {
        //System.setProperty("webdriver.edge.driver","edgedriver.exe");
        WebDriverManager.edgedriver().setup();
    }
     driver.manage().window().maximize();
     driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS);
     driver.get(properties.getProperty("url"));
    }
}





