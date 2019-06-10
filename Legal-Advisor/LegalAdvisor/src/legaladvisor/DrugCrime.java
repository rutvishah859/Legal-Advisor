package legaladvisor;

public class DrugCrime extends CriminalCase{
    
    private boolean trafficking;
    private boolean possession;
    private String quantity[] = {"30","3","0"};
    private String typeOfDrug;
    private String typeOfOffense;
    private String scheduleType[] = {"schedule I", "schedule II", "schedule III"};
    
    private String scheType;
    
    public DrugCrime(String rem, String jur, String crim, String sen, boolean pos, boolean traf, String tOD) {
        super(rem, jur, crim, sen);
        this.trafficking=traf;
        this.possession=pos;
    }
    public void setCrimeTypeAndSentence(String keyword){
        String sentence;
      
        if(super.SearchMechanism(keyword, super.getDrugType(), 0) && this.getTrafficking()){
            this.typeOfOffense = "indictable";
            if(keyword.equalsIgnoreCase(super.getDrugType()[2]) || keyword.equals(super.getDrugType()[5]) || keyword.equalsIgnoreCase(super.getDrugType()[0])
            || keyword.equalsIgnoreCase(super.getDrugType()[8])){   //cocaine,heroine,amphetamines 
                this.setScheduleType(keyword);
                if(keyword.equalsIgnoreCase(this.quantity[0])){
                    sentence = "The max jail sentence is life imprisonment.";
                }else if(keyword.equalsIgnoreCase(this.quantity[1])){
                    sentence = "The max jail sentence is between 6 to 8 years";
                }else{
                    sentence = "The max jail sentence is between 6 months to 2 years";
                }
            }else if(keyword.equalsIgnoreCase(super.getDrugType()[5])){ //and LSD
                this.setScheduleType(keyword);
                sentence = "The maximum jail sentence is 10 years";
            }else if(keyword.equalsIgnoreCase(super.getDrugType()[4]) || keyword.equalsIgnoreCase(super.getDrugType()[7])){ //hashish and marijuana
                this.setScheduleType(keyword);
                if(keyword.equalsIgnoreCase(this.quantity[1])){ //if keyword equals to 30
                    sentence = "The maximum jail sentence is life imprionment";
                }else if(keyword.equalsIgnoreCase(this.quantity[1])){  //  if keyword equals to 3
                    sentence = "The maximum jail sentence is 5 years";
                }
            }else if(keyword.equalsIgnoreCase(super.getDrugType()[2])){
                sentence = "The maximum jail sentence is 18 months.";
            }
        }else{
            if(keyword.equalsIgnoreCase(this.quantity[0])){
                this.typeOfOffense = "indictable";
                if(this.scheType.equalsIgnoreCase("schedule I")){
                    sentence = "The max jail sentence is 7 years";
                }else if(this.scheType.equalsIgnoreCase("schedule II")){
                    sentence = "The max jail sentence is five years less a day";
                }else{
                    sentence = "The max jail sentence is 3 years";
                }
            }else{
                this.typeOfOffense="summary";
                if(keyword.equalsIgnoreCase(super.getDrugType()[1]) || keyword.equals(super.getDrugType()[4]) || keyword.equalsIgnoreCase(super.getDrugType()[0])|| keyword.equalsIgnoreCase(super.getDrugType()[2]) 
               || keyword.equalsIgnoreCase(super.getDrugType()[5]) || (keyword.equalsIgnoreCase(super.getDrugType()[6])) ){
                    sentence = "For the first offense, the maximum fine is $1,000 and jail sentence is up to 6 months."
                            + "For the second offense, the maximum fine is $2,000 and jail sentence is up to one year.";
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
        if(super.SearchMechanism(keyword, super.getTraffickingTerm(), 0)){
           this.trafficking = true;
        }else{
            this.trafficking = false;
        }
    }
    public void setScheduleType(String keyword){
        if(keyword.equalsIgnoreCase(super.getDrugType()[2]) || keyword.equals(super.getDrugType()[5]) || keyword.equalsIgnoreCase(super.getDrugType()[0])
                    || keyword.equalsIgnoreCase(super.getDrugType()[8])){   //cocaine,heroine,amphetamines 
            this.scheType = "schedule I";
        }else if(keyword.equalsIgnoreCase(super.getDrugType()[5]) ||keyword.equalsIgnoreCase(super.getDrugType()[4]) || keyword.equalsIgnoreCase(super.getDrugType()[7])){
            this.scheType = "schedule II";
        }        
    }
    /*public String getQuantity(){
        return quantity;
    }*/
    public String getTypeOfDrug(){
        return typeOfDrug;
    }
    public String getTypeOfOffense(){
        return this.typeOfOffense;
    }
    public void setTypeOfOffense(String of){
       this.typeOfOffense= of;
    }
    
    String printInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
