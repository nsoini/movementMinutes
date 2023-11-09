package s23.movementMinutes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteCategory(@PathVariable("catId") Long catId, Model model) {
		catRepository.deleteById(catId);
		return "redirect:/categorylist";
	}
	
	//add a new category
	@RequestMapping(value = "/catadd")
	@PreAuthorize("hasRole('ADMIN')")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
		
	}
	
	//save a category
	@PostMapping(value = "/catsave")
	@PreAuthorize("hasRole('ADMIN')")
	public String saveCategory(@ModelAttribute Category category) {
		catRepository.save(category);
		return "redirect:/categorylist";
	}

}
