package week3.day2.assignments;


import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailUnique {

	public static void main(String[] args) throws InterruptedException {
		
//		Set the system property and Launch the URL
		
		WebDriverManager.chromedriver().setup();	
		
		//to disable notifications 
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");		
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
//		Click the 'sort on date' checkbox
		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();

//		clear and type in the from station text field
		driver.findElement(By.id("txtStationFrom")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("txtStationFrom")).sendKeys("Tambaram");
		driver.findElement(By.id("txtStationFrom")).sendKeys(Keys.TAB);
		
//		clear and type in the to station text field
		driver.findElement(By.id("txtStationTo")).clear();
		Thread.sleep(1000);

		driver.findElement(By.id("txtStationTo")).sendKeys("Salem Jn");
		driver.findElement(By.id("txtStationTo")).sendKeys(Keys.TAB);
//		Add a java sleep for 2 seconds
		Thread.sleep(2000);

//		Store all the train names in a list
		List<WebElement> Train_Names=driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//td[2]"));	
//		Get the size of it
		System.out.println(Train_Names.size());
//		Add the list into a new Set

		Set<String> SortedUniqueTrainNames=new TreeSet<String>();
		
		for(int i=0;i<=Train_Names.size()-1;i++)
			SortedUniqueTrainNames.add(Train_Names.get(i).getText());			
		
		
//		And print the size of it
		System.out.println(SortedUniqueTrainNames.size());
		driver.close();
		
	
	}

}
