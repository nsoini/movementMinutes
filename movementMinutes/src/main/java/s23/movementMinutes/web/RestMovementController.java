package s23.movementMinutes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import s23.movementMinutes.domain.Movement;
import s23.movementMinutes.domain.MovementRepository;

@RestController
public class RestMovementController {
	
	@Autowired
	MovementRepository moveRepository;
	
	//list all moves
	@GetMapping("/movements")
	public Iterable<Movement> getMovement(){
		return moveRepository.findAll();
	}
	
	//add new movement
	@PostMapping("/movements")
	Movement newMovement(@RequestBody Movement newMovement) {
		return moveRepository.save(newMovement);
	}
	
	//edit existing movement
	@PutMapping("/movements/{id}")
	Movement editMovement(@RequestBody Movement editedMovement, @PathVariable Long id) {
		editedMovement.setId(id);
		return moveRepository.save(editedMovement);
	}
	
	//delete movement
	@DeleteMapping("/movements/{id}")
	public Iterable<Movement> deleteMovement(@PathVariable Long id){
		moveRepository.deleteById(id);
		return moveRepository.findAll();
	}

}
