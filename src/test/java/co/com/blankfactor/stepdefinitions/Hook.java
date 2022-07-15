package co.com.blankfactor.stepdefinitions;

import co.com.blankfactor.utils.Utilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.WebDriver;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getWebdriverManager;

public class Hook {

    WebDriver driver= getWebdriverManager().getWebdriver(Utilities.getDriver());

    @Before
    public void setStage(){
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(driver)));
    }

    @After
    public void closeDriver(){
        driver.close();
        driver.quit();
    }
}
