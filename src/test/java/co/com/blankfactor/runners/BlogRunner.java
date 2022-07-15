package co.com.blankfactor.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/Blog.feature",
        glue = "co.com.blankfactor.stepdefinitions",
        plugin = {"rerun:target/rerunFailed/BlogRerun.txt", "pretty"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class BlogRunner {
}
