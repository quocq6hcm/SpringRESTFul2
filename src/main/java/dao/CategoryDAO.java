package dao;

import model.entities.Category;
import model.util.AbstractDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAO extends AbstractDao
{
	@Override protected Session getSession()
	{
		return super.getSession();
	}


	//	@SuppressWarnings("unchecked")
	public List<Category> findAll()
	{
		System.out.println(getSession().isOpen());
		List<Category> list = getSession().createQuery("FROM Category ", Category
				.class).list();

		System.out.println(list.get(0).getBooksById().size());
		getSession().close();
		return list;
	}

	public String hello()
	{
		return "category repository";
	}
}
