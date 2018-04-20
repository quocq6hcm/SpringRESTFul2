package controllers;

import dao.CustomerDAO;
import model.entities.Book;
import model.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.Book.BookService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController
{

	@Autowired
	BookService bookService;

	@GetMapping("hello")
	public String sayHello()
	{
		return "hello ahihi";
	}

	@GetMapping("books")
	public List<Book> list ()
	{
		return bookService.findAll();
	}

}
