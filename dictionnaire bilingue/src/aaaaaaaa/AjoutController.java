/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package aaaaaaaa;


import java.io.IOException;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.AutoCompletionBinding.AutoCompletionEvent;
import org.controlsfx.control.textfield.TextFields;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahla baba ija mamma
 */
public class AjoutController implements Initializable {
    @FXML
    private ComboBox<String> comboBox1;
   
    @FXML
    private ComboBox<String> comboBox3;
    @FXML
    private ComboBox<String> comboBox4;
    @FXML
    private ComboBox<String> comboBox5;
    @FXML
    private ComboBox<String> comboBox6;
    @FXML
    private TextField textField;
     @FXML
    private TextField mot1; 
     @FXML
    private TextField mot2; 
     @FXML
    private TextField ex1;
      @FXML
    private TextField ex2;
       @FXML
    private TextField ex3;
        @FXML
    private TextField ex4;
        
    private Parent root;
        private Stage stage;  
         private Scene scene;  
    @FXML
    private Button button1;
    @FXML
    private Button button2;
        @FXML
    private Button button3; 
        @FXML
    private Button buttonsup;
         @FXML
    private Button buttonmod;
    @FXML
    private Label labelL1;   
  
    @FXML
    private Label label3;
     @FXML
    private Label ajout1;
     @FXML
    private Label label4;
      @FXML
    private Label label5;
       @FXML
    private Label label6;
        @FXML
    private Label label7;
         @FXML
    private Label label8;
     

      
       private final String [] lan={"EN","FR"};
        private final String [] type={"Nom","Verbe","Adjectif","Adverbe"};
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
         textField.textProperty().addListener((observable, oldValue, newValue) -> {
            autoC();
        });
         comboBox1.getItems().addAll(lan);
        comboBox3.getItems().addAll(lan);
        comboBox4.getItems().addAll(lan);
         comboBox5.getItems().addAll(type);
        comboBox6.getItems().addAll(type);
        comboBox1.setValue("FR");

    comboBox1.setVisible(false);
     textField.setVisible(false);
     button1.setVisible(false);
      labelL1.setVisible(false);
      label3.setVisible(false);
      button2.setVisible(false);
           buttonsup.setVisible(false);
            buttonmod.setVisible(false);


        // TODO
    } 
    
     @FXML
private void thirdadd(ActionEvent event) {
    
    
    textField.setText("");
    ex1.setText("");
    ex2.setText("");
    mot1.setText("");
    mot2.setText("");
    ex3.setText("");
    ex4.setText("");
    
     ajout1.setText("Modification");
          buttonsup.setVisible(false);
comboBox1.setVisible(true);
     textField.setVisible(true);
     button1.setVisible(true);
      labelL1.setVisible(true);
      label3.setVisible(true);
      label5.setVisible(true);
      label6.setVisible(true);
      label7.setVisible(true);     
      label8.setVisible(true);
      mot1.setVisible(true);
      ex1.setVisible(true);
      ex2.setVisible(true);
               buttonmod.setVisible(true);

      

         button2.setVisible(false);
          button3.setVisible(false);

       comboBox3.setVisible(false);
        label4.setVisible(false);
       comboBox4.setVisible(false);
        mot2.setVisible(false);
        comboBox6.setVisible(false);
        ex3.setVisible(false);
         ex4.setVisible(false);



       










} @FXML
private void fourthadd(ActionEvent event) {
       
    textField.setText("");
    ex1.setText("");
    ex2.setText("");
    mot1.setText("");
    mot2.setText("");
    ex3.setText("");
    ex4.setText("");
     ajout1.setText("Suppression");
     
     buttonsup.setVisible(true);
comboBox1.setVisible(true);
     textField.setVisible(true);
     button1.setVisible(true);
      labelL1.setVisible(true);
      label3.setVisible(true);
      label5.setVisible(true);
      label6.setVisible(true);
      label7.setVisible(true);     
      label8.setVisible(true);
      mot1.setVisible(true);
      ex1.setVisible(true);
      ex2.setVisible(true);
      buttonmod.setVisible(false);

      

      button2.setVisible(false);
      button3.setVisible(false);

      comboBox3.setVisible(false);
      label4.setVisible(false);
      comboBox4.setVisible(false);
       mot2.setVisible(false);
       comboBox6.setVisible(false);
       ex3.setVisible(false);
        ex4.setVisible(false);



       










}
      @FXML
       public void ModifierTrad(ActionEvent event ) {
      
       String text = mot1.getText();

     if(text.matches("[a-zA-Z]+")){
         
          try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.128:1521/xe", "C##AB", "0000");
        con.setAutoCommit(true);
        String query = "UPDATE  MOT_"+comboBox1.getSelectionModel().getSelectedItem()+" set MOT='"+ mot1.getText()+"',TYPE='"+comboBox5.getSelectionModel().getSelectedItem()+"',EXAMPLE='"+ex1.getText()+"',EXAMPLE2='"+ex2.getText()+"' Where MOT='"+textField.getText()+"'";                                                                                                         
        PreparedStatement statement = con.prepareStatement(query);
        int  result = statement.executeUpdate();
        if (result>0)
          {
             Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("CONFIRMATION:");
            alert1.setHeaderText(" Maj avec succees!");
            alert1.showAndWait(); 
              
          }
          }
          
          
         catch (SQLException ex) {
        ex.printStackTrace();
    }
         
         
         
         
     }else {
                  Alert alert = new Alert(Alert.AlertType.WARNING);

         alert.setTitle("Warning");
            alert.setHeaderText(" Mot invalide!");
            alert.showAndWait();
         
     }
 
       }

     @FXML
       public void ajouterTrad(ActionEvent event ) {int maxID ;
       
       
                      Alert alert = new Alert(Alert.AlertType.WARNING);   

     String text1 = mot1.getText();
          String text2 = mot2.getText();

if (text1.matches("[a-zA-Z]+") && text2.matches("[a-zA-Z]+") ) {
        try {
                  Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.128:1521/xe", "C##AB", "0000");
        con.setAutoCommit(true);
        String query = "SELECT MAX(ID_FR) AS MaxID FROM (SELECT ID_FR FROM MOT_FR UNION SELECT ID_EN FROM MOT_EN)";
        PreparedStatement statement = con.prepareStatement(query);
        ResultSet result = statement.executeQuery();
            int newID = 0;
        if (result.next()) {
            maxID = result.getInt("MaxID");
            newID = maxID + 1;
        
        
        
        }   result.close();
        statement.close();
          String querycheck = "SELECT count(*)  FROM MOT_" + comboBox3.getSelectionModel().getSelectedItem() + " WHERE MOT='"+mot1.getText()+"'";
           PreparedStatement statementcheck = con.prepareStatement(querycheck);
           ResultSet resultcheck = statementcheck.executeQuery();
           int check = 0;
          if (resultcheck.next()) {
     check = resultcheck.getInt(1);
              }
        
     
        
    
           if(check==0){
        
        
        
    String queryL2 = "INSERT INTO MOT_" + comboBox3.getSelectionModel().getSelectedItem() + " (ID_" + comboBox3.getSelectionModel().getSelectedItem() + ", Mot,type,example,example2) VALUES (?,?,?,?,?)";
    PreparedStatement stmtL2 = con.prepareStatement(queryL2);
    stmtL2.setInt(1, newID);
    stmtL2.setString(2, mot1.getText());
    stmtL2.setString(3, comboBox5.getSelectionModel().getSelectedItem());
    stmtL2.setString(4, ex1.getText());
    stmtL2.setString(5, ex2.getText());
    stmtL2.executeUpdate();
    stmtL2.close();
    
         
    String queryL3 = "INSERT INTO MOT_" + comboBox4.getSelectionModel().getSelectedItem() + " (ID_" + comboBox4.getSelectionModel().getSelectedItem() + ", Mot,type,example,example2) VALUES (?,?,?,?,?)";
    PreparedStatement stmtL3 = con.prepareStatement(queryL3);
    stmtL3.setInt(1, newID);
    stmtL3.setString(2, mot2.getText());
    stmtL3.setString(3, comboBox6.getSelectionModel().getSelectedItem());
    stmtL3.setString(4, ex3.getText());
    stmtL3.setString(5, ex4.getText());
    stmtL3.executeUpdate();
    stmtL3.close();
    
         
    String queryL = "INSERT INTO TRADUCTION  (ID_" + comboBox3.getSelectionModel().getSelectedItem() + ",ID_" + comboBox4.getSelectionModel().getSelectedItem() + ") VALUES (?,?)";
    PreparedStatement stmtL = con.prepareStatement(queryL);
    stmtL.setInt(1, newID); 
    stmtL.setInt(2, newID);
  
    stmtL.executeUpdate();
    stmtL.close();
    
    
    con.close();
    Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("CONFIRMATION:");
            alert1.setHeaderText(" Ajout avec succees!");
            alert1.showAndWait();
        
           }
           else {
                alert.setTitle("Warning");
            alert.setHeaderText(" Attention Mot existant !");
            alert.showAndWait();
               
               
           }
        
        
        
        
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
         
         
     
          } else {
    
     alert.setTitle("Warning");
            alert.setHeaderText(" Mot invalide!");
            alert.showAndWait();
    
}
     
        
     
     
     
     
     
     }
    
     @FXML
     public void ajouterPartTrad(ActionEvent event ) {int maxID ;
     
      Alert alert = new Alert(Alert.AlertType.WARNING);
String text = mot2.getText();

     if(text.matches("[a-zA-Z]+") &&  (comboBox1.getSelectionModel().getSelectedItem() !=comboBox4.getSelectionModel().getSelectedItem() )  ){
         
    
     
     
     
        try {
                 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.128:1521/xe", "C##AB", "0000");
        con.setAutoCommit(true);
        String query = "SELECT MAX(ID_FR) AS MaxID FROM (SELECT ID_FR FROM MOT_FR UNION SELECT ID_EN FROM MOT_EN)";
        PreparedStatement statement = con.prepareStatement(query);
        ResultSet result = statement.executeQuery();
            int newID = 0;
        if (result.next()) {
            maxID = result.getInt("MaxID");
            newID = maxID + 1;
        }
        result.close();
        statement.close();
        
        String query1 = "SELECT ID_" + comboBox1.getSelectionModel().getSelectedItem() + " AS ID FROM MOT_"+ comboBox1.getSelectionModel().getSelectedItem()+ " WHERE MOT='"+ textField.getText() + "'";
        PreparedStatement statement1 = con.prepareStatement(query1);
        ResultSet result1 = statement1.executeQuery();
            int actualID = 0;
        if (result1.next()) {
            actualID = result1.getInt("ID");
            
        }
        result1.close();
        statement1.close();
        
        
         String querycheck = "SELECT count(*)  FROM MOT_" + comboBox4.getSelectionModel().getSelectedItem() + " WHERE MOT='"+mot2.getText()+"'";
           PreparedStatement statementcheck = con.prepareStatement(querycheck);
           ResultSet resultcheck = statementcheck.executeQuery();
           int check = 0;
          if (resultcheck.next()) {
     check = resultcheck.getInt(1);
              }
     if(check==0){
         
     
         
    String queryL3 = "INSERT INTO MOT_" + comboBox4.getSelectionModel().getSelectedItem() + " (ID_" + comboBox4.getSelectionModel().getSelectedItem() + ", Mot,type,example,example2) VALUES (?,?,?,?,?)";
    PreparedStatement stmtL3 = con.prepareStatement(queryL3);
    stmtL3.setInt(1, newID);
    stmtL3.setString(2, mot2.getText());
    stmtL3.setString(3, comboBox6.getSelectionModel().getSelectedItem());
    stmtL3.setString(4, ex3.getText());
    stmtL3.setString(5, ex4.getText());
    stmtL3.executeUpdate();
    stmtL3.close();
    
         
    String queryL = "INSERT INTO TRADUCTION  (ID_" + comboBox1.getSelectionModel().getSelectedItem() + ",ID_" + comboBox4.getSelectionModel().getSelectedItem() + ") VALUES (?,?)";
    PreparedStatement stmtL = con.prepareStatement(queryL);
    stmtL.setInt(1, actualID); 
    stmtL.setInt(2, newID);
  
    stmtL.executeUpdate();
    stmtL.close();
    
    
    con.close();

        
        
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
          alert1.setTitle("CONFIRMATION");
            alert1.setHeaderText(" Ajout avec sccees!");
            alert1.showAndWait();
        
      }else {
           alert.setTitle("Warning");
            alert.setHeaderText(" Mot Existant!");
            alert.showAndWait();
     }  
        
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
         
         
   
        
         }else {
          
          alert.setTitle("Warning");
            alert.setHeaderText(" Mot invalide ou meme langue selectionner!");
            alert.showAndWait();
         
         
     }
     
     
     
     
     
     }
    
    
    @FXML
     public void firstadd(ActionEvent event ) {
            
    textField.setText("");
    ex1.setText("");
    ex2.setText("");
    mot1.setText("");
    mot2.setText("");
    ex3.setText("");
    ex4.setText("");
            ajout1.setText("Ajout");

     buttonsup.setVisible(false);

    comboBox1.setVisible(false);
     textField.setVisible(false);
     button1.setVisible(false);
      labelL1.setVisible(false);
      label3.setVisible(false);
      button2.setVisible(false);
            button3.setVisible(true);

      
        buttonmod.setVisible(false);

      
       label8.setVisible(true);
    label7.setVisible(true);
    label6.setVisible(true);
    label5.setVisible(true);
    label4.setVisible(true);
    comboBox3.setVisible(true);
    comboBox4.setVisible(true);
    comboBox5.setVisible(true);
    comboBox6.setVisible(true);
    
    mot1.setVisible(true);
    mot2.setVisible(true);
    ex1.setVisible(true);
    ex3.setVisible(true);
    ex2.setVisible(true);
    ex4.setVisible(true);
      
        // TODO
    }    
  @FXML
private void secondadd(ActionEvent event) {
       
    textField.setText("");
    ex1.setText("");
    ex2.setText("");
    mot1.setText("");
    mot2.setText("");
    ex3.setText("");
    ex4.setText("");
                ajout1.setText("Ajout");
     buttonsup.setVisible(false);

   comboBox1.setVisible(true);
     textField.setVisible(true);
     button1.setVisible(true);
      labelL1.setVisible(true);
      label3.setVisible(true);      
      label4.setVisible(false);
        buttonmod.setVisible(false);

      button2.setVisible(true);
    
     
    comboBox3.setVisible(false);
     comboBox6.setVisible(true);
         mot2.setVisible(true);
         ex3.setVisible(true);
         ex4.setVisible(true);


            


  
    
   
    
    
    
}

private  void autoC(){
    
  ObservableList<String> autoCompleteList = FXCollections.observableArrayList();

        // Retrieve data from the database
        String query = "SELECT MOT FROM MOT_FR UNION SELECT MOT FROM MOT_EN";
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
    public void handle(AutoCompletionEvent<String> event) {
        // Handle the AutoCompletionEvent
    }
}); 
}

    @FXML
     private void toEXPORT( ActionEvent event) {
  try {
              root = FXMLLoader.load(getClass().getResource("importexport.fxml"));
          } catch (IOException ex) {
              Logger.getLogger(ImportexportController.class.getName()).log(Level.SEVERE, null, ex);
          }
    stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    scene=new Scene(root);
    stage.setScene(scene);
    stage.show();
     }

    @FXML
     private void rechercher( ActionEvent event) {
         
         
         
         Alert alert = new Alert(Alert.AlertType.WARNING);
    
           String exp="";  

       String text = textField.getText();

     if(text.matches("[a-zA-Z]+") ){
         
         
         
     
           
    try {
         try {
    Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (ClassNotFoundException e) {
    System.out.println("Oracle JDBC driver not found.");
    e.printStackTrace();
}
         
         
         
   
                    // Establish a connection to the database
                     Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.128:1521/xe", "C##AB", "0000");
       
                    
                    
                    
                    String querycheckcb = "SELECT count(*)  FROM MOT_EN WHERE MOT='"+textField.getText()+"'";
           PreparedStatement statementcheckcb = con.prepareStatement(querycheckcb);
           ResultSet resultcheckcb = statementcheckcb.executeQuery();
           int checkcbb = 0;
          if (resultcheckcb.next()) {
     checkcbb= resultcheckcb.getInt(1);
              }
          if(checkcbb>0)
              comboBox1.setValue("EN");
          else 
              comboBox1.setValue("FR");
              
        statementcheckcb.close();    
        resultcheckcb.close();
                    
                    
                    
                    
                    
                    
                    String selectedItem1 = comboBox1.getValue();
        
        
        
        
        
        
        
        
        String querycheck = "SELECT count(*)  FROM MOT_" + comboBox1.getSelectionModel().getSelectedItem() + " WHERE MOT='"+textField.getText()+"'";
           PreparedStatement statementcheck = con.prepareStatement(querycheck);
           ResultSet resultcheck = statementcheck.executeQuery();
           int check = 0;
          if (resultcheck.next()) {
     check = resultcheck.getInt(1);
              }
     if(check>0){
           
                        String query0 = "SELECT * FROM MOT_" + selectedItem1 + " WHERE  MOT = '" + textField.getText() + "'";        
                        PreparedStatement command0 = con.prepareStatement(query0);

                        ResultSet reader0 = command0.executeQuery();
     while (reader0.next()) {
                 exp = reader0.getString(4);
                 mot1.setText(reader0.getString(2));
                 comboBox5.setValue(reader0.getString(3));
                 ex1.setText(reader0.getString(4));
                 ex2.setText(reader0.getString(5));
                 
                 
                
            }
     }
     else
     {
           alert.setTitle("Warning");
            alert.setHeaderText("Mot inexistant!");
            alert.showAndWait();
     }
     
    } catch (SQLException e) {
        e.printStackTrace();
    } 
    catch (NullPointerException e){
        
          alert.setTitle("Warning");
            alert.setHeaderText("Please select two  languages");
            alert.showAndWait();
    }
    
    
   

    }  else{
         
         alert.setTitle("Warning");
            alert.setHeaderText(" Mot invalide!");
            alert.showAndWait();
         
     } 
    
}
     
    
     
     
     @FXML
     private void supprimerTrad(ActionEvent event ) {
         
     
      String text = mot1.getText();

     if(text.matches("[a-zA-Z]+")){
     
     try {
              try {
    Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (ClassNotFoundException e) {
    System.out.println("Oracle JDBC driver not found.");
    e.printStackTrace();
}
                 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.128:1521/xe", "C##AB", "0000");
        String query1 = "DELETE FROM  TRADUCTION where  ID_"+ comboBox1.getSelectionModel().getSelectedItem()+" in (select ID_"+comboBox1.getSelectionModel().getSelectedItem()+"  from MOT_"+comboBox1.getSelectionModel().getSelectedItem()+" where MOT='"+ mot1.getText()+"')";                                                                                                         
        PreparedStatement statement1 = con.prepareStatement(query1);
            statement1.execute();
        
        String query = "DELETE  FROM MOT_"+comboBox1.getSelectionModel().getSelectedItem()+" WHERE  MOT='"+ mot1.getText()+"'";                                                                                                         
        PreparedStatement statement = con.prepareStatement(query);
         statement.execute();
       
             Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("CONFIRMATION:");
            alert1.setHeaderText(" Suppression avec succees!");
            alert1.showAndWait(); 
              
          
          }
          
          
         catch (SQLException ex) {
        ex.printStackTrace();
    }
         
     
     
     }
     else {
                 
         Alert alert = new Alert(Alert.AlertType.WARNING);
         alert.setTitle("Warning");
            alert.setHeaderText(" Mot invalide!");
            alert.showAndWait();
         
     }
     }
     
     
     
     
     
    
    
}
