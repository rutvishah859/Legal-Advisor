//This file will determine crime sentence of drug crime. Drug crime has two types of offences: dictable and summary. 
//The offence will be determined based on whether the criminal do the trafficking or possession, the amount of drugs they have,
//and the types of drugs(the more serious drugs will result as high jail sentence)

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
    //this method decide the crime sentence differently if the criminal does the drug trafficking or drug possession. 
    //The crime sentence will be more serious for schedule I and in trafficking category
    //The crime sentence depends on whether the drug is in schedule I, II, or II, trafficking or drug possession, 
    //and the quantity that they trafficking or possess
    public void setCrimeTypeAndSentence(String keyword){
        String sentence;
      
        if(super.SearchMechanism(keyword, super.getDrugType(), 0) && this.getTrafficking()){
            this.typeOfOffense = "Possession with the intent of trafficking which is indictable";
            if(keyword.equalsIgnoreCase(super.getDrugType()[2]) || keyword.equals(super.getDrugType()[5]) 
            || keyword.equalsIgnoreCase(super.getDrugType()[8])){   //cocaine,heroine,methamphetamine 
                this.setScheduleType(keyword);//set which of these drugs in what schedule level (Level I is the most serious)
                
                if(this.quantity > 30){ //if the amount is greater than 30grams
                    sentence = "The max jail sentence is life imprisonment.";
                }else if(this.quantity >3 ){    //if the amount is greater than 3 grams
                    sentence = "The max jail sentence is between 6 to 8 years";
                }else{  //if the amount is less than 3 grams
                    sentence = "The max jail sentence is between 6 months to 2 years";
                }
            }else if(keyword.equalsIgnoreCase(super.getDrugType()[6])){ //and LSD
                this.setScheduleType(keyword);
                sentence = "The maximum jail sentence is 10 years";
            }else if(keyword.equalsIgnoreCase(super.getDrugType()[4]) || keyword.equalsIgnoreCase(super.getDrugType()[7])){ //hashish and marijuana
                this.setScheduleType(keyword);
                if(this.quantity > 30){
                    sentence = "The maximum jail sentence is life imprionment";
                }else if(this.quantity < 3){
                    sentence = "The maximum jail sentence is 5 years";
                }
            }else if(keyword.equalsIgnoreCase(super.getDrugType()[3])){ //if keyword equals to "hallucionogens"
                sentence = "The maximum jail sentence is 18 months.";
            }
        }else{ //else if this is not drug trafficking but drug possession
            if(this.quantity > 30){
                this.typeOfOffense = "Possession and indictable";
                if(this.scheType.equalsIgnoreCase("schedule I")){
                    sentence = "The max jail sentence is 7 years";
                }else if(this.scheType.equalsIgnoreCase("schedule II")){
                    sentence = "The max jail sentence is five years less a day";
                }else{
                    sentence = "The max jail sentence is 3 years";
                }
            }else{//else if the equantity is less than 30grams
                this.typeOfOffense="Possession and summary";
                if(keyword.equalsIgnoreCase(super.getDrugType()[1]) || keyword.equals(super.getDrugType()[4]) || keyword.equalsIgnoreCase(super.getDrugType()[0])|| keyword.equalsIgnoreCase(super.getDrugType()[2]) 
               || keyword.equalsIgnoreCase(super.getDrugType()[5]) || (keyword.equalsIgnoreCase(super.getDrugType()[6])) ){
                    sentence = "For the first offense, the maximum fine is $1,000 and jail sentence is up to 6 months."
                            + "For the second offense, the maximum fine is $2,000 and jail sentence is up to one year.";
                }
            }
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
    public void setTrafficking(String keyword){ //set whether the drug is trafficking or not
        if(super.SearchMechanism(keyword, super.getTraffickingTerm(), 0)){  //if keyword equals to one of Trafficking terms
           this.trafficking = true; //drug trafficking is true
        }else{
            this.trafficking = false;//else false
        }
    }
    //This method will decide which drugs are in schedule I, II, or III. It will read if the keyword the users enter match one of the drugs 
    public void setScheduleType(String keyword){ //if keyword equals to one of these drugs (cocaine, heroine, methamphetamine)
        if(keyword.equalsIgnoreCase(super.getDrugType()[2]) || keyword.equals(super.getDrugType()[5]) 
                    || keyword.equalsIgnoreCase(super.getDrugType()[8])){    
            this.scheType = "Schedule I";    
        }//if keyword equals to "hashish" and "marijuana"
        else if(keyword.equalsIgnoreCase(super.getDrugType()[4]) || keyword.equalsIgnoreCase(super.getDrugType()[7])){
            this.scheType = "Schedule II";
        }else if(keyword.equalsIgnoreCase(super.getDrugType()[0])){//if keyword equals to "amphetamine"
            this.scheType = "schedule III";
        }       
    }
    public String getScheType(){
        return scheType;
    }
    public double getQuantity(double qty){  //get the amount of drug in grams that the criminal has
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
