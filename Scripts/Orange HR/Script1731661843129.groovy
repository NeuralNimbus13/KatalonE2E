import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

/*
Step	Expected Result
Navigate to the login page at https://opensource-demo.orangehrmlive.com/web/index.php/auth/login	Login page is displayed
Enter valid username 'Admin' in the username field	Username is entered
Enter valid password 'admin123' in the password field	Password is entered
Click the 'Login' button	User is taken to the dashboard page
*/
// Navigate to the login page
WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')

// Enter valid username 'Admin' in the username field
WebUI.setText(findTestObject('Page_OrangeHRM/input_Username_username'), 'Admin')

// Enter valid password 'admin123' in the password field
WebUI.setText(findTestObject('Page_OrangeHRM/input_Password_password'), 'admin123')

// Click the 'Login' button
WebUI.click(findTestObject('Page_OrangeHRM/button_Login'))

WebUI.verifyElementText(findTestObject('Page_OrangeHRM/h6_Dashboard'), 'Dashboard')

WebUI.closeBrowser()

