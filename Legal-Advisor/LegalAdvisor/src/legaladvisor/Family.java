package legaladvisor;

public class Family extends Civil {
    
    private boolean marriage;
    private boolean divorce;
    private boolean child;
    private int numChild;
    //                                0        1        2         3
    private String custodyType[] = {"full", "joint", "shared", "split"};
    private boolean childDecision;
    private boolean parentDecision;
    //                               0          1         2         3           4           5         6            7        8           9             10          11       12        13
    private String famKeyword[] = {"abuse","aggreement","child", "custody", "decision","disagree", "divorce", "emotional","marry","mistreatment","permanent", "physical","share", "sexual"};
    private String custType;
    //                                     0         1            2           3      4           5
    private String emotionalAbuse [] = {"hurting","insults","intimadation", "fun","threats", "yelling"};
    //                                  0             1         2             3
    private String sexualAbuse[] = {"harrassment","touching","unsafe","without consent"};
    //                                   0          1          2         3         4          5          6          7         8         9           10   
    private String physicalAbuse[] = {"burning", "choking", "cutting","hitting","locking","pinching","punching","pushing","slapping","throwing","objects"};
    private String abuseType;
    //                                        0           1         2
    private String abuseViolenceType[] = {"emotional","physical","sexual"};
    public Family(String rem, String jur, String tC, boolean mar, boolean div, boolean child) {
        super(rem, jur, tC);
        this.marriage = mar;
        this.divorce = div;
        this.child = child;
    }
    public void setCustody(String keyword){
        String sentence;
        if(super.SearchMechanism(keyword, famKeyword, 0)){
            if((this.marriage == true) && (this.child == true)){
                if((keyword.equalsIgnoreCase(famKeyword[10]) || keyword.equalsIgnoreCase(famKeyword[5]))){
                    sentence = "If both parents disagree to live together, this will be full custody means only one parent has the right to make all decision about the child";
                    custType = custodyType[0];  //full custody
                    this.divorce = true;
                }else if(keyword.equalsIgnoreCase(famKeyword[0]) || keyword.equalsIgnoreCase(famKeyword[6])){
                     sentence = "This is a joint custody means both parents have to share equal responsibility for child's wellfare."
                    +  "The major decisions will be decided by both parents.";
                custType = custodyType[1];  //joint custody
                }else if(this.numChild > 2){
                    if(this.childDecision == true){
                        sentence = "The child decision might affect whether this will be a split custody. The judge might take into consideration.";
                    }else{
                        custType = custodyType[3];  //split custody
                    }
                }
           }
           if(keyword.equalsIgnoreCase(famKeyword[9]) || keyword.equalsIgnoreCase(famKeyword[0]) || keyword.equalsIgnoreCase(famKeyword[9]) || keyword.equalsIgnoreCase(famKeyword[7])
              || keyword.equalsIgnoreCase(famKeyword[11]) || keyword.equalsIgnoreCase(famKeyword[13])){
              sentence = "This is a Family Violence case."; 
           }
        }
    }
    
    
    
    public void custType(String keyword){
        
    }
    public boolean isMarriage() {
        return marriage;
    }
   public void setFamilyViolenceType(String keyword){
       String sentence;
       if(super.SearchMechanism(keyword, famKeyword, 0)){
             if(keyword.equalsIgnoreCase(famKeyword[0])){
                if(super.SearchMechanism(keyword, emotionalAbuse, 0)){
                abuseType = abuseViolenceType[0];
                sentence = "This is a Family Violence case and you have suffered emotional abuse";
                }else if(super.SearchMechanism(keyword, physicalAbuse, 0)){
                abuseType = abuseViolenceType[1];   
                sentence = "This is a Family Violence case and you have suffered physical abuse";
                }else if(super.SearchMechanism(keyword, sexualAbuse, 0)){
                abuseType = abuseViolenceType[2];
                sentence = "This is a Family Violence case and you have suffered sexual abuse";
                }
            }
       }
   }

    public void setMarriage(boolean marriage) {
        this.marriage = marriage;
    }
    
    public boolean isDivorce() {
        return divorce;
    }

    public void setDivorce(boolean divorce) {
        this.divorce = divorce;
    }

    public boolean isChild() {
        return child;
    }

    public void setChild(boolean child) {
        this.child = child;
    }
    
    public boolean getChildDecision(){
        return this.childDecision;
    }
    
    public void setChildDecision(boolean dec){
        this.childDecision = dec;
    }
    
    public boolean getParentDeicision(){
        return this.parentDecision;
    }
    
    public void setParentDecision(String keyword){
        if(keyword.equalsIgnoreCase("no")){
            this.parentDecision = false;
        }else{
            this.parentDecision = true;
        }
    }
    
    
}
