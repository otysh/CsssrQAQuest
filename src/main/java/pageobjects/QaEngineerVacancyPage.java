package pageobjects;

import com.codeborne.selenide.Condition;
import framework.WebDriverCommands;
import org.testng.Assert;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static framework.Constants.CONSTANT_10_SECONDS;
import static framework.Constants.qaQuestUrl;

public class QaEngineerVacancyPage extends WebDriverCommands {

    public QaEngineerVacancyPage(){
    }

    private static QaEngineerVacancyPage qaEngineerVacancyPage = null;

    public static QaEngineerVacancyPage getQaEngineerVacancyPage(){
        if(qaEngineerVacancyPage == null)
            qaEngineerVacancyPage = new QaEngineerVacancyPage();

        return qaEngineerVacancyPage;
    }

    private final String FIND_BUGS_BLOCK_URL_TEXT = "//a[text() = 'НАХОДИТЬ НЕСОВЕРШЕНСТВА']";
    private final String SCREENSHOTS_SOFT_URL_TEXT = "//a[text() = 'Софт для быстрого создания скриншотов']";

    public QaEngineerVacancyPage checkIfScreenShotUrlAddressMatches(String screenshotUrlAddress) throws Exception{

        //Go to page
        goToPage(qaQuestUrl);

        //Click 60% block link
        $(byXpath(FIND_BUGS_BLOCK_URL_TEXT)).waitUntil(Condition.visible, CONSTANT_10_SECONDS).click();

        //Check if link is right
        Assert.assertTrue($(byXpath(SCREENSHOTS_SOFT_URL_TEXT)).waitUntil(Condition.visible, CONSTANT_10_SECONDS).getText().equals(screenshotUrlAddress),
                "Error link address! Expected " + screenshotUrlAddress + " but found " + $(byXpath(SCREENSHOTS_SOFT_URL_TEXT)).getAttribute("href"));

        return  this;
    }

}
