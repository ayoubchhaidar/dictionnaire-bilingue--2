/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aaaaaaaa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Ahla baba ija mamma
 */
public class NewClass {
    
       public static void main (String[] args )
     {
         
         try {
        
             traduction [] T=new traduction[2];
             traduction t1=new traduction();
             t1.setExpl1("sur la table");
             t1.setExpl2("on the table");
             t1.setMot_L1("table");
             t1.setMot_L2("table");
             t1.setType("nom");
             
             traduction t2=new traduction();
              t2.setExpl1("la couleur bleu");
             t2.setExpl2("the blue color");
             t2.setMot_L1("couleur");
             t2.setMot_L2("color");
             t2.setType("nom");
             
             
             T[0]=t1;
             T[1]=t2;
             
             
               ObjectOutputStream fs=new ObjectOutputStream(new FileOutputStream("C:\\Users\\ramif\\OneDrive\\Documents\\NetBeansProjects\\aaaaaaaa\\nouvtraduction.dat"));
        fs.writeObject(T);
        fs.close();
        System.out.print("haha");
        
        
    }catch(Exception e){
        
        System.out.print(e.getCause());
    }


     
     }
    
}
