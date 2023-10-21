/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

/**
 *
 * @author Ahla baba ija mamma
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private ComboBox<String> comboBox1;
     @FXML
    private ComboBox<String> comboBox2;
     @FXML
    private TextField textField;
      @FXML
    private TextArea textArea;
    @FXML
    private Button switchbutton ;
      
    private String motsss;    
         private Parent root;
        private Stage stage;  
         private Scene scene;  
     
    private final String [] lan={"EN","FR"};
    
    
    
    
    
    
    
      @FXML
    private void toadmin(ActionEvent event) {
    
    try {
              root = FXMLLoader.load(getClass().getResource("LOGIN.fxml"));
          } catch (IOException ex) {
              Logger.getLogger(ImportexportController.class.getName()).log(Level.SEVERE, null, ex);
          }
    stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    scene=new Scene(root);
    stage.setScene(scene);
    stage.show();
    
    
    }
    
    
    
    @FXML
    private void switchbutton(ActionEvent event) {
      String c1=comboBox1.getSelectionModel().getSelectedItem();
      String c2=comboBox2.getSelectionModel().getSelectedItem();
       comboBox1.setValue(c2);
        comboBox2.setValue(c1);
         textField.setText(motsss);          
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          textField.textProperty().addListener((observable, oldValue, newValue) -> {
            autoC();
        });
         
        comboBox1.getItems().addAll(lan);
        comboBox2.getItems().addAll(lan);
        comboBox1.setValue("FR");
        comboBox2.setValue("EN");
        if(!textArea.getText().isEmpty()){
            
            
            
            
        }
        
        
        
      
        // TODO
    }    
    private  void autoC(){
    
  ObservableList<String> autoCompleteList = FXCollections.observableArrayList();

        // Retrieve data from the database
        String query = "SELECT MOT FROM MOT_"+ comboBox1.getValue();
        try {
                 Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.128:1521/xe", "C##AB", "0000");
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();


            while (rs.next()) {
        autoCompleteList.add(rs.getString(1));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        AutoCompletionBinding<String> autoCompleteBinding = TextFields.bindAutoCompletion(textField, autoCompleteList);



// Add a listener to handle the AutoCompletionEvent (optional)
autoCompleteBinding.setOnAutoCompleted(new EventHandler<AutoCompletionBinding.AutoCompletionEvent<String>>() {
    @Override
    public void handle(AutoCompletionBinding.AutoCompletionEvent<String> event) {
        // Handle the AutoCompletionEvent
    }
});
    
    
    
    
}

    @FXML
     private void rechercher( ActionEvent event) {
         Alert alert = new Alert(Alert.AlertType.WARNING);
         textArea.setText("");
    
           String exp="";  

    try {
         try {
    Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (ClassNotFoundException e) {
    System.out.println("Oracle JDBC driver not found.");
    e.printStackTrace();
}
                    // Establish a connection to the database
                     Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.128:1521/xe", "C##AB", "0000");
        String selectedItem1 = comboBox1.getValue();
        String selectedItem2 = comboBox2.getValue();
        
        
        if (selectedItem1 != null && selectedItem2 != null && !selectedItem1.equals(selectedItem2)) {
           
                        String query0 = "SELECT EXAMPLE FROM MOT_" + selectedItem1 + " WHERE  MOT = '" + textField.getText() + "'";        
                        PreparedStatement command0 = con.prepareStatement(query0);

                        ResultSet reader0 = command0.executeQuery();
     while (reader0.next()) {
                 exp = reader0.getString(1);
                
            }
            
            
            String query = "SELECT * FROM MOT_" + selectedItem2 + " WHERE ID_" + selectedItem2 + " IN (SELECT ID_" + selectedItem2 + " FROM traduction WHERE ID_" + selectedItem1 + " = (SELECT ID_" + selectedItem1 + " FROM MOT_" + selectedItem1 + " WHERE  MOT = '" + textField.getText() + "'))";
            PreparedStatement command = con.prepareStatement(query);
            ResultSet reader = command.executeQuery();
            
            while (reader.next()) {
                motsss=reader.getString(2);
                String item = "Type :'" + reader.getString(3) + "',Traduction:'" + reader.getString(2) + "',Exemple:'" +reader.getString(4)  + "'Exemple2:"+ exp + "'"; // assuming the first column is a string column
                textArea.appendText("\n" + item);
            }
        } else {  
            
            
          
              if (selectedItem1.equals(selectedItem2)){
                alert.setTitle("Warning");
            alert.setHeaderText("Please select two different languages");
            alert.showAndWait();
            } 
             
           
           
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } 
    catch (NullPointerException e){
        
          alert.setTitle("Warning");
            alert.setHeaderText("Please select two  languages");
            alert.showAndWait();
    }
    
    
   

    
    
}
}