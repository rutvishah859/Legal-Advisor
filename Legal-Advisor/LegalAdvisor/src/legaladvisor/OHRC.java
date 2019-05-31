package legaladvisor;
public class OHRC extends HumanRights{
    private String grounds; 
    private String area; 
    private String typeOfDis; 
    public String groundKeywords[]={"black","white","asian","muslim","jewish","christian","buddhist","hindu","female","male","man","woman","girl","boy","pregnancy","citizenship","culture","disabled","mental disability","physical disability","gay","homosexual","lesbian","bisexual","transgender","heterosexual","married","not married","kids","no kids","too young","too old","wellfare"};
    private String areaKeywords[]={"rent","work","employment","hired","fired","member","group","union","hospital","restaurant","movie theater","school","service","place","contract"};
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
        if(super.SearchMechanism(keyword, groundKeywords, 0)==true){
            if(this.getISM()>=0&&this.getISM()<3){
                grounds="Race";
            }
            else if(this.getISM()>=3&&this.getISM()<8){
                grounds="Creed";
            }
            else if(this.getISM()>=8&&this.getISM()<15){
                grounds="Sex";
            }
            else if(this.getISM()==15){
                grounds="Citizenship";
            }
            else if(this.getISM()==16){
                grounds="Ethnic origin";
            }
            else if(this.getISM()>=17&&this.getISM()<20){
                grounds="Handicap";
            }
            else if(this.getISM()>=20&&this.getISM()<26){
                grounds="Sexual Orientation";
            }
            else if(this.getISM()==26||this.getISM()==27){
                grounds="Marital Status";
            }
            else if(this.getISM()==28||this.getISM()==29){
                grounds="Family Status";
            }
            else if(this.getISM()==30||this.getISM()==31){
                grounds="Age";
            }
            else{
                grounds="Receipt of public assistance";
            }
        }
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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
