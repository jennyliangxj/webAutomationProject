
# web自动化测试框架 Release Note - v1.0.0
## 发布日期：2025-2-28
## 版本类型：功能增强版、
## 兼容性：Java | Chrome | TestNG
----------------------------------------------

# 框架架构

省略待写


# 【🚀🚀====框架基本功能=====🚀🚀🚀】
1. 页面对象模型 (POM) 支持
   新增 BaiduHomePage 类统一管理百度首页元素和操作验证
   新增 TubiHomePage 类统一管理TubiTV首页元素和操作验证

2、支持链式操作
如：baiduPage.open().searchFor("keyword")
tubiPage.open().searchFor("tvName")

3、集成显式等待机制，提升元素操作稳定性

4、自动关联失败用例与屏幕截图

5、新增浏览器控制台日志收集功能

6. 多浏览器支持
   通过 BrowserType 枚举切换不通浏览器：Chrome、IE、Firefox、Edgen

7、支持 Chrome/Firefox/Edge 自动化测试

8、新增 Headless 模式配置选项

# 【✨✨✨=====框架核心优化======✨✨✨】
1、优化 BaseTest 类的浏览器初始化逻辑
2、隐式等待时间从 10s 调整为 5s
3、日志管理
4、日志文件自动按日期归档
5、关键操作增加 DEBUG 级日志追踪
6、配置管理：配置文件迁移至 src/main/resources/config.properties
7、支持环境变量覆盖配置参数



# 【🔄  升级指南=====】
1、依赖更新
<dependency>
<groupId>org.seleniumhq.selenium</groupId>
<artifactId>selenium-java</artifactId>
<version>4.14.1</version>
</dependency>


# 【📥  Git仓库获取方式=====】

`git clone `

# 联系人信息
`jenny.liangxj@gmail.com`

