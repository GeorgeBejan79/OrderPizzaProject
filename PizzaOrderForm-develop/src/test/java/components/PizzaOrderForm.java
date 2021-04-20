package components;

import com.sample.test.demo.Configuration;
import com.sample.test.demo.TestBase;
import com.sample.test.demo.utils.PageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class PizzaOrderForm extends TestBase {

    static Map<String, String> prop = Configuration.HashMapFromTextFile();

    public static void pizza1 (String pizzaType) {
        Select pizza1 = PageUtil.ByID(prop.get("pizza1ID"), driver);
        pizza1.selectByValue(pizzaType);
    }

    public static void toppings1 (String toppings1) {
//        Select Toppings1 = PageUtil.ByXPath("//div[@id='pizza1']//select[@class='toppings1']", driver);
        Select Toppings1 = PageUtil.ByXPath(prop.get("pizza1Toppings1xpath"), driver);
        Toppings1.selectByValue(toppings1);
    }

    public static void toppings2 (String toppings2) {
        Select Toppings2 = PageUtil.ByXPath(prop.get("pizza1Toppings2xpath"), driver);
        Toppings2.selectByValue(toppings2);
    }

    public static void quantity (String quantity) {
        //driver.findElement(By.id("pizza1Qty")).sendKeys(quantity);
        driver.findElement(By.id(prop.get("pizza1QuantityID"))).sendKeys(quantity);
    }

    public static void name (String name) {
        driver.findElement(By.id(prop.get("nameID"))).sendKeys(name);
    }

    public static void email (String email) {
        driver.findElement(By.id(prop.get("emailID"))).sendKeys(email);
    }

    public static void phone (String phone) {
        driver.findElement(By.id(prop.get("phoneID"))).sendKeys(phone);
    }

    public static void cashOnPickup () {
        driver.findElement(By.id(prop.get("radioCashID"))).click();
    }

    public static void clickPlaceOrder () {
        //driver.findElement(By.id("placeOrder")).click();
        driver.findElement(By.id(prop.get("placeOrderButtonID"))).click();
    }

    public static String verifyThankyouMessage () {
        String thankYouMessage = driver.findElement(By.id(prop.get("dialogID"))).getText();
        return thankYouMessage;
    }

}
