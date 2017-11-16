/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import javax.persistence.Entity;

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

	public String getUsername() {
		return Username;
	}

	public String getPassword() {
		return Password;
	}

	public String getName() {
		return Name;
	}
        
        public String getTel() {
		return Tel;
	}

	public String getEmail() {
		return Email;
	}
        
        public String getIdCardNumber() {
		return IdCardNumber;
	}

	public String getPlan() {
		return Plan;
	}

	@Override
	public String toString() {
		return String.format("(Username: %s, Password: %s, Name: %s, E-mail: %s, Tel: %s, ID Card Number: %s, Plan: %s)", 
                        this.Username, this.Password, this.Name, this.Email, this.Tel, this.IdCardNumber, this.Plan);
	}
}
