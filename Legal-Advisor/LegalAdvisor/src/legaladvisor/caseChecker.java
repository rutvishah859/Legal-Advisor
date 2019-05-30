package legaladvisor;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 325075141
 */
public class caseChecker extends Case{
    private String Case; 
    private Case cal; 
    private String keyWord;
    private File caseFile; 
    
    public caseChecker(String rem, String typ, String jur,File complaint) {
        super(rem, typ, jur);
        caseFile = new File ("H:\\GitHub\\Legal-Advisor\\Legal-Advisor\\LegalAdvisor\\src\\legaladvisor");
        try { 
            BufferedReader br =  new BufferedReader (new FileReader (caseFile));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(caseChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    String printInfo() {
        return null; 
    }
    
}
