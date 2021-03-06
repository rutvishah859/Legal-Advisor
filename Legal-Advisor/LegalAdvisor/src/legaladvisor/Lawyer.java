//This file is all about Lawyer. There will be 3 different types of Lawyer: Criminal, Human Rights and Civil.
//All these lawyers have specialization, name, phone number. The users will be able to book appointment for the 
//lawyer that they want. The appointment depends on the lawyer availiability. The users will choose the day that 
//their lawyer available.
package legaladvisor;
import java.util.ArrayList;
public class Lawyer {
    private String availability[];
    private String specialization[];
    private String name;
    private String phoneNum;
    private String dayofAppointment;
    Lawyer(String [] a, String [] s, String n, String pn){
        availability=a;
        specialization=s;
        name=n;
        phoneNum=pn;
    }
    public boolean appointCase(ArrayList <String> userAvailability){
        boolean haslawyer=false;
        for(int i=0; i<availability.length;i++){
            for(int j=0;j<userAvailability.size();j++){
                if(availability[i].equalsIgnoreCase(userAvailability.get(j))){
                    haslawyer=true;
                    dayofAppointment=availability[i];
                    availability[i]="Busy that day";
                }
            }
        }
        return haslawyer;
    }
    public String[] getAvailability() {
        return availability;
    }
    public void setAvailability(String[] availability) {
        this.availability = availability;
    }
    public String[] getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String[] specialization) {
        this.specialization = specialization;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public String getDayofAppointment() {
        return dayofAppointment;
    }
    public void printInfo(){
        System.out.println("Lawyer's name:" + this.name+"\nPhone number:"+ this.phoneNum+ "\nDay of appointment:"+ this.getDayofAppointment());
    }
    
    
}
