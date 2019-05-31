package legaladvisor;
public class MoneyCrimes extends CriminalCase {
    private double amtStolen; 
    private boolean violence;
    private String typeOfProperty; 
    private String crimeType; 
    //private String keyWords []=  {"fraud", "credit", "card", "mortgage", "trading", "tax", "theft", "stole"};
    
            
    public MoneyCrimes (String rem, String typ, String jur, String crim, String sen, double amtSt, boolean viol, String typeProp){
        super(rem,typ,jur,crim,sen);
        this.amtStolen = amtSt; 
        this.violence = viol; 
        this.typeOfProperty = typeProp; 
    }
    
    public void setCrimeAndSentence (String keyword){
        if (super.SearchMechanism(keyword, super.getFraud(), 0)){
            this.crimeType = super.getCrimeTypes() [0]; 
        }
        else if (super.SearchMechanism(keyword, super.getElectronicCrime(), 0)){
            this.crimeType = super.getCrimeTypes() [1]; 
        }
        else if(super.SearchMechanism(keyword, super.getMoneyLaundering(), 0)){
            this.crimeType = super.getCrimeTypes() [2]; 
        }
        else if (super.SearchMechanism(keyword, super.getTheft(), 0)){
            this.crimeType = super.getCrimeTypes() [3]; 
        if (super.SearchMechanism(keyword, super.getFraud(), 0)){
            this.crimeType = super.getCrimeTypes() [0]; 
            if(amtStolen<5000){
            super.setSentence("Maximum Sentence is 6 months in jail or a 5000$ fine.");
            }
            else{
            super.setSentence("Minimum Sentence is 2 years in jail and the Maximum is 14 years in jail.");
            }
        }
        else if (super.SearchMechanism(keyword, super.getRobbery(), 0)){
            this.crimeType = super.getCrimeTypes() [1]; 
            super.setSentence("Minimum sentence is 5 years in jail.");
        }
        else if(super.SearchMechanism(keyword, super.getMoneyLaundering(), 0)){
            this.crimeType = super.getCrimeTypes() [2]; 
            super.setSentence("Minimum sentence is 6 months in jail or a 5000$ fine and the Maximum Sentence is 10 years.");
        }
        else if (super.SearchMechanism(keyword, super.getTheft(), 0)){
            this.crimeType = super.getCrimeTypes() [3]; 
            super.setSentence("Maximum sentence is 10 years in jail.");

        }
        else {
            crimeType = "not a crime against person"; 
        }
        
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