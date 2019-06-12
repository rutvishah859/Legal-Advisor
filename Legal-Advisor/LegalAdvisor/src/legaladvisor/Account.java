/*
The Account class which contins all te cases lawyers, and methods of set up the cases/lawyers for each individual account
*/
package legaladvisor;
import java.io.*;
import java.util.ArrayList;
public class Account {
    private ArrayList <Case> cases=new ArrayList();
    private ArrayList <String> availableDays=new ArrayList();
    private Lawyer l1;
    private File f;
    private caseChecker c;
    private String dayOfAppointment;
    private int agePerson;
    public Account(File fileName, int age){
        f=fileName;
        agePerson=age;
    }
    public void setCaseChecker(File f) throws IOException{
        c=new caseChecker("","",f,agePerson);
    }
    public caseChecker getCaseChecker(){
        return c;
    }
    public void setCase(){
        Case ca1=new Case("","");
        ca1=c.findKeyWords(c);
        cases.add(ca1);
    }
    public ArrayList <Case> getCase(){
        return cases;
    }
    public void setAvailability(String day){
        availableDays.add(day);
    }
    public void setFile(String name){
       f=new File(name); 
    }
    public Lawyer getLawyer(){
        return l1;
    }
    public ArrayList <String> getAvailability(){
        return availableDays;
    }
    public void setLawyer(Lawyer law1){
        if(law1.appointCase(availableDays)){
            l1=law1;
        }
    }
    public void setDayOfAppointment(){
        dayOfAppointment=l1.getDayofAppointment();
        for(int i=0;i<availableDays.size();i++){
            if(dayOfAppointment.equalsIgnoreCase(availableDays.get(i))){
                availableDays.set(i,"Appointment that day");
            }
        }
    }
    public void sortCases(ArrayList <Case> cases){
        if(cases.size()>1){
        for(int i=0;i<cases.size();i++){
            Case firstAlphabetLetter=cases.get(i);   
            int index=i;
            for(int j=i+1;j<cases.size();j++){
                if(cases.get(j).getType().get(0).charAt(0)<firstAlphabetLetter.getType().get(0).charAt(0)){
                    firstAlphabetLetter=cases.get(j);
                    index=j;
                }
            }
            Case originalValue=cases.get(i);
            cases.set(i, firstAlphabetLetter);
            cases.set(index,originalValue);
        }
        }
        else{
            System.out.println("Cases are in order.");
        }
    }
    }
