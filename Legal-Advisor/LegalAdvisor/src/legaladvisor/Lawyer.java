package legaladvisor;
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
    public void appointCase(String userAvailability){
        for(int i=0;)
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

