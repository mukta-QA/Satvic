package pomPackage;

import basePackage.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class DetoxUrlPage extends BaseClass {

    //object repository
    @FindBy(id = "register_now_btn")
    private WebElement registerNowFrontleft;
    @FindBy(id = "register_right_button")
    private WebElement registerRightdownbutton;
    @FindBy(xpath = "*//a[@data-btn='top-bar']")
    private WebElement registerNowTopbutton;
    @FindBy(xpath = "*//a[text()='Workshop Login']")
    private WebElement workshopLogin;


    //Scroll-down register now webelements part of page
    @FindBy(id = "register_form")
    private WebElement registerNowForm;
    //name
    @FindBy(id = "name")
    private WebElement username;
    //email
    @FindBy(id = "email")
    private WebElement email;
    //phone
    @FindBy(id = "phone")
    private WebElement phone;
    //place
    @FindBy(id = "city")
    private WebElement city;
    //slotdropbox
    @FindBy(id = "time_slot")
    private WebElement timeslot;

    //ckeckbox
    @FindBy(id = "terms")
    private WebElement termsCheckBox;

    //pay_buttonRegisterNow
    @FindBy(id = "pay_button")
    private WebElement registerNowPaybutton;

//initiate page elements
    public DetoxUrlPage() throws IOException {

        PageFactory.initElements(driver,this);


    }
    Actions actions;
    public void clickOnLeftRegisterNow() throws InterruptedException {
        actions=new Actions(driver);

        actions.moveToElement(registerNowFrontleft);
        Thread.sleep(7000);
        registerNowFrontleft.click();
    }

    public void clickOnTopRightRegisterNow(){
        registerNowTopbutton.click();
    }

    public void clickOnRightDownRegisterNow(){
        registerRightdownbutton.click();
        //driver.manage().timeouts().implicitlyWait()
    }

    public boolean registerNowformIsDisplayed(){
        boolean result=registerNowForm.isDisplayed();
        return result;
    }

    public void enterName(String name){
        username.sendKeys(name);
    }

    public void enterEmail(String emailAddress){
        email.sendKeys(emailAddress);
    }

    public void enterphone(String phoneNumber){
        email.sendKeys(phoneNumber);
    }
    public void enterCity(String place){
        city.sendKeys(place);
    }

    public void clickOnTimeSlotDropdown() throws InterruptedException {
        timeslot.click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(7000);
    }

    public void clickTermsCheckbux(){
        termsCheckBox.click();
    }

    public void clickRegisterNowtopay(){
        registerNowPaybutton.click();
    }

    public String verifyPage(){
        return driver.getTitle();
    }



}
