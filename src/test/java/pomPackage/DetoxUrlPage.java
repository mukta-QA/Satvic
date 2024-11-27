package pomPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetoxUrlPage {
    @FindBy(id = "register_now_btn")
    private WebElement registerNow;
    @FindBy(id = "register_right_button")
    private WebElement registerRightbutton;
    @FindBy(xpath = "*//a[text()='Workshop Login']")
    private WebElement workshopLogin;



}
