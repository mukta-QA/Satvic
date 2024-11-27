package pomPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetoxUrlPage {
    @FindBy(id = "register_now_btn")
    private WebElement registerNowMid;
    @FindBy(id = "register_right_button")
    private WebElement registerRightbutton;
    @FindBy(xpath = "*//a[text()='Workshop Login']")
    private WebElement workshopLogin;
    @FindBy(xpath = "*//a[@data-btn='top-bar']")
    private WebElement registerNowTopbutton;

    //Scroll-down register now webelements part of page
    @FindBy(id = "register_form")
    private WebElement registerNowForm;
    //name
    @FindBy(id = "name")
    private WebElement name;
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

    //pay_button
    @FindBy(id = "pay_button")
    private WebElement termsCheckBox;






}
