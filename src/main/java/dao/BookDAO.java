package dao;

import model.entities.Book;
import model.entities.Category;
import model.util.AbstractDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAO extends AbstractDao
{
	@Override protected Session getSession()
	{
		return super.getSession();
	}


	//	@SuppressWarnings("unchecked")
	public List<Book> findAll()
	{
//		System.out.println(getSession().isOpen());
		List<Book> list = getSession().createQuery("FROM Book ", Book
				.class).list();

//		System.out.println(list.get(0).getBooksById().size());
		getSession().close();
		return list;
	}

	public String hello()
	{
		return "category repository";
	}
}
