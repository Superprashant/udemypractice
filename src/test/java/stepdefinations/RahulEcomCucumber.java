package stepdefinations;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.udemy.pageobject.RahullogCucuPage;
import com.udemy.test.Basetest;

import io.cucumber.java.en.*;
public class RahulEcomCucumber extends Basetest{
	
	@Given("I open the website url {string}")
	public void i_open_the_website_url(String string) {
		driver=setup();
		driver.get(string);
	}

	@When("I enter username {string} and password {string} and login")
	public void i_enter_username_and_password_and_login(String string, String string2) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
		RahullogCucuPage rapage=new RahullogCucuPage(driver);
		rapage.email().sendKeys(string);
		rapage.pass().sendKeys(string2);
		rapage.user().click();
		wait.until(ExpectedConditions.visibilityOf(rapage.pop()));
		rapage.pop().click();
		Select select=new Select(rapage.drop());
		select.selectByValue("consult");
		rapage.termsradio().click();
		rapage.signbtn().click();
	}

	@Then("I verify  {string}")
	public void i_verify(String string) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		RahullogCucuPage rapage=new RahullogCucuPage(driver);
	   wait.until(ExpectedConditions.visibilityOf(rapage.tit()));
	   Assert.assertEquals(rapage.tit().getText(), string);
	}

	@Then("added all products to cart")
	public void added_all_products_to_cart() {
		RahullogCucuPage rapage=new RahullogCucuPage(driver);
		rapage.addtocart();
	}

	@Then("I validate the {string}")
	public void i_validate_the(String string) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		RahullogCucuPage rapage=new RahullogCucuPage(driver);
		wait.until(ExpectedConditions.visibilityOf(rapage.cartbtn()));
		rapage.cartbtn().click();
		wait.until(ExpectedConditions.visibilityOf(rapage.checkoutbtn()));
		String che=rapage.checkoutbtn().getText();
		Assert.assertEquals(che, string);
		driver.quit();;
	}

	

}
