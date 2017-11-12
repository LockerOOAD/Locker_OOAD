/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locker;

import com.jfoenix.controls.JFXButton;
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
import javafx.stage.Stage;

/**
 *
 * @author Corerid
 */
public class SelectRoleController implements Initializable {
    
    @FXML
    private JFXButton customer;
    
    @FXML
    public void changeSceneToCustomerLogin(ActionEvent event) throws IOException{
        Parent loginParent = FXMLLoader.load(getClass().getResource("LoginCustomer.fxml"));
        Scene loginScene = new Scene(loginParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(loginScene);
        window.show();
        

    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
