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
        for(String w : this.getWordBank()){  
            for (int i = 0; i < super.getFraud().length; i++){ //checks if its a frad case
               if (w.equals(super.getFraud()[i])){    
                    return true; 
                } 
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
