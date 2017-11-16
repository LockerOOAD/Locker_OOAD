/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Corerid
 */
public class editLockerDB {
    
    public static void main(String[] args){
        LockerDB s;
		
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("$dist/db/LockerDB.odb");		
	EntityManager em = emf.createEntityManager();

//	em.getTransaction().begin();
//		
//	s = new LockerDB(1, "Freeze", "Available", "None");
//	em.persist(s);
//	s = new LockerDB(2, "Freeze", "Available", "None");
//	em.persist(s);
//	s = new LockerDB(3, "Freeze", "Available", "None");
//	em.persist(s);
//	s = new LockerDB(4, "Freeze", "Available", "None");
//	em.persist(s);
//	s = new LockerDB(5, "Freeze", "Available", "None");
//	em.persist(s);
//
//
//	em.getTransaction().commit();
		
	em.getTransaction().begin();
		
	Query q6 = em.createQuery("SELECT s FROM LockerDB s");

		
		
	List<LockerDB> results = q6.getResultList();
	for (LockerDB p : results) {
            System.out.println(p);
	}
        


    }
    
    
}
