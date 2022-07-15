package co.com.blankfactor.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BlogDetailPage {

    public static final Target LBL_NAME_OF_AUTHOR =
            Target.the("Name of the author")
                    .locatedBy("//div[@class='author-name']//a");
    public static final Target LBL_ROLE_OF_AUTHOR =
            Target.the("Role of the author")
                    .locatedBy("(//div[@class='categories-list']//a)[1]");
    public static final Target LBL_TITLE_BLOG =
            Target.the("Blog title")
                    .locatedBy("//h1[contains (@class,'post-title')]");
    public static final Target LBL_DATE =
            Target.the("Date of the blog")
                    .located(By.className("post-date"));
    public static final Target TXT_EMAIL =
            Target.the("Email text box")
                    .located(By.name("Email"));
    public static final Target BTN_SUBSCRIBE =
            Target.the("Subscribe button")
                    .located(By.id("form-newsletter-blog-submit-btn"));
    public static final Target LBL_MESSAGE =
            Target.the("Message of Subscribe")
                    .locatedBy("//div[@class='mc4wp-response']");

    private BlogDetailPage() {
    }
}
