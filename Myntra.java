package week3.day2.assignments;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();	
		
		//to disable notifications 
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");		
		ChromeDriver driver=new ChromeDriver(options);
		
		//1) Open https://www.myntra.com/
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

		//2) Mouse over on WOMEN 
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='desktop-navLink']//a[text()='Women']"))).perform();
		//3) Click Jackets & Coats
		driver.findElement(By.xpath("//li//a[text()='Jackets & Coats']")).click();
		//4) Find the total count of item 
		String text = driver.findElement(By.xpath("//span[@class='title-count']")).getText().replaceAll("\\D+", "");
		System.out.println(text);
		String categoriescount1=driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText().replaceAll("\\D+", "");
		String categoriescount2=driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText().replaceAll("\\D+", "");
		System.out.println(categoriescount1);
		System.out.println(categoriescount2);
		int totalcount=Integer.parseInt(text);
		int CatCategory1=Integer.parseInt(categoriescount1);
		int CatCategory2=Integer.parseInt(categoriescount2);
		System.out.println("Total Count:"+totalcount);
		System.out.println("Count 1:"+CatCategory1);
		System.out.println("Count 2:"+CatCategory2);
		//5) Validate the sum of categories count matches
		if(totalcount==CatCategory1+CatCategory2)
		{
			System.out.println("Count is matched with Total value and Sum of categories");
		}else
		{
			System.out.println("Count didnt match with Total value and Sum of categories");
		}
		Thread.sleep(2000);
		//6) Check Coats
	driver.findElement(By.xpath("(//span[@class='categories-num']//following-sibling::div)[2]")).click();
	Thread.sleep(2000);

	//7) Click + More option under BRAND	
	driver.findElement(By.xpath("//div[@class='vertical-filters-filters brand-container']//div[@class='brand-more']")).click();
	Thread.sleep(2000);
	//8) Type MANGO and click checkbox
	driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("MANGO");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[@class='FilterDirectory-count']/following-sibling::div[1]")).click();
	Thread.sleep(2000);
	//9) Close the pop-up x
	driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
	
	//To confirm all the coats are of brand MANGO 
//	10) Confirm all the Coats are of brand MANGO
	Thread.sleep(2000);

	int totalcoats=driver.findElements(By.xpath("//h3[@class='product-brand']")).size();
	System.out.println(totalcoats);
	for(int i=0;i<=totalcoats-1;i++)
	{
		String coatbrand=driver.findElement(By.xpath("//h3[@class='product-brand']")).getText();
		System.out.println(coatbrand);
		if(coatbrand.equalsIgnoreCase("MANGO"))
		{
			System.out.println("All the brands retrieved are as per the selection MANGO");
		}else
		{
			System.out.println("All the brands retrieved are not of brand MANGO");
		}
	}
	Thread.sleep(2000);

	driver.findElement(By.xpath("//span[@class='myntraweb-sprite sort-downArrow sprites-downArrow']")).click();
	Thread.sleep(6000);
	//11) Sort by Better Discount
	driver.findElement(By.xpath("(//label[@class='sort-label '])[3]")).click();
	
	Thread.sleep(5000);
	//12) Find the price of first displayed item
	String FirstCoatPrice= " ";
	FirstCoatPrice=driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
	Thread.sleep(5000);

	System.out.println("Price of First coat: "+FirstCoatPrice);
	Thread.sleep(5000);
//13) Mouse over on size of the first item
	action.moveToElement(driver.findElement(By.xpath("(//li[@class='product-base']/a)[1]"))).perform();
	Thread.sleep(2000);
	//14) Click on WishList Now
	driver.findElement(By.xpath("(//span[@class='myntraweb-sprite product-notWishlistedIcon sprites-notWishlisted'])[1]")).click();

//15) Close Browser 
	driver.close();
	}}

