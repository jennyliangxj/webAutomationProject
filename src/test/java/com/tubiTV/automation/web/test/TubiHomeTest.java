package com.tubiTV.automation.web.test;


/**
 * @description:
 * @author: jenny liang
 * @date: 2025/2/27  18:05
 */
import com.tubiTV.automation.web.TubiBaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 首页测试用例
 * 验证基本功能的可用性
 */
public class TubiHomeTest extends TubiBaseTest {

    // 页面元素定位器
    private static final String HOME_URL = "https://www.tubitv.com";
    private static final String  SEARCH_INPUT = "//*[@id=\"app\"]/div[3]/nav/div/div[2]/div/form/input";

    private static final String SEARCH_RESULTSFor = "//*[@id=\"app\"]/div[3]/div/div[1]/div[1]/span";
    private static final String SEARCH_RESULT_H1 = "//*[@id=\"app\"]/div[3]/div/div[1]/div[1]/h1";

    // 页面元素
    private static final String HOME_TITLE = "Watch free Movies and TV Shows online | Tubi";
    private static final String SEARCH_MOVIE_NAME_RESULTFOR  = "Results for";
    private static final String SEARCH_MOVIE_NAME = "Lucy Shimmers' Christmas Miracle";

    /**
     * 测试首页可访问性
     * 验证点：
     * 1. 页面能正常打开
     * 2. 页面标题正确
     */
    @Test(description = "验证首页基本功能")
    public void testHomePageAccessibility() {
        // 访问首页
        logger.info("===== 打开首页：" +  HOME_URL + "=======") ;
        navigateTo(HOME_URL);

        // 验证页面标题
        logger.info("===== 验证页面标题：" +  HOME_TITLE + "=======") ;
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("HOME_TITLE"),
                "页面标题验证失败，实际标题：" + actualTitle);
    }

    /**
     * 测试搜索功能
     */
    @Test(description = "验证基本搜索功能")
    public void testBasicSearchFunction() {
        navigateTo(HOME_URL);

        logger.info("===== 验证首页搜索功能  =======");
        driver.findElement(By.xpath(SEARCH_INPUT)).sendKeys(SEARCH_MOVIE_NAME);
        driver.findElement(By.xpath(SEARCH_INPUT)).submit();

        logger.info("===== 验证搜索结果页：存在 Results For =======");
        String acturalResultFor = driver.findElement(By.xpath(SEARCH_RESULTSFor)).getText();
        Assert.assertEquals(acturalResultFor,SEARCH_MOVIE_NAME_RESULTFOR);

        logger.info("===== 验证搜索结果页：包含该电影名字 =======");
        String acturalSearchMovieName = driver.findElement(By.xpath(SEARCH_RESULT_H1)).getText();
        Assert.assertEquals(acturalSearchMovieName,SEARCH_MOVIE_NAME);
    }
}