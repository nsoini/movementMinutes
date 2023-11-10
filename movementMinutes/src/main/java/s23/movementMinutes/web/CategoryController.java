package s23.movementMinutes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import s23.movementMinutes.domain.Category;
import s23.movementMinutes.domain.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryRepository catRepository;
	
	//list all categories
	@GetMapping(value = "/categorylist")
	public String listCategories(Model model) {
		model.addAttribute("categorys", catRepository.findAll());
		return "categorylist";
	}
	
	//delete a category
	@GetMapping(value = "/catdelete/{catId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteCategory(@PathVariable("catId") Long catId, Model model) {
		catRepository.deleteById(catId);
		return "redirect:/categorylist";
	}
	
	//add a new category
	@RequestMapping(value = "/catadd")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
		
	}
	
	//save a category
	@PostMapping(value = "/catsave")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String saveCategory(@Valid @ModelAttribute Category category, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "addcategory";
		}
		catRepository.save(category);
		return "redirect:/categorylist";
	}

}
