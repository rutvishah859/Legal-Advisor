package legaladvisor;

public class Charter extends HumanRights {
    private String right;    
    public Charter(String rem, String jur, String r) {
        super(rem, jur);
        this.right = r; 
    }

    public String getRight() {
        return right;
    }

    public void setRight(String keyword) {
        if(super.SearchMechanism(keyword,getIssues(), 0)==true){
            if(this.getISM()>=0&&this.getISM()<5){
                this.right="Section 2a): Freedom of Religion";
            }
            else if(this.getISM()==5||this.getISM()==6){
                this.right="Section 2b): Freedom of Expression";
            }
            else if(this.getISM()==7||this.getISM()==8){
                this.right="Section 2 d): Freedom of Association";
            }
            else if(this.getISM()==9||this.getISM()==10){
                this.right="Section 2 c):Freedom of peaceful assembly.";
            }
            else if(this.getISM()==11){
                this.right="Section 3: Democratic rights";
            }
            else if(this.getISM()==12||this.getISM()==13){
                this.right="Section 4:Democratic rights";
            }
            else if(this.getISM()>=15&&this.getISM()<18){
                this.right="Section 5: Democratic rights";
            }
            else if(this.getISM()>=18&&this.getISM()<24){
                this.right="Section 6: Mobility Rights";
            }
            else if(this.getISM()>=24&&this.getISM()<27){
                this.right="Section 7: Life, Liberty, Security.";
                super.setRemedies("Remedies are: Stay of proceedings, Reading in a term, Reading Down a term, Striking down a law, Excluding evidence in trial,Monetary Compensation");
            }
            else if(this.getISM()>=27&&this.getISM()<29){
                this.right="Section 8: Unreasonable Search and Seizure";
                super.setRemedies("Remedies are: Stay of proceedings, Reading in a term, Reading Down a term, Striking down a law, Excluding evidence in trial,Monetary Compensation");
            }
            else if(this.getISM()>=29&&this.getISM()<36){
                this.right="Section 9 and 10: Arrest and Detention Rights";
                super.setRemedies("Remedies are: Stay of proceedings, Reading in a term, Reading Down a term, Striking down a law, Excluding evidence in trial,Monetary Compensation");
            }
            else if(this.getISM()>=36&&this.getISM()<41){
                this.right="Section 11: Proceedings in Criminal and Penal matters.";
                super.setRemedies("Remedies are: Stay of proceedings, Reading in a term, Reading Down a term, Striking down a law, Excluding evidence in trial,Monetary Compensation");
            }
            else if(this.getISM()>=41&&this.getISM()<44){
                this.right="Section 12: Cruel and Unusual Punishment";
                super.setRemedies("Remedies are: Stay of proceedings, Reading in a term, Reading Down a term, Striking down a law, Excluding evidence in trial,Monetary Compensation");
            }
            else if(this.getISM()>=44&&this.getISM()<46){
                this.right="Section 13: Witness Rights";
                super.setRemedies("Remedies are: Stay of proceedings, Reading in a term, Reading Down a term, Striking down a law, Excluding evidence in trial,Monetary Compensation");
            }
            else if(this.getISM()==46){
                this.right="Section 14: Right to interpreter";
                super.setRemedies("Remedies are: Stay of proceedings, Reading in a term, Reading Down a term, Striking down a law, Excluding evidence in trial,Monetary Compensation");
            }
            else if(this.getISM()==47){
                this.right="Section 15: Equality Rights";
            }
        }
    }
    
    public String printInfo() {
        return super.printInfo()+ ", Right: " + this.getRight();
        
    }
    
}
