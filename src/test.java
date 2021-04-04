import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

public class test 
{
	@Test
	public void theTest() throws IOException, InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("http://automationpractice.com");
		
		
		File src = new File("afaqytestdata.xlsx"); 
		
		FileInputStream fis = new FileInputStream(src); 
	
		XSSFWorkbook xsf = new XSSFWorkbook(fis) ; 
		
		XSSFSheet sheet = xsf.getSheetAt(0); 
		
		
	
		xsf.close();
	
		WebElement signin = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
		signin.click();
		int countRow = sheet.getLastRowNum();
				
		
		
		WebElement emailField = driver.findElement(By.id("email_create"));
		String Mail = sheet.getRow(1).getCell(0).getStringCellValue(); 
		emailField.sendKeys(Mail);
		
		
		
		WebElement SubmitCreate = driver.findElement(By.id("SubmitCreate"));
		SubmitCreate.click();
		Thread.sleep(2000);
		
		
		WebElement gender = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[1]/div[1]/label"));
		gender.click();
		
		
		WebElement customer_firstname = driver.findElement(By.id("customer_firstname"));
		String customerfirstname = sheet.getRow(1).getCell(1).getStringCellValue(); 
		customer_firstname.sendKeys(customerfirstname);		

		WebElement customer_lastname = driver.findElement(By.id("customer_lastname"));
		String customerlastname = sheet.getRow(1).getCell(2).getStringCellValue(); 
		customer_lastname.sendKeys(customerlastname);
		
		WebElement passwd = driver.findElement(By.id("passwd"));
		String password = sheet.getRow(1).getCell(3).getStringCellValue(); 
		passwd.sendKeys(password);
	
		
		Select daydropdwn =new Select(driver.findElement(By.id("days"))) ; 
		daydropdwn.selectByValue("23");
		
		Select monthsdropdwn =new Select(driver.findElement(By.id("months"))) ; 
		monthsdropdwn.selectByValue("6");
		
		Select yeardrop =new Select(driver.findElement(By.id("years"))) ; 
		yeardrop.selectByValue("1994");
		
		WebElement address1 = driver.findElement(By.id("address1"));
		String address = sheet.getRow(1).getCell(7).getStringCellValue(); 
		address1.sendKeys(address);
		
		WebElement city = driver.findElement(By.id("city"));
		String city1 = sheet.getRow(1).getCell(7).getStringCellValue(); 
		city.sendKeys(city1);
		
		
		Select id_state =new Select(driver.findElement(By.id("id_state"))) ; 
		id_state.selectByValue("53");
		

		WebElement zipcode = driver.findElement(By.id("postcode"));
		double cit = sheet.getRow(1).getCell(9).getNumericCellValue();  
		int zip = (int)cit;
		String str = String.valueOf(zip);  
		zipcode.sendKeys(str);
		
		Select country =new Select(driver.findElement(By.id("id_country"))) ; 
		country.selectByValue("21");
		
		WebElement phone_mobile = driver.findElement(By.id("phone_mobile"));
		double x1 = sheet.getRow(1).getCell(10).getNumericCellValue(); 
		int x2 = (int)x1;
		String phone = String.valueOf(x2);
		
		phone_mobile.sendKeys(phone);
		
		WebElement alias = driver.findElement(By.id("alias"));
		String aliasaddress = sheet.getRow(1).getCell(11).getStringCellValue(); 
		alias.clear();
		alias.sendKeys(aliasaddress);
		
		WebElement submitRegistration = driver.findElement(By.id("submitAccount"));
		submitRegistration.click();
	
		WebElement signout = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a"));
		signout.click();
	}
	
}
