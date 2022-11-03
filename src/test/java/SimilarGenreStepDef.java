import APIComponents.demo.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@ScenarioScope
public class SimilarGenreStepDef {

    private String genre;

    @Autowired
    FilmRepo filmRepo;
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    ActorRepo actorRepo;
    @Autowired
    SakilaFilmArtGenApplication sakilaFilmArtGenApplication = new SakilaFilmArtGenApplication(actorRepo, filmRepo, categoryRepo);
    private List<Film> films;

    @Given("Users chosen movie genre")
    public void users_chosen_movie_genre() {
        // Write code here that turns the phrase above into concrete actions
        genre = "Drama";
        //throw new io.cucumber.java.PendingException();
    }
    @When("Users search for a genre")
    public void users_search_for_a_genre() {
        // Write code here that turns the phrase above into concrete actions
        List<Film> films = sakilaFilmArtGenApplication.getFilmByCategory(genre);
        System.out.println(films);
        //throw new io.cucumber.java.PendingException();
    }
    @Then("The program returns movies of the same genre")
    public void the_program_returns_movies_of_the_same_genre() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(films);
        //throw new io.cucumber.java.PendingException();
    }
}
