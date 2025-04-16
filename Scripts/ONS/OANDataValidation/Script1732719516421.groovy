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

//Opens a new browser instance.
WebUI.openBrowser('')

//Navigates the browser to the URL specified in the GlobalVariable.url.
WebUI.navigateToUrl(GlobalVariable.url)

//Waits for Angular components on the page to fully load within the timeout specified in GlobalVariable.TimeOut.
WebUI.waitForAngularLoad(GlobalVariable.TimeOut)

//Clicks the "Accept Additional Cookies" button on the web page to handle cookie consent.
WebUI.click(findTestObject('ONS/Page_IntegratedDataService/button.AcceptAdditionalCookies'))

//Maximizes the browser window to ensure all elements are fully visible.
WebUI.maximizeWindow()

//Waits until the "Integrated Data Service" image element is visible on the page within the specified timeout.
WebUI.waitForElementVisible(findTestObject('ONS/Page_IntegratedDataService/Img.IntegratedDataService'), GlobalVariable.TimeOut)

//Clicks on the "Available Data" link to navigate to the data selection page.
WebUI.click(findTestObject('ONS/Page_IntegratedDataService/Lnk.AvailableData'))

//Waits for Angular components on the new page to load within a timeout of 700 milliseconds.
WebUI.waitForAngularLoad(700)

//Selects a specific dataset named "Council Tax Property Attributes Data in England and Wales Indexed."
WebUI.click(findTestObject('ONS/Page_DataSet/span_CouncilTaxPropertyAttributesDataInEnglandAndWalesIndexed'))

//Waits for the dataset's resource name header to be present on the page within the specified timeout.
WebUI.waitForElementPresent(findTestObject('ONS/Page_CouncilTaxProperty/h1.DatasetResourceName'), GlobalVariable.TimeOut)

//Verifies that specific text elements (resource name, summary, and description) on the page match the values in the test data (CouncilTaxPropertyData).
WebUI.verifyElementText(findTestObject('ONS/Page_CouncilTaxProperty/h1.DatasetResourceName'), findTestData('CouncilTaxPropertyData').getValue(
        2, 1))

WebUI.verifyElementText(findTestObject('ONS/Page_CouncilTaxProperty/span.Summary'), findTestData('CouncilTaxPropertyData').getValue(
        2, 2))

WebUI.verifyElementText(findTestObject('ONS/Page_CouncilTaxProperty/paragraph.Description'), findTestData('CouncilTaxPropertyData').getValue(
        2, 4))
//Retrieves the text from the "About Page" section.
def strTemporalcoverage = WebUI.getText(findTestObject('ONS/Page_AboutThisPage/Span.AboutPage'))

//Checks if the retrieved text contains the expected temporal coverage data from the test data file. Prints a success message if verified.
if (strTemporalcoverage.contains(findTestData('CouncilTaxPropertyData').getValue(2, 11))) {
    println('Temporal coverage verification is successful')
}

WebUI.verifyElementPresent(findTestObject('ONS/Page_AboutThisPage/Span.AboutPage'), 1000)

def strDataSetTheme = WebUI.getText(findTestObject('ONS/Page_AboutThisPage/Span.AboutPage'))

if (strDataSetTheme.contains(findTestData('CouncilTaxPropertyData').getValue(2, 7))) {
    println('DataSet Theme verification is successful')
}

def strSearchKeyword = WebUI.getText(findTestObject('ONS/Page_AboutThisPage/Span.AboutPage'))

if (strSearchKeyword.contains(findTestData('CouncilTaxPropertyData').getValue(2, 3))) {
    println('Search Keyword verification is successful')
}

def strDataCreator = WebUI.getText(findTestObject('ONS/Page_AboutThisPage/Span.AboutPage'))

if (strDataCreator.contains(findTestData('CouncilTaxPropertyData').getValue(2, 14))) {
    println('Data creator verification is successful')
}

def strFrequency = WebUI.getText(findTestObject('ONS/Page_AboutThisPage/Span.AboutPage'))

if (strFrequency.contains(findTestData('CouncilTaxPropertyData').getValue(2, 12))) {
    println('Frequency verification is successful')
}

def strRestrictionsAccess = WebUI.getText(findTestObject('ONS/Page_AboutThisPage/Span.AboutPage'))

if (strRestrictionsAccess.contains(findTestData('CouncilTaxPropertyData').getValue(2, 18))) {
    println('Restrictions for access verification is successful')
}

def strProjectApproval = WebUI.getText(findTestObject('ONS/Page_AboutThisPage/Span.AboutPage'))

if (strProjectApproval.contains(findTestData('CouncilTaxPropertyData').getValue(2, 21))) {
    println('Project approval verification is successful')
}
//Navigating to Metadata Section:
//Clicks on the metadata link to navigate to the metadata section.
WebUI.click(findTestObject('ONS/Page_MetaData/lnk.Metadata'))

//Waits for the metadata section to appear on the page.
WebUI.waitForElementPresent(findTestObject('ONS/Page_MetaData/section.Metadata'), GlobalVariable.TimeOut)

//Metadata Field Verifications:
//Extracts the geographic coverage text and verifies it against test data.
def strGeographiCoverage = WebUI.getText(findTestObject('ONS/Page_MetaData/section.Metadata'))

/*Similar steps for 
 * Geographic Level, 
 * Licensing Status, 
 * Disclosure Control, 
 * Research Outputs, 
 * Research Disclaimer, 
 * Provenance
Retrieves each field's text from the metadata section and verifies it against corresponding values in the test data file.*/

if (strGeographiCoverage.contains(findTestData('CouncilTaxPropertyData').getValue(2, 10))) {
    println('Geographic coverage verification is successful')
}

def strGeographicLevel = WebUI.getText(findTestObject('ONS/Page_MetaData/section.Metadata'))

if (strGeographicLevel.contains(findTestData('CouncilTaxPropertyData').getValue(2, 13))) {
    println('Geographic Level verification is successful')
}

def strLicensingStatus = WebUI.getText(findTestObject('ONS/Page_MetaData/section.Metadata'))

if (strLicensingStatus.contains(findTestData('CouncilTaxPropertyData').getValue(2, 16))) {
    println('Licensing status verification is successful')
}

def strDisclosureControl = WebUI.getText(findTestObject('ONS/Page_MetaData/section.Metadata'))

if (strDisclosureControl.contains(findTestData('CouncilTaxPropertyData').getValue(2, 17))) {
    println('Disclosure Control verification is successful')
}

def strResearchOutputs = WebUI.getText(findTestObject('ONS/Page_MetaData/section.Metadata'))

if (strResearchOutputs.contains(findTestData('CouncilTaxPropertyData').getValue(2, 19))) {
    println('Research Outputs verification is successful')
}

def strResearchDisclaimer = WebUI.getText(findTestObject('ONS/Page_MetaData/section.Metadata'))

if (strResearchDisclaimer.contains(findTestData('CouncilTaxPropertyData').getValue(2, 21))) {
    println('Research Disclaimer verification is successful')
}

def strProvenance = WebUI.getText(findTestObject('ONS/Page_MetaData/section.Metadata'))

if (strProvenance.contains(findTestData('CouncilTaxPropertyData').getValue(2, 23))) {
    println('Provenance verification is successful')
}
//Closes the browser, ending the test session.
WebUI.closeBrowser()