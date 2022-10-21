package APIComponents.demo;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SakilaFilmArtGenApplicationTests {

	@Test
	public void givenActorFirstLastName_whenGetMapping_returnSuccess() {

        String actualFirstName = Actor.getActorFirstName();
        String actualLastName = Actor.getActorLastName();

        String expectedFirstName = "John";
        String expectedLastName = "Testopolis";

        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
	}

}
