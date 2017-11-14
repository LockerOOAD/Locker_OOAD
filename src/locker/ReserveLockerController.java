/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locker;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
 * FXML Controller class
 *
 * @author Corerid
 */
public class ReserveLockerController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXComboBox type;

    @FXML
    private JFXButton confirmButton;
    
    public void changeToCustomerDetail(ActionEvent event) throws IOException{
        
        Parent reserveLockerParent = FXMLLoader.load(getClass().getResource("CustomerDetail.fxml"));
        Scene ReserveLocker = new Scene(reserveLockerParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(ReserveLocker);
        window.show();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        type.getItems().addAll("Small", "Medium", "Big", "Fresh Food");
    }    
    
}
