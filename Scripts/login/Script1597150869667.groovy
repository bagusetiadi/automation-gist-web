import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.url)

WebUI.maximizeWindow()

WebUI.click(findTestObject('login/login'))

WebUI.setText(findTestObject('login/email'), GlobalVariable.email)

WebUI.setEncryptedText(findTestObject('login/pass'), GlobalVariable.pass)

WebUI.click(findTestObject('login/sign-in'))

if (WebUI.waitForElementPresent(findTestObject('login/avatar'), 30)) {
    KeywordUtil.markPassed('Passed')
} else {
    KeywordUtil.markFailedAndStop('error')
}

