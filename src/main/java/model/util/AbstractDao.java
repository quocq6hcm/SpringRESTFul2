package model.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
public abstract class AbstractDao<T>
{
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession()
	{
		return sessionFactory.openSession();
	}

	private Class<T> entityClass;

	private Session se = null;
	private Transaction ts;

	public AbstractDao() {
	}

	private List<T> listTemp;

	public AbstractDao(Class<T> entityClass)
	{
		this.entityClass = entityClass;
	}

	protected boolean createEntity(T entity)
	{
		try
		{
			se = getSession();
			ts = se.beginTransaction();
			se.persist(entity);
			ts.commit();

			return true;
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
			ts.rollback();
			return false;
		}
		finally
		{
			se.close();
		}
	}

	protected <T> List<T> findAll(Class<T> clazz)
	{
		try
		{
			se = sessionFactory.getCurrentSession();
//			listTemp = new ArrayList<T>();
//			listTemp = sessionFactory.getCurrentSession().createCriteria(T).list();
//			return listTemp;
			return se.createCriteria(clazz).list();
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
			ts.rollback();
			return null;
		}
		finally
		{
			se.close();

		}

	}

	protected T find(Integer id)
	{
		try
		{
			se = getSession();
			return (T) se.get(entityClass, id);
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
			return null;
		}
		finally
		{
			se.close();
		}
	}

	protected boolean update(T entity)
	{
		try
		{
			se = getSession();
			ts = se.beginTransaction();
			se.update(entity);
			ts.commit();
			return true;
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
			ts.rollback();
			return false;
		}
		finally
		{
			se.close();
		}
	}

	protected boolean remove(T entity)
	{
		try
		{
			se = getSession();
			ts = se.beginTransaction();
			se.delete(entity);
			ts.commit();
			return true;
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
			ts.rollback();
			return false;
		}
		finally
		{

			se.close();
		}
	}

//	protected List<T> runQuery(String query)
//	{
//		se = getSession();
//		listTemp = new ArrayList<T>();
//		ts = se.beginTransaction();
//		listTemp = (ArrayList<T>) se.createQuery(query).list();
//		ts.commit();
//		se.close();
//		return listTemp;
//	}
}
