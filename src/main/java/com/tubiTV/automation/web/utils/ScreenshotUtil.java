package com.tubiTV.automation.web.utils;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 截图相关处理
 * @author: jenny liang
 * @date: 2025/2/24  12:16
 */
public class ScreenshotUtil {

    //创建截图保存目录
    private static final String SCREENSHOT_DIR = System.getProperty("user.dir")
            + File.separator + "screenshots" + File.separator;

    public static Logger logger = LogManager.getLogger(ScreenshotUtil.class);


    /**
     * 捕捉屏幕截图并返回文件路径
     * @param driver
     * @param testName
     * @return 截图文件完整路径
     */
    public static String captureScreensHot(WebDriver driver,String testName){
        try {
            //创建目录（如果不存在）
            File directory = new File(SCREENSHOT_DIR);
            if(!directory.exists()){
                directory.mkdirs();
            }

            //生成带时间戳的文件名
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
            String fileName = testName + "_" + timeStamp + ".png";
            String filePath = SCREENSHOT_DIR + fileName;

            //执行截图操作
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot,new File(filePath));

            logger.info("截图已保存至：" + filePath);
            return  filePath;
        }catch (IOException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            logger.error("Exception error:" ,e.getMessage());
            return  null;
        }
    }
}
