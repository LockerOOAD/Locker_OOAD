/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locker;
import javax.persistence.Entity;
/**
 *
 * @author Corerid
 */
@Entity
public class CustomerDB {
        private String ID;
	private String Name;
	private String Surname;
        private String Password;
	

	CustomerDB(String ID, String name, String pass) {
		this.ID = ID;
		this.Name = name;
		this.Password = pass;
	}

	public String getID() {
		return ID;
	}

	public String getName() {
		return Name;
	}

	public String getPassword() {
		return Password;
	}

	@Override
	public String toString() {
		return String.format("(ID: %s, Name: %s, Pass: %d)", this.ID, this.Name, this.Password);
	}
    
}
