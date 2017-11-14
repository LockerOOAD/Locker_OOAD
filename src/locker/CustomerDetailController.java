/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locker;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.persistence.Query;
/**
 * FXML Controller class
 *
 * @author Corerid
 */
public class CustomerDetailController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label username;

    @FXML
    private Label name;

    @FXML
    private Label email;

    @FXML
    private Label tel;

    @FXML
    private Label idCardNumber;

    @FXML
    private Label plan;
    
    @FXML
    private JFXButton logout;
    
    public void logOutToLoginCustomer(ActionEvent event) throws IOException{
        
        Parent loginCustomerParent = FXMLLoader.load(getClass().getResource("LoginCustomer.fxml"));
        Scene LoginCustomer = new Scene(loginCustomerParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(LoginCustomer);
        window.show();
    }
    
    public void changeToReserveLocker(ActionEvent event) throws IOException{
        
        Parent reserveLockerParent = FXMLLoader.load(getClass().getResource("ReserveLocker.fxml"));
        Scene ReserveLocker = new Scene(reserveLockerParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(ReserveLocker);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        CustomerDB s;
		
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("$dist/db/CustomerDB.odb");		
	EntityManager em = emf.createEntityManager();
                
        em.getTransaction().begin();
                
        Query q1 = em.createQuery("SELECT Name FROM CustomerDB s WHERE s.Username = :username", CustomerDB.class);
        Query q2 = em.createQuery("SELECT Email FROM CustomerDB s WHERE s.Username = :username", CustomerDB.class);
        Query q3 = em.createQuery("SELECT Tel FROM CustomerDB s WHERE s.Username = :username", CustomerDB.class);
        Query q4 = em.createQuery("SELECT IdCardNumber FROM CustomerDB s WHERE s.Username = :username", CustomerDB.class);
        Query q5 = em.createQuery("SELECT Plan FROM CustomerDB s WHERE s.Username = :username", CustomerDB.class);
        
        username.setText(LoginCustomerController.username_s);
        name.setText(q1.setParameter("username", LoginCustomerController.username_s).getSingleResult().toString());
        email.setText(q2.setParameter("username", LoginCustomerController.username_s).getSingleResult().toString());
        tel.setText(q3.setParameter("username", LoginCustomerController.username_s).getSingleResult().toString());
        idCardNumber.setText(q4.setParameter("username", LoginCustomerController.username_s).getSingleResult().toString());
        plan.setText(q5.setParameter("username", LoginCustomerController.username_s).getSingleResult().toString());
        

    }    
    
}
