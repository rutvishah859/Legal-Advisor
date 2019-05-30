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
    public String groundKeywords[]={"black","white","asian","muslim","jewish","christian","buddhist","hindu","female","male","man","woman","girl","boy","citizenship","culture","disabled","mental disability","physical disability","pregnancy","gay","homosexual","lesbian","bisexual","transgender","heterosexual","married","not married","kids","no kids","too young","too old","wellfare"};
    private String areaKeywords[]={"rent","work","employment","hired","fired","member","group","union","hospital","restaurant","movie theater","school","service","place","contract"};
    public OHRC(String rem, String typ, String jur, String gr, String ar, String typeDis) {
        super(rem, typ, jur);
        this.grounds = gr; 
        this.area = ar; 
        this.typeOfDis = typeDis; 
    } 

    public String getGrounds() {
        return grounds;
    }

    public void setGrounds(String keyword) {
        if(super.SearchMechanism(keyword, groundKeywords, 0)==true){
            
        }
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
