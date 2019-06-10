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
        Person p1=new Person(name,filename,phoneNumber);
        System.out.println(p1.getName());
        System.out.println(p1.getPhoneNum());
        Account acc= new Account(p1.getF());
        p1.setA1(acc);

    }
}
