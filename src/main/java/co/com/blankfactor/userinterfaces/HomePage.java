package co.com.blankfactor.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    public static final Target BTN_ACCEPT_COOKIES =
            Target.the("Blog title")
                    .locatedBy("//a[@role='button' and contains (text(),'Accept')]");

    private HomePage() {
    }
}
