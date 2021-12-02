package tests;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;


public class Test01 extends TestBaseRapor {
    AmazonPage page = new AmazonPage();
    Actions actions = new Actions(Driver.getDriver());
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),20);
    @Test
    public void tets01() throws InterruptedException {
        extentTest = extentReports.createTest("Amazon", "Gecerli bilgilerle login testi");
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        extentTest.info("Amazon sayfasina gidildi");
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), ConfigReader.getProperty("amazon_url"));
        extentTest.pass("Basarili giris yapildigi test edildi");
        page.cookiesAccept.click();
        actions.moveToElement(page.movetoLogin).perform();
        page.login.click();
        page.ePosta.sendKeys(ConfigReader.getProperty("email"));
        page.continueButton.click();
        page.password.sendKeys(ConfigReader.getProperty("password"));
        page.signIn.click();
        extentTest.info("Gecerli bilgilerle login olundu");
        page.searchBox.sendKeys(ConfigReader.getProperty("item") + Keys.ENTER);
        extentTest.info("Urun aramasi yapildi");

        String result="";
        int sira=0;

        for (int i = 0; i < page.samsungResult.size(); i++) {
             System.out.println(page.samsungResult.get(i).getText());
             if (page.samsungResult.get(i).getText().contains(ConfigReader.getProperty("urun"))){
                result=page.samsungResult.get(i).getText();
                sira=i;
            }
        }
        extentTest.info("Sayfadaki tum urunler liste atildi ve yazdirildi");
        Assert.assertTrue(result.contains(ConfigReader.getProperty("urun")));
        extentTest.pass("Istenen urun sayfada goruntulendi");
        System.out.println(page.price.get(sira).getText());
        extentTest.info("urunun fiyati yazdirildi");
        page.samsungResult.get(sira).click();
        extentTest.info("Urunun icine gidildi");
        actions.sendKeys(Keys.DOWN).perform();
        page.addList.click();
        page.newList.click();
        page.creatList.click();
        extentTest.info("olusturulan shopping liste urun eklendi");
        wait.until(ExpectedConditions.visibilityOf(page.listeyiGoruntule));
        page.listeyiGoruntule.click();
        Assert.assertTrue(page.urunDogrula.isDisplayed());
        extentTest.pass("ShopppingListeki urun goruntulendi");
        page.delete.click();
        extentTest.info("urun silindi");
        wait.until(ExpectedConditions.visibilityOf(page.deleteAssert));
        Assert.assertTrue(page.deleteAssert.isDisplayed());
        extentTest.pass("Listenin bos oldugu goruntulendi");

        }
    }
