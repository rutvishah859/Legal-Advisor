package legaladvisor;

public class Civil extends Case{

    String typeCase;
    String sentence;
    public Civil(String rem, String jur, String tC) {
        super(rem, jur);
       this.typeCase= tC;
    }
    public String getTypeCase(){
        return typeCase;
    }
    public void setTypeCase(String tC){
        this.typeCase= tC;
    }
    public String printInfo(){
        return  "\nType of civil case: "+this.typeCase+super.printInfo();
    }
    public void setSentence(String s){
        sentence=s;
    
    }
    
}
