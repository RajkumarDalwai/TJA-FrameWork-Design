package org.tractorjunction.testUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
	
    service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\IT_Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
			 .withIPAddress("127.0.0.1").usingPort(4723).build();
			  service.start();
			
	UiAutomator2Options options = new UiAutomator2Options();
	options.setDeviceName("RajkumarDevice"); // emulator
//	options.setDeviceName("Android Device"); // real device
	
//	options.setApp("C:\\Users\\IT_Admin\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
//	options.setApp("C:\\Users\\IT_Admin\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\General-Store.apk");
	options.setApp("C:\\Users\\IT_Admin\\eclipse-workspace\\TJATestAutomationFramework\\src\\test\\java\\org\\tractorjunction\\resources\\TJ_3.8.3.apk");	
	
//	options.setChromedriverExecutable("C:\\Users\\IT_Admin\\Downloads\\chromedriver_win32\\chromedriver.exe"); //for emulator
//	options.setChromedriverExecutable("C:\\Users\\IT_Admin\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"); //real device
	
//	options.setCapability("browserName", "Chrome");
	
	driver = new AndroidDriver(new URL(" http://127.0.0.1:4723/"), options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	}
	
	public String getScreenshotPath (String testCaseName, AppiumDriver driver) throws IOException
	{
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
	
//	1.capture & place in folder 2.extent report pick file & attach to report
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		service.stop();
	}
}
