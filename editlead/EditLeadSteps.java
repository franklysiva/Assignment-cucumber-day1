package editlead;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLeadSteps {
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

	@Given("Enter First name as {string}")
	public void enterFirstname(String firstName) {
		driver.findElement(By.xpath("//span[text()='Find by']//following::input[@name='firstName']"))
				.sendKeys(firstName);
	}

	@Given("Enter Last name as {string}")
	public void enterLastName(String lastName) {
		driver.findElement(By.xpath("//span[text()='Find by']//following::input[@name='lastName']")).sendKeys(lastName);
	}

	@Given("Enter Company name as {string}")
	public void enterCompanyName(String companyName) {
		driver.findElement(By.xpath("//span[text()='Find by']//following::input[@name='companyName']"))
				.sendKeys(companyName);
	}

	@Given("Click on Find Leads Button")
	public void clickFindLeadsButton() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}

	@Given("Click on First LeadID in the Lead List")
	public void clickLeadID() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}

	@Given("Click on Edit Button")
	public void clickEditButton() {
		driver.findElement(By.linkText("Edit")).click();
	}

	@Given("Edit Company name as {string}")
	public void editCompanyName(String editedCompanyName) {
		WebElement editCompanyName = driver.findElement(By.id("updateLeadForm_companyName"));
		editCompanyName.clear();
		editCompanyName.sendKeys(editedCompanyName);
	}

	@Given("Edit Last name as {string}")
	public void editLastName(String editedLastname) {
		WebElement editLastName = driver.findElement(By.id("updateLeadForm_lastName"));
		editLastName.clear();
		editLastName.sendKeys(editedLastname);
	}

	@Given("Click on Update Button")
	public void clickUpdateButton() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Then("View Lead page should be displayed")
	public void viewLeadPage() {
		String text = driver.findElement(By.xpath("//div[@id='sectionHeaderTitle_leads']")).getText();
		if (text.equals("View Lead")) {
			System.out.println("Edited and View Lead Page is displayed");
		} else {
			System.out.println("View Lead Page is not displayed, Lead Edit might not be successful");
		}
	}

	@Given("Close the Chrome Browser")
	public void closeBrowser() {
		driver.close();
	}
}