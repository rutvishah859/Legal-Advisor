package legaladvisor;

public class CrimeAgainstPerson extends CriminalCase{
    
    private boolean moment;
    private String typeOfOffence;
    private String mensRea;
    private String crimeType;
    private String murderTypes[]={"First Degree Murder","Second Degree Murder","Manslaughter","Physical Assault","Aggravated Assault","Sexual Assault","Verbal Assault"};
    private String keywords []={"killed","murdered","assassinated","executed","finished off",};
    
    public CrimeAgainstPerson( String rem, String typ, String jur , String crim, String sen, String tOO){
            super(rem, typ, jur, crim, sen);
           
            this.typeOfOffence = tOO;
        
    }
    
    public String getTypeOfOffence() {
        return typeOfOffence;
    }
    public void setCrimeTypeAndSentence(String keyword){
        if(keyword.equalsIgnoreCase("killed")||keyword.equalsIgnoreCase("kill")||keyword.equalsIgnoreCase("murder")||keyword.equalsIgnoreCase("execute")||keyword.equalsIgnoreCase("assassinate")||keyword.equalsIgnoreCase("finish off")){
            
          if(moment==false&&(mensRea.equalsIgnoreCase("intent")&&mensRea.equalsIgnoreCase("motive")&&mensRea.equalsIgnoreCase("knowledge"))) {
              crimeType="First Degree Murder";
          }
          else if(moment==true && (mensRea.equalsIgnoreCase("intent")||mensRea.equalsIgnoreCase("motive")||mensRea.equalsIgnoreCase("knowledge"))){
              crimeType="Second Degree Murder";
          }
          else if(mensRea.equalsIgnoreCase("criminal negligence")||mensRea.equalsIgnoreCase("willful blindness")||mensRea.equalsIgnoreCase("recklessness")){
              crimeType="Manslaughter";
          }
          else{
              crimeType="Not a murder";
          }
        }
        else if(keyword.equalsIgnoreCase("hit")||keyword.equalsIgnoreCase("kicked")||keyword.equalsIgnoreCase("")){
            
        }   
    }
    public String printInfo(){
        return "";
    }
    
}