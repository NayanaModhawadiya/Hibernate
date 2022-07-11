package info.onetoone;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetch {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();

		//Query query = session.createQuery("from Student");

		Student student = session.load(Student.class, 1);

		System.out.println(student.getStudentId() + " " + student.getName() + " " + student.getEmail());

		Address address = student.getAddress();

		System.out.println(address.getAddressId() + " " + address.getCity() + " " + address.getCountry());
		
		boolean b = session.contains(student);
		
		System.out.println("session.contaions(student) :" + b);
		
		Student student1 = session.load(Student.class, 1);

		System.out.println(student1.getStudentId() + " " + student1.getName() + " " + student1.getEmail());

		session.close();
		
		Session session1 = sessionFactory.openSession();
		
		Student student2 = session1.load(Student.class, 1);

		System.out.println(student2.getStudentId() + " " + student2.getName() + " " + student2.getEmail());
		session1.close();
		sessionFactory.close();
	}
}
