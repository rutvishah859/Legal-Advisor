/*
The Criminal Case method extends the Case class  
*/
package legaladvisor;

public abstract class CriminalCase extends Case {
    
    private String crime;
    private String sentence;
    
    public CriminalCase(String rem, String jur, String crim, String sen) {
        super(rem, jur);
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
}