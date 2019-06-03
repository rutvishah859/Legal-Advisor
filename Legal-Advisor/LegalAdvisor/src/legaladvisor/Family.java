package legaladvisor;

public class Family extends Civil {
    
    private boolean marriage;
    private boolean divorce;
    private boolean child;
    
    public Family(String rem, String typ, String jur, String tC, boolean mar, boolean div, boolean child) {
        super(rem, typ, jur, tC);
        
    }
    
    
}
