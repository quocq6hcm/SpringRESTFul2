package controllers;

import model.entities.Category;
import model.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.Category.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController
{
	@Autowired CategoryService categoryService;

	@GetMapping("/categories")
	public List list()
	{
		return categoryService.findAll();
	}

}
