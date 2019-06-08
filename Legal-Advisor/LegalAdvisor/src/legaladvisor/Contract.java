package legaladvisor;

public class Contract extends Civil {
    
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
    private boolean hasContract;    //must have contract in order to make a case
    private boolean brokenContract; // if the parties break the contract
    //                                  0       1      2        3            4          5          6         7         8        9       10       11       12        13        14      15       16
    private String contractWord []= {"agree","break","car","compensate","condition","contract","disagree","failing","goods", "house","illness","make", "mental","negotiate","offer", "pay","request"};
    private String consideration;   //The actual value or amount exchanged between the two parties
    private boolean consider;
    private boolean offer;
    private String unlawfulPurpose[] = {"betting", "gambling", "gaming"}; //the contract must have lawful objective or purpose
    private boolean lawfulPurpose;
    //                                            0                 1                        2                      3
    private String dischargingContract [] = {"performance", "mutual agreement" , "frustration of contract", "breach of contract"};
    //breach of contract is failing to perform an obligation owed to another party
    //if breach occurs, it allows the party to cancel or end the contract
    private boolean breachOfContract;
    private String contractType[] = {"express", "implied", "valid","void"};
    private String typeContract;
    public Contract(String rem, String jur, String tC,String pur, boolean pC, boolean hC, int partAge) {
        super(rem, jur, tC);
        this.purpose = pur;
        this.partiesConsent = pC;
        this.hasContract = hC;
        this.participantAge = partAge;
        
    }
    
    public void setContract(String keyword){    //type of contract
        String contract;
        if(super.SearchMechanism(keyword, contractWord, 0)){
            if((this.capacity == false) || (this.lawfulPurpose == false) || this.dischargingContract.equals(dischargingContract[2])){
                typeContract = ("This is a void contract means the contract is no longer valid.");
            }else if(((this.partiesConsent == true) && (this.consider == true) && (this.lawfulPurpose == true) && (this.capacity == true) && (this.offer == true)) ||
                    (keyword.equalsIgnoreCase(contractWord[2])) || keyword.equalsIgnoreCase(contractWord[9])){
                typeContract = ("This is an expressed contracts because both parties are understand the terms of contract with legal purpose");
            }
        }
    }
    public void setRemedies(String keyword){
        if(this.failingToPerform == true){
            if(this.breachOfContract == true){
                if(keyword.equalsIgnoreCase(contractWord[3]) || keyword.equalsIgnoreCase(contractWord[15])){
                    super.setRemedies("If one party is failling to perform, the judge will put this as compensatory damages to cover the loss of nonbreaching party.");
                    this.remedy = this.remedies[0];
                }else{
                    super.setRemedies("If one party is failing to perform, the judge will one of these remedies:\n"
                            + "1. The court may order the party to fulfill the terms of a contract\n"
                            + "2. One party is not to fulfill the terms of a contract\n"
                            + "3. the court may order the contract to be cancelled");
                }
            }
        }
    }
    
    public void setBreachOfContract(String keyword){
        if(keyword.equalsIgnoreCase(contractWord[1]) || keyword.equalsIgnoreCase(contractWord[6])){
            this.failingToPerform = true;
        }
    }
    
    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public boolean isPartiesConsent() {
        return partiesConsent;
    }

    public void setPartiesConsent(boolean partiesConsent) {
        this.partiesConsent = partiesConsent;
    }

    public boolean isHasContract() {
        return hasContract;
    }

    public void setHasContract(boolean hasContract) {
        this.hasContract = hasContract;
    }
    
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
    
    
}
