package com.tubiTV.automation.web;


/**
 * @description:
 * @author: jenny liang
 * @date: 2025/3/3  18:04
 */
import com.tubiTV.automation.web.utils.BrowserFactory;
import com.tubiTV.automation.web.utils.ScreenshotUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 * Web自动化测试基类
 * 封装浏览器初始化和清理的通用方法
 */
public class TubiBaseTest {

    // 使用protected修饰符便于子类访问
    protected WebDriver driver;
    public final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * 测试前置方法 - 初始化浏览器
     */
    @BeforeClass
    public void setUp() {
        // 自动下载并配置ChromeDriver
        driver = BrowserFactory.createDriver("chrome");
    }

    /**
     * 测试后置方法 - 清理浏览器资源
     */
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (driver != null) {
            //  driver.quit();  // 完全关闭浏览器进程
            // driver.close(); // 仅关闭当前窗口（适合多窗口场景）
        }

        // 如果测试失败自动截图
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.info(" ======= 测试失败,截图如下: ========");
            ScreenshotUtil.captureScreensHot(driver,
                    result.getName() + "_Failure");
        } else {
            logger.info(" ======= 测试成功,截图如下: ========");
            ScreenshotUtil.captureScreensHot(driver,
                    result.getName() + "_Success");
        }
    }

    /**
     * 通用页面跳转方法
     * @param url 目标页面地址
     */
    protected void navigateTo(String url) {
        driver.get(url);
    }
}
