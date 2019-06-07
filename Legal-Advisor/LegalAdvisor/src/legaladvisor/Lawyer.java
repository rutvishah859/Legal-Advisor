package legaladvisor;
import java.util.ArrayList;
public class Lawyer {
    private String availability[];
    private String specialization[];
    private String name;
    private String phoneNum;
    Lawyer(String [] a, String [] s, String n, String pn){
        availability=a;
        specialization=s;
        name=n;
        phoneNum=pn;
    }
    public String appointCase(ArrayList <String> userAvailability){
        boolean haslawyer=false;
        for(int i=0; i<availability.length;i++){
            for(int j=0;j<userAvailability.size();j++){
                if(availability[i].equalsIgnoreCase(userAvailability.get(j))){
                    haslawyer=true;
                    return availability[i]+"is the day when you will have your appointment with your lawyer.";
                    
                }
            }
            if(haslawyer=true){
                    availability[i]="Busy that day";
            }
        }
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
    
}

