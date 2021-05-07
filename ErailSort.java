package week3.day2.assignments;

import java.util.ArrayList;
import java.util.Collections;
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

public class ErailSort {

		public static void main(String[] args) throws InterruptedException {
//			Launch the browser
			
//			Launch the URL - https://erail.in/
			
			WebDriverManager.chromedriver().setup();	
			
			//to disable notifications 
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");		
			ChromeDriver driver=new ChromeDriver(options);
			
			//1) Open https://erail.in/
			driver.get("https://erail.in/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
			
//			Uncheck the check box - sort on date
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
			
//			clear and type in the source station 
			driver.findElement(By.id("txtStationFrom")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("txtStationFrom")).sendKeys("Tambaram");
			driver.findElement(By.id("txtStationFrom")).sendKeys(Keys.TAB);

//			clear and type in the destination station
			
			driver.findElement(By.id("txtStationTo")).clear();
			Thread.sleep(1000);

			driver.findElement(By.id("txtStationTo")).sendKeys("Salem Jn");
			driver.findElement(By.id("txtStationTo")).sendKeys(Keys.TAB);
			Thread.sleep(1000);

//			Find all the train names using xpath and store it in a list
			driver.findElement(By.id("buttonFromTo")).click();
			
			List<WebElement> Train_Names=driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//td[2]"));		
			//System.out.println(Train_Names);
			
			Set<String> SortedUniqueTrainNames=new TreeSet<String>();
			
			for(int i=0;i<=Train_Names.size()-1;i++)
				SortedUniqueTrainNames.add(Train_Names.get(i).getText());			
//			Use Java Collections sort to sort it and then print it
			
			List<String> TrainNamesList=new ArrayList<String>(SortedUniqueTrainNames);
			Collections.sort(TrainNamesList);
			System.out.println(TrainNamesList);
			driver.close();
			
		}

	}