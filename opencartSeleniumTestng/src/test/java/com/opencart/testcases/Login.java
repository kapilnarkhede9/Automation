package com.opencart.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	@Test
	public void verifyLoginWithValidCredentials() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://localhost/opencart/upload/");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		driver.findElement(By.id("input-email")).sendKeys("ishvarkharche@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("password");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='My Account']")).isDisplayed());
		driver.quit();
	}
	@Test
	public void verifyLoginWithInvalidCredentials() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://localhost/opencart/upload/");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		driver.findElement(By.id("input-email")).sendKeys("ishv23@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("passwor2d");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(.,'Warning: No match for E-Mail Address and/or Password')]/div/div")).isDisplayed());
		System.out.println("ggbj "+driver.findElement(By.id("alert")).getText());
		driver.quit();
	}
	@Test
	public void verifyLoginWithInvalidEmailAndValidPassword() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://localhost/opencart/upload/");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		driver.findElement(By.id("input-email")).sendKeys("ishvarkharch@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("password");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		String actual=driver.findElement(By.id("alert")).getText();
		String expected="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actual,expected);
		//driver.quit();
	}
}
