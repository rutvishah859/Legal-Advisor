package legaladvisor;
import java.io.*;
import java.util.Scanner;
public class LegalAdvisor {
    public static void main(String []args) throws IOException{
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to your personal Legal Advisor!");
        System.out.println("---------------------------------------");
        System.out.println("Please format your text file complaint likewise:");
        System.out.println("------------------------------------------------");
        System.out.println("1. Include the grievance you experienced.");
        System.out.println("2. Please include your jurisdiction but it may ONLY be Canada or Ontario.");
        System.out.println("3. Write your complaint out in a SINGLE line.");
        System.out.println("4. Please include only one complaint per file.");
        System.out.println("5. If you have no more complaints please enter: none.");
        String filename;
        String name;
        String phoneNumber;
        int age;
        System.out.println("Please enter your name:");
        name=input.nextLine();
        System.out.println("Please enter your phone number:");
        phoneNumber=input.nextLine();
        System.out.println("Please enter a file location with your complaint. Please include the double slashes.");
        filename=input.nextLine();
        System.out.println("Please enter your age:");
        age=input.nextInt();
        File f= new File(filename);
        Person p1=new Person(name,filename,phoneNumber);
        String availableDaysL1[]={"Monday","Tuesday","Friday"};
        String specialization[]={"Criminal Law","Human Rights","Civil Law"};
        Lawyer l1=new Lawyer(availableDaysL1,specialization, "Mark Brown","416-897-5781");
        String availableDaysL2[]={"Sunday","Tuesday","Wednesday"};  
        Lawyer l2=new Lawyer(availableDaysL2,specialization,"Josh Peck","416-123-4567");
        String availableDaysL3[]={"Thursday","Saturday"};
        Lawyer l3=new Lawyer(availableDaysL3,specialization,"Shawna Mendes","647-589-2123");
        Account acc= new Account(p1.getF(),age);
        p1.setA1(acc);
        p1.getA1().setFile(filename);
        p1.getA1().setCaseChecker(f);
        String needsLawyer;
        String dayAvailable="";
        do{
        p1.getA1().setCase();
        System.out.println("Please enter the next file name:");
        filename=input.next();
        p1.getA1().setFile(filename);
        }while(!filename.equalsIgnoreCase("none"));
        p1.getA1().sortCases(p1.getA1().getCase());
        System.out.println("Do you need a lawyer?");
        needsLawyer=input.next();
        if(needsLawyer.equalsIgnoreCase("yes")){
           System.out.println("Please enter the days you are available, one at a time. Once you entered them all, enter: none.");
           dayAvailable=input.next();
            while(!dayAvailable.equalsIgnoreCase("none")){
            p1.getA1().getAvailability().add(dayAvailable);
            System.out.println("Please enter the days you are available");
            dayAvailable=input.next();
            }
            p1.getA1().setLawyer(l1);
            p1.getA1().setLawyer(l2);
            p1.getA1().setLawyer(l3);
            System.out.println("Your Account:");
            System.out.println("Name:"+p1.getName());
            System.out.println("Phone Number:"+p1.getPhoneNum());
            System.out.println("Case:"+p1.getA1().getCase().get(0).printInfo());
            p1.getA1().getLawyer().printInfo();
            System.out.println("Thank you for using Legal Advisor");
        }
        else{
            System.out.println("Thank you for using Legal Advisor.");
        }
    }
}
