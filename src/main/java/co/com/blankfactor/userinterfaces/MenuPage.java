package co.com.blankfactor.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public final class MenuPage {

    public static final Target MENU_OPTION =
            Target.the("Menu option")
                    .locatedBy("//ul[@id='menu-main-menu']//span[contains(.,'{0}')]");
    public static final Target SUBMENU_OPTION =
            Target.the("Submenu option")
                    .locatedBy("//p[@class='page-item__title' and contains (text(),'{0}')]");

    private MenuPage() {
    }
}
