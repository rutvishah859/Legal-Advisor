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
public class Charter extends HumanRights {
    private String right; 
        
    public Charter(String rem, String typ, String jur, String r) {
        super(rem, typ, jur);
        this.right = r; 
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }
    
    String printInfo() {
        return null;
        
    }
    
}
