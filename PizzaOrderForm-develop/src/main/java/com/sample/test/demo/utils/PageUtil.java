package com.sample.test.demo.utils;

import com.sample.test.demo.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PageUtil extends TestBase {

    public static Select ByID(String id, WebDriver driver) {
        Select ByID = new Select(driver.findElement(By.id(id)));
        return ByID;
    }

    public static Select ByXPath(String xpath, WebDriver driver) {
        Select ByXpath = new Select(driver.findElement(By.xpath(xpath)));
        return ByXpath;
    }
}