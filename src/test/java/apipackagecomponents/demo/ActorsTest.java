package apipackagecomponents.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActorsTest {

    Actor myActorTest = new Actor("John", "Testopolis");

    Actor myActorTestTwo = new Actor();

    @Test
    public void testGivenActorFirstName_whenGetMapping_returnSuccess() {

        String actualFirstName = myActorTest.getActorFirstName();

        String expectedFirstName = "John";

        Assertions.assertEquals(expectedFirstName, actualFirstName, "Failed First Name");
    }

    @Test
    public void testGivenActorLastName_whenGetMapping_returnSuccess() {

        String actualLastName = myActorTest.getActorLastName();

        String expectedLastName = "Testopolis";

        Assertions.assertEquals(expectedLastName, actualLastName, "Failed Second Name");
    }

    @Test
    public void testGivenActorID_whenGetMapping_returnSuccess(){

        int actualID = myActorTest.getActorId();

        int expectedID = 0;

        Assertions.assertEquals(expectedID, actualID, "Failed ID Check");
    }

    @Test
    public void testGivenActorID_whenPutMapping_returnSuccess(){
        myActorTest.setActorId(1);

        int expectedActorId = 1;
        int actualActorId = myActorTest.getActorId();

        Assertions.assertEquals(expectedActorId, actualActorId, "Actor ID mismatched from setter method");
    }

    @Test
    public void testGivenActorFirstName_whenPutMapping_returnSuccess(){
        myActorTest.setActorFirstName("John");

        String expectedFirstName = "John";
        String actualFirstName = myActorTest.getActorFirstName();

        Assertions.assertEquals(expectedFirstName, actualFirstName, "Actor First Name mismatched from setter method");
    }

    @Test
    public void testGivenActorLastName_whenPutMapping_returnSuccess(){
        myActorTest.setActorLastName("Testopolis");

        String expectedLastName = "Testopolis";
        String actualLastName = myActorTest.getActorLastName();

        Assertions.assertEquals(expectedLastName, actualLastName, "Actor Last Name mismatched from setter method");
    }
}
