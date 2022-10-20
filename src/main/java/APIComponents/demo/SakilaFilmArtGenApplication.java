package APIComponents.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/home")
@CrossOrigin
public class SakilaFilmArtGenApplication {

	@Autowired
	private ActorRepo actorRepo;
	public SakilaFilmArtGenApplication(ActorRepo actorRepo){
		this.actorRepo = actorRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(SakilaFilmArtGenApplication.class, args);
	}

	@GetMapping("/allActors")
	public @ResponseBody
	Iterable<Actor> getAllActors(){
		return actorRepo.findAll();
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
				.orElseThrow(() -> new ResourceAccessException("Employee not found for this id :: " + actorId));

		actorRepo.delete(actorHere);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
//	Iterable<Actor> putAllActors(){
//
//
//	}

}
