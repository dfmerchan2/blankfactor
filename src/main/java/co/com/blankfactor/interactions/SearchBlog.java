package co.com.blankfactor.interactions;

import co.com.blankfactor.userinterfaces.BlogPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.interactions.Actions;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class SearchBlog implements Interaction {

    private final String tittle;
    private final String author;

    public SearchBlog(String tittle, String author) {
        this.tittle = tittle;
        this.author = author;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        while (!BlogPage.LBL_BLOG.of(tittle, author).resolveFor(actor).isPresent()) {
            actor.attemptsTo(
                    WaitUntil.the(BlogPage.BTN_LOAD_MORE, isPresent()),
                    Scroll.to(BlogPage.BTN_LOAD_MORE).andAlignToBottom(),
                    WaitUntil.the(BlogPage.BTN_LOAD_MORE, isEnabled()),
                    MoveMouse.to(BlogPage.BTN_LOAD_MORE).andThen(Actions::click)
            );
        }
        actor.attemptsTo(
                Scroll.to(BlogPage.LBL_BLOG.of(tittle, author)).andAlignToBottom()
        );
    }

    public static Performable of(String tittle, String author) {
        return instrumented(SearchBlog.class, tittle, author);
    }

}
