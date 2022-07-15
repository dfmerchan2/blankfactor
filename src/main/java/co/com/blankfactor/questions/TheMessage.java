package co.com.blankfactor.questions;

import co.com.blankfactor.userinterfaces.BlogDetailPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return BlogDetailPage.LBL_MESSAGE.resolveFor(actor).getText();
    }

    public static TheMessage ofSubscribeIs() {
        return new TheMessage();
    }

}
