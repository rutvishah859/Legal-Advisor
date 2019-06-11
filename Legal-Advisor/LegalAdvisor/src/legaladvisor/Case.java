/*
The Case Abstract Class contains multiple type of cases which inhherites the Case class 
The class contains all of the key words for all the classes, and sub classes of those classes
*/

package legaladvisor; 
import java.util.*; 

    public /*abstract*/ class Case {

    private String remedies;
    private ArrayList <String> type = new ArrayList <String> ();
    private String jurisdiction;
    private boolean trialNeeded;
    private int indexforSearchMechanism;
    //MoneyCrime keywords
    private String crimeTypes1 [] = {"fraud", "robbery", "money laundering", "theft"};
    private String fraud [] = {"transferred", "funds", "investment", "bank","computer", "app", "phone", "online", "banking"};    
    private String electronicCrime [] = {"computer", "app", "phone", "online",  "banking"};
    private String moneyLaundering [] = {"fake", "money"}; 
    private String theft [] = {"stole", "took",  "own"}; 
    private String robbery [] = {"forced","stole","broke","threatened","forcefully stole"}; 
    //CrimeAgainstPerson keywords 
    private String mensReaTypes[]={"accident","unintended","did not mean to","reckless","risky","ignored","planned","intended","did not know","out of nowhere"};
    private String crimeTypes2[]={"First Degree Murder","Second Degree Murder","Manslaughter","Physical Assault","Aggravated Assault","Sexual Assault","Verbal Assault"};
    private String murderkeywords []={"assissinated","executed","finished","kill","killed"};
    private String assaultkeywords[]={"assaulted","attacked","beat","hit","hurt","insulted","kicked","punched","raped"};
    //OHRC keywords                     0        1      2       3         4         5          6          7      8        9     10      11     12    13     14           15           16         17          18       19         20        21      22            23       24           25           26             27      28     29       30    31        32      33    34
    private String groundKeywords[]={"black","white","asian","muslim","jewish","christian","buddhist","hindu","female","male","man","woman","girl","boy","pregnancy","citizenship","culture","disabled","mental","physical","disability","gay","homosexual","lesbian","bisexual","transgender","heterosexual","married","kids","children","kid","child","young", "old","wellfare"};
    
    
    //                               0      1       2         3         4       5       6         7       8         9           10          11            12        13      14        15                                
    private String areaKeywords[]={"rent","house","work","employment","hired","fired","member","group","union","hospital","restaurant","movie theater","school","service","place","contract"};
    

    //Charter keywords        0           1        2           3         4       5         6             7          8       9           10         11      12      13    14            15    16     17      18      19       20          21       22     23     24       25     26        27        28        29      30          31         32      33         34       35          36       37     38      38      39      40         41     42         43            44         45                 46           47                                                                   
    private String issues[]={"muslim","jewish","christian","buddhist","hindu","speech","expression","associate","group","non-violent","protest","vote","election","5","parliament","meeting","1","once","travel","Canada","within","throughout","into","out","safety","life","privacy","search","seizure","arrest","detention","arrest","reasons","lawyer","attorney","release","offence","trial","time","guilty","bail","sentence","cruel","unusual","punishment","witness","self-incriminated","interpreter","unequal"};
    //DrugCrime keywords 
    private String[] traffickingTerm = {"administer", "deliver", "give", "obtain","sell", "send", "transfer", "transport"};
    private String [] drugType= {"amphetamines","cannabis","cocaine", "hallucionogens", "hashish","heroine","LSD", "marijuana", "methamphetamine","opiums","steroids"};
    ///Jurisdiction keywords
    private String jurisdictions[]={"Ontario","Canada"};
    //Family keywords
    private String famKeyword[] = {"abuse","aggreement","child", "custody", "decision","disagree", "divorce", "emotional","marry","mistreatment","permanent", "physical","share", "sexual"};
    private String emotionalAbuse [] = {"hurting","insults","intimadation", "fun","threats", "yelling"};
    private String sexualAbuse[] = {"harrassment","touching","unsafe","without consent"};
    private String physicalAbuse[] = {"burning", "choking", "cutting","hitting","locking","pinching","punching","pushing","slapping","throwing","objects"};
    //Contract keywords
    private String contractWord []= {"agree","break","buy","car","compensate","condition","contract","disagree","failing","goods", "house","illness","make", "mental","negotiate","offer", "pay","purchase","request"};
    private String unlawfulPurpose[] = {"betting", "drugs", "firearm","gambling", "gaming", "kill","prostitution", "prositute"}; //the contract must have lawful objective or purpose

    public Case(String rem, String jur){
        this.remedies = rem;
        this.jurisdiction = jur;
    }
    //This sets the remedies for the crime for the victim
    public void setRemedies(String rem){
        this.remedies = rem;
    }
    public void setType(String typ){
        boolean check = false;
        for(int i = 0; i < type.size(); i++){
            if (type.get(i).equals(typ)){
                check = true;
            }
        }
        if(!check){
            this.type.add(typ);
        }
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
    public ArrayList <String> getType(){
        return this.type;
    }
    public boolean getTrialNeeded(){
        return this.trialNeeded;
    }
    public String getJurisdiction(){
        return this.jurisdiction;
    }
    //printInfo is an abstract method which is set by the child/grandchild classes which prints all the info about the case plus the sentance
    //abstract String printInfo();   
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

    public String[] getTraffickingTerm() {
        return traffickingTerm;
    }

    public String[] getDrugType() {
        return drugType;
    }
    public String[] getIssues(){
        return issues;
    }
    public String[] getJusrisdictions(){
        return jurisdictions;
    }

    public String[] getFamKeyword() {
        return famKeyword;
    }

    public String[] getContractWord() {
        return contractWord;
    }

    public String[] getUnlawfulPurpose() {
        return unlawfulPurpose;
    }

    public String[] getEmotionalAbuse() {
        return emotionalAbuse;
    }

    public String[] getSexualAbuse() {
        return sexualAbuse;
    }

    public String[] getPhysicalAbuse() {
        return physicalAbuse;
    }

}