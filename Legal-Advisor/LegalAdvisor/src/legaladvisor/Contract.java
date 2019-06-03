package legaladvisor;

public class Contract extends Civil {
    
    private String purpose;
    private boolean partiesConsent;
    private boolean hasContract;
    
    public Contract(String rem, String typ, String jur, String tC,String pur, boolean pC, boolean hC) {
        super(rem, typ, jur, tC);
        
    }
    
}
