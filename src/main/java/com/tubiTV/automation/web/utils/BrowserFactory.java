package com.tubiTV.automation.web.utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 *  浏览器驱动管理
 */
public class BrowserFactory {

    public static WebDriver createDriver(String browserType) {
        WebDriver driver = null;
        switch (browserType.toLowerCase()) {
            case "chrome":
               // 初始化一个chrome浏览器驱动，设置页面加载超时时间为10秒
                WebDriverManager.chromedriver().setup();

                // 浏览器配置选项
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");        // 最大化窗口
                options.addArguments("--disable-notifications");  // 禁用通知
                options.addArguments("--disable-extensions");     // 禁用扩展


//                // 禁用Cookie提示的配置参数
//                options.addArguments("--disable-cookie-encryption");
//                options.addArguments("--disable-web-security");
//                options.addArguments("--allow-running-insecure-content");

                // 初始化浏览器实例
                driver = new ChromeDriver(options);

                // 全局等待配置
                driver.manage().timeouts()
                        .implicitlyWait(Duration.ofSeconds(10))    // 隐式等待
                        .pageLoadTimeout(Duration.ofSeconds(15));   // 页面加载超时
                 break;
            case "firefox":
                //初始化一个 firefox 浏览器驱动，设置页面加载超时时间为 10秒
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(10));
                break;

            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported brower: " + browserType);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }


}
