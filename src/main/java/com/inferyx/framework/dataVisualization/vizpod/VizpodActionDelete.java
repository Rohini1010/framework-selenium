package com.inferyx.framework.dataVisualization.vizpod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.inferyx.framework.selenium.TestBase;

public class VizpodActionDelete extends TestBase{
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		Thread.sleep(3000);
		start = System.currentTimeMillis();
		driver.findElement(By.cssSelector("button.btn.green.btn-xs.btn-outline.dropdown-toggle")).click();

		Thread.sleep(1000);
	}
	@Test(priority =11, description = "vizpodDelete")
	public void vizpodDelete() throws IOException, InterruptedException {
		Thread.sleep(3000);
		//vizpodDelete
		try {
			WebElement vizpodDelete = driver
					.findElement(By.xpath("/html/body/ul/li[3]/a"));
			start = System.currentTimeMillis();
			vizpodDelete.click();
			Thread.sleep(1000);
			finish = System.currentTimeMillis();
			totalTime = finish - start;  
			dataFromExcelSheet.updateResult(4,5, "Vizpod Action Delete", "PASS", totalTime);
		} catch (NoSuchElementException e) {
			dataFromExcelSheet.updateResult(4,5, "Vizpod Action Delete", "FAIL", totalTime);
		}
	}
	
	@AfterMethod
	public void AfterMethod() throws InterruptedException {
		Thread.sleep(3000);
		start = System.currentTimeMillis();
		WebElement actionDelete = driver.findElement(By.xpath("//*[@id='DeleteConfModal']/div/div/div[3]/button[2]"));
		actionDelete.click();
	}
	
}
