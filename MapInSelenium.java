package week3.day2.assignments;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MapInSelenium {

	public static void main(String[] args) throws InterruptedException {

//		1) Set the property
		WebDriverManager.chromedriver().setup();	
			
//		2) Initiate ChromeDriver class and also to disable notifications 
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");		
		ChromeDriver driver=new ChromeDriver(options);

//		3) Launch the URL - https://erail.in/
		driver.get("https://erail.in/");
		
//		4) Maximize the browser
		driver.manage().window().maximize();
			
//		5) Add implicityWait
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

//		6) Clear and type in the from station
		
		driver.findElement(By.id("txtStationFrom")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("txtStationFrom")).sendKeys("Tambaram");
		driver.findElement(By.id("txtStationFrom")).sendKeys(Keys.TAB);
			
//		7) Clear and type in the to station
		
		driver.findElement(By.id("txtStationTo")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("txtStationTo")).sendKeys("Salem Jn");
		driver.findElement(By.id("txtStationTo")).sendKeys(Keys.TAB);
		Thread.sleep(1000);
			
//		8) Uncheck the 'Sort on Date' checkbox		
		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
			
//		9) Declare a Map
	
		Map<Integer,String> map=new TreeMap<Integer,String>();
			
//		10) Store the table in a web element
		
		WebElement tbl=driver.findElement(By.xpath("//table[@class='DataTable DataTableHeader TrainList TrainListHeader']"));
			
//		11) Get all the rows and store it in a List
		
		List<WebElement> NumOfRows=driver.findElements(By.xpath("//table[@class='DataTable DataTableHeader TrainList TrainListHeader']//tr//td//a"));
//		12) Iterate the rows and store all the columns in a List
		Thread.sleep(2000);
		Set<String> Columnnames=new TreeSet<String>();	
		for(int i=0;i<=NumOfRows.size()-1;i++)
		{
			List<WebElement> NumofColumns=driver.findElements(By.xpath("//table[@class='DataTable DataTableHeader TrainList TrainListHeader']//tr//td"));
			for(int j=0;j<=NumofColumns.size()-1;j++)
				Columnnames.add(NumofColumns.get(j).getText());	
		}
		System.out.println(Columnnames);

		
//			13) Check and get the values that start with 'S'
		
		for(String s:Columnnames)
		{
			//14) If the condition satisfies add it into the map as key & value

			if(s.startsWith("S"))
					{
					int k=1;
					map.put(k, s);
					}	
		}
//		15) Print those values by iterating the map

				System.out.println(map);

				driver.close();
	}

}
