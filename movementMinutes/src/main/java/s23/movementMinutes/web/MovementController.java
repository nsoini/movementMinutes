package s23.movementMinutes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import s23.movementMinutes.domain.AppUserRepository;
import s23.movementMinutes.domain.CategoryRepository;
import s23.movementMinutes.domain.IntensityRepository;
import s23.movementMinutes.domain.MovementRepository;
import s23.movementMinutes.domain.Movement;
import s23.movementMinutes.domain.AppUser;


@Controller
public class MovementController {
	
	@Autowired 
	private MovementRepository moveRepository;
	
	@Autowired
	private CategoryRepository catRepository;
	
	@Autowired
	private IntensityRepository inteRepository;
	
	@Autowired 
	private AppUserRepository userRepository;
	
	//show home page
	@RequestMapping(value = "/home")
	public String home( ) {
		return "/home";
	}
	
	//list all movements
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	
	//list all movements
	@GetMapping(value = "/movementlist")
	public String listMovements(Model model, @AuthenticationPrincipal UserDetails currentUser ) {
		AppUser user = (AppUser) userRepository.findByUsername(currentUser.getUsername());
		model.addAttribute("moves", moveRepository.findByAppuserId(user.getId()));
		return "movementlist";
	}
	
	//edit a movement
	@GetMapping(value = "/edit/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editMovement(@PathVariable("id") Long moveId, Model model) {
		model.addAttribute("movement", moveRepository.findById(moveId));
		model.addAttribute("categorys", catRepository.findAll());
		model.addAttribute("intensitys", inteRepository.findAll());
		return "editmovement";
	}
	
	//delete a movement
	@GetMapping(value = "/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteMovement(@PathVariable("id") Long moveId, Model model) {
		moveRepository.deleteById(moveId);
		return "redirect:/movementlist";
	}
	
	
	// add a new movement
	@RequestMapping(value = "/add")
	public String addMovement(Model model) {
		model.addAttribute("movement", new Movement());
		model.addAttribute("categorys", catRepository.findAll());
		model.addAttribute("intens"
				+ "itys", inteRepository.findAll());
		return "addmovement";
	}
	
	//save a movement
	@PostMapping(value = "/save")
	public String saveMovement(@Valid @ModelAttribute("movement") Movement movement, BindingResult bindingResult, Model model, @AuthenticationPrincipal UserDetails currentUser ) {	
		System.out.println("Received date: " + movement.getDate());
		if (bindingResult.hasErrors()) {
			model.addAttribute("movement", movement);
			model.addAttribute("categorys", catRepository.findAll());
			model.addAttribute("intensitys", inteRepository.findAll());
			return "addmovement";
		}
		AppUser user = (AppUser) userRepository.findByUsername(currentUser.getUsername());
		movement.setAppuser(user);
		moveRepository.save(movement);
		return "redirect:/movementlist";
	}

}
