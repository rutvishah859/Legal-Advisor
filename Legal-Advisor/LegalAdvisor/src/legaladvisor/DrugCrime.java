package legaladvisor;

public class DrugCrime extends CriminalCase{
    
    private boolean trafficking;
    private boolean possession;
    private double quantity;
    private String typeOfDrug;
    private String typeOfOffense; 
    private String [] drugType= {"amphetamines","cocaine", "hallucionogens", "hashish","heroine","LSD", "marijuana", "opium", "steroids"};
    
    public DrugCrime(String rem, String typ, String jur, String crim, String sen, boolean pos, boolean traf, double qty, String tOD) {
        super(rem, typ, jur, crim, sen);
        this.trafficking=traf;
        this.possession=pos;
        
    }
    public void setCrimeTypeAndSentence(String keyword){
        String sentence;
        
        if(super.SearchMechanism(keyword, drugType, 0)){
            this.typeOfOffense = "indictable";
            if(keyword.equalsIgnoreCase(drugType[1]) || keyword.equals(drugType[4])){   //cocaine and heroine
                sentence = "The maximum sentence is 7 years";
            }else if(keyword.equalsIgnoreCase(drugType[0])||keyword.equalsIgnoreCase(drugType[5])){ //amphetamines and LSD
                sentence = "The maximum sentence is 5 years";
            }else if(keyword.equalsIgnoreCase(drugType[3]) || keyword.equalsIgnoreCase(drugType[6])){ //hashish and marijuana
                sentence = "The maximum sentence is 3 years";
            }
            
        }
        //the possession of Amphetamine/LSD will have maximum sentence of 3 years
        //the possession of cocain or heroine will have maximum sentence of 7 years on an indictable persecution
        //Possession of marijuana and hashish will have maximum sentence of 5 years on an indictable persecution
        
    }
    public boolean getPossession(){
        return possession;
        
    }
    public boolean getTrafficking(){
        return trafficking;
        
    }
    public double getQuantity(double qty){
        return quantity;
        
        //For marijuana, if the quantity is under 30kgrams, it will be 5 years. If it's over 30kg, it's a life imprisonment 
    }
    public String getTypeOfDrug(){
        return typeOfDrug;
    }
    public void setTypeofDrug(){
        
    }
    public String getTypeOfOffense(){
        return this.typeOfOffense;
    }
    public void setTypeOfOffense(String keyword){
        if(keyword.equalsIgnoreCase(drugType[4])){
            this.typeOfOffense="indictable";
        }
    }
    
    
}
