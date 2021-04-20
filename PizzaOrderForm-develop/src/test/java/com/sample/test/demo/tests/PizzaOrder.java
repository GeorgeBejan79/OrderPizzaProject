package com.sample.test.demo.tests;
import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import components.PizzaOrderForm;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import static com.sample.test.demo.Configuration.readDataFile;

public class PizzaOrder extends TestBase {

    Actions actions = new Actions(driver);
    @Test
    public void PizzaOrderTest() throws IOException {
         actions = new Actions(driver);
        Properties propData = readDataFile("src/test/resources/files/data.txt");
        propData.getProperty("url");
        //.getProperty()
        
        //driver.get("url");
        //select pizza type
        WebElement pizzaTypeDD = driver.findElement(By.xpath("//select[@id='pizza1Pizza']"));
        Select pizzadropDownHandler = new Select(pizzaTypeDD);
        pizzadropDownHandler.selectByVisibleText("Large 10 Slices - 2 toppings");
        PizzaOrderForm.pizza1(PizzaTypes.SMALL_NOTOPPINGS.getDisplayName());

        //select topping1
        WebElement toppings1 = driver.findElement(By.xpath("//select[@class='toppings1']"));
        Select toppings1DownHandler = new Select(toppings1);
        toppings1DownHandler.selectByVisibleText("Mushrooms");

        PizzaOrderForm.toppings1(PizzaToppings.OLIVES.getDisplayName());
        System.out.println();
        WebElement toppings2 = driver.findElement(By.xpath("//select[@class='toppings2'"));
        Select toppings2DownHandler = new Select(toppings2);
        toppings2DownHandler.selectByVisibleText("Italian Ham");

        PizzaOrderForm.toppings2(PizzaToppings.PARMASAN.getDisplayName());

        //enter quantity
        System.out.println("Please enter quantity");
        WebElement quantity = driver.findElement(By.id("//input[@id='pizza1Qty']"));
        actions.sendKeys(quantity, "5");
        PizzaOrderForm.quantity(propData.getProperty("quantity"));

        //enter name
        WebElement nameField = driver.findElement(By.id("//input[@id='name']"));
        actions.sendKeys(nameField, "Tester One").perform();
        PizzaOrderForm.name(propData.getProperty("name"));

        //enter email
        WebElement email = driver.findElement(By.id("//input[@id='email']"));
        actions.sendKeys(email, "test@gmail.com").perform();
        PizzaOrderForm.email(propData.getProperty("email"));

        //enter phone number
        WebElement phoneNumber = driver.findElement(By.id("//input[@id='phone']"));
        actions.sendKeys(phoneNumber, "5107898888");
        PizzaOrderForm.phone(propData.getProperty("phone"));

        //click cash on pickup radio button
        WebElement cashPayment = driver.findElement(By.id("//input[@id='cashpayment']"));
        cashPayment.click();
        Assert.assertTrue(cashPayment.isSelected());
        PizzaOrderForm.cashOnPickup();
        //click place order button
        WebElement placeOrderBtn = driver.findElement(By.id("//button[@id='placeOrder']"));
        placeOrderBtn.click();

        PizzaOrderForm.clickPlaceOrder();

        //Assert.assertTrue();
        //Verify thank you message
        String SuccessMessage = PizzaOrderForm.verifyThankyouMessage();
        Assert.assertEquals(SuccessMessage, propData.getProperty("expectedMessage"));
    }
    @Test
    public void pizzaOrderForm( ) throws IOException {
        //check the title displayed
        Properties propData = readDataFile("src/test/resources/files/data.txt");
        propData.getProperty("url");
        Assert.assertTrue(driver.getTitle().contains("Pizza Order Form"));
    }
    @Test
    public void validateTitlesTest() throws IOException {
        Properties propData = readDataFile("src/test/resources/files/data.txt");
        propData.getProperty("url");
        //verify if pizza1 text
        WebElement pizza1Text=driver.findElement(By.xpath("//div[@id='pizza1']/label[1]"));
        String pizza1ActualText=pizza1Text.getText();
        Assert.assertEquals(pizza1ActualText,"Pizza 1");

                //verify toppings1 text
        WebElement toppings1Text=driver.findElement(By.linkText("Toppings 1"));
        String toppings1actual1Text=toppings1Text.getText();
        Assert.assertEquals(toppings1actual1Text,"Toppings 1");
                    //verify toppings1 text
        WebElement toppings2Text=driver.findElement(By.linkText("Toppings 2"));
        String toppings2actual1Text=toppings2Text.getText();
        Assert.assertEquals(toppings2actual1Text,"Toppings 2");
            //verify toppings1 quantity
        WebElement quantityText=driver.findElement(By.linkText("Quantity"));
        String quantityActualText=quantityText.getText();
        Assert.assertEquals(quantityActualText,"Quantity");

            //verify cost field
        WebElement costText=driver.findElement(By.linkText("Quantity"));
        String costActualText=costText.getText();
        Assert.assertEquals(costActualText,"Quantity");

        //verify pickup info field
        WebElement pickupInfoText=driver.findElement(By.xpath("//div[@id='pickupInfo']/h3"));
        String pickupInfoActualText=pickupInfoText.getText();
        Assert.assertEquals(pickupInfoActualText,"PICKUP INFORMATION ");

        //verify name field
        WebElement nameText=driver.findElement(By.xpath("//div[@id='pickupInfo']/label"));
        String nameActualText=nameText.getText();
        Assert.assertEquals(nameActualText,"Name* ");

        //verify email field
        WebElement emailText=driver.findElement(By.xpath("//div[@id='pickupInfo']/label"));
        String emailActualText=emailText.getText();
        Assert.assertEquals(emailActualText,"Email");

        //verify phone field
        WebElement phoneText=driver.findElement(By.linkText("Phone*"));
        String phoneActualText=phoneText.getText();
        Assert.assertEquals(phoneActualText,"Phone*");

        //verify pickUp info field
        WebElement pickUpInfoText=driver.findElement(By.xpath("//div[@id='pickupInfo']/h3"));
        String pickUpInfoActualText=pickUpInfoText.getText();
        Assert.assertEquals(pickUpInfoActualText,"PICKUP INFORMATION ");

        //verify creditcard radiobtn is there
        WebElement creditCardBtn=driver.findElement(By.xpath("//input[@id='ccpayment']"));
        Assert.assertFalse(creditCardBtn.isSelected());//verify is initially radiobtn is not selected
        creditCardBtn.click();
        Assert.assertEquals(true,creditCardBtn.isSelected());//after click should be selected

        //verify cash radiobtn is there
        WebElement cashCardBtn=driver.findElement(By.xpath("//input[@id='cashpayment']"));
        Assert.assertFalse(cashCardBtn.isSelected());//verify is initially radiobtn is not selected
        cashCardBtn.click();
        Assert.assertEquals(true,cashCardBtn.isSelected());//after click should be selected

                //verify the displayed text on placeOrderBtn
        WebElement placeOrderBtn=driver.findElement(By.id("placeOrder"));
        String placeOrderBtnActualText=placeOrderBtn.getText();
        Assert.assertEquals(placeOrderBtnActualText,"Place Order");

            //verify the displayed text on resetBtn
        WebElement resetBtn=driver.findElement(By.id("placeOrder"));
        String resetBtnActualText=resetBtn.getText();
        Assert.assertEquals(resetBtnActualText,"Reset");

    }
    @Test
    public void pizza1DropDownTest(){

        WebDriver driver = new ChromeDriver();
        actions=new Actions(driver);
        WebElement pizza1TypeDD = driver.findElement(By.xpath("//select[@id='pizza1Pizza']"));
        Select pizza1dropDownHandler = new Select(pizza1TypeDD);

       // pizza1dropDownHandler.click();
        List<WebElement> allOptions = pizza1dropDownHandler.getOptions();

        System.out.println(allOptions.size());

        for (WebElement option : allOptions) {
            System.out.println(option.getText());
        }
    }
}
