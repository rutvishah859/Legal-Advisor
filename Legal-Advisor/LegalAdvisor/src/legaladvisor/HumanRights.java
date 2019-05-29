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
public abstract class HumanRights extends Case {
    private String CharterOHRC; 

    public HumanRights(String rem, String typ, String jur) {
        super(rem, typ, jur);  
    }

    public String getCharterOHRC() {
        return CharterOHRC;
    }

    public void setCharterOHRC(String SCO) {
        this.CharterOHRC = SCO;
    }
    
    
}
