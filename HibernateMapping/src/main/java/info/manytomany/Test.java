package info.manytomany;

import java.util.ArrayList;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Test {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		/*
		 * Transaction tx = session.beginTransaction();
		 * 
		 * 
		 * Employer emp1 = new Employer(); Employer emp2 = new Employer();
		 * 
		 * emp1.setEpmloyerId(30); emp1.setName("Ram");
		 * 
		 * emp2.setEpmloyerId(31); emp2.setName("Shyam");
		 * 
		 * List<Employer> empList = new ArrayList<Employer>(); empList.add(emp1);
		 * empList.add(emp2);
		 * 
		 * Project p1 = new Project(); Project p2 = new Project();
		 * 
		 * p1.setProjectId(12); p1.setProjectName("Library management");
		 * 
		 * p2.setProjectId(13); p2.setProjectName("order management");
		 * 
		 * List<Project> prcList = new ArrayList<Project>(); prcList.add(p1);
		 * prcList.add(p2);
		 * 
		 * emp1.setProjects(prcList); p2.setEmp(empList);
		 * 
		 * session.save(emp1); session.save(emp2); session.save(p1); session.save(p2);
		 * 
		 * tx.commit();
		 */
		 
		Project p = session.get(Project.class,12);
		System.out.println(p);
		session.close();
		
		Session session1 = sessionFactory.openSession();
		Project pp1 = session1.get(Project.class,12);
		System.out.println(pp1);
		sessionFactory.close();
	
	}
}
