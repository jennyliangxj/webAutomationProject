package com.tubiTV.automation.web.test;


import com.tubiTV.automation.web.TubiBaseTest;
import com.tubiTV.automation.web.pages.BaiduHomePage;
import com.tubiTV.automation.web.pages.TubiHomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @description:
 * @author: jenny liang
 * @date: 2025/2/27  11:15
 */
public class TubiHomeTestWithPageObject extends TubiBaseTest {

    private TubiHomePage homePage;
    private String search_movie_name = "ATL";

    @BeforeClass
    public  void setup(){
        homePage = new TubiHomePage(driver);
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
        homePage.enterSearchKeyword(search_movie_name);
        homePage.performSearch();
    }
}
