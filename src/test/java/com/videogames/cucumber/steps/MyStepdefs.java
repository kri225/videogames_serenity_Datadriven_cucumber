package com.videogames.cucumber.steps;

import com.videogames.utils.TestUtils;
import com.videogames.videogameinfo.VideogameSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.core.IsEqual.equalTo;

public class MyStepdefs {
    static int id= 10 +TestUtils.getRandomValueInt();
  static int videogameID;
    static String name = ("Aroma-gun");
    static String category=("KidsGame");
    static String releaseDate =("2021-08-01T10:02:16.369Z");
    static int reviewScore = (8);
    static String rating = ("String");


    static ValidatableResponse response;

    @Steps
    VideogameSteps videogameSteps;

    @When("^user sends a get request to endpoint, they must get back a valid status code 200$")
    public void userSendsAGetRequestToEndpointTheyMustGetBackAValidStatusCode() {

        videogameSteps.getAllVideoGameFromList().statusCode(200);

    }

    @When("^I create a new videogame by providing the information id\"([^\"]*)\" name\"([^\"]*)\" releaseDate\"([^\"]*)\" reviewScore\"([^\"]*)\" category\"([^\"]*)\" rating\"([^\"]*)\"$")
    public void iCreateANewVideogameByProvidingTheInformationIdNameReleaseDateReviewScoreCategoryRating(int id, String name, String releaseDate, int reviewScore, String category, String rating) {

//        id = id +TestUtils.getRandomValueInt();
        response = videogameSteps.createNewVideoGame(id, name, releaseDate, reviewScore, category, rating).statusCode(201);
    }

    @Then("^I should be able to verify videogame with \"([^\"]*)\" is created$")
    public void iShouldBeAbleToVerifyVideogameWithIsCreated()  {
        response.statusCode(201);
        response = videogameSteps.getVideogameByID(id);
        Assert.assertEquals(response,hasValue(id));
    }
    @When("^I update a vidogame by providing new \"([^\"]*)\" category rating$")
    public void iUpdateAVidogameByProvidingNewCategoryRating(String name)  {

        id = id;
        name = name + "_Changed";
        releaseDate = releaseDate;
        reviewScore = reviewScore + 1;
        category = category +"_Changed";
        rating = rating + "_new";
        videogameSteps.updateVideogame(id,name,releaseDate, reviewScore, category, rating).statusCode(200).log().all();
    }



    @Then("^I verify product is updated$")
    public void iVerifyProductIsUpdated() {
        videogameSteps.getVideogameByID(id).body("id",equalTo(id));

    }

    @When("^I delete a created videogame ,they must get back a valid status code  is (\\d+)$")
    public void iDeleteACreatedVideogameTheyMustGetBackAValidStatusCodeIs(int videogameID) {

        videogameSteps.deleteVideoGame(id).statusCode(200);
    }

    @Then("^I verify the videogame is deleted$")
    public void iVerifyTheVideogameIsDeleted() {
        videogameSteps.getVideogameByID(videogameID).statusCode(404);
    }


}
