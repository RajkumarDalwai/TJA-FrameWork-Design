package org.tractorjunction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.tractorjunction.testUtils.BaseClass_TJ;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class HomePage extends BaseClass_TJ{
	
	@BeforeMethod
	public void preSetup()
	{
		Activity activity = new Activity("com.tractorjunction","com.tractorjunction.MainActivity");
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent", "com.tractorjunction/com.tractorjunction.MainActivity"));
	}
	
	@Test // Verify that user is able login with valid credentials or not
	public void LoginTest() throws InterruptedException	
	{	
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Password']")).click();
		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText")).sendKeys("9314081898");
		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText")).sendKeys("9314081898");
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Login\"]")).click();	
	}	
	
	@Test // Verify that user is able to close the Popup or not
	public void PopupClose() 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"No Thanks\"]")).click();
	}
	
	@Test // Verify that user is able Redirect to Popular & Latest Tractors listing page or not
	public void Redirections() throws InterruptedException 
	{
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"View All Popular Tractors\"]")).click();
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Latest\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"View All Latest Tractors\"]")).click();
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
	}
}
