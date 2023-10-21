/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package aaaaaaaa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author Ahla baba ija mamma
 */
public class ImportexportController implements Initializable {
    
      @FXML
private ComboBox<String> comboBox1;
     @FXML
    private ComboBox<String> comboBox2;
        @FXML
    private ComboBox<String> comboBox3;
          @FXML
    private ComboBox<String> comboBox5;
     @FXML
private Label labelL1;
        @FXML
private Label label3;
          @FXML
private Label mlab;
        @FXML
    private TextField textField;
       @FXML
    private Button button1;
            @FXML
    private Button button2;
                 @FXML
    private Button button3;
                      @FXML
    private Button button4;
                           @FXML
    private Button button5;
        @FXML
    private TextField mot1;
         @FXML
    private TextField ex1;
      @FXML
    private TextField ex2;
            
       private Parent root;
        private Stage stage;  
         private Scene scene;  
            
            
            
       private final String [] lan={"EN","FR"};

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         textField.textProperty().addListener((observable, oldValue, newValue) -> {
            autoC();
        });
         comboBox3.getItems().addAll(lan);
        comboBox1.getItems().addAll(lan);
        comboBox2.getItems().addAll(lan);
        comboBox1.setValue("FR");
        comboBox2.setValue("EN");
           comboBox3.setValue("FR");
           
         label3.setVisible(false);
           labelL1.setVisible(false);
             comboBox3.setVisible(false);
     textField.setVisible(false);
     button1.setVisible(false);
     mot1.setVisible(false);
      comboBox5.setVisible(false);
     ex1.setVisible(false);
       ex2.setVisible(false);
          button2.setVisible(false);
               button3.setVisible(false);
        // TODO
    }    
    
    
     @FXML
private void firstadd(ActionEvent event) {
         mlab.setText("Export/Import");

       
         label3.setVisible(false);
           labelL1.setVisible(false);
             comboBox3.setVisible(false);
     textField.setVisible(false);
     button1.setVisible(false);
          button2.setVisible(false);
               button3.setVisible(false);
     mot1.setVisible(false);
      comboBox5.setVisible(false);
     ex1.setVisible(false);
       ex2.setVisible(false);
       
        comboBox1.setVisible(true);
         comboBox2.setVisible(true);
        button4.setVisible(true);
         button5.setVisible(true);

}
 @FXML
private void secondadd(ActionEvent event) {
                mlab.setText("Listage ");
         label3.setVisible(true);
           labelL1.setVisible(true);
             comboBox3.setVisible(true);
     textField.setVisible(true);
     button1.setVisible(true);
          button2.setVisible(true);
               button3.setVisible(true);
     mot1.setVisible(true);
      comboBox5.setVisible(true);
     ex1.setVisible(true);
       ex2.setVisible(true);
       
        comboBox1.setVisible(false);
         comboBox2.setVisible(false);
        button4.setVisible(false);
         button5.setVisible(false);

}
    
    
  
     @FXML
private void importer(ActionEvent event) {
    String path="";    traduction[] T=null;

    try {
        
     
    FileChooser fileChooser = new FileChooser();
    File selectedFile = fileChooser.showOpenDialog(null);

    if (selectedFile != null) {
      path=selectedFile.getAbsolutePath();
    }

   
             try (ObjectInputStream fs = new ObjectInputStream(new FileInputStream(path))) {
                 T = (traduction [])fs.readObject();
             }
             
           
              
    } catch(Exception e){
        
        System.out.print(e.getCause());
    }
    
           
           
           
           
           
        if(T !=null){
     try { 
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.128:1521/xe", "C##AB", "0000");
        for(int i=0;i<T.length;i++){
            
            
              
             
             
                
        String query = "SELECT MAX(ID_FR) AS MaxID FROM (SELECT ID_FR FROM MOT_FR UNION SELECT ID_EN FROM MOT_EN)";
        PreparedStatement statement = con.prepareStatement(query);
        ResultSet result = statement.executeQuery();
            int newID = 0;int maxID ;
        if (result.next()) {
            maxID = result.getInt("MaxID");
            newID = maxID + 1;
        
        
        
        }   result.close();
        statement.close();
          String querycheck = "SELECT count(*)  FROM MOT_" + comboBox1.getSelectionModel().getSelectedItem() + " WHERE MOT='"+T[i].getMot_L1()+"'";
           PreparedStatement statementcheck = con.prepareStatement(querycheck);
           ResultSet resultcheck = statementcheck.executeQuery();
           int check = 0;
          if (resultcheck.next()) {
     check = resultcheck.getInt(1);
              }
        resultcheck.close();
        statementcheck.close();
     String querycheck1 = "SELECT count(*)  FROM MOT_" + comboBox2.getSelectionModel().getSelectedItem() + " WHERE MOT='"+T[i].getMot_L1()+"'";
           PreparedStatement statementcheck1 = con.prepareStatement(querycheck1);
           ResultSet resultcheck1 = statementcheck1.executeQuery();
           int check1 = 0;
          if (resultcheck1.next()) {
     check1 = resultcheck1.getInt(1);
              }
         resultcheck1.close();
        statementcheck1.close();
          
          
          
        
    
           if(check==0 && check1==0 ){
        
        
        
    String queryL2 = "INSERT INTO MOT_" + comboBox1.getSelectionModel().getSelectedItem() + " (ID_" + comboBox1.getSelectionModel().getSelectedItem() + ", Mot,type,example,example2) VALUES (?,?,?,?,?)";
    PreparedStatement stmtL2 = con.prepareStatement(queryL2);
    stmtL2.setInt(1, newID);
    stmtL2.setString(2, T[i].getMot_L1());
    stmtL2.setString(3, T[i].getType());
    stmtL2.setString(4, T[i].getExpl1());
    stmtL2.setString(5, T[i].getExpl2());
    stmtL2.execute();
    stmtL2.close();
    
         
    String queryL3 = "INSERT INTO MOT_" + comboBox2.getSelectionModel().getSelectedItem() + " (ID_" + comboBox2.getSelectionModel().getSelectedItem() + ", Mot,type,example,example2) VALUES (?,?,?,?,?)";
    PreparedStatement stmtL3 = con.prepareStatement(queryL3);
    stmtL3.setInt(1, newID);
    stmtL3.setString(2, T[i].getMot_L2());
    stmtL3.setString(3, T[i].getType());
    stmtL3.setString(4, T[i].getExpl2());
    stmtL3.setString(5, T[i].getExpl1());
    stmtL3.execute();
    stmtL3.close();
    
         
    String queryL = "INSERT INTO TRADUCTION  (ID_" + comboBox1.getSelectionModel().getSelectedItem() + ",ID_" + comboBox2.getSelectionModel().getSelectedItem() + ") VALUES (?,?)";
    PreparedStatement stmtL = con.prepareStatement(queryL);
    stmtL.setInt(1, newID); 
    stmtL.setInt(2, newID);
  
    stmtL.execute();
    stmtL.close();
    
    
   

        
           }
           else if (check>0 && check1==0)  {
               String query1 = "SELECT ID_" + comboBox1.getSelectionModel().getSelectedItem() + " AS ID FROM MOT_"+ comboBox1.getSelectionModel().getSelectedItem()+ " WHERE MOT='"+ T[i].getMot_L1() + "'";
        PreparedStatement statement1 = con.prepareStatement(query1);
        ResultSet result1 = statement1.executeQuery();
            int actualID = 0;
        if (result1.next()) {
            actualID = result1.getInt("ID");
            
        }
        result1.close();
        statement1.close();
               
               
               
               
               
               String queryL3 = "INSERT INTO MOT_" + comboBox2.getSelectionModel().getSelectedItem() + " (ID_" + comboBox2.getSelectionModel().getSelectedItem() + ", Mot,type,example,example2) VALUES (?,?,?,?,?)";
    PreparedStatement stmtL3 = con.prepareStatement(queryL3);
    stmtL3.setInt(1, newID);
    stmtL3.setString(2, T[i].getMot_L2());
    stmtL3.setString(3, T[i].getType());
    stmtL3.setString(4, T[i].getExpl2());
    stmtL3.setString(5, T[i].getExpl1());
    stmtL3.execute();
    stmtL3.close();
    
         
    String queryL = "INSERT INTO TRADUCTION  (ID_" + comboBox1.getSelectionModel().getSelectedItem() + ",ID_" + comboBox2.getSelectionModel().getSelectedItem() + ") VALUES (?,?)";
    PreparedStatement stmtL = con.prepareStatement(queryL);
    stmtL.setInt(1, actualID); 
    stmtL.setInt(2, newID);
  
    stmtL.execute();
    stmtL.close();
               
               
               
               
               
           } 
            else if (check==0 && check1>0)  {
                
                String query1 = "SELECT ID_" + comboBox2.getSelectionModel().getSelectedItem() + " AS ID FROM MOT_"+ comboBox2.getSelectionModel().getSelectedItem()+ " WHERE MOT='"+ T[i].getMot_L2() + "'";
        PreparedStatement statement1 = con.prepareStatement(query1);
        ResultSet result1 = statement1.executeQuery();
            int actualID = 0;
        if (result1.next()) {
            actualID = result1.getInt("ID");
            
        }
        result1.close();
        statement1.close();
               
               
               
               
               
               String queryL3 = "INSERT INTO MOT_" + comboBox1.getSelectionModel().getSelectedItem() + " (ID_" + comboBox1.getSelectionModel().getSelectedItem() + ", Mot,type,example,example2) VALUES (?,?,?,?,?)";
    PreparedStatement stmtL3 = con.prepareStatement(queryL3);
    stmtL3.setInt(1, newID);
    stmtL3.setString(2, T[i].getMot_L2());
    stmtL3.setString(3, T[i].getType());
    stmtL3.setString(4, T[i].getExpl2());
    stmtL3.setString(5, T[i].getExpl1());
    stmtL3.execute();
    stmtL3.close();
    
         
    String queryL = "INSERT INTO TRADUCTION  (ID_" + comboBox1.getSelectionModel().getSelectedItem() + ",ID_" + comboBox2.getSelectionModel().getSelectedItem() + ") VALUES (?,?)";
    PreparedStatement stmtL = con.prepareStatement(queryL);
    stmtL.setInt(1, actualID); 
    stmtL.setInt(2, newID);
  
    stmtL.execute();
    stmtL.close();
                
     
           }  System.out.println( T[i]); } 
           
           
           
               
 
   con.close();   } catch (SQLException ex) {
        ex.printStackTrace();
    }
              
         
            
            
            
            
       Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("CONFIRMATION:");
            alert1.setHeaderText(" Imprtation avec succees!");
            alert1.showAndWait();      
            
        

        }
        
       
            
          
        
    
    
    
    
    
        
 



}





         @FXML
private void retour(ActionEvent event) throws IOException {
          try {
              root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
          } catch (IOException ex) {
              Logger.getLogger(ImportexportController.class.getName()).log(Level.SEVERE, null, ex);
          }
    stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    scene=new Scene(root);
    stage.setScene(scene);
    stage.show();
    }





         @FXML
private void exporter(ActionEvent event) {
    
    int i=0,k=0; traduction [] T = null;
          String Mot="";String path="";
          
      DirectoryChooser directoryChooser = new DirectoryChooser();
File selectedDirectory = directoryChooser.showDialog(null);

    if (selectedDirectory  != null) {
      path=selectedDirectory.getAbsolutePath()+"\\traductionseng.dat";
    }

    
 try {
                 Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.128:1521/xe", "C##AB", "0000");   
                 String query = "SELECT * FROM MOT_"+ comboBox1.getValue();

                 
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            
            
            String query2 = "Select count(*) from MOT_"+ comboBox1.getValue();

                 
            PreparedStatement stmt2 = conn.prepareStatement(query2);
            ResultSet rs2 = stmt2.executeQuery();
             if (rs2.next()) {
        // Get the value of the "MOT" column from the current row
         i = rs2.getInt(1);
                           }
              T=new traduction[i];


            while (rs.next()) {
                traduction trad = new traduction();
   
                
                String query1 = "SELECT MOT FROM MOT_" + comboBox2.getValue() + " WHERE ID_" + comboBox2.getValue() + " IN (SELECT ID_" + comboBox2.getValue() + " FROM traduction WHERE ID_" + comboBox1.getValue() + " in (SELECT ID_" + comboBox1.getValue() + " FROM MOT_" + comboBox1.getValue() + " WHERE  MOT = '" + rs.getString(2) + "'))";

                 
            PreparedStatement stmt1 = conn.prepareStatement(query1);
            ResultSet rs1 = stmt1.executeQuery();
             if (rs1.next()) {
        // Get the value of the "MOT" column from the current row
         Mot = rs1.getString("MOT");
                           }

      
                trad.setMot_L2(Mot);
                trad.setExpl1(rs.getString(4));
                trad.setExpl2(rs.getString(5));
                trad.setMot_L1(rs.getString(2));
                trad.setType(rs.getString(3));
      

                T[k]=trad;
                k++;
     
            }
            rs.close();
            stmt.close();
            conn.close();
  
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
 try {
        
        ObjectOutputStream fs=new ObjectOutputStream(new FileOutputStream(path));
        fs.writeObject(T);
        fs.close();
    
    }catch(Exception e){
        
        System.out.print(e.getCause());
    }

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
              comboBox3.setValue("EN");
          else 
              comboBox3.setValue("FR");
              
        statementcheckcb.close();    
        resultcheckcb.close();    
                    
                    
                    
                    
                    
                    
                    
        String selectedItem1 = comboBox3.getValue();
        
        String querycheck = "SELECT count(*)  FROM MOT_" + comboBox3.getSelectionModel().getSelectedItem() + " WHERE MOT='"+textField.getText()+"'";
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

    
   

    }  else{
         
         alert.setTitle("Warning");
            alert.setHeaderText(" Mot invalide!");
            alert.showAndWait();
         
     } 
    
}
    
    
         @FXML
         private void motEtTradTXT(ActionEvent event) {
             
             String path="";
                   DirectoryChooser directoryChooser = new DirectoryChooser();
File selectedDirectory = directoryChooser.showDialog(null);

    if (selectedDirectory  != null) {
      path=selectedDirectory.getAbsolutePath()+"\\motTrad.txt";
    }
   
              try {
         try {
    Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (ClassNotFoundException e) {
    System.out.println("Oracle JDBC driver not found.");
    e.printStackTrace();
}
                    // Establish a connection to the database
                     Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.128:1521/xe", "C##AB", "0000");
        String selectedItem1 = comboBox3.getValue();
        String selectedItem2="";
        
        
        
        if(selectedItem1.equals("FR"))
            selectedItem2 = "EN";
        else 
            selectedItem2 = "FR";
        
        String exp="";
        
        
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
              try{
                  FileWriter f=new FileWriter(path);
                    String ah="Mot:"+textField.getText()+"\n";
                     f.write(ah);
            while (reader.next()) {
                String aha=" Type :'" + reader.getString(3) + "',Traduction("+selectedItem2+"):'" + reader.getString(2) + "',Exemple:'" +reader.getString(4)  + "',Exemple2:'"+ exp + "'.\n";
                    f.write(aha);
                }f.close();
                 // assuming the first column is a string column
                
                }catch(IOException e){ System.out.print(e.getCause());}
                
                
            
        } 
             
           
           
        
    } catch (SQLException e) {
        e.printStackTrace();
    } 
             
             
             


}
    
   
         @FXML
         private void allMotsTradTXT(ActionEvent event) throws IOException {
             String path="";
             
             
                   DirectoryChooser directoryChooser = new DirectoryChooser();
File selectedDirectory = directoryChooser.showDialog(null);

    if (selectedDirectory  != null) {
      path=selectedDirectory.getAbsolutePath()+"\\Allmots.txt";
    }
             
             
             
             
              try {
         try {
    Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (ClassNotFoundException e) {
    System.out.println("Oracle JDBC driver not found.");
    e.printStackTrace();
}
                    // Establish a connection to the database
                 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.128:1521/xe", "C##AB", "0000");
        String selectedItem1 = comboBox3.getValue();  String selectedItem2="";
        if(selectedItem1.equals("FR"))
            selectedItem2 = "EN";
        else 
            selectedItem2 = "FR";
        
        String exp="";
        
        
        if (selectedItem1 != null && selectedItem2 != null && !selectedItem1.equals(selectedItem2)) {
            
            ArrayList<String> mots= new  ArrayList<String>();
            
             String quer = "SELECT MOT FROM MOT_" + comboBox3.getValue();        
                        PreparedStatement comman = con.prepareStatement(quer);

                        ResultSet reade = comman.executeQuery();
             while (reade.next()) {
                 mots.add(reade.getString(1));
                
            }
            
            
               FileWriter f=new FileWriter(path);
            for(int i=0;i<mots.size();i++){ 
                
            
         
           
                        String query0 = "SELECT EXAMPLE FROM MOT_" + selectedItem1 + " WHERE  MOT = '" + mots.get(i) + "'";        
                        PreparedStatement command0 = con.prepareStatement(query0);

                        ResultSet reader0 = command0.executeQuery();
     while (reader0.next()) {
                 exp = reader0.getString(1);
                
            }
            
            
            String query = "SELECT * FROM MOT_" + selectedItem2 + " WHERE ID_" + selectedItem2 + " IN (SELECT ID_" + selectedItem2 + " FROM traduction WHERE ID_" + selectedItem1 + " = (SELECT ID_" + selectedItem1 + " FROM MOT_" + selectedItem1 + " WHERE  MOT = '" + mots.get(i) + "'))";
            PreparedStatement command = con.prepareStatement(query);
            ResultSet reader = command.executeQuery();
              try{
               
                    String ah="Mot:"+mots.get(i)+"\n";
                     f.write(ah);
            while (reader.next()) {
                String aha=" Type :'" + reader.getString(3) + "',Traduction("+selectedItem2+"):'" + reader.getString(2) + "',Exemple:'" +reader.getString(4)  + "',Exemple2:'"+ exp + "'.\n";
                    f.write(aha);
                }
                 // assuming the first column is a string column
                
                }catch(IOException e){ e.getCause();}
                
              }  f.close();
            
        } 
             
           
           
        
    } catch (SQLException e) {
        e.printStackTrace();
    } 
             
             
             


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
    public void handle(AutoCompletionBinding.AutoCompletionEvent<String> event) {
        // Handle the AutoCompletionEvent
    }
});
    
    
    
    
}
    
}
