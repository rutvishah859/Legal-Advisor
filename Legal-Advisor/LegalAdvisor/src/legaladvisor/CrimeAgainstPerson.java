package legaladvisor;

public class CrimeAgainstPerson extends CriminalCase{
    
    private boolean moment;
    private String typeOfOffence;
    private String mensRea;
    private String crimeType;
    private boolean weapon;

    public CrimeAgainstPerson( String rem, String jur , String crim, String sen, String tOO){
            super(rem, jur, crim, sen);
            typeOfOffence=tOO;    
    }
    public String getTypeOfOffence() {
        return typeOfOffence;
    }
    public void setCrimeTypeAndSentence(String keyword){
        if(super.SearchMechanism(keyword, super.getMurderkeywords(),0)==true){
            if(mensRea.equalsIgnoreCase("motive,intent,knowledge")){
                this.setTypeOfOffence("indictable");
                crimeType= super.getCrimeTypes2()[0];
                super.setSentence("The maximum sentence is life in jail");
            }
            else if(mensRea.equalsIgnoreCase("motive")||mensRea.equalsIgnoreCase("intent")||mensRea.equalsIgnoreCase("knowledge")){
                this.setTypeOfOffence("indictable");
                crimeType= super.getCrimeTypes2()[1];
                super.setSentence("The maximum sentence is life in jail with possibility for parole after 10 years");
            }
            else if(mensRea.equalsIgnoreCase("criminal negligence")||mensRea.equalsIgnoreCase("recklessness")||mensRea.equalsIgnoreCase("willful blindness")){
                this.setTypeOfOffence("indictable");
                crimeType= super.getCrimeTypes2()[2];
                super.setSentence("The minimum sentence is 4-7 years in jail");
            }
            else{
                crimeType="Not murder";
            }
        }
        if(super.SearchMechanism(keyword,super.getAssaultkeywords(),0)==true){
            this.setTypeOfOffence("indictable");
            if(keyword.equalsIgnoreCase(super.getAssaultkeywords()[4])){
                crimeType= super.getCrimeTypes2()[6];
                super.setSentence("The maximum sentence is 10 years in jail");
                
            }
            else if(keyword.equalsIgnoreCase(super.getAssaultkeywords()[7])){
                crimeType= super.getCrimeTypes2()[5];
                super.setSentence("The maximum sentence is life in jail");
            }
            else if(isWeapon()==true){
                crimeType= super.getCrimeTypes2()[4];
                super.setSentence("The maximum sentence is 14 years in jail");
            }
            else{
                crimeType= super.getCrimeTypes2()[3];
                super.setSentence("The maximum sentence is 10 years in jail");
            }
        }
    }
    public void setMensRea(String keyword){
        if(super.SearchMechanism(keyword,super.getMensReaTypes(),0)==true){
            if(keyword.equalsIgnoreCase(super.getMensReaTypes()[6])||keyword.equalsIgnoreCase(super.getMensReaTypes()[7])){
                mensRea="motive,intent,knowledge";
            }
            else if(keyword.equalsIgnoreCase(super.getMensReaTypes()[3])||keyword.equalsIgnoreCase(super.getMensReaTypes()[4])){
                mensRea="recklessness";
            }
            else if(keyword.equalsIgnoreCase(super.getMensReaTypes()[5])){
                mensRea="willful blindness";
            }
            else if(keyword.equalsIgnoreCase(super.getMensReaTypes()[8])){
                mensRea="criminal negligence";
            }
            else{
                mensRea="none";
            }
        }
    }    
    public String printInfo(){
        return "";
    }
    public void setTypeOfOffence(String typeOfOffence) {
        this.typeOfOffence = typeOfOffence;
    }
    public String getCrimeType() {
        return crimeType;
    }
    public boolean isWeapon() {
        return weapon;
    }
    public void setWeapon(boolean weapon) {
        this.weapon = weapon;
    }
    public String getMensRea(){
        return mensRea;
    }
    
}
