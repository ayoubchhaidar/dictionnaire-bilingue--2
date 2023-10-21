/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package aaaaaaaa;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahla baba ija mamma
 */
public class LOGINController implements Initializable {

      @FXML
    private Button button1;
       @FXML
    private Button button2;
      @FXML
    private TextField textfeild1;
      @FXML
    private TextField textfeild2;
        @FXML
    private PasswordField textfeild3;
      @FXML
private Label label1;
     @FXML
private Label label2;
     @FXML
private Label label3;
       private Parent root;
        private Stage stage;  
         private Scene scene;  
            
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         button1.setVisible(false);
          label1.setVisible(false);
           textfeild1.setVisible(false);
        // TODO
    }    
    
    @FXML
     public void logClick(ActionEvent event ) {
         
           button1.setVisible(false);
          label1.setVisible(false);
           textfeild1.setVisible(false);
        
    
           
             button2.setVisible(true);
          label2.setVisible(true);
           textfeild2.setVisible(true);
           label3.setVisible(true);
           textfeild3.setVisible(true);
        
           
     }
     
    @FXML
     public void signClick(ActionEvent event ) {
         
           button1.setVisible(true);
          label1.setVisible(true);
           textfeild1.setVisible(true);
        
    
           
             button2.setVisible(false);
          label2.setVisible(true);
           textfeild2.setVisible(true);
           label3.setVisible(true);
           textfeild3.setVisible(true);
        
           
     }
     
    @FXML
     public void connect(ActionEvent event ) {
          int exp=0;
          
           try {
         try {
    Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (ClassNotFoundException e) {
    System.out.println("Oracle JDBC driver not found.");
    e.printStackTrace();
}
                    // Establish a connection to the database
                     Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.128:1521/xe", "C##AB", "0000");
       
        
       
           
                        String query0 = "SELECT COUNT(*) FROM LOGIN  WHERE  LOGIN='"+textfeild2.getText()+"' and PASSWD='"+textfeild3.getText()+"'";        
                        PreparedStatement command0 = con.prepareStatement(query0);

                        ResultSet reader0 = command0.executeQuery();
     if (reader0.next()) {
                  exp = reader0.getInt(1);
                
            }
            
            
           
            
          
              if (exp>0){
                  
                    try {
              root = FXMLLoader.load(getClass().getResource("ajout.fxml"));
          } catch (IOException ex) {
              Logger.getLogger(ImportexportController.class.getName()).log(Level.SEVERE, null, ex);
          }
    stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    scene=new Scene(root);
    stage.setScene(scene);
    stage.show();
                  
                  
                  
                
              }
              else {
                           Alert alert = new Alert(Alert.AlertType.WARNING);
                  alert.setTitle("Warning");
            alert.setHeaderText("Login ou password inexistant!");
            alert.showAndWait();
                  
              }
             
           
           
        
    } catch (SQLException e) {
        e.printStackTrace();
    } 
        
           
     }
     
    
}
