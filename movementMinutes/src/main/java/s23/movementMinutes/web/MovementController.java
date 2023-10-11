package s23.movementMinutes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import s23.movementMinutes.domain.CategoryRepository;
import s23.movementMinutes.domain.IntensityRepository;
import s23.movementMinutes.domain.MovementRepository;

@Controller
public class MovementController {
	
	@Autowired 
	private MovementRepository moveRepository;
	
	@Autowired
	private CategoryRepository catRepository;
	
	@Autowired
	private IntensityRepository inteRepository;
	
	//list all movements
	@GetMapping(value = "movementlist")
	public String Listmovements(Model model) {
		model.addAttribute("moves", moveRepository.findAll());
		return "movementlist";
	}
	
	//edit a movement
	
	
	//delete a movement
	
	
	// add a new movement
	
	
	//save a movement
	

}
