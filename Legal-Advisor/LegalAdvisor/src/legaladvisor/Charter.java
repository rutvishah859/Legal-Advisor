package legaladvisor;

public class Charter extends HumanRights {
    private String right;    
    public Charter(String rem, String typ, String jur, String r) {
        super(rem, typ, jur);
        this.right = r; 
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }
    
    String printInfo() {
        return null;
        
    }
    
}
