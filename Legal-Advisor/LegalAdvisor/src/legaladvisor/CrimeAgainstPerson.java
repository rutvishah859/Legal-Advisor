package legaladvisor;

import java.util.ArrayList;

public class CrimeAgainstPerson extends CriminalCase{
    
    private boolean moment;
    private String typeOfOffence;
    private String mensRea; //the intention or knowledge of wrong doing that make people commit a crime or cause a crime to be committed  
    private ArrayList <String> crimeType;
    private boolean weapon;

    public CrimeAgainstPerson( String rem, String jur , String crim, String sen, String tOO){
            super(rem, jur, crim, sen);
            mensRea = "";
            typeOfOffence=tOO;
            crimeType = new ArrayList<>();
    }
    public String getTypeOfOffence() {
        return typeOfOffence;
    }
    public void setCrimeTypeAndSentence(String keyword){
        //if the keyword equals to one of the words in murkeywords array
        if(super.SearchMechanism(keyword, super.getMurderkeywords(),0)){
            //if the criminal has motive, intent, knowledge to commit the crime
            if((this.mensRea).equalsIgnoreCase("motive,intent,knowledge")) {
                this.setTypeOfOffence("indictable"); //the offence is indictable because this is a serious crime  
                this.crimeType.add(super.getCrimeTypes2()[0]);  //this crime will be First Degree Murder
                super.setSentence("The maximum sentence is life in jail");
            }//if the criminal has one or two of these (motive intent, knowledge) to commit the crime
            else if(mensRea.equalsIgnoreCase("motive")||mensRea.equalsIgnoreCase("intent")||mensRea.equalsIgnoreCase("knowledge")){
                this.setTypeOfOffence("indictable");    //the offence is indictable
                this.crimeType.add (super.getCrimeTypes2()[1]);//this crime will be Second Degree Murder
                super.setSentence("The maximum sentence is life in jail with possibility for parole after 10 years");
            }//if 
            else if(mensRea.equalsIgnoreCase("criminal negligence")||mensRea.equalsIgnoreCase("recklessness")||mensRea.equalsIgnoreCase("willful blindness")){
                this.setTypeOfOffence("indictable");
                this.crimeType.add (super.getCrimeTypes2()[2]);
                super.setSentence("The minimum sentence is 4-7 years in jail");
            }
            else{
                crimeType.add("Not murder");
            }
        }
        if(super.SearchMechanism(keyword,super.getAssaultkeywords(),0)){
            this.setTypeOfOffence("indictable");
            if(keyword.equalsIgnoreCase(super.getAssaultkeywords()[5])){
                this.crimeType.add (super.getCrimeTypes2()[6]);
                super.setSentence("The maximum sentence is 10 years in jail");
                
            }
            else if(keyword.equalsIgnoreCase(super.getAssaultkeywords()[8])){
                this.crimeType.add (super.getCrimeTypes2()[5]);
                super.setSentence("The maximum sentence is life in jail");
            }
            else if(isWeapon()==true){
                this.crimeType.add (super.getCrimeTypes2()[4]);
                super.setSentence("The maximum sentence is 14 years in jail");
            }
            else{
                this.crimeType.add (super.getCrimeTypes2()[3]);
                super.setSentence("The maximum sentence is 10 years in jail");
            }
        }
    }
    public void setMensRea(String keyword){
        if(super.SearchMechanism(keyword,super.getMensReaTypes(),0)){   //if the keyword equals to the word in mens rea array
            //if the criminal is "planned" or "intended" about his crime
            if(keyword.equalsIgnoreCase(super.getMensReaTypes()[6])||keyword.equalsIgnoreCase(super.getMensReaTypes()[7])){
                mensRea="motive,intent,knowledge";
            }
            //if the criminal is "reckless" or "risky" about his crime
            else if(keyword.equalsIgnoreCase(super.getMensReaTypes()[3])||keyword.equalsIgnoreCase(super.getMensReaTypes()[4])){
                mensRea="recklessness";
            }
            //if the criminal "ignored" about his crime
            else if(keyword.equalsIgnoreCase(super.getMensReaTypes()[5])){
                mensRea="willful blindness";
            }
            //if the criminal "did not know" about his crime
            else if(keyword.equalsIgnoreCase(super.getMensReaTypes()[8])){
                mensRea="criminal negligence";
            }
            else{
                mensRea="none";
            }
        }
    }    
    public String printInfo(){
        return "Type of Offense: " + this.getTypeOfOffence() + "\nMens Rea" + this.getMensRea() + "\nCrime Type: " + this.getCrimeType(); 
    }
    public void setTypeOfOffence(String typeOfOffence) {
        this.typeOfOffence = typeOfOffence;
    }
    public ArrayList <String> getCrimeType() {
        return crimeType;
    }
    public boolean isWeapon() {         
        return weapon;
    }
    public void setWeapon(boolean weapon) {//set true if the criminal has weapon, false if he/she doesn't have

        this.weapon = weapon;
    }
    public String getMensRea(){
        return mensRea;
    }
    
}
