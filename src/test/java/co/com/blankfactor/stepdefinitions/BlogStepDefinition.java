package co.com.blankfactor.stepdefinitions;

import co.com.blankfactor.exceptions.InvalidMessageExceptions;
import co.com.blankfactor.interactions.OpenPlatform;
import co.com.blankfactor.questions.TheMessage;
import co.com.blankfactor.tasks.EnterTheBlog;
import co.com.blankfactor.tasks.GenerateRecord;
import co.com.blankfactor.tasks.SubscribeEmail;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.blankfactor.utils.ErrorMessages.UNEXPECTED_MESSAGE_ERROR;
import static co.com.blankfactor.utils.PlatformUrl.BLANK_FACTOR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

public class BlogStepDefinition {

    @Given("that {string} accesses the BlankFactor platform")
    public void thatAccessesTheBlankFactorPlatform(String actor) {
        theActorCalled(actor).attemptsTo(
                OpenPlatform.of(BLANK_FACTOR.getUrl())
        );
    }

    @When("he enters the blog {string} by {string}")
    public void heEntersTheBlogBy(String tittle, String author) {
        theActorInTheSpotlight().attemptsTo(
                EnterTheBlog.of(tittle, author)
        );
    }

    @And("you signed up with your email {string}")
    public void youSignedUpWithYourEmail(String email) {
        theActorInTheSpotlight().attemptsTo(
                SubscribeEmail.toTheBlogs(email)
        );
    }

    @Then("he should see the message {string}")
    public void heShouldSeeTheMessage(String message) {
        theActorInTheSpotlight()
                .should(
                        seeThat(TheMessage.ofSubscribeIs(), equalTo(message))
                                .orComplainWith(
                                        InvalidMessageExceptions.class, UNEXPECTED_MESSAGE_ERROR.getMessage()
                                )
                );
    }

    @And("he could go back to the main page and generate a log of the blogs found")
    public void heCouldGoBackToTheMainPageAndGenerateALogOfTheBlogsFound() {
        theActorInTheSpotlight().attemptsTo(
                GenerateRecord.ofTheBlogs()
        );
    }

}
