package co.com.blankfactor.tasks;

import co.com.blankfactor.interactions.SearchBlog;
import co.com.blankfactor.interactions.SelectMenuOption;
import co.com.blankfactor.userinterfaces.BlogPage;
import co.com.blankfactor.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.interactions.Actions;

import static co.com.blankfactor.utils.ActorNotepad.AUTHOR;
import static co.com.blankfactor.utils.ActorNotepad.DATE;
import static co.com.blankfactor.utils.ActorNotepad.TITLE;
import static co.com.blankfactor.utils.ActorNotepad.ROLE;
import static co.com.blankfactor.utils.ActorNotepad.LINK;
import static co.com.blankfactor.utils.MenuOptions.BLOG;
import static co.com.blankfactor.utils.MenuOptions.INSIGHTS;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class EnterTheBlog implements Task {

    private final String tittle;
    private final String author;

    public EnterTheBlog(String tittle, String author) {
        this.tittle = tittle;
        this.author = author;
    }

    @Step("{0} Juan enters the blog of: #author")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HomePage.BTN_ACCEPT_COOKIES, isPresent()),
                Click.on(HomePage.BTN_ACCEPT_COOKIES),
                SelectMenuOption.named(INSIGHTS.getValue()).andSubmenu(BLOG.getValue()),
                WaitUntil.the(BlogPage.BTN_LOAD_MORE, isPresent()),
                Scroll.to(BlogPage.BTN_LOAD_MORE).andAlignToBottom(),
                WaitUntil.the(BlogPage.BTN_LOAD_MORE, isEnabled()),
                SearchBlog.of(tittle, author));
        actor.remember(TITLE.getKey(), BlogPage.LBL_TITLE_BLOG.of(tittle, author).resolveFor(actor).getText());
        actor.remember(AUTHOR.getKey(), BlogPage.LBL_NAME_OF_AUTHOR.of(tittle, author).resolveFor(actor).getText());
        actor.remember(ROLE.getKey(), BlogPage.LBL_ROLE_OF_AUTHOR.of(tittle, author).resolveFor(actor).getText());
        actor.remember(DATE.getKey(), BlogPage.LBL_DATE.of(tittle, author).resolveFor(actor).getText());
        actor.remember(LINK.getKey(), BlogPage.BTN_READ_MORE.of(tittle, author).resolveFor(actor).getAttribute("href"));
        actor.attemptsTo(MoveMouse.to(BlogPage.BTN_READ_MORE.of(tittle, author)).andThen(Actions::click));
    }

    public static Performable of(String tittle, String author) {
        return instrumented(EnterTheBlog.class, tittle, author);
    }
}
