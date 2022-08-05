package mergelead;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLeadSteps {
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

	@Given("Click on Merge Leads Page")
	public void clickMergeLeads() {
		driver.findElement(By.linkText("Merge Leads")).click();
	}

	@Given("Click on From Lead Lookup Leads Image Button")
	public void clickFromLookup() {
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
	}

	@Then("Enter {string} {string} and {string} in new window, search and select first LeadId and Click To Lead Lookup Image Button and Enter {string} {string} and {string} in new window, search and select first LeadId")
	public void selectMergeId(String fromFirstName, String fromLastName, String fromCompanyName, String toFirstName,
			String toLastName, String toCompanyName) throws InterruptedException {
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fromFirstName);
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(fromLastName);
		driver.findElement(By.xpath("//input[@name='companyName']")).sendKeys(fromCompanyName);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
		driver.switchTo().window(allhandles.get(0));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> allWindows1 = driver.getWindowHandles();
		List<String> allhandles1 = new ArrayList<String>(allWindows1);
		driver.switchTo().window(allhandles1.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(toFirstName);
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(toLastName);
		driver.findElement(By.xpath("//input[@name='companyName']")).sendKeys(toCompanyName);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
		driver.switchTo().window(allhandles1.get(0));
		Thread.sleep(2000);
	}

	@Given("Click on Merge Button")
	public void clickMergeButton() {
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
	}

	@Given("Click Ok Button on alert")
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	@Then("View Lead Page should be displayed")
	public void viewLeadPage() {
		String text = driver.findElement(By.xpath("//div[@id='sectionHeaderTitle_leads']")).getText();
		if (text.equals("View Lead")) {
			System.out.println("View Lead Page is displayed");
		} else {
			System.out.println("View Lead Page is not displayed");
		}
	}

	@Given("Close the Browser")
	public void closeBrowser() {
		driver.close();
	}
}
