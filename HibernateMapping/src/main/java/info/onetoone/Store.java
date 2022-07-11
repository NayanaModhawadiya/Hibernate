package info.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Store {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction tx = openSession.beginTransaction();
		
		Student s1 = new Student();
		   s1.setName("Ravi Malik");    
		    s1.setEmail("ravi@gmail.com");    
		        
		    Address address1=new Address();    
		    address1.setAddressLine1("G-21,Lohia nagar");    
		    address1.setCity("Ghaziabad");    
		    address1.setState("UP");    
		    address1.setCountry("India");    
		    address1.setPincode(201301);    
		        
		    s1.setAddress(address1);    
		    address1.setStudent(s1);    
		        
		    openSession.persist(s1); 
		    openSession.persist(address1);
		    tx.commit();   

		openSession.close();
		sessionFactory.close();

	}
}
