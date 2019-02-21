package com.inferyx.framework.dataProfiling.rule;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.inferyx.framework.selenium.TestBase;

public class RuleActionEdit extends TestBase{
	@BeforeMethod
	public void setUp() throws InterruptedException {
		Thread.sleep(3000);
		start = System.currentTimeMillis();
		driver.findElement(By.cssSelector("button.btn.green.btn-xs.btn-outline.dropdown-toggle")).click();

		Thread.sleep(1000);
	}
	@Test(priority =5, description = "ruleEdit")
	public void ruleEdit() throws IOException, InterruptedException {
		Thread.sleep(3000);
		//vizpodEdit
		try {
			WebElement vizpodEdit = driver
					.findElement(By.xpath("/html/body/ul/li[2]/a"));
			long start1 = System.currentTimeMillis();
			vizpodEdit.click();
			Thread.sleep(1000);
			long finish1 = System.currentTimeMillis();
			totalTime = finish1 - start1; 
			dataFromExcelSheet.updateResult(7, 8, "Rule Action Edit", "PASS", totalTime);
		} catch (NoSuchElementException e) {
			dataFromExcelSheet.updateResult(7, 8, "Rule Action Edit", "FAIL", totalTime);
		}
	}
	
	@AfterMethod
	public void AfterMethod() throws InterruptedException {
		Thread.sleep(3000);
		start = System.currentTimeMillis();
		WebElement ruleAcationbutton = driver
				.findElement(By.xpath("/html/body/screenshot/div[4]/div[2]/div/div[4]/div/div[1]/div/div[4]/div[1]/div[2]/a[5]/i"));
		Thread.sleep(1000);
		ruleAcationbutton.click();
		Thread.sleep(1000);
	}
}