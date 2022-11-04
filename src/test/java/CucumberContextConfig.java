import apipackagecomponents.demo.SakilaFilmArtGenApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = SakilaFilmArtGenApplication.class)
public class CucumberContextConfig {

}
