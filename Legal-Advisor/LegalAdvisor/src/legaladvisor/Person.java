package legaladvisor;
public class Person {
private String name;
private String complaintFilePath;
private String phoneNum;
private Account a1;
    public Person(String n, String c, String pn){
    name=n;
    complaintFilePath=n;
    phoneNum=pn;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getComplaintFilePath() {
        return complaintFilePath;
    }
    public void setComplaintFilePath(String complaintFilePath) {
        this.complaintFilePath = complaintFilePath;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public Account getA1() {
        return a1;
    }
    public void setA1(Account a1) {
        this.a1 = a1;
    }

}
