package legaladvisor;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class caseChecker extends Case{
    private String CaseType; 
    private Case cal; 
    private String keyWord;
    private String [] wordBank; //a bank of key words found in the text file
    private File caseFile; 
    
    public caseChecker(String rem, String typ, String jur,File complaint) throws IOException {
        super(rem, typ, jur);
        caseFile = complaint; 
    }

    String printInfo() {
        String st = null; 
        String s = ""; 
        try { 
            BufferedReader br =  new BufferedReader (new FileReader (this.caseFile));
            try {
                while ((st = br.readLine()) != null){
                    s += st + " ";
                }
                return s; 
            } catch (IOException ex) {
                Logger.getLogger(caseChecker.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(caseChecker.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null; 
    } 
    
    //methods that cecks if any of the types cases apply to the this complaint
    //each case type class will call this method to check if any of their clases apply here
    public boolean findKeyWords (/*String [] words*/ caseChecker caseFile){
        this.setWordBank(caseFile.printInfo().split("\\s")));
        String caseType="";
        for(String w : this.getWordBank()){  
            if (super.SearchMechanism(w, super.getFraud(), 0)){
                super.setType ("Money Crimes");
                MoneyCrimes fraud= new MoneyCrimes ("","","", "", "", 0.0, true, "");
                fraud.setCrimeAndSentence(w);
            }
            else if (super.SearchMechanism(w, super.getElectronicCrime(), 0)){
                super.setType ("Money Crimes"); 
                MoneyCrimes electronicCrime = new MoneyCrimes ("","","", "", "", 0.0, true, "");
                electronicCrime.setCrimeAndSentence(w);
            }
            else if (super.SearchMechanism(w, super.getMoneyLaundering(), 0)){
                super.setType("Money Crimes");
                MoneyCrimes moneyLaundering = new MoneyCrimes ("","","", "", "", 0.0, true, "");
                moneyLaundering.setCrimeAndSentence(w);
            }
            else if (super.SearchMechanism(w, super.getTheft(), 0)){
                super.setType("Money Crimes");
                MoneyCrimes theft = new MoneyCrimes ("","","", "", "", 0.0, true, ""); 
                theft.setCrimeAndSentence(w);
            }
            else if (super.SearchMechanism(w, super.getRobbery(), 0)){
                super.setType ("MoneY Crimes"); 
                MoneyCrimes robbery = new MoneyCrimes ("","","", "", "", 0.0, true, ""); 
                robbery.setCrimeAndSentence(w);
            }
            if (super.SearchMechanism(w, super.getMurderkeywords(), 0)){
                super.setType("Crime Against Person");
                CrimeAgainstPerson murder = new CrimeAgainstPerson ("", "", "", "", "", "");
            }
            else if (super.SearchMechanism(w, super.getAssaultkeywords(), 0)){
                super.setType("Crime Against Person");
                CrimeAgainstPerson assult = new CrimeAgainstPerson ("", "", "", "", "", "");
            }
            if (super.SearchMechanism(w, super.getGroundKeywords(), 0)){
                super.setType("OHRC");
                OHRC ground = new OHRC ("", "", "", "", "");
            }
            
        }
            
        return false;
    }

    public String[] getWordBank() {
        return wordBank;
    }

    public void setWordBank(String[] wordBank) {
        this.wordBank = wordBank;
    }

    public void setCaseType(String CaseType) {
        this.CaseType = CaseType;
    }
}
