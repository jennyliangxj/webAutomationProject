package com.tubiTV.automation.web.test;


import com.tubiTV.automation.web.TubiBaseTest;
import com.tubiTV.automation.web.pages.BaiduHomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @description: 百度首页 web 自动化测试脚本（基于BaiduHomePage 类的 PageObject 分层封装）
 * @author: jenny liang
 * @date: 2025/2/26  20:20
 */
public class BaiduHomePageTestWithPageObject extends TubiBaseTest {

    private static BaiduHomePage homePage ;
    private  String searchKeyInput = "北京名声古迹景点有哪些";


    @BeforeClass
    public  void setup(){
        homePage = new BaiduHomePage(driver);
    }


    @Test(description = "测试首页可以打开")
    public void testHomePageAccessibility(){
        logger.info("======测试首页可以打开 ========  ");
        homePage.openHomePageUrl();
    }


    @Test(description = "测试搜索功能")
    public  void testBasicSearchFunction(){
        logger.info("======测试首页可以打开 ========  ");
        homePage.openHomePageUrl();

        logger.info("======测试搜索框正常显示 ========  ");
        homePage.isSearchInputDisplayed();

        logger.info("======测试搜索功能 ========  ");
        homePage.enterSearchKeyword(searchKeyInput);
        homePage.performSearch();
    }
}
