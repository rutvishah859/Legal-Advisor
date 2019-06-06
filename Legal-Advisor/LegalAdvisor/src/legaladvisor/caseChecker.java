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
    
    public caseChecker(String rem, String jur, File complaint) throws IOException {
        super(rem, jur);
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
    public Case findKeyWords (/*String [] words*/ caseChecker caseFile){
        this.setWordBank(caseFile.printInfo().split("\\s"));
        String jurisdiction="";
        for(String w : this.getWordBank()){  
            if(super.SearchMechanism(w, super.getJusrisdictions(), 0)){
                if(this.getISM()==0){
                    jurisdiction="Ontario";
                }
                else{
                    jurisdiction="Canada";
                }
            }
            if (super.SearchMechanism(w, super.getFraud(), 0)){
                super.setType ("Money Crimes");
                MoneyCrimes fraud= new MoneyCrimes ("","","", "", 0.0, true, "");
                fraud.setCrimeAndSentence(w);
                return fraud;
            }
            else if (super.SearchMechanism(w, super.getElectronicCrime(), 0)){
                super.setType ("Money Crimes"); 
                MoneyCrimes electronicCrime = new MoneyCrimes ("","", "", "", 0.0, true, "");
                electronicCrime.setCrimeAndSentence(w);
                return electronicCrime;
            }
            else if (super.SearchMechanism(w, super.getMoneyLaundering(), 0)){
                super.setType("Money Crimes");
                MoneyCrimes moneyLaundering = new MoneyCrimes ("","", "", "", 0.0, true, "");
                moneyLaundering.setCrimeAndSentence(w);
                return moneyLaundering;
            }
            else if (super.SearchMechanism(w, super.getTheft(), 0)){
                super.setType("Money Crimes");
                MoneyCrimes theft = new MoneyCrimes ("","", "", "", 0.0, false, ""); 
                theft.setCrimeAndSentence(w); 
                return theft;
            }
            else if (super.SearchMechanism(w, super.getRobbery(), 0)){
                super.setType ("MoneY Crimes"); 
                MoneyCrimes robbery = new MoneyCrimes ("","", "", "", 0.0, false, ""); 
                return robbery;
            }
            if (super.SearchMechanism(w, super.getMurderkeywords(), 0)){
                super.setType("Crime Against Person");
                CrimeAgainstPerson murder = new CrimeAgainstPerson ("", "", "", "", "");
                murder.setMensRea(w);
                murder.setCrimeTypeAndSentence(w);
                return murder;
            }
            else if (super.SearchMechanism(w, super.getAssaultkeywords(), 0)){
                super.setType("Crime Against Person");
                CrimeAgainstPerson assault = new CrimeAgainstPerson ("", "", "", "", "");
                return assault;
            }
            if(jurisdiction.equalsIgnoreCase(super.getJusrisdictions()[1])){ //will only be an OHRC case if the jurisdiction is Ontario
                if (super.SearchMechanism(w, super.getGroundKeywords(), 0)||super.SearchMechanism(w, super.getAreaKeywords(), 0)){ 
                    super.setType("OHRC");
                    OHRC ohrcComplaint = new OHRC ("", "Ontario", "", "");
                    ohrcComplaint.setArea(w);
                    ohrcComplaint.setGrounds(w);
                    ohrcComplaint.setCharterOHRC("OHRC");
                    return ohrcComplaint;
                }
                }
            }
            if(jurisdiction.equalsIgnoreCase("Canada")){ //will only be a Charter case is the jurisdiction is Canada
                if (super.SearchMechanism(w, super.getIssues(), 0)){
                    super.setType("Charter");
                    Charter charter = new Charter ("", "", "");
                }
            }
            if (super.SearchMechanism(w, super.getTraffickingTerm(), 0)){
                super.setType("Drug Crime");
                DrugCrime trafficking = new DrugCrime ("", "", jurisdiction, "", "", false, false, 0.0, "");
            }
            else if (super.SearchMechanism(w, super.getDrugType(), 0)){
                super.setType ("Drug Crimes"); 
                DrugCrime drug = new DrugCrime ("", "", jurisdiction, "", "", false, false, 0.0, "");
            }
        return null;
            
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