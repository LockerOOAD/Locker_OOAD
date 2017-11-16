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
public class LockerDB {
        private int No;
        private String Type;
	private String Status;
        private String Owner;


        
       
	public LockerDB(int No, String Type, String Status, String Owner){
                this.No = No;
                this.Type = Type;
		this.Status = Status;
                this.Owner = Owner;
        }
        
        public int getNo() {
		return No;
	}
        
        public String getType() {
		return Type;
	}
      
	public String getStatus() {
		return Status;
	}

	public String getOwner() {
		return Owner;
	}

	

	@Override
	public String toString() {
		return String.format("(No: %d, Type: %s, Status: %s, Owner: %s)", 
                        this.No, this.Type, this.Status, this.Owner);
	}
    
}
