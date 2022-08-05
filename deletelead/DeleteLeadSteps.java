package deletelead;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLeadSteps {
public ChromeDriver driver;
	
	@Given("Open the Chrome Browser")
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@Given("Load the URL")
	public void loadUrl() {
		driver.get("http://leaftaps.com/opentaps/control/login");
	}
	@Given("Enter Username as {string}")
	public void enterUsername(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}
	@Given("Enter Password as {string}")
	public void enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}
	@Given("Click on Login Button")
	public void clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	@Given("Click on crmsfa Button")
	public void clickCrmsfa() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	@Given("Click on Leads Page")
	public void clickLeads() {
		driver.findElement(By.linkText("Leads")).click();
	}
	@Given("Click on Find Leads Page")
	public void clickFindLeads() {
		driver.findElement(By.linkText("Find Leads")).click();
	}
	@Given("Click on Phone Tab under Find by")
	public void clickPhoneTab() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}
	@Given("Enter Phone number as {string}")
	public void enterPhoneNum(String Phone) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(Phone);
	}
	@Given("Click on Find Leads Button")
	public void clickFindLeadsButton() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}
	String leadID;
	@Given("Click on First LeadID in the List")
	public void clickonLeadId() {
		leadID = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).getText();
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
	}
	@Given("Click on Delete Button")
	public void deleteLead() {
		driver.findElement(By.linkText("Delete")).click();
	}
	@Given("Check Deleted Lead using LeadID")
	public void checkDeletedLead() throws InterruptedException {
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Find by']//following::input[@name='id']")).sendKeys(leadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if(text.equals("No records to display")) {
			System.out.println("Lead ID: "+leadID+" Deleted Successfully");
		} else {
			System.out.println("Something went wrong, LeadID: "+leadID+" is not deleted");
		}
	}
	@Given("Close the Browser")
	public void closeBrowser() {
		driver.close();
	}
}
