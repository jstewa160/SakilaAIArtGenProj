package APIComponents.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmTest {

    Film myFilmtest = new Film("ACADEMY DINOSAUR",
            "A Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies",
            "PG");

    @Test
    public void testGivenFilmTitleDescRating_whenGetMapping_returnSuccess(){

        String actualFilmTitle = myFilmtest.getFilmTitle();

        String expectedFilmTitle = "ACADEMY DINOSAUR";

        Assertions.assertEquals(expectedFilmTitle, actualFilmTitle, "Failed film title check");
    }

    @Test
    public void testGivenFilmDesc_whenGetMapping_returnSuccess(){
        String actualFilmDesc = myFilmtest.getFilmDesc();

        String expectedFilmDesc = "A Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies";

        Assertions.assertEquals(expectedFilmDesc, actualFilmDesc, "Failed film desc check");
    }

    @Test
    public void testGivenFilmRating_whenGetMapping_returnSuccess(){
        String actualFilmRating = myFilmtest.getFilmRating();

        String expectedFilmRating = "PG";

        Assertions.assertEquals(expectedFilmRating, actualFilmRating, "Failed film rating check");
    }


}
