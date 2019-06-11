/*
 The CaseChecker class inheriates the Case class, who basically checks that text file searching for keywords setting up objects for those cases 
 for example if the CaseChecker found a murder keyword then it would create a CrimeAgainstPerson object 
 */
package legaladvisor;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
public class caseChecker extends Case{
  private String CaseType; 
  private int agePerson;
  private String [] wordBank; //a bank of key words found in the text file
  private File casef; 
  Scanner input= new Scanner(System.in); 
  public caseChecker(String rem, String jur, File complaint, int age) throws IOException {
    super(rem, jur);
    casef = complaint; 
    agePerson=age;
  }
  
  String readFile() {
    String st = null; 
    String s = ""; 
    try { 
      BufferedReader br =  new BufferedReader (new FileReader (this.casef));
      try {
        while ((st = br.readLine()) != null){
          s += st + " ";
        }
        return s; 
      } catch (IOException ex) {
        Logger.getLogger(caseChecker.class.getName()).log(Level.SEVERE, null, ex);
      }
      
    } catch (FileNotFoundException ex) {
      Logger.getLogger(caseChecker.class.getName()).log(Level.SEVERE, null, ex);
    } 
    return null; 
  } 
  
  //methods that cecks if any of the types cases apply to the this complaint
  //each case type class will call this method to check if any of their clases apply here
  public Case findKeyWords (caseChecker caseFile){
    this.setWordBank(caseFile.readFile().split("\\s"));
    String jurisdiction="";
    String word = ""; 
    Case c1 = new Case ("", "");
    for(String w : this.getWordBank()){ 
      word = w; 
      if(super.SearchMechanism(w, super.getJusrisdictions(), 0)){
        if(this.getISM()==0){
          jurisdiction="Ontario";
        }
        else{
          jurisdiction="Canada";
        }
      }
      if (super.SearchMechanism(w, super.getFraud(), 0)){
        super.setType ("Criminal Case");
        MoneyCrimes fraud= new MoneyCrimes ("Trial",jurisdiction,"", "", 0.0, true);
        for(int i=0;i<wordBank.length;i++){
          fraud.setCrimeAndSentence(wordBank[i]);
        }
        fraud.setCrime("Money Crime");
        c1=fraud;
        break;
      }
      else if (super.SearchMechanism(w, super.getElectronicCrime(), 0)){
        super.setType ("Criminal Case"); 
        MoneyCrimes electronicCrime = new MoneyCrimes ("Trial",jurisdiction, "", "", 0.0, false);
        for(int i=0;i<wordBank.length;i++){
          electronicCrime.setCrimeAndSentence(wordBank[i]);
        }
        electronicCrime.setCrime("Money Crime");
        c1=electronicCrime;
        break;
      }
      else if (super.SearchMechanism(w, super.getMoneyLaundering(), 0)){
        super.setType("Criminal Case");
        MoneyCrimes moneyLaundering = new MoneyCrimes ("Trial",jurisdiction, "", "", 0.0, false);
        for(int i=0;i<wordBank.length;i++){
          moneyLaundering.setCrimeAndSentence(wordBank[i]);
        }
        moneyLaundering.setCrime("Money Crime");
        c1=moneyLaundering;
        break;
      }
      else if (super.SearchMechanism(w, super.getTheft(), 0)){
        super.setType("Criminal Case");
        MoneyCrimes theft = new MoneyCrimes ("Trial",jurisdiction, "", "", 0.0, false); 
        for(int i=0;i<wordBank.length;i++){
          theft.setCrimeAndSentence(wordBank[i]);
        }
        theft.setCrime("Money Crime");
        c1=theft;
        break;
      }
      else if (super.SearchMechanism(w, super.getRobbery(), 0)){
        super.setType ("Criminal Case"); 
        MoneyCrimes robbery = new MoneyCrimes ("Trial",jurisdiction, "", "", 0.0, false); 
        for(int i=0;i<wordBank.length;i++){
          robbery.setCrimeAndSentence(w);
        }
        robbery.setCrime("Money Crimes");
        c1=robbery;
        break;
      }
      if (super.SearchMechanism(w, super.getMurderkeywords(), 0)){
        super.setType("Criminal Case");
        CrimeAgainstPerson murder = new CrimeAgainstPerson ("Trial", jurisdiction, "", "", "");
        for(int i=0;i<wordBank.length;i++){
          murder.setMensRea(w);
        }
        for(int i=0;i<wordBank.length;i++){
          murder.setCrimeTypeAndSentence(w);
        }
        murder.setCrime("Crimes against the Person");
        c1=murder;
        break;
      }
      else if (super.SearchMechanism(w, super.getAssaultkeywords(), 0)){
        super.setType("Criminal Case");
        CrimeAgainstPerson assault = new CrimeAgainstPerson ("Trial", jurisdiction, "", "", "");
        assault.setCrime("Crimes against the Person");
        for(int i=0;i<wordBank.length;i++){
          assault.setCrimeTypeAndSentence(wordBank[i]);
        }
        c1=assault;
      }
      if(jurisdiction.equalsIgnoreCase(super.getJusrisdictions()[1])){ //will only be an OHRC case if the jurisdiction is Ontario
        if (super.SearchMechanism(w, super.getGroundKeywords(), 0)||super.SearchMechanism(w, super.getAreaKeywords(), 0)){ 
          super.setType("Human Rights Case");
          OHRC ohrcComplaint = new OHRC ("", "Ontario", "", "");
          for(int i=0;i<wordBank.length;i++){
            ohrcComplaint.setArea(w);
          }
          for(int i=0;i<wordBank.length;i++){
            ohrcComplaint.setGrounds(w);
          }
          ohrcComplaint.setRemedies();
          ohrcComplaint.setCharterOHRC("OHRC Case");
          //c1=ohrcComplaint;
          break;
        }
      }
      
      if(jurisdiction.equalsIgnoreCase("Canada")){ //will only be a Charter case is the jurisdiction is Canada
        if (super.SearchMechanism(w, super.getIssues(), 0)){
          super.setType("Human Rights Case");
          Charter charter = new Charter ("No remedies needed", "Canada", "");
          for(int i=0;i<wordBank.length;i++){
            charter.setRight(w);
          }
          charter.setCharterOHRC("Charter Case");
          c1=charter;
          break;
        }
      }
      if (super.SearchMechanism(w, super.getTraffickingTerm(), 0)){
        double quantity;
        super.setType("Criminal Case");
        DrugCrime trafficking = new DrugCrime ("Trial", jurisdiction, "", "", false, false, "");
        trafficking.setCrime("Drug Crime");
        for(int i=0;i<wordBank.length;i++){
          trafficking.setTrafficking(wordBank[i]);
        }
        System.out.println("Please enter the quanity of drugs in grams:");
        quantity=input.nextDouble();
        trafficking.setQuantity(quantity);
        for(int i=0;i<wordBank.length;i++){
          trafficking.setCrimeTypeAndSentence(wordBank[i]);
        }
        c1=trafficking;
        break;
      }
      
      else if (super.SearchMechanism(w, super.getDrugType(), 0)){
        double quantity;
        super.setType ("Criminal Case"); 
        DrugCrime possession = new DrugCrime ("Trial", jurisdiction, "", "", false, false, "");
        possession.setCrime("Drug Crime");
        System.out.println("Please enter the quanity of drugs in grams:");
        quantity=input.nextDouble();
        possession.setQuantity(quantity);
        for(int i=0;i<wordBank.length;i++){
          possession.setCrimeTypeAndSentence(wordBank[i]);
        }
        c1= possession;
        break;
      }
      else if(super.SearchMechanism(w, super.getFamKeyword(), 0)){
        super.setType("Civil Case");
        Family fam1= new Family("Court or negotiation, mediation or collaborative settlemnets approaches",jurisdiction,"Family Law",false, false);
        for(int i=0;i<wordBank.length;i++){
          if(wordBank[i].equalsIgnoreCase("child")){
            fam1.setChild(true);
          }
          else{
            fam1.setChild(false);
          }
        }
        for(int i=0;i<wordBank.length;i++){
          if(w.equalsIgnoreCase("married")){
            fam1.setMarriage(true);
          }
          else{
            fam1.setMarriage(false);
          }
        }
        int numChildren;
        System.out.println("How many children do you have?");
        numChildren=input.nextInt();
        fam1.setNumChild(numChildren);
        for(int i=0;i<wordBank.length;i++){
          fam1.setCustody(w);
        }
        for(int i=0;i<wordBank.length;i++){
          fam1.setFamilyViolenceType(w);
        }
        c1=fam1;
        break;
      }
      else if(super.SearchMechanism(w, super.getContractWord(), 0)){
        Contract con1= new Contract("",jurisdiction,"Contract Case","",true,agePerson,false,false,false);
        super.setType("Civil Case");
        for(int i=0;i<wordBank.length;i++){
          con1.setLawfulPurpose(wordBank[i]);
        }
        for(int i=0;i<wordBank.length;i++){
          if(w.equalsIgnoreCase("disability")){
            con1.setDisability(true);
          }else{
            con1.setDisability(false);
          }
//                    
        }
        con1.setCapacity(con1.getDisability(), agePerson);
        for(int i=0;i<wordBank.length;i++){
          con1.setFailingToPerform(wordBank[i]);
        }
        for(int i=0;i<wordBank.length;i++){
          con1.setPurpose(wordBank[i]);
        }
        for(int i=0;i<wordBank.length;i++){
          con1.setContract(wordBank[i]);
        }
        for(int i=0;i<wordBank.length;i++){
          con1.setRemedies(wordBank[i]);
        }
        c1=con1;
        break;
      }
    }
    return c1;
  }
  
  public String[] getWordBank() {
    return wordBank;
  }
  
  public void setWordBank(String[] wordBank) {
    this.wordBank = wordBank;
  }
  
  public void setCaseType(String ct) {
    this.CaseType = ct;
  }
  
  public String printInfo () throws IOException{
    File f= new File ("C:\\Users\\Mitesh\\Documents\\GitHub\\Legal-Advisor\\Legal-Advisor\\LegalAdvisor\\src\\legaladvisor\\caseFile.txt");
    BufferedReader br = new BufferedReader(new FileReader(f));
    String line = null;
    while ((line = br.readLine()) != null) {
      line = " " + line;
    }
    return line; 
  }
}

