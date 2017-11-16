/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locker;

import DB.CustomerDB;
import DB.Customer_Gold;
import DB.Customer_Platinum;
import DB.Customer_Silver;
import DB.ShowCustomerDB;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
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
public class CustomerRegisterController implements Initializable {
    //ObservableList<String> planList = FXCollections.observableArrayList("Silver", "Gold", "Platinum");
    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXComboBox plan;
    
    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField tel;

    @FXML
    private JFXTextField idCardNumber;

    @FXML
    private JFXButton RegisterButton;

    @FXML
    private JFXButton BackButton;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private Label notiSameUsername;
    
    @FXML
    public void backToLogin(ActionEvent event) throws IOException{
        Parent loginCustomerParent = FXMLLoader.load(getClass().getResource("LoginCustomer.fxml"));
        Scene LoginCustomer = new Scene(loginCustomerParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(LoginCustomer);
        window.show();
        
    }
    
    public void addData(ActionEvent event) throws IOException{
        
        Stage stage;
        Parent root;
        
        String username_s = username.getText();
        String password_s = password.getText();
        String name_s = name.getText();
        String email_s = email.getText();
        String tel_s = tel.getText();
        String idCardNumber_s = idCardNumber.getText();
        String plan_s = plan.getValue().toString();
        
        CustomerDB s;
		
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("$dist/db/CustomerDB.odb");		
	EntityManager em = emf.createEntityManager();
                
        em.getTransaction().begin();
                
        Query q2 = em.createQuery("select Username from CustomerDB");
        Query q3 = em.createQuery("select max(PrimaryKey) from CustomerDB ");
        Query q6 = em.createQuery("SELECT s FROM CustomerDB s"); 
        
	List<CustomerDB> results = q2.getResultList();
                            em.close();
                    emf.close();
        
        //Check whether username already taken
        if(results.contains(username_s)){
                    
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("sameUsernamePopup.fxml"));
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(RegisterButton.getScene().getWindow());
            stage.showAndWait();
            
        }
        else{
               
            CustomerDB b ;
            
            switch(plan_s){
                
                case "Silver" : b = new Customer_Silver(username_s, password_s, name_s, tel_s, email_s, idCardNumber_s, plan_s);    break;
                case "Gold" : b = new Customer_Gold(username_s, password_s, name_s, tel_s, email_s, idCardNumber_s, plan_s);    break;
                case "Platinum" : b = new Customer_Platinum(username_s, password_s, name_s, tel_s, email_s, idCardNumber_s, plan_s);  break;
                default :   b = new CustomerDB(username_s, password_s, name_s, tel_s, email_s, idCardNumber_s, plan_s);
                
            }
            
            
             b.addData(username_s, password_s, name_s, tel_s, email_s, idCardNumber_s, plan_s);
         
            
            Parent successParent = FXMLLoader.load(getClass().getResource("SuccessRegisterCustomer.fxml"));
            Scene Success = new Scene(successParent);
        
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
            window.setScene(Success);
            window.show();


        }
        
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        plan.getItems().addAll("Silver", "Gold", "Platinum");
    }    
    
}
