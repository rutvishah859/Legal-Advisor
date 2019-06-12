package legaladvisor;

public class DrugCrime extends CriminalCase{
    
    private boolean trafficking;
    private boolean possession;
    private double quantity;
    private String typeOfDrug;
    private String typeOfOffense;
    private String crimeType;
    private String scheType;
    
    public DrugCrime(String rem, String jur, String crim, String sen, boolean pos, boolean traf, String tOD) {
        super(rem, jur, crim, sen);
        this.trafficking=traf;
        this.possession=pos;
    }
    public void setCrimeTypeAndSentence(String keyword){
        if(super.SearchMechanism(keyword, super.getDrugType(), 0) && this.getTrafficking()){
            this.typeOfOffense = "indictable";
            this.crimeType="Possession with the intent of trafficking";
            if(keyword.equalsIgnoreCase(super.getDrugType()[2]) || keyword.equals(super.getDrugType()[5]) || keyword.equalsIgnoreCase(super.getDrugType()[0])
            || keyword.equalsIgnoreCase(super.getDrugType()[8])){   //cocaine,heroine,amphetamines 
                this.setScheduleType(keyword);
                
                if(this.quantity > 30){ //if the amount is greater than 30grams
                    super.setSentence("The max jail sentence is life imprisonment.");
                }else if(this.quantity >3 ){    //if the amount is greater than 3 grams
                    super.setSentence("The max jail sentence is between 6 to 8 years");
                }else{  //if the amount is less than 3 grams
                    super.setSentence("The max jail sentence is between 6 months to 2 years");
                }
            }else if(keyword.equalsIgnoreCase(super.getDrugType()[5])){ //and LSD
                this.setScheduleType(keyword);
                super.setSentence("The maximum jail sentence is 10 years");
            }else if(keyword.equalsIgnoreCase(super.getDrugType()[4]) || keyword.equalsIgnoreCase(super.getDrugType()[7])){ //hashish and marijuana
                this.setScheduleType(keyword);
                if(this.quantity > 30){
                    super.setSentence("The maximum jail sentence is life imprionment");
                }else if(this.quantity < 3){
                    super.setSentence("The maximum jail sentence is 5 years");
                }
            }else if(keyword.equalsIgnoreCase(super.getDrugType()[2])){
                    super.setSentence("The maximum jail sentence is 18 months.");
            }
        }else{
            if(this.quantity > 30){
                this.typeOfOffense = "indictable";
                this.crimeType="Possession";
                if(this.scheType.equalsIgnoreCase("schedule I")){
                    super.setSentence("The max jail sentence is 7 years");
                }else if(this.scheType.equalsIgnoreCase("schedule II")){
                    super.setSentence("The max jail sentence is five years less a day");
                }else{
                    super.setSentence("The max jail sentence is 3 years");
                }
            }else{
                this.typeOfOffense="summary";
                this.crimeType="Possession";
                if(keyword.equalsIgnoreCase(super.getDrugType()[1]) || keyword.equals(super.getDrugType()[4]) || keyword.equalsIgnoreCase(super.getDrugType()[0])|| keyword.equalsIgnoreCase(super.getDrugType()[2]) 
               || keyword.equalsIgnoreCase(super.getDrugType()[5]) || (keyword.equalsIgnoreCase(super.getDrugType()[6])) ){
                    super.setSentence("For the first offense, the maximum fine is $1,000 and jail sentence is up to 6 months."
                            + "For the second offense, the maximum fine is $2,000 and jail sentence is up to one year.");
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
    public void setDrugType(String keyword){
        for(int i=0;i<super.getDrugType().length;i++){
            if(keyword.equalsIgnoreCase(super.getDrugType()[i])){
                this.typeOfDrug=super.getDrugType()[i];
            }
        }
    }
    public void setTrafficking(String keyword){
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
    public String getScheType(){
        return scheType;
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
    public void setTypeOfOffense(String of){
       this.typeOfOffense= of;
    }
    public void setQuantity(double q){
        this.quantity=q;
    }
    public String getCrimeType(){
        return crimeType;
    }
    @Override
    public String printInfo() {
        return "Type of Offence: " + this.getTypeOfOffense()+ "\nType of Drug: " + this.getTypeOfDrug()+"\nDrug Schedule:"+this.scheType +"\nCrime Type: "+ this.crimeType+super.printInfo(); 
    }
    
    
}
    
