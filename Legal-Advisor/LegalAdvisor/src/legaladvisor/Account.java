package legaladvisor;
import java.io.*;
import java.util.ArrayList;
public class Account {
    private ArrayList <Case> Cases;
    private ArrayList <String> availableDays;
    private Lawyer l1;
    private File f;
    private caseChecker c;
    private String dayOfAppointment;
    public Account(String fileName){
        f=new File(fileName);
    }
    public void setCaseChecker() throws IOException{
        c=new caseChecker("","",f);
    }
    public void setCase(){
        Case c1;
        c1=c.findKeyWords(c);
    }
    public ArrayList <Case> getCase(){
        return Cases;
    }
    public void setAvailability(String day){
        availableDays.add(day);
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
    public void sortCases(){
        
    }
}
