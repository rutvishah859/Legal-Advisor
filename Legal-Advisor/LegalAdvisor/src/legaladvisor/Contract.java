package legaladvisor;

public class Contract extends Civil {
    
    private String purpose;
    private boolean partiesConsent;
    private boolean hasContract;
    
    public Contract(String rem, String typ, String jur, String tC,String pur, boolean pC, boolean hC) {
        super(rem, typ, jur, tC);
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
