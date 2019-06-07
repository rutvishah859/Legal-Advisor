package legaladvisor;
import java.io.*;
import java.util.ArrayList;
public class Account {
    private ArrayList <Case> Cases;
    private ArrayList <String> availableDays;
    private Lawyer l1;
    private File f;
    private caseChecker c;
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
}
