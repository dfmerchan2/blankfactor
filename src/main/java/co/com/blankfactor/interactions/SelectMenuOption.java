package co.com.blankfactor.interactions;

import co.com.blankfactor.userinterfaces.MenuPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.interactions.Actions;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class SelectMenuOption implements Interaction {

    private final String menuOption;
    private String submenuOption;

    public SelectMenuOption(String menuOption) {
        this.menuOption = menuOption;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(MenuPage.MENU_OPTION.of(menuOption), isPresent()),
                MoveMouse.to(MenuPage.MENU_OPTION.of(menuOption)),
                WaitUntil.the(MenuPage.SUBMENU_OPTION.of(submenuOption), isEnabled()),
                MoveMouse.to(MenuPage.SUBMENU_OPTION.of(submenuOption)).andThen(Actions::click)
        );
    }

    public static SelectMenuOption named(String menuOption) {
        return instrumented(SelectMenuOption.class, menuOption);
    }

    public SelectMenuOption andSubmenu(String submenuOption) {
        this.submenuOption = submenuOption;
        return this;
    }
}