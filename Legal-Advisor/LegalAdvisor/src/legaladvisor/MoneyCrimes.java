package legaladvisor;
public class MoneyCrimes extends CriminalCase {
    private double amtStolen; 
    private boolean violence;
    private String typeOfProperty; 
    private String crimeType; 
    //private String keyWords []=  {"fraud", "credit", "card", "mortgage", "trading", "tax", "theft", "stole"};
    private String crimeTypes [] = {"fraud", "robbery", "money laundering", "theft"};
    private String fraud [] = {"transfered funds", "investment", "bank","computer", "app", "phone", "online banking"};    
    private String electronicCrime [] = {"computer", "app", "phone", "online banking"};
    private String moneyLaundering [] = {"fake money"}; 
    private String theft [] = {"stole", "took", "does not own"}; 
    private String robbery [] = {"forced","stole","broke in","threatened","forcefully stole"}; 
    
            
    public MoneyCrimes (String rem, String typ, String jur, String crim, String sen, double amtSt, boolean viol, String typeProp){
        super(rem,typ,jur,crim,sen);
        this.amtStolen = amtSt; 
        this.violence = viol; 
        this.typeOfProperty = typeProp; 
    }
    
    public void setCrimeAndSentence (String keyword){
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
        if (super.SearchMechanism(keyword, fraud, 0)){
            this.crimeType = crimeTypes [0]; 
            if(amtStolen<5000){
            super.setSentence("Maximum Sentence is 6 months in jail or a 5000$ fine.");
            }
            else{
            super.setSentence("Minimum Sentence is 2 years in jail and the Maximum is 14 years in jail.");
            }
        }
        else if (super.SearchMechanism(keyword, robbery, 0)){
            this.crimeType = crimeTypes [1]; 
            super.setSentence("Minimum sentence is 5 years in jail.");
        }
        else if(super.SearchMechanism(keyword, moneyLaundering, 0)){
            this.crimeType = crimeTypes [2]; 
            super.setSentence("Minimum sentence is 6 months in jail or a 5000$ fine and the Maximum Sentence is 10 years.");
        }
        else if (super.SearchMechanism(keyword, theft, 0)){
            this.crimeType = crimeTypes [3]; 
            super.setSentence("Maximum sentence is 10 years in jail.");

        }
        else {
            crimeType = "not a crime against person"; 
        }
        
    }
    public double getAmtStolen(){
        return amtStolen;
    }
    public boolean getViolence() {
        return violence;
    }

    public String getTypeOfProperty() {
        return typeOfProperty;
    }
     
}