package legaladvisor;

public class Contract extends Civil {
    //For the contract law, in order to make a contract, it must have purpose, the agreement/consent between two parties
    //,the ability to understand the terms of contract, and whether the contract has a lawful purpose. 
    
    private String purpose; //contract must have purpose
    private boolean partiesConsent; //parties must agree the terms of contract
    private boolean capacity; // parties must have ability to understand what they were agreeing to
    //                                0            1                  2                 3                4
    private String remedies [] = {"Damages" , "Injunctions", "Rescission","Specific Performance"};
    //remedies are available if the breach of contract occurs
    //Damages is awarded to compensate the injured party in the contract. Liquidates damages, sum of money specified in contract to settle the breach
    //Specific performance is the court may order the party to fulfill the terms of a contract
    //Injuction: one party is ordered not to fulfill the terms of a contract
    //Rescission is when the court may order the contract to be cancelled
    private String remedy;
    private boolean failingToPerform;
    private boolean disability; // anyone with disability or impaired judgment can't make a valid contract
    private int participantAge; // anyone who under 18 or 19 years old does not have the capacity to enter into valid contract
    private boolean brokenContract; // if the parties break the contract
    //                                  0       1      2     3        4          5             6         7         8        9        10       11       12        13        14      15       16      17
    
    private boolean offer;  //offer is made or not. An offer contains all of the important and revelant terms of contract
    private boolean consideration;   //if the parties agree the offer, both parties will exchange valuable things between them.

    private boolean lawfulPurpose;
    //                                            0                 1                        2                      3
  //  private String dischargingContract [] = {"performance", "mutual agreement" , "frustration of contract", "breach of contract"};
    //breach of contract is failing to perform an obligation owed to another party
    //if breach occurs, it allows the party to cancel or end the contract
    private boolean breachOfContract;
    private String contractType[] = {"express", "valid","void", "illegal"};
    private String typeContract;
    private boolean hasContract;
    
    public Contract(String rem, String jur, String tC,String pur, boolean pC, int partAge, boolean dis, boolean offe, boolean consi) {
        super(rem, jur, tC);
        this.purpose = pur;
        this.partiesConsent = pC;
        this.participantAge = partAge;
        this.disability = dis;
        this.offer = offe;
        this.consideration = consi;
    }
    //this method will set what types of contract will it be. There are three types of contract: void, expressed and illegal
    //void is dealing with whether the parties have ability to understand the terms of contract of the purpose of this contract is lawful
    //expressed contract is when the parties have meet all the requirements such as lawful purpose, good capacity, the offer is made
    //illegal contract is involved with anything that is illegal (drugs, killing)
    public void setContract(String keyword){    //type of contract
        String contract;
        if(super.SearchMechanism(keyword, super.getContractWord(), 0)){
            if((this.capacity == false) || (this.lawfulPurpose == false)){  //if the person does not have ability to understand the terms of contract or it has unlawful purpose
                typeContract = this.contractType[2];
            }else if(((this.partiesConsent == true) && (this.consideration == true) && (this.lawfulPurpose == true) && (this.capacity == true) && (this.offer == true)) ||
                    (keyword.equalsIgnoreCase(getContractWord()[3])) || keyword.equalsIgnoreCase(getContractWord()[10]) || keyword.equalsIgnoreCase(getContractWord()[17])){
            //if the parties agree and accept the offer and the contract purpose is lawful and has ability to understand the terms of contract
            //or the keyword equals to "car", "house", "purchase" then this is an expressed contracts
                typeContract = this.contractType[0];
            }else if(this.lawfulPurpose == false){  //if the contract purpose is unlawful
                typeContract = this.contractType[3];
            }
        }
    }
    //Remedy can only have if one of the parties break the rules in terms of contract. This method will determine which remedy 
    //the party will receive
    public void setRemedies(String keyword){
        if(this.failingToPerform == true){  //if one of the parties is failed to perform the terms of agreement in contract
            this.breachOfContract = true;
                if(keyword.equalsIgnoreCase(getContractWord()[4]) || keyword.equalsIgnoreCase(getContractWord()[16]) || keyword.equalsIgnoreCase(getContractWord()[1])){
                //if the keyword equals to "failing" or "pay" then remedy is money damages
                //The compensatory damages is requested by the nonbreaching party who feels unjustly. THe judge will base on that to determine the amount of money
                //that breaching party will pay to cover for the loss.
                    super.setRemedies("If one party is failling to perform, the judge will put this as compensatory damages to cover the loss of nonbreaching party.");
                    this.remedy = this.remedies[0];
                }else{
                    this.remedy= ("If one party is failing to perform, the judge will decide one of these remedies:\n"
                            + "1. The court may order the party to fulfill the terms of a contract\n"
                            + "2. One party is not to fulfill the terms of a contract\n"
                            + "3. the court may order the contract to be cancelled");
                }
            
        }
    }
    //failingToPerform method will determine if one of the parties break the rules or not
    public void setFailingToPerform(String keyword){
        if(keyword.equalsIgnoreCase(getContractWord()[1]) || keyword.equalsIgnoreCase(getContractWord()[8])){
            //if keyword equals to "break" or "failing"
            this.failingToPerform = true;   //then the party is failed to perform the agreement terms
        }else{
            this.failingToPerform = false;
        }
    }
    
    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public boolean getPartiesConsent() {
        return partiesConsent;
    }

    public void setPartiesConsent(boolean partiesConsent) {
        this.partiesConsent = partiesConsent;
    }
    //this method is important because if the person is disability and underage, the contract will not be made
    public void setCapacity(boolean dis, int age){
        if((dis == true) || (age < 19)){    //if the person is disability or under 19 years old
           this.capacity =false;            //the person does not have capacity to perform the contract
        }else{
           this.capacity = true;            //else the person have ability to perform the contract
        }
    }
    
    public boolean getCapacity(){
        return this.capacity;
    }
    //the contract is made or become illegal contract depends on whether the purpose is legal to the Criminal Code of Canada
    public void setLawfulPurpose(String keyword){
        if(super.SearchMechanism(keyword, super.getUnlawfulPurpose(), 0)){     //if keyword equals to any words that related to gambling or other
                                                                    //unlawful purpose
            this.lawfulPurpose = false;     //it will be unlawful to make a contract
        }else{
            this.lawfulPurpose = true;      //else it will be lawful to make a contract
        }
    }
    
    public boolean getLawfulPurpose(){
        return this.lawfulPurpose;
    }
    
    public void setDisability(boolean dis){
      this.disability = dis; 
    }
    
    public boolean getDisability (){
      return this.disability; 
    }
    
    public String printInfo(){
        return "Type of Contract: " + this.typeContract + "\nRemedy: " + this.remedy;
    }
    
    
}
