package s23.movementMinutes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import s23.movementMinutes.domain.Exercise;
import s23.movementMinutes.domain.ExerciseRepository;

@RestController
public class RestExerciseController {
	
	@Autowired
	ExerciseRepository exeRepository;
	
	//list all exercise types
	@GetMapping("/exercises")
	public Iterable<Exercise> getExercise(){
		return exeRepository.findAll();
	}
	
	//add new exercise
	@PostMapping("/exercises")
	Exercise newExercise(@RequestBody Exercise newExercise) {
		return exeRepository.save(newExercise);
	}
	
	//delete exercise
	@DeleteMapping("/categories/{exerciseId}")
	public Iterable<Exercise> deleteExercise(@PathVariable Long exerciseId){
		exeRepository.deleteById(exerciseId);
		return exeRepository.findAll();
	}
	

}
