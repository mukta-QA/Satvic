package pomPackage;

import basePackage.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class DetoxUrlPage extends BaseClass {

    //object repository
    @FindBy(id = "register_now_btn")
    private WebElement registerNowFrontleft;
    @FindBy(id = "register_right_button")
    private WebElement registerRightdownbutton;
    @FindBy(xpath = "//a[@data-btn='top-bar']")
    private WebElement registerNowTopbutton;
    @FindBy(xpath = "//a[text()='Workshop Login']")
    private WebElement workshopLogin;
    @FindBy(id="loader")
    private WebElement Paymentprogressloader;
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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(registerNowFrontleft)).click();

        //registerNowFrontleft.click();
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
        username.click();
        username.sendKeys(name);
    }

    public void enterEmail(String emailAddress){
        email.click();
        email.sendKeys(emailAddress);
    }

    public void enterphone(String phoneNumber){
        phone.click();
        phone.sendKeys(phoneNumber);
    }
    public void enterCity(String place){
        city.click();
        city.sendKeys(place);
    }

    public void clickOnTimeSlotDropdown() throws InterruptedException {
        timeslot.click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(7000);
    }



    public void clickRegisterNowtopay(){
        registerNowPaybutton.click();
    }

    public String verifyPage(){
        return driver.getTitle();
    }
    public void fillFormWithValidData() throws InterruptedException {
        username.clear();
        username.sendKeys(properties.getProperty("name"));
        email.clear();
        email.sendKeys(properties.getProperty("email"));
        phone.clear();
        phone.sendKeys(properties.getProperty("phone"));
        city.clear();
        city.sendKeys(properties.getProperty("city"));

        Select selectTimeslot = new Select(timeslot);
        selectTimeslot.selectByVisibleText(properties.getProperty("timeslot"));

        if (!termsCheckBox.isSelected()) {
            termsCheckBox.click();
        }



    }
    public void submitForm() {
        // Locate and click the Submit button

        registerNowPaybutton.click();
    }

    public boolean isPaymentProgressdisplayed() {
        try {

            return Paymentprogressloader.getText().contains("Please Wait. . . Payment In Progress. . . ");
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}
