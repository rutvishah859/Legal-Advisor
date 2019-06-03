package legaladvisor;
import java.io.*;

public class Tester {
    public static void main(String []args) throws IOException{
        CrimeAgainstPerson c1= new CrimeAgainstPerson("None","Criminal","Ontario","Crime Against The Person","null","indictable");
        c1.setMensRea("accident");
        System.out.println(c1.getMensRea());
        c1.setCrimeTypeAndSentence("killed");
        System.out.println(c1.getCrimeType());
        OHRC o1=new OHRC("","","","","");
        o1.setGrounds("white");
        o1.setArea("hospital");
        System.out.println(o1.getArea());
        System.out.println(o1.getGrounds());
        File c = new File ("H:\\GitHub\\Legal-Advisor\\Legal-Advisor\\LegalAdvisor\\src\\legaladvisor\\caseFile.txt");
        caseChecker cc = new caseChecker ("abc", "abc", "abc", c);
        System.out.println(cc.printInfo()); 
    }
}
