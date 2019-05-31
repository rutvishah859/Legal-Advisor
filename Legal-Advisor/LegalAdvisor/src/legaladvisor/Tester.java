package legaladvisor;
import java.io.*;

public class Tester {
    public static void main(String []args) throws IOException{
        CrimeAgainstPerson c1= new CrimeAgainstPerson("None","Criminal","Ontario","Crime Against The Person","null","indictable");
        c1.setMensRea("accident");
        System.out.println(c1.getMensRea());
        c1.setCrimeTypeAndSentence("killed");
        System.out.println(c1.getCrimeType());
        
        File c = new File ("H:\\GitHub\\Legal-Advisor\\Legal-Advisor\\LegalAdvisor\\src\\legaladvisor\\caseFile.txt");
        caseChecker cc = new caseChecker ("abc", "abc", "abc", c);
        System.out.println(cc.printInfo()); 
        String word = "hello"; 
        System.out.println(cc.findKeyWords(cc ,word));
    }
}
