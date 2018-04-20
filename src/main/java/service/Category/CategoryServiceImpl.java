package service.Category;

import dao.CategoryDAO;
import model.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class CategoryServiceImpl implements CategoryService
{
	@Autowired
	private CategoryDAO dao;

	public List<Category> findAll()
	{
		return dao.findAll();
	}

	public String ahihi()
	{
		return dao.hello();
	}
}
