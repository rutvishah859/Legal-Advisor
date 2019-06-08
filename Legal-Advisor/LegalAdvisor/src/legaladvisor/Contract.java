package legaladvisor;

public class Contract extends Civil {
    
    private String purpose; //contract must have purpose
    private boolean partiesConsent; //parties must agree the terms of contract
    private boolean capacity; // parties must have ability to understand what they were agreeing to
    private String remedies [] = {"Damages" , "Injunctions", "Privity of Contract","Rescission","Specific Performance"};
    //remedies are available if the breach of contract occurs
    //Damages is awarded to compensate the injured party in the contract. Liquidates damages, sum of money specified in contract to settle the breach
    //Specific performance is the court may order the party to fulfill the terms of a contract
    //Injuction: one party is ordered not to fulfill the terms of a contract
    //Rescission is when the court may order the contract to be cancelled
    private boolean disability; // anyone with disability or impaired judgment can't make a valid contract
    private int participantAge; // anyone who under 18 or 19 years old does not have the capacity to enter into valid contract
    private boolean hasContract;    //must have contract in order to make a case
    private boolean brokenContract; // if the parties break the contract
    private String contractWord []= {"agree","break","condition","contract","disagree","goods","illness","make", "mental","negotiate","offer", "request"};
    private String consideration;   //The actual value or amount exchanged between the two parties
    private boolean consider;
    private boolean offer;
    private String unlawfulPurpose[] = {"betting", "gambling", "gaming"}; //the contract must have lawful objective or purpose
    private boolean lawfulPurpose;
    private String dischargingContract [] = {"performance", "mutual agreement" , "frustration of contract", "breach of contract"};
    //breach of contract is failing to perform an obligation owed to another party
    //if breach occurs, it allows the party to cancel or end the contract
    private boolean breachOfContract;
    private String contractType[] = {"express", "implied", "valid","void"};
    public Contract(String rem, String jur, String tC,String pur, boolean pC, boolean hC, int partAge) {
        super(rem, jur, tC);
        this.purpose = pur;
        this.partiesConsent = pC;
        this.hasContract = hC;
        
    }
    
    public void setContract(String keyword){    //type of contract
        if(super.SearchMechanism(keyword, contractWord, 0)){
            if((this.capacity == false) || (this.lawfulPurpose == false) || this.dischargingContract.equals(dischargingContract[2])){
                super.setRemedies("This is a void contract means the contract is no longer valid.");
            }else if((this.partiesConsent == true) && (this.consider == true) && (this.lawfulPurpose == true) && (this.capacity == true) && (this.offer == true)){
                super.setRemedies("This is an expressed contracts because both parties are understand the terms of contract with legal purpose");
            }
        }
    }
    public void setRemedies(){
        if(this.breachOfContract == true){
            
        }
    }
    
    public void setBreachOfContract(){
        
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
    
    public void setCapacity(boolean d, int a){
        if((d == true) || (a < 19)){
           this.capacity = true;
        }else{
           this.capacity = false;
        }
    }
    
    public boolean getCapacity(){
        return this.capacity;
    }
    
    
}
