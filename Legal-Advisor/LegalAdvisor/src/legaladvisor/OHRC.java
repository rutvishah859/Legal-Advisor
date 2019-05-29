/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legaladvisor;

/**
 *
 * @author 325075141
 */
public class OHRC extends HumanRights{
    private String grounds; 
    private String area; 
    private String typeOfDis; 
    
    public OHRC(String rem, String typ, String jur, String gr, String ar, String typeDis) {
        super(rem, typ, jur);
        this.grounds = gr; 
        this.area = ar; 
        this.typeOfDis = typeDis; 
    } 

    public String getGrounds() {
        return grounds;
    }

    public void setGrounds(String grounds) {
        this.grounds = grounds;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTypeOfDis() {
        return typeOfDis;
    }

    public void setTypeOfDis(String typeOfDis) {
        this.typeOfDis = typeOfDis;
    }
    
    String printInfo() {
        return null; 
    }
    
}
