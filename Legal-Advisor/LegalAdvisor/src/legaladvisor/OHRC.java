package legaladvisor;
public class OHRC extends HumanRights{
    private String grounds; 
    private String area; 
    private String typeOfDis; 
    
    public OHRC(String rem, String typ, String jur, String gr, String ar, String typeDis) {
        super(rem, typ, jur);
        this.grounds = gr; 
        this.area = ar; 
        this.typeOfDis = typeDis; 
    } 

    public String getGrounds() {
        return grounds;
    }

    public void setGrounds(String keyword) {
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
            else if(this.getISM()>=17&&this.getISM()<20){
                this.grounds="Handicap";
            }
            else if(this.getISM()>=20&&this.getISM()<26){
                this.grounds="Sexual Orientation";
            }
            else if(this.getISM()==26||this.getISM()==27){
                this.grounds="Marital Status";
            }
            else if(this.getISM()==28||this.getISM()==29){
                this.grounds="Family Status";
            }
            else if(this.getISM()==30||this.getISM()==31){
                this.grounds="Age";
            }
            else{
                this.grounds="Receipt of public assistance";
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
            else if(this.getISM()>=2&&this.getISM()<6){
                this.area="Employment";
            }
            else if(this.getISM()>=6&&this.getISM()<9){
                this.area="Membership in vocational associations and trade unions";
            }
            else if(this.getISM()>=9&&this.getISM()<15){
                this.area="Goods, services, and facilities";
            }
            else if(this.getISM()==15){
                this.area="Contracts";
            }
        }
        
    }

    public String getTypeOfDis() {
        return typeOfDis;
    }

    public void setTypeOfDis(String typeOfDis) {
        this.typeOfDis = typeOfDis;
    }
    
    String printInfo() {
        return null; 
    }
    
}
