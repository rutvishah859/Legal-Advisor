package legaladvisor;
import java.util.*;
public class MoneyCrimes extends CriminalCase {
    private double amtStolen; 
    private boolean violence;
    private ArrayList <String> crimeType;     
            
    public MoneyCrimes (String rem, String jur, String crim, String sen, double amtSt, boolean viol){
        super(rem,jur,crim,sen);
        this.amtStolen = amtSt; 
        this.violence = viol; 
        this.crimeType = new ArrayList<>();
    }
    
    public void setCrimeAndSentence (String keyword){
        if (super.SearchMechanism(keyword, super.getFraud(), 0)){
            this.crimeType.add (super.getCrimeTypes1() [0]); 
            if(amtStolen<5000){
                super.setSentence("Maximum Sentence is 6 months in jail or a 5000$ fine.");
            }
            else{
                super.setSentence("Minimum Sentence is 2 years in jail and the Maximum is 14 years in jail.");
            }
        }
        else if (super.SearchMechanism(keyword, super.getRobbery(), 0)){
            this.crimeType.add (super.getCrimeTypes1() [1]); 
            super.setSentence("Minimum sentence is 5 years in jail.");
        }
        else if(super.SearchMechanism(keyword, super.getMoneyLaundering(), 0)){
            this.crimeType.add (super.getCrimeTypes1() [2]); 
            super.setSentence("Minimum sentence is 6 months in jail or a 5000$ fine and the Maximum Sentence is 10 years.");
        }
        else if (super.SearchMechanism(keyword, super.getTheft(), 0)){
            this.crimeType.add (super.getCrimeTypes1() [3]); 
            super.setSentence("Maximum sentence is 10 years in jail.");

        }
        else {
            this.crimeType.add ("not a money crime"); 
        }
        
    }
    public double getAmtStolen(){
        return amtStolen;
    }
    public boolean getViolence() {
        return violence;
    }
    
   public String printInfo(){
        return "Jurisdiction: " + super.getJurisdiction() + "\nType: " + this.getType()+ "\nCrime: " + super.getCrime() +"\nDrug Crime Type:"+this.crimeType.get(0)+"\nSentence: " + super.getSentence();
    } 
}
