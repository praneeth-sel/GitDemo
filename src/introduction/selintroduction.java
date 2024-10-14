package introduction;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class selintroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
              
		//invoking browser
		//Chrome ChromeDriver ->methods
		System.setProperty("Webdrive.chrome.driver", "C:/Users/praneethk/Documents/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	driver.findElement(By.xpath("//tr//th[1]")).click();
	
	List<WebElement> elementslist= driver.findElements(By.xpath("//tr/td[1]"));
		List<String> originallist=elementslist.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String>sortedlist =originallist.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originallist.equals(sortedlist));
		
		List<String> price;
		do {
			List<WebElement> rows= driver.findElements(By.xpath("//tr/td[1]"));
		price= rows.stream().filter(s->s.getText().contains("Rice")).
				map(s->getpriceveggies(s)).collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
		
		
		if(price.size()<1) {
		
		driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		
		}
		}while(price.size()<1);
		
	}
			

	private static String  getpriceveggies(WebElement s) {
		// TODO Auto-generated method stub
		String pricevalue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
	
		return pricevalue;
	}
}