package testLayer;

import basePackage.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pomPackage.DetoxUrlPage;
import utility.TimeUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RegistorNowTest extends BaseClass {
    WebDriverWait driverWait;
    DetoxUrlPage detoxUrlPage;
    SoftAssert assertS;

    public RegistorNowTest() throws IOException {
        super();
    }
    //@Parameters("browser")
    @BeforeTest
    public void initsetup() throws IOException {
        //initsetup();
        initiate();

    }
    @BeforeClass
    public void pomPageLaunch() throws IOException {
        detoxUrlPage= new DetoxUrlPage();
    }


    @Test(priority = 1)
    public void Verifytitle(){
        assertS=new SoftAssert();
        String actualTitle=detoxUrlPage.verifyPage();
        System.out.println("Actual Title= "+actualTitle);
        assertS.assertEquals(actualTitle,"2-Hour Detox Masterclass");
        assertS.assertAll();
    }
    @Test(priority=2)
    public void VerifyTopRegisterNowbuttonReachesRegistorNowForm() throws InterruptedException {
        detoxUrlPage.clickOnTopRightRegisterNow();
           Thread.sleep(7000);
      boolean actualResult=detoxUrlPage.registerNowformIsDisplayed();

        assertS=new SoftAssert();
        assertS.assertEquals(actualResult,true,"Form is not visible yet");
        assertS.assertAll();
    }
//can be used for verifying other registor now buttons
   /* @Test(priority=3)
    public void VerifyLeftRegisterNowbuttonReachesRegisterNowForm() throws InterruptedException {
        detoxUrlPage.clickOnLeftRegisterNow();
        Thread.sleep(7000);
        boolean actualResult=detoxUrlPage.registerNowformIsDisplayed();

        assertS=new SoftAssert();
        assertS.assertEquals(actualResult,true,"Form is not visible yet");
        assertS.assertAll();
    }*/

    @Test(priority = 3)
    public void VerifyFormisSubmittedwithValidData(){
    boolean formisvisible=detoxUrlPage.registerNowformIsDisplayed();
    if (formisvisible)
    {
        detoxUrlPage.enterName();
    }
    }

    @AfterClass
    public void objectClear() {
        detoxUrlPage=null;

    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver=null;
        System.gc();
    }
    }


