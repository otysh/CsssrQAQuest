import framework.SeleniumTestCase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.QaEngineerVacancyPage;

public class CheckLinkAddressTest extends SeleniumTestCase {

    @Test(dataProvider = "screenshotUrl", enabled = true)
    public void CheckLinkAddressTest(String screenshotUrlAddressValue) throws Exception{

        QaEngineerVacancyPage
                .getQaEngineerVacancyPage()
                .checkIfScreenShotUrlAddressMatches(screenshotUrlAddressValue)
        ;

    }

    @DataProvider
    public Object[][] screenshotUrl(){
        return new Object[][]{
                {
                    "http://monosnap.com/",
                }
        };
    }

}
