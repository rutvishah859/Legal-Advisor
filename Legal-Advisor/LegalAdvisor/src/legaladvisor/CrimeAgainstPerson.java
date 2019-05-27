package legaladvisor;

public class CrimeAgainstPerson extends CriminalCase{
    
    private boolean moment;
    private String typeOfOffence;
    private String mensRea;
    private String crimeType;
    private boolean weapon;
    private String mensReaTypes[]={"accident","did not intend","did not mean to","reckless","risky","ignored","planned","intended","did not know","out of nowhere"};
    private String crimeTypes[]={"First Degree Murder","Second Degree Murder","Manslaughter","Physical Assault","Aggravated Assault","Sexual Assault","Verbal Assault"};
    private String murderkeywords []={"assissinated","executed","finished off","kill","killed"};
    private String assaultkeywords[]={"attacked","beat up","hit","hurt","insulted","kicked","punched","raped"};
    public CrimeAgainstPerson( String rem, String typ, String jur , String crim, String sen, String tOO){
            super(rem, typ, jur, crim, sen);
            this.typeOfOffence = this.setTypeOfOffence();
        
    }
    public String getTypeOfOffence() {
        return typeOfOffence;
    }
    public void setCrimeTypeAndSentence(String keyword){
        String sentence;
        if(SearchMechanism(keyword,murderkeywords,0)==true){
        if(mensRea.equalsIgnoreCase("motive,intent,knowledge")){
            crimeType=crimeTypes[0];
            sentence="The maximum sentence is life in jail";
            super.setSentence(sentence);
        }
        else if(mensRea.equalsIgnoreCase("motive")||mensRea.equalsIgnoreCase("intent")||mensRea.equalsIgnoreCase("knowledge")){
            crimeType=crimeTypes[1];
            sentence="The maximum sentence is life in jail with possibility for parole after 10 years";
            super.setSentence(sentence);
        }
        else if(mensRea.equalsIgnoreCase("criminal negligence")||mensRea.equalsIgnoreCase("recklessness")||mensRea.equalsIgnoreCase("willful blindness")){
            crimeType=crimeTypes[2];
            sentence="The minimum sentence is 4-7 years in jail";
            super.setSentence(sentence);
        }
        else{
            crimeType="Not murder";
        }
        }
        if(SearchMechanism(keyword,assaultkeywords,0)==true){
            if(keyword.equalsIgnoreCase(assaultkeywords[4])){
                crimeType=crimeTypes[6];
                sentence="The maximum sentence is 10 years in jail";
                super.setSentence(sentence);
            }
            else if(keyword.equalsIgnoreCase(assaultkeywords[7])){
                crimeType=crimeTypes[5];
                sentence="The maximum sentence is life in jail";
                super.setSentence(sentence);
            }
            else if(weapon==true){
                crimeType=crimeTypes[4];
                sentence="The maximum sentence is 14 years in jail";
                super.setSentence(sentence);
            }
            else{
                crimeType=crimeTypes[3];
                sentence="The maximum sentence is 10 years in jail";
                super.setSentence(sentence);
            }
        }
        else{
            crimeType="Not a crime against a person";
        }
    }
    public void setMensRea(String keyword){
        if(SearchMechanism(keyword,mensReaTypes,0)==true){
            if(keyword.equalsIgnoreCase(mensReaTypes[6])||keyword.equalsIgnoreCase(mensReaTypes[7])){
                mensRea="motive,intent,knowledge";
            }
            else if(keyword.equalsIgnoreCase(mensReaTypes[3])||keyword.equalsIgnoreCase(mensReaTypes[4])){
                mensRea="recklessness";
            }
            else if(keyword.equalsIgnoreCase(mensReaTypes[5])){
                mensRea="willful blindness";
            }
            else if(keyword.equalsIgnoreCase(mensReaTypes[8])){
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
    public boolean SearchMechanism(String keyword, String a[],int n){
        if(a[n].equalsIgnoreCase(keyword)){
            return true;
        }
        else{
            return SearchMechanism(keyword,a,n+1);
        }
    }
    
}
