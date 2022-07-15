package co.com.blankfactor.tasks;

import co.com.blankfactor.interactions.ReviewBlogs;
import co.com.blankfactor.interactions.ShowAllBlogs;
import co.com.blankfactor.userinterfaces.BlogPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class GenerateRecord implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        getDriver().navigate().back();
        actor.attemptsTo(
                WaitUntil.the(BlogPage.LBL_NUMBER_PAGE, isPresent()),
                Scroll.to(BlogPage.LBL_NUMBER_PAGE).andAlignToBottom(),
                WaitUntil.the(BlogPage.LBL_NUMBER_PAGE, isEnabled()),
                WaitUntil.the(BlogPage.LBL_NUMBER_PAGE, isPresent()),
                ShowAllBlogs.ofThePage(),
                Scroll.to(BlogPage.LBL_NUMBER_PAGE).andAlignToBottom(),
                ReviewBlogs.ofThePage()
        );
    }

    public static Performable ofTheBlogs() {
        return instrumented(GenerateRecord.class);
    }
}
