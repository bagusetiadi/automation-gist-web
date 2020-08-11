import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

def now = new Date().format('yyyy-MM-dd HH:mm:ss', TimeZone.getTimeZone('GMT+7'))

WebUI.openBrowser(GlobalVariable.url)

WebUI.maximizeWindow()

WebUI.waitForElementPresent(findTestObject('login/login'), 2)

WebUI.click(findTestObject('login/login'))

WebUI.setText(findTestObject('login/email'), GlobalVariable.email)

WebUI.setEncryptedText(findTestObject('login/pass'), GlobalVariable.pass)

WebUI.click(findTestObject('login/sign-in'))

if (WebUI.waitForElementPresent(findTestObject('login/avatar'), 50)) {
    KeywordUtil.markPassed('Passed')
} else {
    KeywordUtil.markFailedAndStop('error')
}

WebUI.click(findTestObject('create/add'))

WebUI.setText(findTestObject('create/desc'), "created with katalon studio at $now")

WebUI.setText(findTestObject('create/filename'), 'bagus.txt')

WebUI.setText(findTestObject('create/code'), "creating gists at $now")

WebUI.click(findTestObject('create/create'))

if (WebUI.waitForElementPresent(findTestObject('create/verify'), 10)) {
    KeywordUtil.markPassed('Passed')
} else {
    KeywordUtil.markFailedAndStop('error')
}

WebUI.click(findTestObject('get-list/list'))

WebUI.scrollToElement(findTestObject('get-list/bottom'), 5)

WebUI.scrollToElement(findTestObject('login/avatar'), 5)

WebUI.click(findTestObject('login/avatar'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('get-list/my-gist'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('edit/open-gist'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('edit/edit'), FailureHandling.STOP_ON_FAILURE)

WebUI.clearText(findTestObject('create/desc'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('create/desc'), "updated with katalon studio at $now")

WebUI.clearText(findTestObject('create/filename'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('create/filename'), 'bagus update.txt')

WebUI.clearText(findTestObject('create/code'))

WebUI.setText(findTestObject('create/code'), "update the code at $now")

WebUI.click(findTestObject('edit/update'), FailureHandling.STOP_ON_FAILURE)

if (WebUI.waitForElementPresent(findTestObject('create/verify'), 10)) {
    KeywordUtil.markPassed('Passed')
} else {
    KeywordUtil.markFailedAndStop('error')
}

WebUI.click(findTestObject('delete/del'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForAlert(2)

WebUI.verifyAlertPresent(2)

WebUI.acceptAlert()

if (WebUI.waitForElementPresent(findTestObject('delete/success'), 10)) {
    KeywordUtil.markPassed('Passed')
} else {
    KeywordUtil.markFailedAndStop('error')
}

WebUI.click(findTestObject('login/avatar'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('logout/logout'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('logout/confirm'), FailureHandling.STOP_ON_FAILURE)

if (WebUI.waitForElementPresent(findTestObject('logout/success'), 50)) {
    KeywordUtil.markPassed('Passed')
} else {
    KeywordUtil.markFailedAndStop('error')
}

