package com.nitara.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Health_AddDewormingPage extends BasePage{

	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*amountValue.*\"))") 
	private MobileElement amount;

	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*saveBtn.*\"))") 
	private MobileElement save_button;


	@AndroidFindBy(id = "dateValue") 
	private MobileElement dewormerDate;


	public void enter_dewormerDate(String date) {
		dewormerDate.clear();
		sendKeys(dewormerDate,date);
	}



	public void deselect_Dewormer() {
		List<MobileElement> deselect = (List<MobileElement>) driver.findElementsById("com.nitara.serviceprovider:id/checkbox");
		for(int i=0;i<deselect.size()-1 ;i++ ) {
			System.out.println("No Click");
			if(deselect.get(i).getAttribute("checked").equals("true")) {
				System.out.println("Click");
				deselect.get(i).click();	
			}

		}


	}


	public void select_dewormer(String dewormer) {
		String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/";

		for(int i=1;i<6;i++) {
			WebElement dewormers = driver.findElement(By.xpath(xpath+"android.widget.FrameLayout["+i+"]/android.widget.TextView"));
			System.out.println(dewormers.getText());
			if(dewormers.getText().equalsIgnoreCase(dewormer)) {
				driver.findElement(By.xpath(xpath+"android.widget.FrameLayout["+i+"]/android.widget.CheckBox")).click();
				System.out.println(dewormers.getText());
				break;

			}
		}
	}
	public void enter_Amount(String value) {
		waitForVisibility(amount);
		sendKeys(amount, value);
	}


	public void click_Save() {
		waitForVisibility(save_button);
		click(save_button);
	}



}
