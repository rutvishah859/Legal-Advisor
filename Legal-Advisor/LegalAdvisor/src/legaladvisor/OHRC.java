/*
The OHRC class extends the HumanRights class which inheriates the Case class, this class basically sets the variables, which is later printed in the printInfo abstract method
*/
package legaladvisor;
public class OHRC extends HumanRights{
    private String grounds; 
    private String area; 
    
    public OHRC(String rem, String jur, String gr, String ar) {
        super(rem, jur);
        this.grounds = gr; 
        this.area = ar; 
    } 

    public String getGrounds() {
        return grounds;
    }
    //This method will determine specific protected grounds
    //The definition of OHRC is every person has the right to freedom from discrimination and harrassment based on specific protected grounds
    public void setGrounds(String keyword) {
        if(this.getJurisdiction().equalsIgnoreCase("Ontario")){ //if the jurisdiction equals to Ontario
        if(super.SearchMechanism(keyword, getGroundKeywords(), 0)){ //if keyword equals to any words in groundskeywords array
            if(this.getISM()>=0&&this.getISM()<3){  //if the array index of groundskeywords is between 0(includes) and 2 
                                                    //(black, white, asian)
                this.grounds="Race";    //the ground will be Race 
            }
            else if(this.getISM()>=3&&this.getISM()<8){ //if the array index of groundkeywords is between 3(includes) and 7
                                                        //muslim,jewish,christian,buddhist,hindu
                this.grounds="Creed";   //the ground will be Creed (religious belief or fatih
            }
            else if(this.getISM()>=8&&this.getISM()<15){ //if the array index is between 8(includes) and 14
                                                         //female,male,man,woman,girl,boy,pregnancy
                this.grounds="Sex"; //the ground will be Sex
            }
            else if(this.getISM()==15){ //if the array index equals to 15
                this.grounds="Citizenship"; //the ground will be Citizenship
            }
            else if(this.getISM()==16){ //if the array index equals to 16
                this.grounds="Ethnic origin"; //the ground will be Ethnic origin
            }
            else if(this.getISM()>=17&&this.getISM()<21){   //if the array index is between 17(includes) and 20
                this.grounds="Handicap";                    //disabled,mental,physical,disability
            }
            else if(this.getISM()>=21&&this.getISM()<27){   //if the array index is between 21(includes) and 26   
                                                            //gay,homosexual,lesbian,bisexual,transgender,heterosexual
                this.grounds="Sexual Orientation";
            }
            else if(this.getISM()==27){                     //if the array index equals to 27 (married)
                this.grounds="Marital Status";
            }
            else if(this.getISM()>=28||this.getISM()<32){   //if the array index is between 28(includes) and 31
                this.grounds="Family Status";               //kids,children,kid,child
            }
            else if(this.getISM()==32||this.getISM()==33){  //if the array index equals to 32 or equals to 33
                                                            //young, old
                this.grounds="Age";
            }
            else if(this.getISM()==34){                     //if the array index equals to 34 (wellfare)
                this.grounds="Receipt of public assistance";
            }
        }
    }
    }
    public String getArea() {
        return area;
    }
    //Under the code, you have the right to be free from discrimination in five parts of society - called social areas-based on one or more grounds
    public void setArea(String keyword) {
        if(super.SearchMechanism(keyword, getAreaKeywords(), 0)){ //if the keyword equals to any words in the areakeywords array
            if(this.getISM()==0||this.getISM()==1){         //if the array index equals to 0 or equals to 1
                                                            //rent, house
                this.area="Occupancy of accomodation";
            }
            else if(this.getISM()>=2&&this.getISM()<7){     //if the array index is between 2(includes) and 6
                                                            //work,employment,hired,fired,member
                this.area="Employment";
            }
            else if(this.getISM()>=7&&this.getISM()<12){    //if the array index is between 7(includes) and 11
                                                            //group,union,hospital,restaurant,movie theater
                this.area="Membership in vocational associations and trade unions";
            }
            else if(this.getISM()>=12&&this.getISM()<15){   //if the array index is between 12(includes) and 17
                                                            //school,service,place,contract
                this.area="Goods, services, facilities";
            }
            else if(this.getISM()==15){     //if the array index equals to 18 (Contract)
                this.area="Contracts";
            }
        }
        
    }
    //this method will set remedies based on the area 
    public void setRemedies(){
        if(this.getArea().equalsIgnoreCase("occupancy of accomodation")){
            super.setRemedies("The respondent will have to stop the discrimination and offer a letter of apologies. Monetary compensation will also be provided.");
        }
        else if(this.getArea().equalsIgnoreCase("employment")){
           super.setRemedies("The respondent will have to give you the job/promotion. The staff will also have to go through HR Training.");
        }
        else if(this.getArea().equalsIgnoreCase("goods, services, facilities")){
            super.setRemedies("The respondent will have to issue you a letter of apology and stop the discriminatory behaviour.");
        }
        else if(this.getArea().equalsIgnoreCase("membership in vocational associations and trade unions")){
            super.setRemedies("The respondent will have to stop the discriminatory behaviour, issue you a letter of apology and the staff will have to go through HR Training.");
        }
        else if(this.getArea().equalsIgnoreCase("contracts")){
            super.setRemedies("The respondent will have to provide you with monetary compensation.");
        }
    }
    public String printInfo() {
        return "Grounds: " + this.getGrounds() + "\nArea: " + this.getArea(); 
    }
    
}
