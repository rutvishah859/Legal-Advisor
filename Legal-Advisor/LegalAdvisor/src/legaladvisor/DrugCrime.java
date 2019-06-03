package legaladvisor;

public class DrugCrime extends CriminalCase{
    
    private boolean trafficking;
    private boolean possession;
    private double quantity;
    private String typeOfDrug;
    private String typeOfOffense;
    private String scheduleType[] = {"schedule I", "schedule II", "schedule III"};
    private String scheType;
    private String[] traffickingTerm = {"administer", "deliver", "give", "obtain","sell", "send", "transfer", "transport"};
    private String [] drugType= {"amphetamines","cannabis","cocaine", "hallucionogens", "hashish","heroine","LSD", "marijuana", "methamphetamine","opiums","steroids"};
    
    public DrugCrime(String rem, String typ, String jur, String crim, String sen, boolean pos, boolean traf, double qty, String tOD) {
        super(rem, typ, jur, crim, sen);
        this.trafficking=traf;
        this.possession=pos;
        
    }
    public void setCrimeTypeAndSentence(String keyword){
        String sentence;
      
        if(super.SearchMechanism(keyword, drugType, 0) && this.getTrafficking()==true){
            this.typeOfOffense = "indictable";
            if(keyword.equalsIgnoreCase(drugType[2]) || keyword.equals(drugType[5]) || keyword.equalsIgnoreCase(drugType[0])
                    || keyword.equalsIgnoreCase(drugType[8])){   //cocaine,heroine,amphetamines 
                this.setScheduleType(keyword);
                if(this.quantity > 30){
                    sentence = "The maximum jail sentence is life imprisonment.";
                }else if(this.quantity >3 ){
                    sentence = "The jail sentence is between 6 to 8 years";
                }else{
                    sentence = "The jail sentence is between 6 months to 2 years";
                }
            }else if(keyword.equalsIgnoreCase(drugType[5])){ //and LSD
                this.setScheduleType(keyword);
                sentence = "The maximum jail sentence is 10 years";
            }else if(keyword.equalsIgnoreCase(drugType[4]) || keyword.equalsIgnoreCase(drugType[7])){ //hashish and marijuana
                this.setScheduleType(keyword);
                if(this.quantity > 30){
                    sentence = "The maximum jail sentence is life imprionment";
                }else if(this.quantity < 3){
                    sentence = "The maximum jail sentence is 5 years";
                }
            }else if(keyword.equalsIgnoreCase(drugType[2])){
                sentence = "The maximum jail sentence is 18 months.";
            }
        }else{
            if(this.quantity > 30){
                this.typeOfOffense = "indictable";
            }else{
                this.typeOfOffense="summary";
            }
            if(this.typeOfOffense.equalsIgnoreCase("summary")){
                if(keyword.equalsIgnoreCase(drugType[1]) || keyword.equals(drugType[4]) || keyword.equalsIgnoreCase(drugType[0])|| keyword.equalsIgnoreCase(drugType[2]) 
               || keyword.equalsIgnoreCase(drugType[5]) || (keyword.equalsIgnoreCase(drugType[6]) && (this.getQuantity(quantity)<0.3)) ){
                    sentence = "For the first offense, the maximum fine is $1,000 and jail sentence is up to 6 months."
                            + "For the second offense, the maximum fine is $2,000 and jail sentence is up to one year.";
            }else{
                
            }
            
        }
        //the possession of Amphetamine/LSD will have maximum sentence of 3 years
        //the possession of cocain or heroine will have maximum sentence of 7 years on an indictable persecution
        //Possession of marijuana and hashish will have maximum sentence of 5 years on an indictable persecution
        }   
    }
    public boolean getPossession(){
        return this.possession;
    }
    public boolean getTrafficking(){
        return trafficking;
    }
    public void setTrafficking(String keyword, int n){
        if(super.SearchMechanism(keyword, traffickingTerm, 0)==true){
           this.trafficking = true;
        }else{
            this.trafficking = false;
        }
        
    }
    public void setScheduleType(String keyword){
        if(keyword.equalsIgnoreCase(drugType[2]) || keyword.equals(drugType[5]) || keyword.equalsIgnoreCase(drugType[0])
                    || keyword.equalsIgnoreCase(drugType[8])){   //cocaine,heroine,amphetamines 
            this.scheType = "schedule I";
        }else if(keyword.equalsIgnoreCase(drugType[5]) ||keyword.equalsIgnoreCase(drugType[4]) || keyword.equalsIgnoreCase(drugType[7])){
            this.scheType = "schedule II";
        }        
    }
    public double getQuantity(double qty){
        return quantity;
    }
    public String getTypeOfDrug(){
        return typeOfDrug;
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
