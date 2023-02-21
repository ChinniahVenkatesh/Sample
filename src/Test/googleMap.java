package Test;

import java.awt.AWTException;
import java.awt.Event;
import java.awt.Robot;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class googleMap {

	public static void main(String [] args) throws InterruptedException, AWTException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the place1");
	    String place1 = sc.nextLine();
	    System.out.println("Enter the place2");
	    String place2 = sc.nextLine();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\chinn\\eclipse-workspace\\GoogleMap\\browser\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/maps");
      
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@id='hArJGc']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.findElement(By.xpath("//div[@id='sb_ifc50']/input[@class='tactile-searchbox-input'][1]")).sendKeys(place1);
        Thread.sleep(1000);
      List<WebElement> address =   driver.findElements(By.xpath("//div[@role='gridcell']/span[4]/span"));
		for(WebElement ad : address)
		{
			System.out.println(ad.getText());
		}
		
	    WebElement placeDec = driver.findElement(By.xpath("//div[@id='sb_ifc51']/input"));
	    placeDec.sendKeys(place2);
	    placeDec.sendKeys(Keys.ENTER);
	    Thread.sleep(1000);
	   
	    String distance = driver.findElement(By.xpath("//div[@class='ivN21e tUEI8e fontBodyMedium']/div")).getText();
	    
		System.out.println("The distance between the place is:"+distance);
		
	}

}
