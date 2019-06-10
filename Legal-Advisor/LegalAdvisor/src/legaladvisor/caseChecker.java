/*
The CaseChecker class inheriates the Case class, who basically checks that text file searching for keywords setting up objects for those cases 
for example if the CaseChecker found a murder keyword then it would create a CrimeAgainstPerson object 
*/
package legaladvisor;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class caseChecker extends Case{
    private String CaseType; 
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
    public Case findKeyWords (caseChecker caseFile){
        this.setWordBank(caseFile.printInfo().split("\\s"));
        String jurisdiction="";
        String word = ""; 
        for(String w : this.getWordBank()){ 
            word = w; 
            if(super.SearchMechanism(w, super.getJusrisdictions(), 0)){
                if(this.getISM()==0){
                    jurisdiction="Ontario";
                }
                else{
                    jurisdiction="Canada";
                }
            }
            if (super.SearchMechanism(w, super.getFraud(), 0)){
                super.setType ("Criminal Case");
                MoneyCrimes fraud= new MoneyCrimes ("Trial",jurisdiction,"", "", 0.0, true);
                fraud.setCrimeAndSentence(w);
                fraud.setCrime("Money Crime");
                return fraud;
            }
            else if (super.SearchMechanism(w, super.getElectronicCrime(), 0)){
                super.setType ("Criminal Case"); 
                MoneyCrimes electronicCrime = new MoneyCrimes ("Trial",jurisdiction, "", "", 0.0, false);
                electronicCrime.setCrimeAndSentence(w);
                electronicCrime.setCrime("Money Crime");
                return electronicCrime;
            }
            else if (super.SearchMechanism(w, super.getMoneyLaundering(), 0)){
                super.setType("Criminal Case");
                MoneyCrimes moneyLaundering = new MoneyCrimes ("Trial",jurisdiction, "", "", 0.0, false);
                moneyLaundering.setCrimeAndSentence(w);
                moneyLaundering.setCrime("Money Crime");
                return moneyLaundering;
            }
            else if (super.SearchMechanism(w, super.getTheft(), 0)){
                super.setType("Criminal Case");
                MoneyCrimes theft = new MoneyCrimes ("Trial",jurisdiction, "", "", 0.0, false); 
                theft.setCrimeAndSentence(w);
                theft.setCrime("Money Crime");
                theft.setCrimeAndSentence(w); 
                return theft;
            }
            else if (super.SearchMechanism(w, super.getRobbery(), 0)){
                super.setType ("Criminal Case"); 
                MoneyCrimes robbery = new MoneyCrimes ("Trial",jurisdiction, "", "", 0.0, false); 
                robbery.setCrimeAndSentence(w);
                robbery.setCrime("Money Crimes");

                return robbery;
            }
            if (super.SearchMechanism(w, super.getMurderkeywords(), 0)){
                super.setType("Criminal Case");
                CrimeAgainstPerson murder = new CrimeAgainstPerson ("Trial", jurisdiction, "", "", "");
                murder.setMensRea(w);
                murder.setCrimeTypeAndSentence(w);
                murder.setCrime("Crimes against the Person");
                return murder;
            }
            else if (super.SearchMechanism(w, super.getAssaultkeywords(), 0)){
                super.setType("Criminal Case");
                CrimeAgainstPerson assault = new CrimeAgainstPerson ("Trial", jurisdiction, "", "", "");
                assault.setCrime("Crimes against the Person");
                return assault;
            }
            if(jurisdiction.equalsIgnoreCase(super.getJusrisdictions()[1])){ //will only be an OHRC case if the jurisdiction is Ontario
                if (super.SearchMechanism(w, super.getGroundKeywords(), 0)||super.SearchMechanism(w, super.getAreaKeywords(), 0)){ 
                super.setType("Human Rights Case");
                OHRC ohrcComplaint = new OHRC ("", "Ontario", "", "");
                ohrcComplaint.setArea(w);
                ohrcComplaint.setGrounds(w);
                ohrcComplaint.setRemedies();
                ohrcComplaint.setCharterOHRC("OHRC Case");
                return ohrcComplaint;
                }
                }
            
            if(jurisdiction.equalsIgnoreCase("Canada")){ //will only be a Charter case is the jurisdiction is Canada
                if (super.SearchMechanism(w, super.getIssues(), 0)){
                    super.setType("Human Rights Case");
                    Charter charter = new Charter ("No remedies needed", "Canada", "");
                    charter.setRight(w);
                    charter.setCharterOHRC("Charter Case");
                    return charter;
                }
            }
            if (super.SearchMechanism(w, super.getTraffickingTerm(), 0)){
                super.setType("Criminal Case");
                DrugCrime trafficking = new DrugCrime ("", jurisdiction, "", "", false, false, 0.0, "");
                trafficking.setCrime("Drug Crime");
                trafficking.setTrafficking(w, 0);
                trafficking.setCrimeTypeAndSentence(w);
                return trafficking;
            }
            
            else if (super.SearchMechanism(w, super.getDrugType(), 0)){
                super.setType ("Criminal Case"); 
                DrugCrime possession = new DrugCrime ("", jurisdiction, "", "", false, false, 0.0, "");
                possession.setCrime("Drug Crime");
                possession.setCrimeTypeAndSentence(w);
                return possession;
            }
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