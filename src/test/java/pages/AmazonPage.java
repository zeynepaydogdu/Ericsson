package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AmazonPage {
    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "a-autoid-0")
    public WebElement cookiesAccept;

    @FindBy(id = "nav-link-accountList")
    public WebElement movetoLogin;
    @FindBy(xpath = "//span[@class='nav-action-inner']")
    public WebElement login;
    @FindBy(xpath = "//input[@id='ap_email']")
    public WebElement ePosta;
    @FindBy(xpath = "//span[@id='continue']")
    public WebElement continueButton;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;
    @FindBy(id = "auth-signin-button")
    public WebElement signIn;
    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(xpath = "//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']")
    public List<WebElement> samsungResult;

    @FindBy(xpath = "//span[@class='a-size-base-plus a-color-base a-text-normal']")
    public WebElement product;

    @FindBy(xpath = "//span[@class='a-price-whole']")
    public List<WebElement> price;

    @FindBy(xpath = "(//input[@id='add-to-wishlist-button'])")
    public WebElement addList;

    @FindBy(xpath = "//span[@class='a-size-small atwl-hz-vertical-align-middle']")
    public WebElement newList;

    @FindBy(xpath = "(//input[@class='a-button-input a-declarative'])[3]")
    public WebElement creatList;

    @FindBy(xpath = "//span[@id='wishListMainButton']")
    public WebElement listeAc;
    @FindBy(xpath = "(//input[@class='a-button-input a-declarative'])[3]")
    public WebElement urunEkle;

    @FindBy(xpath = "(//span[@class='a-button a-button-base'])[10]")
    public WebElement urunuGoruntule;

    @FindBy(xpath = "//a[@class='a-button-text']")
    public WebElement listeyiGoruntule;

    @FindBy(xpath = "(//a[@class='a-link-normal'])[11]")
    public WebElement urunDogrula;

    @FindBy(name = "submit.deleteItem")
    public WebElement delete;

    @FindBy(xpath = "(//div[@class='a-box-inner a-alert-container'])[11]")
    public WebElement deleteIcon;

    @FindBy(xpath = "(//i[@class='a-icon a-icon-alert'])[11]")
    public WebElement deleteAssert;
}
