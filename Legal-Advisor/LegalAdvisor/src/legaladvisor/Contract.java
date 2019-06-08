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
    private String contractWord []= {"contract","make" , "goods"};
    private String consideration;   //The actual value or amount exchanged between the two parties
    private String unlawfulPurpose[] = {"betting", "gambling", "gaming"}; //the contract must have lawful objective or purpose
    private String dischargingContract [] = {"performance", "mutual agreement" , "frustration of contract", "breach of contract"};
    //breach of contract is failing to perform an obligation owed to another party
    //if breach occurs, it allows the party to cancel or end the contract
    public Contract(String rem, String jur, String tC,String pur, boolean pC, boolean hC) {
        super(rem, jur, tC);
        this.purpose = pur;
        this.partiesConsent = pC;
        this.hasContract = hC;
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
    
}
