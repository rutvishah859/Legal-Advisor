package legaladvisor;

public class Family extends Civil {
    
    private boolean marriage;
    private boolean divorce;
    private boolean child;
    private int numChild;
    private String custodyType[] = {"full", "joint", "shared", "split"};
    private boolean childDecision;
    private String famKeyword[] = {"aggreement","child", "custody", "disagree", "divorce", "permanent", "share","decision making" };
    private String custType;
    private boolean mentalHealth;
    private boolean physicalHealth;
    
    
    public Family(String rem, String typ, String jur, String tC, boolean mar, boolean div, boolean child) {
        super(rem, typ, jur, tC);
        this.marriage = mar;
        this.divorce = div;
        this.child = child;
    }
    public void setCustody(String keyword){
        String advice;
        if(super.SearchMechanism(keyword, famKeyword, 0)){
           
        }
    }
    
    public void custType(String keyword){
        if(keyword.equalsIgnoreCase(famKeyword[5])){
            custType = custodyType[0];
        }else if(keyword.equalsIgnoreCase(famKeyword[0]) || keyword.equalsIgnoreCase(famKeyword[6])){
            custType = custodyType[1];
        }else if(this.numChild > 2){
            custType = custodyType[3];
        }
    }
    public boolean isMarriage() {
        return marriage;
    }

    public void setMarriage(boolean marriage) {
        this.marriage = marriage;
    }
    
    public boolean isDivorce() {
        return divorce;
    }

    public void setDivorce(boolean divorce) {
        this.divorce = divorce;
    }

    public boolean isChild() {
        return child;
    }

    public void setChild(boolean child) {
        this.child = child;
    }
    
    
    
}
