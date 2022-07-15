package co.com.blankfactor.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class ObtainList implements Question<List<String>> {

    private final Target element;

    public ObtainList(Target element) {
        this.element = element;
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(element, isPresent()));
        return element.resolveAllFor(actor).texts();
    }

    public static ObtainList ofElement(Target element) {
        return new ObtainList(element);
    }
}