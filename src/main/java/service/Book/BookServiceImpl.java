package service.Book;

import dao.BookDAO;
import model.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class BookServiceImpl implements BookService
{

	@Autowired BookDAO bookDAO;

	public List<Book> findAll()
	{
		return bookDAO.findAll();
	}
}
