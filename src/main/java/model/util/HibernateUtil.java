package model.util;

import model.entities.Category;
import org.hibernate.*;

import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Properties;

public class HibernateUtil
{
	private static final SessionFactory ourSessionFactory;

	static
	{
		try
		{
			Configuration configuration = new Configuration();
//			configuration.configure("hibernate.cfg.xml").buildSessionFactory();

			Properties properties = new Properties();
			properties.load(Thread.currentThread().getContextClassLoader().
					getResourceAsStream("hibernate-cfg.properties"));

			configuration.setProperties(properties);

			ourSessionFactory = configuration.buildSessionFactory();

		}
		catch (Throwable ex)
		{
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() throws HibernateException
	{
		return ourSessionFactory.openSession();
	}

	public static void main(String[] args)
	{
		Session se = HibernateUtil.getSession();
		Transaction ts = se.beginTransaction();
		List<Category> list = se.createQuery("from Category ",Category.class).list();

		for (Category b : list)
		{
			Hibernate.initialize(b.getBooksById());
		}

		ts.commit();
		se.close();



		for (Category b : list)
		{
			System.out.println(b.getName() + " - " + b.getBooksById().size());
		}
	}
}