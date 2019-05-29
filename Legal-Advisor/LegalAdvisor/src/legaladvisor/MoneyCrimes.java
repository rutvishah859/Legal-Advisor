package legaladvisor;

public class MoneyCrimes extends CriminalCase {
    private double amtStolen; 
    private boolean violence;
    private String typeOfProperty; 
    private String crimeType; 
    //private String keyWords []=  {"fraud", "credit", "card", "mortgage", "trading", "tax", "theft", "stole"};
    private String crimeTypes [] = {"fraud", "electronic crime", "money laundering", "theft"}; 
    private String fraud [] = {"transfered funds", "investment", "bank"};  
    private String electronicCrime [] = {"computer", "app", "phone", "online banking"};
    private String moneyLaundering [] = {"fake money"}; 
    private String theft [] = {"stole"}; 
            
    public MoneyCrimes (String rem, String typ, String jur, String crim, String sen, double amtSt, boolean viol, String typeProp){
        super(rem,typ,jur,crim,sen);
        this.amtStolen = amtSt; 
        this.violence = viol; 
        this.typeOfProperty = typeProp; 
    }
    
    public void setCrimeAndSentence (String keyword){
        String sentence; 
        if (super.SearchMechanism(keyword, fraud, 0)){
            this.crimeType = crimeTypes [0]; 
        }
        else if (super.SearchMechanism(keyword, electronicCrime, 0)){
            this.crimeType = crimeTypes [1]; 
        }
        else if(super.SearchMechanism(keyword, moneyLaundering, 0)){
            this.crimeType = crimeTypes [2]; 
        }
        else if (super.SearchMechanism(keyword, theft, 0)){
            this.crimeType = crimeTypes [3]; 
        }
        else {
            crimeType = "not a crime against person"; 
        }
        
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