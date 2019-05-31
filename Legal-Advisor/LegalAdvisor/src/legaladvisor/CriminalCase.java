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
<<<<<<< HEAD
    
=======
>>>>>>> 4034e5632badbdf4c0e592af43b9cc3dd81661c9
    public String printInfo(){
        return "Jurisdiction: " + this.getJurisdiction() + "\nType: " + this.getType()+ "\nCrime: " + this.crime + "";
    }

    boolean SearchMechanism(String keyword, String[] murderkeywords, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}