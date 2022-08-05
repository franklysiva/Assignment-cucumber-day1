package createlead;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadSteps {
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
	@Given("Click on Create Lead Page")
	public void clickCreateLead() {
		driver.findElement(By.linkText("Create Lead")).click();
	}
	@Given("Enter Company name as {string}")
	public void companyName(String companyName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
	}
	@Given("Enter First name as {string}")
	public void firstName(String firstName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
	}
	@Given("Enter Last name as {string}")
	public void lastName(String lastName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
	}
	@Given("Enter Phone number as {string}")
	public void phoneNumber(String phoneNum) {
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phoneNum);
	}
	@Given("Click on Create Lead Submit Button")
	public void clickSubmitButtton() {
		driver.findElement(By.name("submitButton")).click();
	}
	@Then("View Lead Page should be displayed")
	public void viewLeadPage() {
		String text = driver.findElement(By.xpath("//div[@id='sectionHeaderTitle_leads']")).getText();
		if (text.equals("View Lead")) {
			System.out.println("View Lead Page is displayed");
		} else {
			System.out.println("View Lead Page is not displayed, Check if the Lead Created");
		}
	}
	@Given("Close the Chrome Browser")
	public void closeBrowser() {
		driver.close();
	}
}
