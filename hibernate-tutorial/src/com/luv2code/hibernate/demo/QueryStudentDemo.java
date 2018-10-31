package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create a session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();

			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display students
			displayStudents(theStudents);
			
			// query students: lastName='Ronaldo'
			theStudents = session.createQuery("from Student s where s.lastName='Ronaldo'").getResultList();
			
			// display students
			System.out.println("\nStudents who has last name of Ronaldo");
			displayStudents(theStudents);
			
			// query students: lastName='Ronaldo' or firstName='Johny'
			theStudents = session.createQuery("from Student s where s.lastName='Ronaldo' or s.firstName='Johny'").getResultList();
			
			// display students
			System.out.println("\nStudents who has last name of Ronaldo or first name of Johny");
			displayStudents(theStudents);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

}
