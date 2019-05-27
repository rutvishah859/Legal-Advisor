/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legaladvisor;

/**
 *
 * @author 344832068
 */
public class DrugCrime extends CriminalCase{
    private boolean trafficking;
    private boolean possession;
    private double quantity;
    private String typeOfDrug;
    private String crimeType; 
    private String [] drugType= {"amphetamines","cocaine", "hallucionogens", "hashish","heroine", "marijuana", "opium", "steroids"};
    
    public DrugCrime(String rem, String typ, String jur, String crim, String sen, boolean pos, boolean traf, double qty, String tOD) {
        super(rem, typ, jur, crim, sen);
        this.trafficking=traf;
        this.possession=pos;
        
    }
    public void setCrimeTypeAndSentence(){
        
    }
    public boolean getPossession(){
        return possession;
    }
    public boolean getTrafficking(){
        return trafficking;
    }
    public double getQuantity(){
        return quantity;
    }
    public String getTypeOfDrug(){
        return typeOfDrug;
    }
    
}