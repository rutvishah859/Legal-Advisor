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
        System.out.println("5. If you have no more complaints please enter: No more complaints.");
        String filename;
        String name;
        String phoneNumber;
        System.out.println("Please enter your name:");
        name=input.nextLine();
        System.out.println("Please enter your phone number:");
        phoneNumber=input.nextLine();
        System.out.println("Please enter a file name with your complaint. Please include the double slashes.");
        filename=input.nextLine();
        Person p1=new Person(name,filename,phoneNumber);
        String availableDaysL1[]={"Monday","Tuesday","Friday"};
        String specialization[]={"Criminal Law","Human Rights","Civil Law"};
        Lawyer l1=new Lawyer(availableDaysL1,specialization, "Mark Brown","416-897-5781");
        String availableDaysL2[]={"Sunday","Tuesday","Wednesday"};  
        Lawyer l2=new Lawyer(availableDaysL2,specialization,"Josh Peck","416-123-4567");
        String availableDaysL3[]={"Thursday","Saturday"};
        Lawyer l3=new Lawyer( availableDaysL3,specialization,"Shawna Mendes","647-589-2123");
        Account acc= new Account(p1.getF());
        p1.setA1(acc);
        p1.getA1().setCaseChecker();
        String needsLawyer;
        while(!filename.equalsIgnoreCase("no more complaints")){
        p1.getA1().setCase();
        for(int i=0;i<p1.getA1().getCase().size();i++){
        System.out.println(p1.getA1().getCase().get(i).printInfo());
        }
        System.out.println("Do you need a lawyer?");
        needsLawyer=input.next();
        if(needsLawyer.equalsIgnoreCase("yes")){
            System.out.println("Please enter the days you are available");
            p1.getA1().setLawyer(l1);
            p1.getA1().setLawyer(l2);
            p1.getA1().setLawyer(l3);
        }
        }
    }
}
