package s23.movementMinutes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import s23.movementMinutes.domain.Exercise;
import s23.movementMinutes.domain.ExerciseRepository;

@Controller
public class ExerciseController {
	
	@Autowired
	private ExerciseRepository exeRepository;
	
	//add a new exercise
	@GetMapping(value = "/newexercise")
	public String addExercise(Model model) {
	    model.addAttribute("exercise", new Exercise());
	    return "newexercise"; 
	}
	
	//save a exercise
	@PostMapping(value = "/exercisesave")
	public String saveCategory(@ModelAttribute Exercise exercise) {
		exeRepository.save(exercise);
		return "redirect:/movementlist";
	}

}
