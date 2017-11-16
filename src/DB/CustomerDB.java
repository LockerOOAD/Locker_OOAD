/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Corerid
 */
@Entity
public class CustomerDB {
    
        //private int PrimaryKey;
        private String Username;
	private String Password;
        private String Name;
        private String Tel;
        private String Email;
        private String IdCardNumber;
        private String Plan;
        
        protected float cost = 0;   //cost
        
       
	public CustomerDB(String Username, String Password, String Name, String Tel, String Email, String IdCardNumber, String Plan){
                //this.PrimaryKey = PrimaryKey;
		this.Username = Username;
                this.Password = Password;
                this.Name = Name;
                this.Tel = Tel;
                this.Email = Email;
                this.IdCardNumber = IdCardNumber;
                this.Plan = Plan;     
	}
        
//        public int getPrimaryKey() {
//		return PrimaryKey;
//	}
        
         public void setCost(float cost) {
            this.cost = cost;
        }  //cost
        
        public float discount(){            //calculate discount
            return this.cost * 0;
        }
        
        public float realCost(){
            return this.cost - discount(); 
        }  // Calculate realcost(cost - discount)
        
        
        
        ////////////////////////////////
        public void addData(String Username, String Password, String Name, String Tel, String Email, String IdCardNumber, String Plan){
        

        CustomerDB s;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("$dist/db/CustomerDB.odb");		
	EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        s = new CustomerDB(Username, Password, Name, Tel, Email, IdCardNumber, Plan);
	em.persist(s);


	em.getTransaction().commit();
    }
        ////////////////////////////////
        

         
         @Override
	public String toString() {
		return String.format("(Username: %s, Password: %s, Name: %s, E-mail: %s, Tel: %s, ID Card Number: %s, Plan: %s)", 
                        this.Username, this.Password, this.Name, this.Email, this.Tel, this.IdCardNumber, this.Plan);
	}
}
