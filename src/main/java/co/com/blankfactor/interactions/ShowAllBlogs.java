package co.com.blankfactor.interactions;

import co.com.blankfactor.userinterfaces.BlogPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.interactions.Actions;

import static co.com.blankfactor.utils.ActorNotepad.NUMBER_PAGE_FINAL;
import static co.com.blankfactor.utils.Utilities.getValuePage;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ShowAllBlogs implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        String numberPageFinal = getValuePage(BlogPage.LBL_NUMBER_PAGE.resolveFor(actor).getText(), 3);
        actor.remember(NUMBER_PAGE_FINAL.getKey(), numberPageFinal);
        while (!numberPageFinal.equals(getValuePage(BlogPage.LBL_NUMBER_PAGE.resolveFor(actor).getText(), 2))) {
            actor.attemptsTo(
                    WaitUntil.the(BlogPage.BTN_LOAD_MORE, isPresent()),
                    Scroll.to(BlogPage.BTN_LOAD_MORE).andAlignToBottom(),
                    WaitUntil.the(BlogPage.BTN_LOAD_MORE, isEnabled()),
                    MoveMouse.to(BlogPage.BTN_LOAD_MORE).andThen(Actions::click),
                    WaitUntil.the(BlogPage.BTN_LOAD_MORE, isPresent()),
                    Scroll.to(BlogPage.LBL_NUMBER_PAGE).andAlignToBottom()
            );
        }
    }

    public static Performable ofThePage() {
        return instrumented(ShowAllBlogs.class);
    }
}
