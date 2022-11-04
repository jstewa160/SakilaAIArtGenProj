package APIComponents.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class FilmTest {

    Film myFilmtest = new Film("ACADEMY DINOSAUR",
            "A Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies",
            "PG");


    @Test
    public void testFilmId_whenGetMapping_returnSuccess(){
        int actualFilmId = myFilmtest.getFilmId();

        int expectedFilmId = 0;

        Assertions.assertEquals(expectedFilmId, actualFilmId, "Failed film ID check");
    }

    @Test
    public void testGivenFilmTitleDesc_whenGetMapping_returnSuccess(){

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

    @Test
    public void testFilmTitle_whenPutMapping_returnSuccess(){
        myFilmtest.setFilmTitle("ACADEMY DINOSAURR");

        String expectedFilmTitle = "ACADEMY DINOSAURR";
        String actualFilmTitle = myFilmtest.getFilmTitle();

        Assertions.assertEquals(expectedFilmTitle, actualFilmTitle, "Film title mismatched from setter method");
    }

    @Test
    public void testFilmId_whenPutMapping_returnSuccess(){
        myFilmtest.setFilmId(1);

        int expectedFilmId = 1;
        int actualFilmId = 1;

        Assertions.assertEquals(expectedFilmId, actualFilmId, "Film ID mismatched from setter method");
    }

    @Test
    public void testFilmDesc_whenPutMapping_returnSuccess(){
        myFilmtest.setFilmDesc("A Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies");

        String expectedFilmDesc = "A Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies";
        String actualFilmDesc = myFilmtest.getFilmDesc();

        Assertions.assertEquals(expectedFilmDesc, actualFilmDesc, "Film description mismatched from setter method");
    }

    @Test
    public void testFilmRating_whenPutMapping_returnSuccess(){
        myFilmtest.setFilmRating("PG");

        String expectedFilmRating = "PG";
        String actualFilmRating = myFilmtest.getFilmRating();

        Assertions.assertEquals(expectedFilmRating, actualFilmRating, "Film rating mismatched from setter method");
    }

    @Test
    public void testFilmCategory_whenGetMapping_returnSuccess(){
        myFilmTest.
    }


}
