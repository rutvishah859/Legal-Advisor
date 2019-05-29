package legaladvisor;
public class Tester {
    public static void main(String []args){
        CrimeAgainstPerson c1= new CrimeAgainstPerson("None","Criminal","Ontario","Crime Against The Person","null","indictable");
        c1.setMensRea("accident");
        System.out.println(c1.getMensRea());
       c1.setCrimeTypeAndSentence("killed");
        System.out.println(c1.getCrimeType());
    }
}
