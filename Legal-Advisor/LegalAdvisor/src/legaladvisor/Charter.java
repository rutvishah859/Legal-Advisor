//Charter protects a number of rights and freedoms

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
    //Based on the keyword the users enter, this method will decide the freedoms, rights and remedies that they suppose to have in Ontario
    public void setRight(String keyword) {
        if(super.SearchMechanism(keyword,getIssues(), 0)==true){    //if keyword equals to any words in 'issues' array
            if(this.getISM()>=0&&this.getISM()<5){                  //if the array index is between 0(includes) and 4
                                                                    //"muslim","jewish","christian","buddhist","hindu"
                this.right="Section 2a): Freedom of Religion";
            }
            else if(this.getISM()==5||this.getISM()==6){            //if the array index equals to 5 or equals to 6
                                                                    //"speech","expression"
                this.right="Section 2b): Freedom of Expression";    
            }
            else if(this.getISM()==7||this.getISM()==8){            //if the array endex quals to 7 or equals to 8
                                                                    //"associate","group"
                this.right="Section 2 d): Freedom of Association";  
            }
            else if(this.getISM()==9||this.getISM()==10){           //if the array index equals to 9 or equals to 10
                                                                    //"non-violent","protest"
                this.right="Section 2 c):Freedom of peaceful assembly.";
            }
            else if(this.getISM()==11){                             //if the array index equals to 11
                                                                    //"vote"
                this.right="Section 3: Democratic rights";  
            }
            else if(this.getISM()==12||this.getISM()==13){          //if the array index equals to 12 or equals to 13
                                                                    //"election","5"
                this.right="Section 4:Democratic rights";
            }
            else if(this.getISM()>=14&&this.getISM()<18){           //if the array index is between 14(includes and 17
                                                                    //"meeting","1","once"
                this.right="Section 5: Democratic rights";
            }
            else if(this.getISM()>=18&&this.getISM()<24){           //if the array index is between 18(includes) and 23
                                                                    //"travel","Canada","within","throughout","into","out"
                this.right="Section 6: Mobility Rights";
            }
            else if(this.getISM()>=24&&this.getISM()<27){           //if the array of index is between 24(includes) and 26
                                                                    //"safety","life","privacy"
                this.right="Section 7: Life, Liberty, Security.";
                super.setRemedies("Remedies are: Stay of proceedings, Reading in a term, Reading Down a term, Striking down a law, Excluding evidence in trial,Monetary Compensation");
            }
            else if(this.getISM()>=27&&this.getISM()<29){           //if the array of index is between 27(includes) and 28
                                                                    //"search","seizure"
                this.right="Section 8: Unreasonable Search and Seizure";
                super.setRemedies("Remedies are: Stay of proceedings, Reading in a term, Reading Down a term, Striking down a law, Excluding evidence in trial,Monetary Compensation");
            }
            else if(this.getISM()>=29&&this.getISM()<36){           //if the array of index is between 29(includes) and 35
                                                                    //"arrest","detention","arrest","reasons","lawyer","attorney","release"
                this.right="Section 9 and 10: Arrest and Detention Rights";
                super.setRemedies("Remedies are: Stay of proceedings, Reading in a term, Reading Down a term, Striking down a law, Excluding evidence in trial,Monetary Compensation");
            }
            else if(this.getISM()>=36&&this.getISM()<41){           //if the array of index is between 36(includes) and 40
                                                                    //"offence","trial","time","guilty","bail","sentence"
                this.right="Section 11: Proceedings in Criminal and Penal matters.";
                super.setRemedies("Remedies are: Stay of proceedings, Reading in a term, Reading Down a term, Striking down a law, Excluding evidence in trial,Monetary Compensation");
            }
            else if(this.getISM()>=41&&this.getISM()<44){           //if the array of index is between 41(includes) and 43
                                                                    //"cruel","unusual","punishment"
                this.right="Section 12: Cruel and Unusual Punishment";
                super.setRemedies("Remedies are: Stay of proceedings, Reading in a term, Reading Down a term, Striking down a law, Excluding evidence in trial,Monetary Compensation");
            }
            else if(this.getISM()>=44&&this.getISM()<46){           //if the array of index is between 44(includes) and 45
                                                                    //"witness","self-incriminated"
                this.right="Section 13: Witness Rights";
                super.setRemedies("Remedies are: Stay of proceedings, Reading in a term, Reading Down a term, Striking down a law, Excluding evidence in trial,Monetary Compensation");
            }
            else if(this.getISM()==46){                             //if the array of index equals to 46("interpreter")
                this.right="Section 14: Right to interpreter";
                super.setRemedies("Remedies are: Stay of proceedings, Reading in a term, Reading Down a term, Striking down a law, Excluding evidence in trial,Monetary Compensation");
            }
            else if(this.getISM()==47){                             //if the array of index equals to 47("unequal")
                this.right="Section 15: Equality Rights";
            }
        }
    }
  
    public String printInfo() {
        return super.printInfo()+ ", Right: " + this.getRight();
        
    }
    
}
