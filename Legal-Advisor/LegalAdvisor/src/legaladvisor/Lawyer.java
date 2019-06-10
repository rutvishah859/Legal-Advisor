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
        System.out.println("Lawyer's name:" + this.name+" Phone number:"+ this.phoneNum+ "Day of appointment:"+ this.getDayofAppointment());
    }
    
    
}

