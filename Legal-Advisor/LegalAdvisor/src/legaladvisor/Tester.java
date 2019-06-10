package legaladvisor;
import java.io.*;
import java.util.Scanner;
public class Tester {
    public static void main(String []args) throws IOException{
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to your personal Legal Advisor!");
        System.out.println("---------------------------------------");
        System.out.println("Please format your text file complaint likewise:");
        System.out.println("------------------------------------------------");
        System.out.println("1. Include the grievance you experienced.");
        System.out.println("2. Your jurisdiction may ONLY be Canada or Ontario.");
        System.out.println("3. Write your complaint out in a SINGLE line.");
        System.out.println("4. Please include only one complaint per file.");
        String filename;
        String name;
        String phoneNumber;
        System.out.println("Please enter your name:");
        name=input.nextLine();
        System.out.println("Please enter your phone number:");
        phoneNumber=input.nextLine();
        System.out.println("Please enter a file name with your complaint. Please include the double slashes.");
        filename=input.nextLine();
<<<<<<< HEAD
        Person p1=new Person(name,filename,phoneNumber);
        System.out.println(p1.getName());
        System.out.println(p1.getPhoneNum());
        Account acc= new Account(p1.getF());
        p1.setA1(acc);

=======
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
        
>>>>>>> 9aca77874bc41e1720b1c0fc28c13ce1af7382f7
    }
}
