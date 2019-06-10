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

    public void setGrounds(String keyword) {
        if(this.getJurisdiction().equalsIgnoreCase("Ontario")){
        if(super.SearchMechanism(keyword, getGroundKeywords(), 0)==true){
            if(this.getISM()>=0&&this.getISM()<3){
                this.grounds="Race";
            }
            else if(this.getISM()>=3&&this.getISM()<8){
                this.grounds="Creed";
            }
            else if(this.getISM()>=8&&this.getISM()<15){
                this.grounds="Sex";
            }
            else if(this.getISM()==15){
                this.grounds="Citizenship";
            }
            else if(this.getISM()==16){
                this.grounds="Ethnic origin";
            }
            else if(this.getISM()>=17&&this.getISM()<21){
                this.grounds="Handicap";
            }
            else if(this.getISM()>=21&&this.getISM()<27){
                this.grounds="Sexual Orientation";
            }
            else if(this.getISM()==27){
                this.grounds="Marital Status";
            }
            else if(this.getISM()>=28||this.getISM()<32){
                this.grounds="Family Status";
            }
            else if(this.getISM()==32||this.getISM()==33){
                this.grounds="Age";
            }
            else if(this.getISM()==34){
                this.grounds="Receipt of public assistance";
            }
        }
    }
    }
    public String getArea() {
        return area;
    }
    public void setArea(String keyword) {
        if(super.SearchMechanism(keyword, getAreaKeywords(), 0)==true){
            if(this.getISM()==0||this.getISM()==1){
                this.area="Occupancy of accomodation";
            }
            else if(this.getISM()>=2&&this.getISM()<7){
                this.area="Employment";
            }
            else if(this.getISM()>=7&&this.getISM()<12){
                this.area="Membership in vocational associations and trade unions";
            }
            else if(this.getISM()>=12&&this.getISM()<18){
                this.area="Goods, services, facilities";
            }
            else if(this.getISM()==18){
                this.area="Contracts";
            }
        }
        
    }
    public void setRemedies(String keyword){
        if(this.getArea().equalsIgnoreCase("occupancy of accomodation")){
            super.setRemedies("The respondent will have to stop the discrimination and offer a letter of apologies. Monetary compensation will also be provided.");
        }
        else if(this.getArea().equalsIgnoreCase("employment")){
            if(keyword.equalsIgnoreCase("promotion")){
              super.setRemedies("The respondent will have to give you the promotion and pay monetary compensation for any losses that you experienced. The staff will also have to go through HR training.");  
            }
            else if(keyword.equalsIgnoreCase("hired")||keyword.equalsIgnoreCase("fired")){
                super.setRemedies("The respondent will have to hire you and monetary compensation for any losses that you experienced.The staff will also have to go through HR training.");  
            }
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
