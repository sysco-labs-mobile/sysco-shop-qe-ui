package com.qe;

import com.aventstack.extentreports.Status;
import com.qe.reports.ExtentReport;
import com.qe.utils.TestUtils;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.ThreadContext;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BaseTest {
    protected static ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
    protected static ThreadLocal<Properties> props = new ThreadLocal<Properties>();
    protected static ThreadLocal<HashMap<String, String>> strings = new ThreadLocal<HashMap<String, String>>();
    protected static ThreadLocal<String> platform = new ThreadLocal<String>();
    protected static ThreadLocal<String> dateTime = new ThreadLocal<String>();
    protected static ThreadLocal<String> deviceName = new ThreadLocal<String>();
    protected static ThreadLocal<String> androidBitrise = new ThreadLocal<String>();
    protected static ThreadLocal<String> isIosTablet = new ThreadLocal<String>();
    private static AppiumDriverLocalService server;
    public static JSONObject users;
    public static JSONObject products;
    TestUtils utils = new TestUtils();

    public AppiumDriver getDriver() {
        return driver.get();
    }

    public void setDriver(AppiumDriver driver2) {
        driver.set(driver2);
    }

    public Properties getProps() {
        return props.get();
    }

    public void setProps(Properties props2) {
        props.set(props2);
    }

    public HashMap<String, String> getStrings() {
        return strings.get();
    }

    public void setStrings(HashMap<String, String> strings2) {
        strings.set(strings2);
    }

    public String getPlatform() {
        return platform.get();
    }

    public void setPlatform(String platform2) {
        platform.set(platform2);
    }

    public String getIosTablet() {
        return isIosTablet.get();
    }

    public void setIosTablet(String isTablet) {
        isIosTablet.set(isTablet);
    }

    public String getDateTime() {
        return dateTime.get();
    }

    public void setDateTime(String dateTime2) {
        dateTime.set(dateTime2);
    }

    public String getDeviceName() {
        return deviceName.get();
    }

    public void setDeviceName(String deviceName2) {
        deviceName.set(deviceName2);
    }

    public void setAndroidBitrise(String androidBitrise2) {
        androidBitrise.set(androidBitrise2);
    }

    public String getAndroidBitrise() {
        return androidBitrise.get();
    }

    public BaseTest() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver(), Duration.ofSeconds(15)), this);
    }


    @BeforeClass
    public void beforeClass() throws Exception {
        InputStream datais = null;
        try {
            String dataFileName = "data/users.json";
            datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener tokener = new JSONTokener(datais);
            users = new JSONObject(tokener);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (datais != null) {
                datais.close();
            }
        }
        datais = null;

        try {
            String dataFileName = "data/products.json";
            datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener tokener = new JSONTokener(datais);
            products = new JSONObject(tokener);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (datais != null) {
                datais.close();
            }
        }

        closeApp();
        launchApp();
    }

    @BeforeMethod
    public void beforeMethod() {
//        ((CanRecordScreen) getDriver()).startRecordingScreen();
        closeApp();
        launchApp();
    }

    //stop video capturing and create *.mp4 file
    @AfterMethod
    public synchronized void afterMethod(ITestResult result) throws Exception {
//        String media = ((CanRecordScreen) getDriver()).stopRecordingScreen();
//
//        Map <String, String> params = result.getTestContext().getCurrentXmlTest().getAllParameters();
//        String dirPath = "videos" + File.separator + params.get("platformName") + "_" + params.get("deviceName")
//                + File.separator + getDateTime() + File.separator + result.getTestClass().getRealClass().getSimpleName();
//
//        File videoDir = new File(dirPath);
//
//        synchronized(videoDir){
//            if(!videoDir.exists()) {
//                videoDir.mkdirs();
//            }
//        }
//        FileOutputStream stream = null;
//        try {
//            stream = new FileOutputStream(videoDir + File.separator + result.getName() + ".mp4");
//            stream.write(Base64.decodeBase64(media));
//            stream.close();
//            utils.log().info("video path: " + videoDir + File.separator + result.getName() + ".mp4");
//        } catch (Exception e) {
//            utils.log().error("error during video capture" + e.toString());
//        } finally {
//            if(stream != null) {
//                stream.close();
//            }
//        }
    }

    @BeforeSuite
    public void beforeSuite() throws Exception {
        ThreadContext.put("ROUTINGKEY", "ServerLogs");
//        server = getAppiumService();
        if (!checkIfAppiumServerIsRunnning(4723)) {
//            server.start();
//            server.clearOutPutStreams();
//            utils.log().info("Appium server started");
        } else {
            utils.log().info("Appium server already running");
        }
    }

    public boolean checkIfAppiumServerIsRunnning(int port) {
        boolean isAppiumServerRunning = false;
        ServerSocket socket;
        try {
            socket = new ServerSocket(port);
            socket.close();
        } catch (IOException e) {
            System.out.println("1");
            isAppiumServerRunning = true;
        } finally {
            socket = null;
        }
        return isAppiumServerRunning;
    }

    @AfterSuite
    public void afterSuite() {
//        server.stop();
//        utils.log().info("Appium server stopped");
    }

    public AppiumDriverLocalService getAppiumServerDefault() {
        return AppiumDriverLocalService.buildDefaultService();
    }
//
//    public AppiumDriverLocalService getAppiumService() {
//        HashMap<String, String> environment = new HashMap<String, String>();
//        environment.put("PATH", "/Library/Internet Plug-Ins/JavaAppletPlugin.plugin/Contents/Home/bin" +
//                ":/Users/eugenezakiev/Library/Android/sdk/tools" +
//                ":/Users/eugenezakiev/Library/Android/sdk/platform-tools" +
//                ":/usr/local/bin" +
//                ":/usr/bin:/bin" +
//                ":/usr/sbin" +
//                ":/sbin" +
//                ":/Library/Apple/usr/bin" + System.getenv("PATH"));
//        environment.put("ANDROID_HOME", "/Users/eugenezakiev/Library/Android/sdk");
//        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//                .usingDriverExecutable(new File("/usr/local/bin/node"))
//                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
//                .usingPort(4723)
//                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
//                .withEnvironment(environment)
//                .withLogFile(new File("ServerLogs/server.log")));
//    }

    @Parameters({"emulator", "platformName", "androidBitrise", "udid", "deviceName", "systemPort",
            "chromeDriverPort", "wdaLocalPort", "webkitDebugProxyPort", "isTablet"})
    @BeforeTest
    public void beforeTest(@Optional("androidOnly") String emulator, String platformName,  @Optional("androidOnly") String androidBitrise, String udid, String deviceName,
                           @Optional("androidOnly") String systemPort, @Optional("androidOnly") String chromeDriverPort,
                           @Optional("iOSOnly") String wdaLocalPort, @Optional("iOSOnly") String webkitDebugProxyPort, @Optional("iOSOnly") String isTablet) throws Exception {
        setDateTime(utils.dateTime());
        setPlatform(platformName);
        setDeviceName(deviceName);
        setIosTablet(isTablet);
        setAndroidBitrise(androidBitrise);
        URL url;
        InputStream inputStream = null;
        InputStream stringsis = null;
        Properties props = new Properties();
        AppiumDriver driver;

        String strFile = "logs" + File.separator + platformName + "_" + deviceName;
        File logFile = new File(strFile);
        if (!logFile.exists()) {
            logFile.mkdirs();
        }
        //route logs to separate file for each thread
        ThreadContext.put("ROUTINGKEY", strFile);
        utils.log().info("log path: " + strFile);

        try {
            props = new Properties();
            String propFileName = "config.properties";

            utils.log().info("load " + propFileName);
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            props.load(inputStream);
            setProps(props);

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", platformName);
            if(getAndroidBitrise().equals("true")) {
                String bitriseEmulatorSerial = System.getenv("BITRISE_EMULATOR_SERIAL");
                utils.log().info("BITRISE_EMULATOR_SERIAL is" + bitriseEmulatorSerial);
                desiredCapabilities.setCapability("udid", bitriseEmulatorSerial);
            }
            if(!getAndroidBitrise().equals("true")) {
                desiredCapabilities.setCapability("deviceName", deviceName);
                desiredCapabilities.setCapability("udid", udid);
            }
            desiredCapabilities.setCapability("unicodeKeyboard", true);
            desiredCapabilities.setCapability("resetKeyboard", true);
            url = new URL(props.getProperty("appiumURL"));

            switch (platformName) {
                case "Android":
                    desiredCapabilities.setCapability("automationName", props.getProperty("androidAutomationName"));
                    desiredCapabilities.setCapability("appWaitPackage", props.getProperty("androidAppWaitPackage"));
                    desiredCapabilities.setCapability("appWaitActivity", props.getProperty("androidAppWaitActivity"));
                    desiredCapabilities.setCapability("unicodeKeyboard", "true");
                    desiredCapabilities.setCapability("resetKeyboard", "true");
                    if (emulator.equalsIgnoreCase("true")) {
                        desiredCapabilities.setCapability("avd", deviceName);
                        desiredCapabilities.setCapability("avdLaunchTimeout", 120000);
                    }
                    desiredCapabilities.setCapability("systemPort", systemPort);
                    desiredCapabilities.setCapability("chromeDriverPort", chromeDriverPort);
                    if(!getAndroidBitrise().equals("true")) {
                        String androidAppUrl = getClass().getResource(props.getProperty("androidAppLocation")).getFile();
                        utils.log().info("appUrl is" + androidAppUrl);
                        desiredCapabilities.setCapability("app", androidAppUrl);
                    }
                    if(getAndroidBitrise().equals("true")) {
                        String bitriseApkPath = "/bitrise/deploy/app-dev-debug.apk";
                        utils.log().info("BITRISE_APK_PATH is" + bitriseApkPath);
                        desiredCapabilities.setCapability("app", bitriseApkPath);
                    }

                    driver = new AndroidDriver(url, desiredCapabilities);
                    break;
                case "iOS":
                    desiredCapabilities.setCapability("automationName", props.getProperty("iOSAutomationName"));
                    String iOSAppUrl = getClass().getResource(props.getProperty("iOSAppLocation")).getFile();
                    utils.log().info("appUrl is" + iOSAppUrl);
                    desiredCapabilities.setCapability("bundleId", props.getProperty("iOSBundleId"));
                    desiredCapabilities.setCapability("wdaLocalPort", wdaLocalPort);
                    desiredCapabilities.setCapability("webkitDebugProxyPort", webkitDebugProxyPort);
                    desiredCapabilities.setCapability("app", iOSAppUrl);

                    driver = new IOSDriver(url, desiredCapabilities);
                    break;
                default:
                    throw new Exception("Invalid platform! - " + platformName);
            }
            setDriver(driver);
            utils.log().info("driver initialized: " + driver);
        } catch (Exception e) {
            utils.log().fatal("driver initialization failure. ABORT!!!\n" + e.toString());
            throw e;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (stringsis != null) {
                stringsis.close();
            }
        }
    }

    protected boolean isElementPresent(By by) {
        try {
            getDriver().findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void waitForInvisibility(MobileElement e, String message, long seconds) {
        utils.log().info("Wait for invisibility of " + message);
        WebDriverWait wait = new WebDriverWait(getDriver(), seconds);
        wait.until(ExpectedConditions.invisibilityOf(e));
    }

    public void waitForInvisibility(MobileElement e, String message) {
        utils.log().info("Wait for invisibility of " + message);
        WebDriverWait wait = new WebDriverWait(getDriver(), TestUtils.WAIT);
        wait.until(ExpectedConditions.invisibilityOf(e));
    }

    public void waitForVisibility(MobileElement e, String message) {
        utils.log().info("Wait for Visibility of " + message);
        WebDriverWait wait = new WebDriverWait(getDriver(), TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void waitForVisibility(MobileElement e, String message, long seconds) {
        utils.log().info("Wait for Visibility of " + message);
        WebDriverWait wait = new WebDriverWait(getDriver(), seconds);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void waitForVisibility(WebElement e, String message) {
        utils.log().info("Wait for Visibility of " + message);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void clear(MobileElement e) {
        e.clear();
    }

    public void click(MobileElement e) {
        e.click();
    }

    public void click(MobileElement e, String msg) {
        utils.log().info(msg);
        //ExtentReport.getTest().log(Status.INFO, msg);
        e.click();
    }

    public void clickAndroidBackButton(){
        ((AndroidDriver)getDriver()).pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public void sendKeys(MobileElement e, String txt) {
        e.sendKeys(txt);
    }

    public void sendKeys(MobileElement e, String txt, String msg) {
        utils.log().info(msg);
        //ExtentReport.getTest().log(Status.INFO, msg);
        e.sendKeys(txt);
    }

    public String getAttribute(MobileElement e, String attribute) {
        waitForVisibility(e, "Some Attribute");
        return e.getAttribute(attribute);
    }

    public String getText(MobileElement e, String msg) {
        String txt = null;
        switch (getPlatform()) {
            case "Android":
                txt = getAttribute(e, "text");
                break;
            case "iOS":
                txt = getAttribute(e, "label");
                break;
        }
        utils.log().info(msg + txt);
        ExtentReport.getTest().log(Status.INFO, msg + txt);
        return txt;
    }

    public void closeApp() {
        ((InteractsWithApps) getDriver()).closeApp();
    }

    public void launchApp() {
        ((InteractsWithApps) getDriver()).launchApp();
    }

    public MobileElement scrollToElement(String elementLocator) {
        return (MobileElement) ((FindsByAndroidUIAutomator) getDriver()).findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
                        + "new UiSelector().description(\"" + elementLocator + "\"));");
    }

    public void scrollDownByCoordinates() {
        utils.log().info("Swiping down by coordinates");
        TouchAction t = new TouchAction(getDriver());
        Dimension size = getDriver().manage().window().getSize();

        int startX = (int) (size.width / 1.1);
        int endX = startX;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        t.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }

    public void scrollDownByCoordinatesOnTablet() {
        utils.log().info("Swiping down by coordinates");
        TouchAction t = new TouchAction(getDriver());
        Dimension size = getDriver().manage().window().getSize();

        int startX = (int) (size.width / 1.1);
        int endX = startX;
        int startY = (int) (size.height * 0.4);
        int endY = (int) (size.height * 0.04);

        t.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }

    @AfterTest
    public void afterTest() {
        getDriver().quit();
    }
}
