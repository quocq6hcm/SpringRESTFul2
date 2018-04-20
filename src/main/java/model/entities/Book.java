package model.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Book
{
	private String id;
	private String name;
	private String categoryId;
	private Category categoryByCategoryId;

	@Id @Column(name = "id")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	public String getId()
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

	@Basic @Column(name = "category_Id") public String getCategoryId()
	{
		return categoryId;
	}

	public void setCategoryId(String categoryId)
	{
		this.categoryId = categoryId;
	}

	@Override public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Book book = (Book) o;
		return id == book.id &&
				Objects.equals(name, book.name) &&
				Objects.equals(categoryId, book.categoryId);
	}

	@Override public int hashCode()
	{

		return Objects.hash(id, name, categoryId);
	}

	@ManyToOne @JoinColumn(name = "category_Id", referencedColumnName = "id",
			insertable = false, updatable = false)
	public Category getCategoryByCategoryId()
	{
		return categoryByCategoryId;
	}

	public void setCategoryByCategoryId(Category categoryByCategoryId)
	{
		this.categoryByCategoryId = categoryByCategoryId;
	}
}
