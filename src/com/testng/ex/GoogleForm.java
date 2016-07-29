package com.testng.ex;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleForm {

	//Removed the public args, since it makes testNg skip.
	//If you want, you can put test parmeters in the testng XML file like always and pick it up from there. 
	//EG: String seleniumHost = context.getCurrentXmlTest().getParameter("selenium.host");
	//need the xml to have: <parameter name="selenium.host" value="localhost" />

	
		WebDriver d1;
		@BeforeTest
		public void setDriver(){
		d1=new FirefoxDriver();
		d1.get("https://accounts.google.com/signup");
		//At this point we've obtained the page we want to play with.
		}
		
		
		@Test
		public void names(){
		//Let's sort out the name fields
		WebElement w1=d1.findElement(By.id("FirstName"));
		w1.sendKeys("Adithya");
		WebElement w2=d1.findElement(By.id("LastName"));
		w2.sendKeys("Das");
		Assert.assertEquals(w2.getText(), "Das");
		}
		
		@Test
		public void userName(){
		//All done. Let's fix your username.
		
		d1.findElement(By.id("GmailAddress")).sendKeys("adithya.dasp");
		}
		
		@Test
		public void passwd(){
		//Setting up Passwords
		d1.findElement(By.id("Passwd")).sendKeys("johnoliver");
		
		d1.findElement(By.id("PasswdAgain")).sendKeys("johnoliver");
		}
		
		@Test 
		public void birthday(){
		//Setting up the Birthday
		d1.findElement(By.xpath("//div[@role='listbox']")).sendKeys("February");
		d1.findElement(By.id("BirthDay")).sendKeys("16");
		d1.findElement(By.id("BirthYear")).sendKeys("1992");
		}
		
		@Test
		public void gender(){
		//Assign Gender
		d1.findElement(By.xpath("//div[@aria-activedescendant=':d']")).sendKeys("Male");
		}
		
		@Test
		public void phoneNumber(){
		// Type you phone number here
        d1.findElement(By.name("RecoveryPhoneNumber")).sendKeys("9920448605");
		}
		
		@Test
		public void setCountry(){
        //Location Setting
        d1.findElement(By.className("nextstep-button")).sendKeys("Rwanda");
        //All done. Now click on that next button.
        
		}
		
		@Test(priority=3) 
		public void setandGO(){
        d1.findElement(By.id("submitbutton")).click(); 
		//Now that we've clicked, we need to get control of the Dialog
        //Now we need to scroll down to the bottom of this dialog and click the I agree button
        JavascriptExecutor js = (JavascriptExecutor) d1;
        js.executeScript("arguments[0].scrollTop = arguments[1];",d1.findElement(By.id("tos-scroll")),Integer.MAX_VALUE);
        d1.findElement(By.id("iagreebutton")).click();
        //d1.close();
        
		}
        //All done. Now we wait for text. Next part can 'only' be done manually. Close the browser for now
		
		

}
