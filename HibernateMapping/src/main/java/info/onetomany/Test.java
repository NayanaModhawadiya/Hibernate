package info.onetomany;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction tx = openSession.beginTransaction();

		Employee e1 = new Employee();
		e1.setsName("Ajay");
		
		Employee e2 = new Employee();
		e2.setsName("Chirag");
		
		Department d1 = new Department();
		d1.setdName("Engineering");
		
		HashSet<Employee> empSet = new HashSet<Employee>();
		empSet.add(e1);
		empSet.add(e2);
		
		d1.setEmps(empSet);
		
		/*
		 * Department d2 = new Department(); d2.setdName("Medical");
		 * 
		 * d2.setEmps(empSet);
		 */
		
		openSession.persist(d1);
		//openSession.persist(d2);
		
		tx.commit();
		openSession.close();
		sessionFactory.close();
	}

}
