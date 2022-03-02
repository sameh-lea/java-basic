package com.e2eTests.automatedTests.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;
import java.util.Properties;
import javax.imageio.ImageIO;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class CommonMethods {
	public static String filePath = "C:\\";
	public static String dowloadFolderPath = "C:\\Users\\21626\\Desktop\\New\\Screenshot\\";

	public CommonMethods() {
		driver = Setup.driver;
	}

	public static WebDriver driver;
	public static Properties prop;

	public void readFileConfig(String url) throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/resources/configs/configs/config.properties");
		prop.load(fis);
		driver.get(prop.getProperty(url));
	}

	public void refreshNavigator() {
		driver.navigate().refresh();
	}

	public void uploadFileWithRobot() {
		StringSelection stringSelection = new StringSelection(filePath);
		Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipBoard.setContents(stringSelection, null);

		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(150);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	public void takeScreenShot(WebElement target) {
		
		Screenshot logoImageScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver, target);
		 try {
			ImageIO.write(logoImageScreenshot.getImage(), "jpg", new File(dowloadFolderPath + "screen" +
					  ".jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		} }

	public void assertIsDisplayed(WebElement element) {
		Assert.assertTrue(element.isDisplayed());
	}

	public boolean compareTwoPicture(WebElement element) throws IOException {
		boolean compare = false;
		BufferedImage expectedImage = ImageIO.read(new File(filePath));
		Screenshot logoImageScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver, element);
		BufferedImage actualImage = logoImageScreenshot.getImage();
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
		if (diff.hasDiff() == false) {
			compare = true;
		}
		return compare;
	}

	public void downloadImage(List<WebElement> list) throws InterruptedException, IOException {
		Actions actions = new Actions(driver);
		WebElement footOfPage = driver.findElement(By.id("footer"));
		 actions.moveToElement(footOfPage).build().perform();
		 Thread.sleep(1000);
		 refreshNavigator();
		 Thread.sleep(2000);
		 URL imageURL;
		 int picRef = 0;
		for (WebElement pic : list) {
			
			
			
			
			imageURL = new URL(pic.getAttribute("src"));
			try (BufferedInputStream in = new BufferedInputStream(imageURL.openStream());
					  FileOutputStream fileOutputStream = new FileOutputStream(dowloadFolderPath+picRef+".jpg")) {
				System.out.println("in is ******"+in);
					    byte dataBuffer[] = new byte[1024];
					    int bytesRead;
					    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
					        fileOutputStream.write(dataBuffer, 0, bytesRead);
					    }
					} catch (IOException e) {
					    // handle exception
					}
			picRef++;
			/*
			 * try { // actions.moveToElement(pic).build().perform();footer
			 * 
			 * imageURL = new URL(pic.getAttribute("src")); System.out.println(imageURL);
			 * BufferedImage imagedsave = ImageIO.read(imageURL); if (imagedsave != null) {
			 * ImageIO.write(imagedsave, "jpg", new File(dowloadFolderPath + picRef +
			 * ".jpeg")); picRef++; }
			 * 
			 * } catch (IOException e) { e.printStackTrace(); }
			 */

		}

	}
	public void getImage() throws IOException {
		int i =0;
		Actions actions = new Actions(driver);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		List<WebElement> list = driver.findElements(By.tagName("img"));;
		for(WebElement element : list) {
			String src = element.getAttribute("src");
			System.out.println(src);
			URL imageURL = new URL(src);
			BufferedImage saveImage = ImageIO.read(imageURL);
			
			ImageIO.write(saveImage, "jpg", new File(dowloadFolderPath+i+".jpg"));
			i++;
		}
		
	}
	  public void downloadFile(List<WebElement> list) throws IOException, Throwable{
		  Actions actions = new Actions(driver);
			WebElement footOfPage = driver.findElement(By.id("footer"));
			 actions.moveToElement(footOfPage).build().perform();
			 Thread.sleep(1000);
			 refreshNavigator();
			 Thread.sleep(2000);
			 int i =0;
			 for (WebElement pic : list) {
				 URL imageURL = new URL(pic.getAttribute("src"));
	            InputStream in = imageURL.openStream();
	            ReadableByteChannel rbc = Channels.newChannel(in);
	            try (FileOutputStream fos = new FileOutputStream(dowloadFolderPath+i)) {
					fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
				}
	            i++;
	        
	  }
			 
}
		public String checkElementContains(WebElement element) {
			String elementToDo = element.getText();
			return elementToDo;
		}
}
