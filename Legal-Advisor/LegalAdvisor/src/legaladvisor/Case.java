package legaladvisor; 

    public abstract class Case {

    private String remedies;
    private String type;
    private String jurisdiction;
    private boolean trialNeeded;
    private int indexforSearchMechanism;
    //MoneyCrime keywords
    private String crimeTypes1 [] = {"fraud", "robbery", "money laundering", "theft"};
    private String fraud [] = {"transfered funds", "investment", "bank","computer", "app", "phone", "online banking"};    
    private String electronicCrime [] = {"computer", "app", "phone", "online banking"};
    private String moneyLaundering [] = {"fake money"}; 
    private String theft [] = {"stole", "took", "does not own"}; 
    private String robbery [] = {"forced","stole","broke in","threatened","forcefully stole"}; 
    //CrimeAgainstPerson keywords 
    private String mensReaTypes[]={"accident","did not intend","did not mean to","reckless","risky","ignored","planned","intended","did not know","out of nowhere"};
    private String crimeTypes2[]={"First Degree Murder","Second Degree Murder","Manslaughter","Physical Assault","Aggravated Assault","Sexual Assault","Verbal Assault"};
    private String murderkeywords []={"assissinated","executed","finished off","kill","killed"};
    private String assaultkeywords[]={"attacked","beat up","hit","hurt","insulted","kicked","punched","raped"};
    //OHRC keywords
    private String groundKeywords[]={"black","white","asian","muslim","jewish","christian","buddhist","hindu","female","male","man","woman","girl","boy","pregnancy","citizenship","culture","disabled","mental disability","physical disability","gay","homosexual","lesbian","bisexual","transgender","heterosexual","married","not married","kids","no kids","too young","too old","wellfare"};
    private String areaKeywords[]={"rent","house","work","employment","hired","fired","member","group","union","hospital","restaurant","movie theater","school","service","place","contract"};
    //Charter keywords
    private String issues[]={"muslim","jewish","christian","buddhist","hindu","speech","expression","associate","group","non-violent protest","vote","election","parliament meeting","5","travel","into Canada","within Canada","out of Canada","safety","life","privacy","arrest","search","seizure","arrest","detention"};
    public Case(String rem, String typ, String jur){
        this.remedies = rem;
        this.type = typ;
        this.jurisdiction = jur;
    }
    //This sets the remedies for the crime for the victim
    public void setRemedies(String rem){
        this.remedies = rem;
    }
    public void setType(String typ){
        this.type = typ;
    }
    public void setTrialNeeded(boolean tn){
        this.trialNeeded = tn;
    }
    public void setJurisdiction(String jur){
        this.jurisdiction = jur;
    }
    public String getRemedies(){
        return this.remedies;
    }
    public String getType(){
        return this.type;
    }
    public boolean getTrialNeeded(){
        return this.trialNeeded;
    }
    public String getJurisdiction(){
        return this.jurisdiction;
    }
    abstract String printInfo();   
    public boolean SearchMechanism(String keyword, String a[],int n){
        if(a[n].equalsIgnoreCase(keyword)){
            this.setIndexforSearchMechanism(n);
            return true;
        }
        else if(n<a.length-1){
            return SearchMechanism(keyword,a,n+1);
        }
        else{
            return false;
        } 
    }
    public void setIndexforSearchMechanism(int indexforSearchMechanism) {
        this.indexforSearchMechanism = indexforSearchMechanism;
    }
    public int getISM() {
        return indexforSearchMechanism;
    }

    public String[] getCrimeTypes1() {
        return crimeTypes1;
    }

    public String[] getFraud() {
        return fraud;
    }

    public String[] getElectronicCrime() {
        return electronicCrime;
    }

    public String[] getMoneyLaundering() {
        return moneyLaundering;
    }

    public String[] getTheft() {
        return theft;
    }

    public String[] getRobbery() {
        return robbery;
    }
    
    public String[] getMensReaTypes() {
        return mensReaTypes;
    }

    public String[] getCrimeTypes2() {
        return crimeTypes2;
    }

    public String[] getMurderkeywords() {
        return murderkeywords;
    }

    public String[] getAssaultkeywords() {
        return assaultkeywords;
    }

    public String[] getGroundKeywords() {
        return groundKeywords;
    }

    public String[] getAreaKeywords() {
        return areaKeywords;
    }
}