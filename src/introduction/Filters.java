package introduction;




import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Filters {

	public static <string> void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	
		System.setProperty("Webdrive.chrome.driver", "C:/Users/praneethk/Documents/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice");
	    driver.switchTo().newWindow(WindowType.WINDOW);
	    Set<String> handles=driver.getWindowHandles();
	    Iterator<String> it=handles.iterator();
	    String parentwindow=it.next();
	    String childwindow=it.next();
	    driver.switchTo().window(childwindow);
	    driver.get("https://rahulshettyacademy.com/");
	   String coursename=(driver.findElements(By.cssSelector("a[href*=\"https://courses.rahulshettyacademy.com/p\"]"))
	    .get(1).getText());
	    driver.switchTo().window(parentwindow);
	   WebElement name=driver.findElement(By.cssSelector("[name='name']"));
	    name.sendKeys(coursename);
	    
		File file=name.getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(file, new File("logo.png"));
       
       System.out.println(name.getRect().getDimension().getHeight());
       System.out.println(name.getRect().getDimension().getWidth());
	}

}