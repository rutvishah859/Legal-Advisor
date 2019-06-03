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

    public void setRight(String keyword) {
        if(super.SearchMechanism(keyword,getIssues(), 0)==true){
            if(this.getISM()>=0&&this.getISM()<5){
                this.right="Section 2a)";
            }
        }
    }
    
    String printInfo() {
        return null;
        
    }
    
}
