/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import javax.persistence.*;
import java.util.*;
/**
 *
 * @author Corerid
 */
public class MainDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                Student s;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/haha.odb");		
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		s = new Student(407001, "Aayush", 67);
		em.persist(s);
		s = new Student(407002, "Tapan", 75);
		em.persist(s);
		s = new Student(407003, "Askhay", 70);
		em.persist(s);
		s = new Student(407014, "Swapnil", 71);
		em.persist(s);
		s = new Student(407028, "Prasann", 66);
		em.persist(s);
		s = new Student(407030, "Ashwin", 65);
		em.persist(s);
		s = new Student(407035, "kishor", 65);
		em.persist(s);

		em.getTransaction().commit();
		
		em.getTransaction().begin();
		
		Query q1 = em.createQuery("SELECT COUNT(s) FROM Student s");
		Query q2 = em.createQuery("select name from Student");
		Query q3 = em.createQuery("select max(aggregate) from Student ");
		Query q4 = em.createQuery("select name from Student where aggregate = 66 ", Student.class);
		Query q5 = em.createQuery("select min(aggregate) from Student ");
		Query q6 = em.createQuery("SELECT s FROM Student s");
		Query q7 = em.createQuery("select sum(aggregate) from Student ");
		Query q8 = em.createQuery("select avg(aggregate) from Student ");
		Query q9 = em.createQuery("select s from Student s order by s.aggregate asc");
		Query q10 = em.createQuery("DELETE FROM Student s WHERE s.rollNo = :p");
		
		
		System.out.println("Total Students: " + q1.getSingleResult());
		System.out.println("Students Name: " + q2.getResultList());
		System.out.println("Max marks of Student: " + q3.getSingleResult());
		System.out.println("Name of student whose Aggregate is 66: " + q4.getResultList());
		System.out.println("Min marks of Student: " + q5.getSingleResult());
		System.out.println("Students Full Details :  " + q6.getResultList());
		System.out.println("Sum marks of Students: " + q7.getSingleResult());
		System.out.println("Average marks of Student: " + q8.getSingleResult());
		System.out.println("Order By marks of Student: " + q9.getResultList());
		System.out.println("Deleted No of records: "+q10.setParameter("p", 407030).executeUpdate());
		
		
		List<Student> results = q6.getResultList();
		for (Student p : results) {
			System.out.println(p);
		}
		
		em.createQuery("delete from Student s").executeUpdate();
		
		em.getTransaction().commit();
    }
    
}
