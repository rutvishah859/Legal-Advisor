package legaladvisor; 

    public abstract class Case {
    
    private String remedies;
    private String type;
    private String jurisdiction;
    private boolean trialNeeded;
    private int indexforSearchMechanism;
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
    public int getIndexforSearchMechanism() {
        return indexforSearchMechanism;
    }
    
}