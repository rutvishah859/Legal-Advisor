package legaladvisor;

public abstract class HumanRights extends Case {
    private String CharterOHRC; 

    public HumanRights(String rem, String jur) {
        super(rem, jur);  
    }

    public String getCharterOHRC() {
        return CharterOHRC;
    }

    public void setCharterOHRC(String SCO) {
        this.CharterOHRC = SCO;
    }
    
    
}
