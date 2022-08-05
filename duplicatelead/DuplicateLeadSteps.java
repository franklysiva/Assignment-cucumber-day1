package duplicatelead;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLeadSteps {
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
	public void clickFindLeadsButton() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
	}
	@Given("Click on First LeadID in the List")
	public void clickonLeadId() {
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
	}
	@Given("Click on Duplicate Lead Button")
	public void clickDuplicateLead() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}
	@Given("And Click on Submit Button")
	public void clickSubmitButton() {
		driver.findElement(By.name("submitButton")).click();
	}
	@Given("Close the Browser")
	public void closeBrowser() {
		driver.close();
	}
}
