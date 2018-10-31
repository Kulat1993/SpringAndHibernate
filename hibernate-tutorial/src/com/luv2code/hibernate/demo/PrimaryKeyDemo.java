package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// create 3 student objects
			System.out.println("Creating 3 student objects...");
			Student student1 = new Student("Bob", "Dylan", "bob@o2.pl");
			Student student2 = new Student("Johny", "Walker", "walker@wp.pl");
			Student student3 = new Student("Cristiano", "Ronaldo", "ronaldo@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save 3 student objects
			System.out.println("Saving Bob...");
			session.save(student1);
			System.out.println("Saving Johny...");
			session.save(student2);
			System.out.println("Saving Cristiano...");
			session.save(student3);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done again!");
		}
		finally {
			factory.close();
		}
		
	}

}
