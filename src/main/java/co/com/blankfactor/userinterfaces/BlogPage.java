package co.com.blankfactor.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BlogPage {

    public static final Target LBL_BLOG =
            Target.the("Label blog")
                    .locatedBy("//div[@class='post-template__info' and contains (.,'{0}') and contains (.,'{1}')]");
    public static final Target BTN_LOAD_MORE =
            Target.the("Load more blogs button")
                    .locatedBy("//span[@class='caption']");
    public static final Target LBL_NUMBER_PAGE =
            Target.the("Number of pages label")
                    .located(By.className("results"));

    public static final Target LBL_TITLE_BLOG =
            Target.the("Blog title")
                    .locatedBy("//div[@class='post-template__info' and contains (.,'{0}') and contains (.,'{1}')]//h2");
    public static final Target LBL_NAME_OF_AUTHOR =
            Target.the("Name of the author")
                    .locatedBy("//div[@class='post-template__info' and contains (.,'{0}') and contains (.,'{1}')]//div[@class='post-meta__author']//a");
    public static final Target LBL_ROLE_OF_AUTHOR =
            Target.the("Role of the author")
                    .locatedBy("//div[@class='post-template__info' and contains (.,'{0}') and contains (.,'{1}')]//div[@class='categories-list']//a");
    public static final Target LBL_DATE =
            Target.the("Date of the blog")
                    .locatedBy("//div[@class='post-template__info' and contains (.,'{0}') and contains (.,'{1}')]//div[@class='post-meta__date']");
    public static final Target BTN_READ_MORE =
            Target.the("read more button")
                    .locatedBy("//div[@class='post-template__info' and contains (.,'{0}') and contains (.,'{1}')]//a[contains(text(),'Read more')]");

    public static final Target LST_TITLE_BLOG =
            Target.the("List blog title")
                    .locatedBy("(//div[@class='post-template__info'])[{0}]//h2[contains(@class,'post-title')]");
    public static final Target LST_READ_MORE =
            Target.the("read more button")
                    .locatedBy("(//div[@class='post-template__info'])[{0}]//a[contains (text(),'Read more')]");

    private BlogPage() {
    }
}
