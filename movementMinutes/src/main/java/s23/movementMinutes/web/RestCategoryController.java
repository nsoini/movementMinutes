package s23.movementMinutes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import s23.movementMinutes.domain.Category;
import s23.movementMinutes.domain.CategoryRepository;

@RestController
public class RestCategoryController {

	@Autowired
	CategoryRepository catRepository;
	
	//list all categories
	@GetMapping("/categories")
	public Iterable<Category> getCategory(){
		return catRepository.findAll();
	}
	
	//add new category
	@PostMapping("categories")
	Category newCategory(@RequestBody Category newCategory) {
		return catRepository.save(newCategory);
	}
	
	//delete category
	@DeleteMapping("/categories/{catId}")
	public Iterable<Category> deleteCategory(@PathVariable Long catId){
		catRepository.deleteById(catId);
		return catRepository.findAll();
	}
}
