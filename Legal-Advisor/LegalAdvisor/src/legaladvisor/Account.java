/*
The Account class which contins all te cases lawyers, and methods of set up the cases/lawyers for each individual account
*/
package legaladvisor;
import java.io.*;
import java.util.ArrayList;
public class Account {
    private ArrayList <Case> cases;
    private ArrayList <String> availableDays;
    private Lawyer l1;
    private File f;
    private caseChecker c;
    private String dayOfAppointment;
    public Account(File fileName){
        f=fileName;
    }
    public void setCaseChecker() throws IOException{
        c=new caseChecker("","",f);
    }
    public void setCase(){
        Case c1;
        c1=c.findKeyWords(c);
        cases.add(c1);
    }
    public ArrayList <Case> getCase(){
        return cases;
    }
    public void setAvailability(String day){
        availableDays.add(day);
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
    }

