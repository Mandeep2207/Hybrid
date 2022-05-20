package runner;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.AboutUs;
import pageobject.FeesAndPayment;
import pageobject.GiftCards;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.SearchPage;
import pageobject.SofaPage;
import pageobject.StudyClass;
import pageobject.TVPage;
import utilities.BaseClass;

public class MainClass extends BaseClass
{
	@Test
	public void newOne() throws Exception 
	{
		
		log=report.createTest ("Starting the Browser");
		
		log.info("website is up and running successfully");
		HomePage HP = new HomePage(driver);
		HP.icon().click();
		HP.Login().click();
		log.pass("Successfully entered into the Website");
		
		log=report.createTest("Log in Page");
		
		log.info("Login is Processing");
		LoginPage LP= new LoginPage(driver);
		Thread.sleep(5000);
		LP.eMailID().sendKeys(ex.getStringData("Mani", 0, 0));
		Thread.sleep(2000);
		LP.password().sendKeys(ex.getStringData("Mani", 0, 1));
		LP.enter().click();
		log.pass("Login successfully");
		
	log=report.createTest("Search page");
		
	log.info("Entering Something in search bar");
		HP.search().sendKeys("study table");
		HP.searchIcon().click();
		log.pass("Submitted the study table in search bar");
		log.pass("Opened the table Page");
		Thread.sleep(5000);
		SearchPage SP= new SearchPage(driver);
		SP.table().click();
		log.pass("Search Page Done");
		
		log=report.createTest ("Study Link");
		
		log.info("clicking on study link");
		Thread.sleep(2000);
		SP.study().click();
		Thread.sleep(5000);
		SP.officeTable().click();
		Thread.sleep(5000);
		StudyClass SC = new StudyClass(driver); 
		Thread.sleep(5000);
		Assert.assertEquals(SC.tableVerify().getText(), "Office Tables");
		log.pass("verification Done");
		
	   log=report.createTest("Sales Page");
		
		log.info("clicking on Sales");
		//SC.sales().click();
		Thread.sleep(5000);
		//SC.sofaBeds().click();
		SofaPage SB = new SofaPage(driver);
		System.out.println(SB.sofabVerify().getText());
		Assert.assertEquals(SB.sofabVerify().getText(),"Office Tables");
		log.pass("Sales Page is Done");
		
		log=report.createTest("Fees and Payments");
		
		log.info("clicking on Fees and Payments");
		SB.feesandpayment().click();
		Thread.sleep(2000);
		FeesAndPayment FP= new FeesAndPayment(driver);
		Thread.sleep(2000);
		Assert.assertEquals (FP.FAPVerify().getText(),"FEES AND PAYMENT OPTIONS");
		log.pass("Fees and Payments Page is Done");
		
		log=report.createTest("Gift Cards");
		
		log.info("clicking on Gift Cards");
		FP.giftCards().click(); 
		GiftCards GC = new GiftCards(driver);
		Thread.sleep(5000);
		Assert.assertEquals(GC.gcVerify().getText(),"1. First, choose an occasion");
		log.pass(" Gift Card Page is Done");
		
		log=report.createTest("About Us");
		
		log.info("clicking on About us");
		GC.aboutUs().click();
		AboutUs AU = new AboutUs(driver);
		Thread.sleep(5000);
		Assert.assertTrue(AU.aboutVerify().getText().contains("Honesty & Transparency"));
		log.pass("About us Page is Done");
		log=report.createTest("TV Units");
		
		AU.tvunits().click();
		log.info("clicking on TV unit");
		Thread.sleep(5000);
		TVPage TP = new TVPage(driver);
		//Assert.assertEquals(TP.tvUnitVerify().getText(), "TV Units");
		log.pass("TV Units verified");
		
		/*
		LP.mailID().sendKeys(ex.getStringData("SignUp", 0, 0));
		LP.password().sendKeys(ex.getStringData("SignUp", e, 1));
		//MP.signup().click();
		SignUpPage SP new SignUpPage (driver);

		SP.email().sendKeys("ManideepGharshakurthi@22");

		SP.password().sendKeys("UrbanLadder@18"); //SP.enail().sendKeys(ex.getStringData("SignUp", 0, 0)); //SP.password().sendKeys(ex.getStringData("SignUp", 0, 1)); SP.submit().click();
		*/
		System.out.println("Printed Successfully");
	}
}