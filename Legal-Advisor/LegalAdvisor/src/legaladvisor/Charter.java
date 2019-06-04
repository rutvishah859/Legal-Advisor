package legaladvisor;

public class Charter extends HumanRights {
    private String right;    
    public Charter(String rem, String typ, String jur, String r) {
        super(rem, typ, jur);
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
            else if(this.getISM()==9){
                this.right="Section 2 c):Freedom of peaceful assembly.";
            }
            else if(this.getISM()==10){
                this.right="Section 3: Democratic rights";
            }
            else if(this.getISM()==11||this.getISM()==12){
                this.right="Section 4:Democratic rights";
            }
            else if(this.getISM()>=13&&this.getISM()<16){
                this.right="Section 5: Democratic rights";
            }
            else if(this.getISM()>=16&&this.getISM()<20){
                this.right="Section 6: Mobility Rights";
            }
            else if(this.getISM()>=20&&this.getISM()<23){
                this.right="Section 7: Life, Liberty, Security.";
                super.setRemedies("Remedies are: Stay of proceedings, Reading in a term, Reading Down a term, Striking down a law, Excluding evidence in trial,Monetary Compensation");
            }
            else if(this.getISM()>=23&&this.getISM()<25){
                this.right="Section 8: Unreasonable Search and Seizure";
                super.setRemedies("Remedies are: Stay of proceedings, Reading in a term, Reading Down a term, Striking down a law, Excluding evidence in trial,Monetary Compensation");
            }
            else if(this.getISM()>=25&&this.getISM()<32){
                this.right="Section 9 and 10: Arrest and Detention Rights";
                super.setRemedies("Remedies are: Stay of proceedings, Reading in a term, Reading Down a term, Striking down a law, Excluding evidence in trial,Monetary Compensation");
            }
            else if(this.getISM()>=32&&this.getISM()<38){
                this.right="Section 11: Proceedings in Criminal and Penal matters.";
                super.setRemedies("Remedies are: Stay of proceedings, Reading in a term, Reading Down a term, Striking down a law, Excluding evidence in trial,Monetary Compensation");
            }
            else if(this.getISM()>=38&&this.getISM()<41){
                this.right="Section 12: Cruel and Unusual Punishment";
                super.setRemedies("Remedies are: Stay of proceedings, Reading in a term, Reading Down a term, Striking down a law, Excluding evidence in trial,Monetary Compensation");
            }
            else if(this.getISM()>=41&&this.getISM()<43){
                this.right="Section 13: Witness Rights";
                super.setRemedies("Remedies are: Stay of proceedings, Reading in a term, Reading Down a term, Striking down a law, Excluding evidence in trial,Monetary Compensation");
            }
            else if(this.getISM()==43){
                this.right="Section 14: Right to interpreter";
                super.setRemedies("Remedies are: Stay of proceedings, Reading in a term, Reading Down a term, Striking down a law, Excluding evidence in trial,Monetary Compensation");
            }
            else if(this.getISM()==44){
                this.right="Section 15: Equality Rights";
            }
        }
    }
    
    String printInfo() {
        return null;
        
    }
    
}
