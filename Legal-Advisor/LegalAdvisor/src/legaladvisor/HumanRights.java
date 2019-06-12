/*
The HumanRights method extends Case
*/
package legaladvisor;

public abstract class HumanRights extends Case {
    private String CharterOHRC; 

    public HumanRights(String rem, String jur) {
        super(rem, jur);  
    }
    //returns the String variable CharterOHRC 
    public String getCharterOHRC() {
        return CharterOHRC;
    }
    //sets the String variable CharterOHRC
    public void setCharterOHRC(String SCO) {
        this.CharterOHRC = SCO;
    }
    @Override
    public String printInfo(){
        return  "Jurisdiction:"+ super.getJurisdiction()+"\nRemedies:" + super.getRemedies()+ "\nType of Human Rights Case:"+ this.getCharterOHRC();
    }
}
