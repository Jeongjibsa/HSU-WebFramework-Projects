package testHibernate;

import java.io.Serializable;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestMain {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

//		Configuration conf = new Configuration();
//		conf.configure("hibernate.cfg.xml");
//		sessionFactory = conf.buildSessionFactory();

		Serializable id;

		sessionFactory = new Configuration().configure().buildSessionFactory();

		Category category1 = new Category(); // Transient Object state
		category1.setName("컴퓨터");

		Category category2 = new Category();
		category2.setName("자동차");

		Product product1 = new Product();
		product1.setName("notebook1");
		product1.setPrice(2000);
		product1.setDescription("Awesome notebook!!!");
		product1.setCategory(category1);

		category1.getProducts().add(product1);

		Product product2 = new Product();
		product2.setName("notebook2");
		product2.setPrice(20000);
		product2.setDescription("Awesome notebook2!!!");
		product2.setCategory(category1);

		category1.getProducts().add(product2);

		Product product3 = new Product();
		product3.setName("sonata");
		product3.setPrice(20000);
		product3.setDescription("Popular Car!!!");
		product3.setCategory(category2);

		category2.getProducts().add(product3);

		Session session = sessionFactory.openSession();
		Serializable catId1 = -1;

		try {
			Transaction tx = session.beginTransaction();

			catId1 = session.save(category1); // Persistent Object state
			session.save(category2);

//			session.delete(category1);

//			session.save(product1); // instead of sql statement
//			session.save(product2); // instead of sql statement
//			session.save(product3); // instead of sql statement

//			session.delete(product3); // product3 -> category2
//			product1.setCategory(null);
//			session.delete(product1); // product1, product2 -> category1

//			Product savedProduct = session.get(Product.class, id);
//			System.out.println(savedProduct);

//			Query<Product> theQuery = session.createQuery("from Product order by name", Product.class); // HQL
//			List<Product> products = theQuery.getResultList();
//			System.out.println(products);

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close(); // Detached Object state
		}

		Session session1 = sessionFactory.openSession();
		Transaction tx1 = session1.beginTransaction();

		Category aCategory = session1.get(Category.class, catId1);
		Set<Product> products = aCategory.getProducts();
		for (Product p : products) {
			System.out.println(p.getName());
		}

		tx1.commit();
		session1.close();

		sessionFactory.close();
	}

}
