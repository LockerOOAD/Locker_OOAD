/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locker;

import DB.Student;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author Corerid
 */
public class LoginCustomerController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXPasswordField customerPass;

    @FXML
    private JFXTextField customerUsername;

    @FXML
    private JFXButton back;
    
    @FXML
    private Label status;

    
    @FXML
    public void changeSceneToSelectRole(ActionEvent event) throws IOException{
        Parent selectRoleParent = FXMLLoader.load(getClass().getResource("SelectRole.fxml"));
        Scene SelectRoleScene = new Scene(selectRoleParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(SelectRoleScene);
        window.show();
        
    }
    
    @FXML
    public void changeSceneToRegister(ActionEvent event) throws IOException{
        Parent registerParent = FXMLLoader.load(getClass().getResource("CustomerRegister.fxml"));
        Scene RegisterScene = new Scene(registerParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(RegisterScene);
        window.show();
        
    }
    
    
    
    @FXML
    public void makeLogin(ActionEvent event) throws IOException{
//        String username = customerUsername.getText();
//        String password = customerPass.getText();
//        
//        CustomerDB s;
//		
//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("$dist/db/CustomerDB.odb");		
//	EntityManager em = emf.createEntityManager();
//                
//        em.getTransaction().begin();
//        
//        Query q4 = em.createQuery("select Username from CustomerDB where Username = :username", Student.class);
        
//        if(id.equals("Kuy")&&password.equals("isas1234")){
//            
//            Parent CustomerDetailParent = FXMLLoader.load(getClass().getResource("CustomerDetail.fxml"));
//            Scene CustomerDetaileScene = new Scene(CustomerDetailParent);
//            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//
//            window.setScene(CustomerDetaileScene);
//            window.show();
//        }
//        else{
//            status.setText("Wrone ID or Password!!");
//        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
