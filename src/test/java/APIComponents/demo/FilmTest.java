package APIComponents.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmTest {

    Film myFilmtest = new Film("ACADEMY DINOSAUR",
            "A Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies",
            "PG");

    @Test
    public void testGivenFilmTitleDescPG_whenGetMapping_returnSuccess(){

        String actualFilmTitle = myFilmtest.getFilmTitle();
        String actualFilmDesc = myFilmtest.getFilmDesc();
        String actualFilmRating = myFilmtest.getFilmRating();

        String expectedFilmTitle = "ACADEMY DINOSAUR";
        String expectedFilmDesc = "A Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies";
        String expectedFilmRating = "PG";

        Assertions.assertEquals(expectedFilmTitle, actualFilmTitle, "Failed film title check");
        Assertions.assertEquals(expectedFilmDesc, actualFilmDesc, "Failed film desc check");
        Assertions.assertEquals(expectedFilmRating, actualFilmRating, "Failed film rating check");
    }

}
