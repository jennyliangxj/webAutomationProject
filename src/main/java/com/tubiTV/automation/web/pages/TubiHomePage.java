package com.tubiTV.automation.web.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @description: 首页 Page Object 类
 * @author: jenny liang
 * @date: 2025/2/27  10:41
 */
public class TubiHomePage {
    public WebDriver driver;
    public WebDriverWait wait;

    private static final String HOME_URL = "https://www.tubitv.com";
    private static final String HOME_TITLE = "Watch free Movies and TV Shows online | Tubi";


    //------------------------ 页面元素定义 ------------------------//
   // 搜索输入框
    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/nav/div/div[2]/div/form/input")
    private WebElement searchInput;


    //------------------------ 初始化 ------------------------//
    public TubiHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    //------------------------ 页面操作 ------------------------//
    /**
     * 打开首页
     */
    public TubiHomePage openHomePageUrl() {
        driver.get(HOME_URL);
        return this;
    }

    /**
     * 输入搜索关键词
     * @param keyword 搜索关键词
     */
    public TubiHomePage enterSearchKeyword(String keyword) {
        wait.until(ExpectedConditions.visibilityOf(searchInput))
                .sendKeys(keyword);
        return this;
    }

    /**
     * 执行搜索
     */
    public void performSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchInput))
                .submit();
    }

    //------------------------ 验证方法 ------------------------//
    /**
     * 验证搜索框是否可见
     */
    public boolean isSearchInputDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(searchInput)).isDisplayed();
    }

    /**
     * 验证页面标题
     */
    public boolean isTitleValid() {
        return driver.getTitle().contains(HOME_TITLE);
    }
}
