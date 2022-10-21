package APIComponents.demo;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class testActor {

    Actor myTestActor = new Actor();

    @Test
    public void givenActorFirstLastName_whenGetMapping_returnSuccess() {

        String actualFirstName = myTestActor.getActorFirstName();
        String actualLastName = myTestActor.getActorLastName();

        String expectedFirstName = "John";
        String expectedLastName = "Testopolis";

        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
    }
}
