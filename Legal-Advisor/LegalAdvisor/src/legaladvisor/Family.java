package legaladvisor;

public class Family extends Civil {
    
    private boolean marriage;
    private boolean divorce;
    private boolean child;
    
    public Family(String rem, String typ, String jur, String tC, boolean mar, boolean div, boolean child) {
        super(rem, typ, jur, tC);
        
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
