package legaladvisor;
import java.io.*;
import java.util.Scanner;
public class Tester {
    public static void main(String []args) throws IOException{

        Scanner input = new Scanner(System.in);
        String filename;
        System.out.println("Please enter a file name with your complaint. Please include the double slashes.");
        filename=input.nextLine();
        Person p1=new Person("Max", filename, "1-888-467-4999");
        
        CrimeAgainstPerson c1= new CrimeAgainstPerson("None","Ontario","Crime Against The Person","null","indictable");
       
        c1.setMensRea("accident");
        System.out.println(c1.getMensRea());
        c1.setCrimeTypeAndSentence("killed");
        System.out.println(c1.getCrimeType());
        OHRC o1=new OHRC("","","","");
        o1.setGrounds("white");
        o1.setArea("hospital");
        System.out.println(o1.getArea());
        System.out.println(o1.getGrounds());
        File c = new File ("H:\\GitHub\\Legal-Advisor\\Legal-Advisor\\LegalAdvisor\\src\\legaladvisor\\caseFile.txt");
        caseChecker cc = new caseChecker ("abc", "abc", c);  
        System.out.println(cc.printInfo()); 
        cc.findKeyWords(cc);
        System.out.println(cc.getType());
        //MoneyCrimes mc = new MoneyCrimes ("", "", "", "", 0.0, false, "");

    }
}
