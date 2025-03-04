package com.tubiTV.automation.web.test;



import com.tubiTV.automation.web.pages.BaiduHomePage;
import com.tubiTV.automation.web.utils.BrowserFactory;
import com.tubiTV.automation.web.utils.ScreenshotUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaiduHomePageTest  {
    private static final String HOME_URL = "https://www.baidu.com";
    public  WebDriver driver;
    public final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void testSearch(){
        logger.info("=========  begin test ============  ");

        driver = BrowserFactory.createDriver("chrome");

        logger.info("========  open the url:www.baidu.com ===============");

        // 打开首页，并确认显示成功
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get(HOME_URL);

        String actualTitle = driver.getTitle();

        logger.info("========  assert:确认页面标题包含： 百度一下，你就知道 ===============");
        Assert.assertEquals(actualTitle,"百度一下，你就知道","页面标题应包含核心关键词");

        //确认首页搜索框按钮正常显示
        By search_id = By.id("kw");
        wait.until(ExpectedConditions.presenceOfElementLocated(search_id));
        WebElement searchBox = driver.findElement(search_id);
        logger.info("========  assert：确认首页搜索框按钮正常显示===============");
        Assert.assertTrue(searchBox.isEnabled());



        //确认首页 head正常显示
        By map_name = By.id("head");
        wait.until(ExpectedConditions.presenceOfElementLocated(map_name));
        WebElement map = driver.findElement(map_name);
        logger.info("========  assert：确认首页head正常显示  ===============");
        Assert.assertTrue(map.isEnabled());


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(searchBox.isDisplayed(),"搜索框未正确显示");
        softAssert.assertTrue(map.isDisplayed(),"百度 LOGO图片未正确显示");

        //搜入 “中国北京名胜古迹”，判断正常跳转搜索结果页
        searchBox.sendKeys("中国北京名胜古迹");
        searchBox.submit();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tsn_inner\"]/div[2]/span")));
        wait.withTimeout(Duration.ofSeconds(20));
        logger.info("========  assert：搜索：中国北京名胜古迹，并截图  ===============");
        Assert.assertEquals(driver.getTitle(),"中国北京名胜古迹_百度搜索");

    }


    @Test
    public void testLog() {
        logger.trace("===== This is trace message ===== ");
        logger.info("===== This is info message =====");
        logger.warn("===== This is warn message =====");
        logger.error("===== This is error message =====");
    }

    @AfterMethod
    public void testMethodEnd(ITestResult result){
        if(result.getStatus() == ITestResult.SUCCESS){
            logger.info("======== 测试结束：Success，截图 ===============");
            ScreenshotUtil.captureScreensHot(driver,result.getName() + "_Sucess");

        }else if(result.getStatus() == ITestResult.FAILURE){
            logger.info("======== 测试结束：Failure，截图 ===============");
            com.tubiTV.automation.web.utils.ScreenshotUtil.captureScreensHot(driver,result.getName() + "_Failure");
        }
    }

}
