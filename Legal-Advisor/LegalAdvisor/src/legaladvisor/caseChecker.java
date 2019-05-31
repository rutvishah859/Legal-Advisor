package legaladvisor;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class caseChecker extends Case{
    private String Case; 
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
    public boolean findKeyWords (/*String [] words*/ caseChecker caseFile, String word){
        String [] comText = caseFile.printInfo().split("\\s"));
        for(String w : comText){  
            if (w.equals(word)){
                return true; 
            }
        }   
        return false; 
    }
}
