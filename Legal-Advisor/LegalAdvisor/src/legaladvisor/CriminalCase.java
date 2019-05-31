package legaladvisor;

public abstract class CriminalCase extends Case {
    
    private String crime;
    private String sentence;
    
    public CriminalCase(String rem, String typ, String jur, String crim, String sen) {
        super(rem, typ, jur);
        this.crime = crim;
        this.sentence = sen;
    }
    public String getCrime() {
        return crime;
    }
    public void setCrime(String crime) {
        this.crime = crime;
    }
    public String getSentence() {
        return sentence;
    }
    public void setSentence(String sentence) {
        this.sentence = sentence;
    }    
    public String printInfo(){
        return "Jurisdiction: " + this.getJurisdiction() + "\nType: " + this.getType()+ "\nCrime: " + this.crime + "";
    }
}