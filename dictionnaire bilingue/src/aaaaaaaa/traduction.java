/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aaaaaaaa;

import java.io.Serializable;

/**
 *
 * @author Ahla baba ija mamma
 */
public class traduction implements Serializable{

    @Override
    public String toString() {
        return "traduction{" + "Mot_L1=" + Mot_L1 + ", Mot_L2=" + Mot_L2 + ", Type=" + Type + ", Expl1=" + Expl1 + ", Expl2=" + Expl2 + '}';
    }
    
      private  String Mot_L1;
      private String Mot_L2;
     private String Type;
     private String Expl1;
      private String  Expl2;

    public String getMot_L1() {
        return Mot_L1;
    }

    public void setMot_L1(String Mot_L1) {
        this.Mot_L1 = Mot_L1;
    }

    public String getMot_L2() {
        return Mot_L2;
    }

    public void setMot_L2(String Mot_L2) {
        this.Mot_L2 = Mot_L2;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getExpl1() {
        return Expl1;
    }

    public void setExpl1(String Expl1) {
        this.Expl1 = Expl1;
    }

    public String getExpl2() {
        return Expl2;
    }

    public void setExpl2(String Expl2) {
        this.Expl2 = Expl2;
    }
    
    
   
    
}
