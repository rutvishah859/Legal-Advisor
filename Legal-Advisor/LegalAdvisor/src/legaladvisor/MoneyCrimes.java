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
public class MoneyCrimes extends CriminalCase {
    private double amtStolen; 
    private boolean violence;
    private String typeOfProperty; 
    private String crimeType; 
    private String keyWords []=  {"fraud", "credit", "card", "mortgage", "trading", "tax", "theft", "stole"};
    
    public MoneyCrimes (String rem, String typ, String jur, String crim, String sen, double amtSt, boolean viol, String typeProp){
        super(rem,typ,jur,crim,sen);
        this.amtStolen = amtSt; 
        this.violence = viol; 
        this.typeOfProperty = typeProp; 
    }
    
    public void setCrimeAndSentence (){
        String sentence; 
        
    }

    public double getAmtStolen() {
        return amtStolen;
    }


    public boolean getViolence() {
        return violence;
    }

    public String getTypeOfProperty() {
        return typeOfProperty;
    }
     
}
