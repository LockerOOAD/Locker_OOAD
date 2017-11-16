/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

//import DB.CustomerDB;
import static java.util.Collections.list;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Corerid
 */

public class ShowCustomerDB {
        public static void main(String[] args) {
            
                CustomerDB s;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$dist/db/CustomerDB.odb");		
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
                
//                s = new CustomerDB(0, "admin", "admin1234", "Corerid", "corerid@hotmail.com", "0863533138", "1100712345678", "Platinum");
//		em.persist(s);
//                
//                em.getTransaction().commit();
//		
//                em.getTransaction().begin();
		
		Query q1 = em.createQuery("SELECT COUNT(s) FROM CustomerDB s");
		Query q2 = em.createQuery("select Name from CustomerDB");
		Query q6 = em.createQuery("SELECT s FROM CustomerDB s");
                //Query q10 = em.createQuery("DELETE FROM CustomerDB s WHERE s.PrimaryKey = :p");
                
                //System.out.println("Deleted No of records: "+q10.setParameter("p", 0).executeUpdate());
		
		List<CustomerDB> results = q6.getResultList();
		for (CustomerDB p : results) {
			System.out.println(p);
		}


                //results.forEach(System.out::println);
                //System.out.println(results);
                em.getTransaction().commit();
		
        }
        
    public void addData(int i,String Username, String Password, String Name, String Tel, String Email, String IdCardNumber, String Plan){
        

        CustomerDB s;
		
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("$dist/db/CustomerDB.odb");		
	EntityManager em = emf.createEntityManager();
        
 
        em.getTransaction().begin();
        
        s = new CustomerDB(Username, Password, Name, Tel, Email, IdCardNumber, Plan);
	em.persist(s);


	em.getTransaction().commit();
    }
}
