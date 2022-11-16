package apipackagecomponents.demo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@RestController
@RequestMapping("/home")
@CrossOrigin
public class SakilaFilmArtGenApplication {

	@Autowired
	private final ActorRepo actorRepo;
	@Autowired
	private final FilmRepo filmRepo;
	@Autowired
	private final CategoryRepo categoryRepo;


	public SakilaFilmArtGenApplication(ActorRepo actorRepo, FilmRepo filmRepo, CategoryRepo categoryRepo){
		this.actorRepo = actorRepo;
		this.filmRepo = filmRepo;
		this.categoryRepo = categoryRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(SakilaFilmArtGenApplication.class, args);
	}

	@GetMapping("/allActors")
	public @ResponseBody
	Iterable<Actor> getAllActors(){
		return actorRepo.findAll();
	}

	@GetMapping("/singleActor/{id}")
	public Actor getSingleActor(@PathVariable(value = "id") int actorId){
		return actorRepo.findById(actorId).orElseThrow(() -> new ResourceAccessException("Actor not found at index " + actorId));
	}

	@PostMapping("/allActors")
	public Actor createActor(@Validated @RequestBody Actor actor) {
		return actorRepo.save(actor);
	}
	@PutMapping("/allActors/{id}")
	public ResponseEntity<Actor> updateActor(@PathVariable(value = "id") Integer actorId,
											 @Validated @RequestBody Actor actor) throws ResourceAccessException{
			Actor actorHere = actorRepo.findById(actorId)
			.orElseThrow(() -> new ResourceAccessException("Actor not found for this id : : " + actorId));
			actor.setActorId(actor.getActorId());
			actor.setActorFirstName(actor.getActorFirstName());
			actor.setActorLastName(actor.getActorLastName());
			final Actor updatedActor = actorRepo.save(actor);
			return ResponseEntity.ok(updatedActor);
	}

	@DeleteMapping("/allActors/{id}")
	public Map<String, Boolean> deleteActor(@PathVariable(value = "id") int actorId)
		throws ResourceAccessException{
		Actor actorHere = actorRepo.findById(actorId)
				.orElseThrow(() -> new ResourceAccessException("Actor not found for this id :: " + actorId));

		actorRepo.delete(actorHere);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@GetMapping("/allFilms")
	Iterable<Film> getAllFilms() { return filmRepo.findAll(); }

	@GetMapping("/allFilms/random/{id}")
	public Film randomFilm(@PathVariable(value = "id") Integer id) { return filmRepo.randomFilm(id); }


	@GetMapping("/allFilms/single/{id}")
	public @ResponseBody
	Optional<Film> getFilm(@PathVariable(value="id") Integer id) {
		return filmRepo.findById(id);
	}

		@PostMapping("/allFilms")
	public Film createFilm(@Validated @RequestBody Film film) {
		return filmRepo.save(film);
	}

	@PutMapping("/allFilms/{id}")
	public ResponseEntity<Film> updateFilm(@PathVariable(value = "id") Integer filmId,
										   @Validated @RequestBody Film film) throws ResourceAccessException{
			Film filmHere = filmRepo.findById(filmId)
					.orElseThrow(() -> new ResourceAccessException("Film not found for this id :: " + filmId));
			film.setFilmId(film.getFilmId());
			film.setFilmTitle(film.getFilmTitle());
            film.setFilmDesc(film.getFilmDesc());
			film.setFilmRating(film.getFilmRating());
			final Film updatedFilm = filmRepo.save(film);
			return ResponseEntity.ok(updatedFilm);
	}

	@DeleteMapping("/allFilms/{id}")
	public Map<String, Boolean> deleteFilm(@PathVariable(value = "id") int filmId)
		throws ResourceAccessException{
		Film filmHere = filmRepo.findById(filmId)
				.orElseThrow(() -> new ResourceAccessException("Film not found for this id :: " + filmId));
		filmRepo.delete(filmHere);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@GetMapping("/allFilms/{title}")
	public String getFilmByTitle(String filmTitle){
		return FilmRepo.getFilmByTitle(filmTitle);
	}

	@GetMapping("/category/{myCategory}")
	public @ResponseBody
	List<Film> getFilmByCategory(@PathVariable(value = "myCategory") String category){
		return filmRepo.findByCategory(category);
	}

	@GetMapping("/actor/{myActor}")
	public @ResponseBody
	List<Film> getFilmByActor(@PathVariable(value = "myActor") String actor){
		return filmRepo.findByActor(actor);
	}


	@GetMapping("/films/{id}")
	public ModelAndView getFilm(@PathVariable int id) throws JSONException, InterruptedException {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("specificFilm");
		//modelAndView.addObject("film", filmRepo.findById(id).orElseThrow(() -> new IndexOutOfBoundsException()));
		//modelAndView.addObject("actorList", filmRepo.findAllById(id);
		//System.out.println(film.findByFilmID(id));

		Film input = filmRepo.findById(id).orElseThrow();

		if(input != null){
			modelAndView.addObject("image", fetchMethod(postMethod(input.getFilmDesc())));
		}

		return modelAndView;
	}

	//.......................OTHER METHODS FOR TESTING IDEAS.........................


	public String fetchMethod(String URL) throws JSONException, InterruptedException {
		RestTemplate restTemplate = new RestTemplate();
		JSONObject obj;

		do{
			TimeUnit.MILLISECONDS.sleep(250);

			ResponseEntity<String> response = restTemplate.getForEntity("https://stablehorde.net/api/v2/generate/check/" + URL, String.class);
			String test = response.getBody();

			obj = new JSONObject(response.getBody());
			System.out.println("trying");
			//System.out.println(obj.getString("finished"));
		}

		while(obj.getInt("finished") != 1);

		ResponseEntity<String> response = restTemplate.getForEntity("https://stablehorde.net/api/v2/generate/status/" + URL, String.class);

		obj = new JSONObject(response.getBody());
		JSONArray test = obj.getJSONArray("generations");
		String imageSource = test.getJSONObject(0).getString("img");

		System.out.println(imageSource);

		return imageSource;
	}

	public String postMethod(String title) throws JSONException {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		String test = "{\"prompt\": \"" + title + "\"}";
		JSONObject obj = new JSONObject(test);

		headers.add("apikey", "ob3dJ5IV9yr2bDppOIpeRw");
		headers.add("accept", "application/json");
		headers.add("Content-Type", "application/json");

		HttpEntity<String> entity = new HttpEntity<>(obj.toString(), headers);

		String URL = "https://stablehorde.net/api/v2/generate/async";
		ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.POST, entity, String.class);

		String responseTest = response.getBody();
		System.out.println(responseTest);

		JSONObject objTest = new JSONObject(response.getBody());
		String links = objTest.getString("id");

		return links;
	}


//	@Service
//	public class TestMethods {
//		@Autowired
//		RestTemplate restTemplate = new RestTemplate();
//		String fooResourceUrl = "http://localhost:8080/home/allFilms";
//		ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
//
//		ObjectMapper mapper = new ObjectMapper();
//		JsonNode root = mapper.readTree(response.getBody());
//		JsonNode name = root.path("name");
//
//		public TestMethods() throws JsonProcessingException {
//		}
//
//		public Film getFilm(String id) {
//
//			ResponseEntity<Film> resp = restTemplate.getForEntity("http://localhost:8080/employee/" + id,
//					Film.class);
//			return resp.getStatusCode() == HttpStatus.OK ? resp.getBody() : null;
//		}
//	}




}