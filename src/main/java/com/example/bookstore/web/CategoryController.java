package com.example.bookstore.web;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository repo;

    @RequestMapping(value="/categorylist", method= RequestMethod.GET)
    public String getCategories(Model model){
        model.addAttribute("categories", repo.findAll());
        return "categorylist";
    }

   //Add new category
	@RequestMapping(value="/addcategory", method = RequestMethod.GET)
	public String addCategory(Model model){
		model.addAttribute("category",new Category());
		return "addcategory";
	}

    //Save category
	@RequestMapping(value="/savecategory", method = RequestMethod.POST)
	public String saveCategory(Category category){
		repo.save(category);
		return "redirect:/categorylist";
	}

	//RESTful service to get all departments
    @RequestMapping(value="/categories", method = RequestMethod.GET)
    public @ResponseBody
	List<Category> getCategoriesRest() {
        return (List<Category>) repo.findAll();
    }

	//RESTful service to get category by id
    @RequestMapping(value="/categories/{id}", method = RequestMethod.GET)
    public @ResponseBody
	Optional<Category> findCategoryRest(@PathVariable("id") Long cId){
    	return repo.findById(cId);
    }

    // RESTful service to save new category
    @RequestMapping(value="/categories", method = RequestMethod.POST)
    public @ResponseBody Category saveCategoryRest(@RequestBody Category category) {
    	return repo.save(category);
    }
}
