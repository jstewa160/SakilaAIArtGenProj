package APIComponents.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActorsTest {

    Actor myTestActor = new Actor("John", "Testopolis");

    @Test
    public void testGivenActorFirstLastName_whenGetMapping_returnSuccess() {

        String actualFirstName = myTestActor.getActorFirstName();
        String actualLastName = myTestActor.getActorLastName();

        String expectedFirstName = "John";
        String expectedLastName = "Testopolis";

        Assertions.assertEquals(expectedFirstName, actualFirstName, "Failed First Name");
        Assertions.assertEquals(expectedLastName, actualLastName, "Failed Second Name");
    }
}
