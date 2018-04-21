package model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Category
{
	private String id;
	private String name;
	private Collection<Book> booksById;

	@Id @Column(name = "id") public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	@Basic @Column(name = "name") public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Category category = (Category) o;
		return Objects.equals(id, category.id) &&
				Objects.equals(name, category.name);
	}

	@Override public int hashCode()
	{

		return Objects.hash(id, name);
	}

	@JsonIgnore
	@OneToMany(mappedBy = "categoryByCategoryId", fetch = FetchType.LAZY)
	public Collection<Book>
	getBooksById()
	{
		return booksById;
	}

	public void setBooksById(Collection<Book> booksById)
	{
		this.booksById = booksById;
	}
}
