package legaladvisor; 

    public abstract class Case {
    
    private String remedies;
    private String type;
    private String jurisdiction;
    private boolean trialNeeded;
    private int indexforSearchMechanism;
    //MoneyCrime key words
    private String crimeTypes [] = {"fraud", "robbery", "money laundering", "theft"};
    private String fraud [] = {"transfered funds", "investment", "bank","computer", "app", "phone", "online banking"};    
    private String electronicCrime [] = {"computer", "app", "phone", "online banking"};
    private String moneyLaundering [] = {"fake money"}; 
    private String theft [] = {"stole", "took", "does not own"}; 
    private String robbery [] = {"forced","stole","broke in","threatened","forcefully stole"}; 
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

    /**
     * @return the crimeTypes
     */
    public String[] getCrimeTypes() {
        return crimeTypes;
    }

    /**
     * @return the fraud
     */
    public String[] getFraud() {
        return fraud;
    }

    /**
     * @return the electronicCrime
     */
    public String[] getElectronicCrime() {
        return electronicCrime;
    }

    /**
     * @return the moneyLaundering
     */
    public String[] getMoneyLaundering() {
        return moneyLaundering;
    }

    /**
     * @return the theft
     */
    public String[] getTheft() {
        return theft;
    }

    /**
     * @return the robbery
     */
    public String[] getRobbery() {
        return robbery;
    }
    
    
}