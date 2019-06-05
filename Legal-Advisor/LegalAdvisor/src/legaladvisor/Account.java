package legaladvisor;
import java.io.*;
public class Account {
    private Case c1;
    private Lawyer l1;
    private File f;
    private caseChecker c;
    public Account(String fileName){
        f=new File(fileName);
    }
    public void setCaseChecker() throws IOException{
        c=new caseChecker("","","",f);
    }
}
