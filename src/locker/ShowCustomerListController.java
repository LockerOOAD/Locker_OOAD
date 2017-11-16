/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locker;

import DB.CustomerDB;
import DB.LockerDB;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



/**
 * FXML Controller class
 *
 * @author Corerid
 */
public class ShowCustomerListController implements Initializable {

    /**
     * Initializes the controller class.
     */
   // ObservableList<CustomerDB> data;
    
    @FXML
    private TableView<CustomerDB> haha;
    
    @FXML
    private TableColumn<CustomerDB, String> username;

    @FXML
    private TableColumn<CustomerDB, String> name;

    @FXML
    private TableColumn<CustomerDB, String> plan;

    @FXML
    private TableColumn<CustomerDB, String> tel;

    @FXML
    private TableColumn<CustomerDB, String> email;

    @FXML
    private TableColumn<CustomerDB, String> idCardNumber;
    

    public void show(ActionEvent event){
//            CustomerDB s;
//		
//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("$dist/db/CustomerDB.odb");		
//	EntityManager em = emf.createEntityManager();
//                
//        em.getTransaction().begin();
//                
//        Query q1 = em.createQuery("SELECT s FROM CustomerDB");
//        List<CustomerDB> results = q1.getResultList();
//        ObservableList results2 = FXCollections.observableArrayList(results);
//        haha.setItems(results2);

//CustomerDB s;
//		
//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("$dist/db/CustomerDB.odb");		
//	EntityManager em = emf.createEntityManager();
//                
//        em.getTransaction().begin();
//                
//        Query q2 = em.createQuery("select Username from CustomerDB");
//        Query q3 = em.createQuery("select max(PrimaryKey) from CustomerDB ");
//        Query q6 = em.createQuery("SELECT s FROM CustomerDB s"); 
//        
//	List<CustomerDB> results = q2.getResultList();
//        System.out.println(Arrays.toString(results.toArray()));
//        if(results.contains("gagna")){
//            System.out.println("aaaaaa");
//        }
//        else{
//            System.out.println("aaaaaaaaaaaaaaa");
//        }
//        
//        ObservableList results2 = FXCollections.observableArrayList(results);
//        System.out.println(results2);
//        System.out.println(results);
//       haha.setItems(results2);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        username.setCellValueFactory(new PropertyValueFactory<CustomerDB, String>("Username"));
        name.setCellValueFactory(new PropertyValueFactory<CustomerDB, String>("Name"));
        plan.setCellValueFactory(new PropertyValueFactory<CustomerDB, String>("Plan"));
        tel.setCellValueFactory(new PropertyValueFactory<CustomerDB, String>("Tel"));
        email.setCellValueFactory(new PropertyValueFactory<CustomerDB, String>("Email"));
        idCardNumber.setCellValueFactory(new PropertyValueFactory<CustomerDB, String>("IdCardNumber"));
        
        
        CustomerDB s;
		
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("$dist/db/CustomerDB.odb");		
	EntityManager em = emf.createEntityManager();
                
        em.getTransaction().begin();
                
        Query q1 = em.createQuery("SELECT s FROM CustomerDB s");
        Query q2 = em.createQuery("select Type from CustomerDB");
        List<CustomerDB> results = q1.getResultList();
        ObservableList<CustomerDB> results2 = FXCollections.<CustomerDB>observableArrayList(results);
        haha.setItems(results2);
        //haha.Items(results2);
        for (Object p : results2) {
			System.out.println(p);
	}
         TableView<CustomerDB> table = new TableView<>();

            //...

                
//                TableRow<CustomerDB> row = new TableRow<>();
//                row.setOnMouseClicked(event -> {
//                                CustomerDB rowData = row.getItem();
//                        System.out.println(rowData);
//        
//        haha.setOnMouseClicked(new EventHandler<MouseEvent>(){
//            @Override
//            public void handle(MouseEvent t) {
//               TableView<CustomerDB> table = new TableView<>();
//
//            //...
//
//                table.setRowFactory( tv -> {
//                TableRow<CustomerDB> row = new TableRow<>();
//                row.setOnMouseClicked(event -> {
//                    if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
//                        System.out.println("JJJ");
//                        CustomerDB rowData = row.getItem();
//                        System.out.println(rowData);
//                    }
//                });
//                return row ;
//                });
//            }
//
//        });
    
    }
}
