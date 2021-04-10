public static void main(String[] args) {
        String webDriver = "webdriver.chrome.driver";
        String webDriverPath = ClassUtils.getDefaultClassLoader().getResource("chrome/chromedriver.exe").getPath();
        String mobileUrl = "https://oauth.aliexpress.com/authorize?response_type=code&client_id=28324835&redirect_uri=https://www.aliexpress.com/&state=1212&view=web&sp=ae";
        WebDriver driver = null;
        String username = "cloudmall.inc@gmail.com";
        String password = "32z9Fb08YCCZplpX";
        System.setProperty(webDriver, webDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Accept=text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        options.addArguments("Accept-Encoding=gzip, deflate, sdch");
        options.addArguments("lang=zh_CN.UTF-8");
        options.addArguments("Connection=keep-alive");
        options.addArguments("Host=activityunion-marketing.meituan.com");
        options.addArguments("Upgrade-Insecure-Requests=1");
        options.addArguments("User-Agent=Mozilla/5.0 (iPhone; CPU iPhone OS 8_0 like Mac OS X) AppleWebKit/600.1.3 (KHTML, like Gecko) Version/8.0 Mobile/12A4345d Safari/600.1.4");
        try {
            if (Objects.isNull(driver)){
                driver = new ChromeDriver(options);
                driver.get(mobileUrl);
                Thread.sleep(200);//等待0.2秒
                WebElement usernameWebElement = driver.findElement(By.id("fm-login-id"));
                usernameWebElement.sendKeys(username);
                Thread.sleep(200);
                WebElement passwordWebElement = driver.findElement(By.id("fm-login-password"));
                Thread.sleep(200);
                passwordWebElement.sendKeys(password);
                //模拟滑动
                /*Thread.sleep(1000);
                WebElement draggable = driver.findElement(By.id("nc_1_n1z"));//定位元素
                Actions bu = new Actions(driver); // 声明action对象
                bu.clickAndHold(draggable).build().perform(); // clickAndHold鼠标左键按下draggable元素不放
                bu.moveByOffset(380, 2).perform(); // 平行移动鼠标
                Thread.sleep(200);
                bu.moveByOffset(400, 2).perform(); // 平行移动鼠标
                Thread.sleep(200);
                bu.moveByOffset(420, 2).perform(); // 平行移动鼠标
                Thread.sleep(1500);*/
                WebElement btnWebElement = driver.findElement(By.className("fm-button"));
                btnWebElement.click();
                Thread.sleep(5000);
                String currentUrl = driver.getCurrentUrl();

                driver.quit();
                System.out.println(currentUrl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(driver)) {
                //  driver.close();
            }
        }
    }
