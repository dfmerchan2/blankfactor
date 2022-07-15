package co.com.blankfactor.interactions;

import co.com.blankfactor.userinterfaces.BlogPage;
import co.com.blankfactor.utils.GenerateReport;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static co.com.blankfactor.utils.ActorNotepad.NUMBER_PAGE_FINAL;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ReviewBlogs implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<Integer, List<String>> dataBlogs = new HashMap<>();
        IntStream.range(1, Integer.parseInt(actor.recall(NUMBER_PAGE_FINAL.getKey())))
                .forEach(
                        i -> {
                            List<String> data = new ArrayList<>();
                            data.add(BlogPage.LST_TITLE_BLOG.of(String.valueOf(i)).resolveFor(actor).getText());
                            data.add(BlogPage.LST_READ_MORE.of(String.valueOf(i)).resolveFor(actor).getAttribute("href"));
                            dataBlogs.put(i, data);
                        }
                );
        Serenity.recordReportData().withTitle("Blog Registration").andContents(GenerateReport.ofBlogs(dataBlogs));
    }

    public static Performable ofThePage(){
        return instrumented(ReviewBlogs.class);
    }
}
