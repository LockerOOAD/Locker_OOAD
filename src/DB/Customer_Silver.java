
package DB;


public class Customer_Silver  extends CustomerDB{

    public Customer_Silver(String Username, String Password, String Name, String Tel, String Email, String IdCardNumber, String Plan) {
        super(Username, Password, Name, Tel, Email, IdCardNumber, Plan);
    }
    
    
   @Override
    public float discount() {
         return (float) (super.cost * .1);
    }
    
    
    
}
