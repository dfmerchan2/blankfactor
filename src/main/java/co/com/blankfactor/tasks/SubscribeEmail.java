package co.com.blankfactor.tasks;

import co.com.blankfactor.userinterfaces.BlogDetailPage;
import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.blankfactor.utils.ActorNotepad.AUTHOR;
import static co.com.blankfactor.utils.ActorNotepad.DATE;
import static co.com.blankfactor.utils.ActorNotepad.TITLE;
import static co.com.blankfactor.utils.ActorNotepad.ROLE;
import static co.com.blankfactor.utils.ActorNotepad.LINK;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class SubscribeEmail implements Task {

    private final Faker faker = new Faker();
    private final String email;

    public SubscribeEmail(String email) {
        this.email = email;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BlogDetailPage.LBL_NAME_OF_AUTHOR, isPresent()),
                WaitUntil.the(BlogDetailPage.LBL_NAME_OF_AUTHOR, isEnabled()),
                Ensure.that(getDriver().getCurrentUrl()).isEqualTo(actor.recall(LINK.getKey()).toString()),
                Ensure.that(BlogDetailPage.LBL_ROLE_OF_AUTHOR).text().isEqualTo(actor.recall(ROLE.getKey()).toString()),
                Ensure.that(BlogDetailPage.LBL_TITLE_BLOG).text().isEqualTo(actor.recall(TITLE.getKey()).toString()),
                Ensure.that(BlogDetailPage.LBL_NAME_OF_AUTHOR).text().isEqualTo(actor.recall(AUTHOR.getKey()).toString()),
                Ensure.that(BlogDetailPage.LBL_DATE).text().contains(actor.recall(DATE.getKey()).toString()),
                Scroll.to(BlogDetailPage.BTN_SUBSCRIBE).andAlignToBottom(),
                Enter.theValue(String.format(email, faker.number().digits(4))).into(BlogDetailPage.TXT_EMAIL),
                Click.on(BlogDetailPage.BTN_SUBSCRIBE),
                WaitUntil.the(BlogDetailPage.LBL_MESSAGE, isVisible()),
                Scroll.to(BlogDetailPage.LBL_MESSAGE).andAlignToBottom()
        );
    }

    public static Performable toTheBlogs(String email) {
        return instrumented(SubscribeEmail.class, email);
    }
}
