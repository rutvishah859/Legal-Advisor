package legaladvisor;

public class Family extends Civil {
    
    private boolean marriage;
    private boolean child;
    private int numChild;
    //                                0        1        2
    private String custodyType[] = {"full", "joint", "split"};
    private boolean childDecision;
    private boolean parentDecision;
    
    private String abuseType;
    //                                        0           1         2
    private String abuseViolenceType[] = {"emotional","physical","sexual"};
    public Family(String rem, String jur, String tC, boolean mar, boolean child) {
        super(rem, jur, tC);
        this.marriage = mar;
        this.child = child;
    }
    public void setCustody(String keyword){
        String sentence;
        if(super.SearchMechanism(keyword, super.getFamKeyword(), 0)){  
            if((this.marriage == true) && (this.child == true)){
                if((keyword.equalsIgnoreCase(super.getFamKeyword()[10]) || keyword.equalsIgnoreCase(super.getFamKeyword()[5]))){
                    sentence = "If both parents disagree to live together, this will be full custody means only one parent has the right to make all decision about the child";  
                }else if(keyword.equalsIgnoreCase(super.getFamKeyword()[0]) || keyword.equalsIgnoreCase(super.getFamKeyword()[6])){
                     sentence = "This is a joint custody means both parents have to share equal responsibility for child's wellfare."
                    +  "The major decisions will be decided by both parents.";
                }else if(this.numChild > 2){
                    if(this.childDecision == true){
                        sentence = "The child decision might affect whether this will be a split custody. The judge might take into consideration.";
                    }else{
                        sentence = "This is a split custody";
                    }
                }
           }
           if(keyword.equalsIgnoreCase(super.getFamKeyword()[9]) || keyword.equalsIgnoreCase(super.getFamKeyword()[0]) || keyword.equalsIgnoreCase(super.getFamKeyword()[7])
              || keyword.equalsIgnoreCase(super.getFamKeyword()[11]) || keyword.equalsIgnoreCase(super.getFamKeyword()[13])){
           //if keyword equals to "mistreatment", "abuse", "emotion", "sexual", "physical"
              sentence = "This is a Family Violence case."; 
           }
        }
    }
    
    public boolean getMarriage() {
        return marriage;
    }
   public void setFamilyViolenceType(String keyword){
       String sentence;
       //the Family Violence only sets for the marriage couple that do not have child/children
       //This is an adult violence
       if((this.marriage == true) && (this.child == false)){    
             if(keyword.equalsIgnoreCase(super.getFamKeyword()[0])){
                if(super.SearchMechanism(keyword, super.getEmotionalAbuse(), 0)){
                abuseType = abuseViolenceType[0];
                sentence = "This is a Family Violence case and you have suffered emotional abuse";
                }else if(super.SearchMechanism(keyword, super.getPhysicalAbuse(), 0)){
                abuseType = abuseViolenceType[1];   
                sentence = "This is a Family Violence case and you have suffered physical abuse";
                }else if(super.SearchMechanism(keyword, super.getSexualAbuse(), 0)){
                abuseType = abuseViolenceType[2];
                sentence = "This is a Family Violence case and you have suffered sexual abuse";
                }
            }
       }
   }

    public void setMarriage(boolean marriage) {
        this.marriage = marriage;
    }

    public boolean getChild() {
        return child;
    }
    //it will return true if the marriage couple has child, return false if they don't have child
    public void setChild(boolean child) {
        this.child = child;
    }
     
    public boolean getChildDecision(){
        return this.childDecision;
    }
    //if the child choose to decide whose parents they want to live with, it will be false
    //if the child does not want to choose and let parents to decide, it will return true
    public void setChildDecision(boolean dec){
        this.childDecision = dec;
    }
    
    public boolean getParentDeicision(){
        return this.parentDecision;
    }
    
    public void setParentDecision(String keyword){
        if(keyword.equalsIgnoreCase(super.getFamKeyword()[5])){    //if keyword equals to "disagree"
            this.parentDecision = false;    //then parent choose to resolve this in court
        }else{
            this.parentDecision = true;
        }
    }

    @Override
    String printInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
