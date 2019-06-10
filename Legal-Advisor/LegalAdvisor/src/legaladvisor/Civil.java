package legaladvisor;

public abstract class Civil extends Case{

    String typeCase;
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
    abstract String printInfo();
    

    
    
    
}
