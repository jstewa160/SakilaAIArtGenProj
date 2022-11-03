import APIComponents.demo.SakilaFilmArtGenApplication;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class readTitleStepDef {

    private String title;
    private String foundTitle;



    SakilaFilmArtGenApplication sakilaFilmArtGenApplication =  new SakilaFilmArtGenApplication(null, null, null);


    @Given("Users chosen title")
    public void users_chosen_title() {
        // Write code here that turns the phrase above into concrete actions
        title = "ACADEMY DINOSAUR";
        //throw new io.cucumber.java.PendingException();
    }
    @When("User is searching for a film")
    public void user_is_searching_for_a_film() {
        // Write code here that turns the phrase above into concrete actions
        foundTitle = sakilaFilmArtGenApplication.getFilmByTitle(title);
        //throw new io.cucumber.java.PendingException();
    }
    @Then("The program returns the movie title")
    public void the_program_returns_the_movie_title() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(foundTitle + " updated");
        //throw new io.cucumber.java.PendingException();
    }


}
