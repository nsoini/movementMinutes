package s23.movementMinutes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import s23.movementMinutes.domain.CategoryRepository;
import s23.movementMinutes.domain.IntensityRepository;
import s23.movementMinutes.domain.MovementRepository;
import s23.movementMinutes.domain.Movement;


@Controller
public class MovementController {
	
	@Autowired 
	private MovementRepository moveRepository;
	
	@Autowired
	private CategoryRepository catRepository;
	
	@Autowired
	private IntensityRepository inteRepository;
	
	//list all movements
	@GetMapping(value = "/movementlist")
	public String listMovements(Model model) {
		model.addAttribute("moves", moveRepository.findAll());
		return "movementlist";
	}
	
	//edit a movement
	@GetMapping(value = "/edit/{id}")
	public String editMovement(@PathVariable("id") Long moveId, Model model) {
		model.addAttribute("movement", moveRepository.findById(moveId));
		model.addAttribute("categorys", catRepository.findAll());
		model.addAttribute("intensitys", inteRepository.findAll());
		return "editmovement";
	}
	
	//delete a movement
	@GetMapping(value = "/delete/{id}")
	public String deleteMovement(@PathVariable("id") Long moveId, Model model) {
		moveRepository.deleteById(moveId);
		return "redirect:/movementlist";
	}
	
	
	// add a new movement
	@RequestMapping(value = "/add")
	public String addMovement(Model model) {
		model.addAttribute("movement", new Movement());
		model.addAttribute("categorys", catRepository.findAll());
		model.addAttribute("intensitys", inteRepository.findAll());
		return "addmovement";
	}
	
	//save a movement
	@PostMapping(value = "/save")
	public String saveMovement(@ModelAttribute Movement movement) {	
		System.out.println("Received date: " + movement.getDate());
		moveRepository.save(movement);
		return "redirect:/movementlist";
	}

}
