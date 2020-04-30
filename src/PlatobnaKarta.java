
import java.util.Random;
import java.util.Scanner;


public class PlatobnaKarta implements KartaAble
{
    int cisloKarty;
    String PIN;
    Karta typKarty;
    
//constructors
          
    public PlatobnaKarta(){
     cisloKarty=generateCardNumber();
     PIN="0000";
     this.typKarty=typKarty.VISA;
    }
    
    public PlatobnaKarta(Karta typKarty){
     cisloKarty=generateCardNumber();
     PIN="0000";
     this.typKarty=typKarty;
    }
    
    public PlatobnaKarta(String PIN){
     cisloKarty=generateCardNumber();
     this.PIN=PIN;
      this.typKarty=typKarty.MAESTRO;
    }
    
    public PlatobnaKarta(String PIN,Karta typKarty){
        cisloKarty=generateCardNumber();
        this.PIN=PIN;
        this.typKarty=typKarty;
        
    }
 
//getters
    public int getCisloKarty(){
        return cisloKarty;
    }
    public String getTypKarty(){
        return typKarty.toString();
    }
    private static int generateCardNumber(){
        int min=100;
        int max=999;
    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
    }
 
//setters  
    
    private boolean checkOldPIN(){
        Scanner skener = new Scanner(System.in);
        String in="";
        System.out.println("zadaj stare heslo:");
        in = skener.nextLine();
           
        if(in==PIN) return true;
            else return false; 
    }
    
    public boolean setKartaPIN(){   
        Scanner skener = new Scanner(System.in);
        String newPIN="";
        
        if (checkOldPIN())
            {
                System.out.println("zadaj nove heslo:");
                newPIN = skener.nextLine();
                PIN=newPIN;
                return true;
            }
        else return false;
    }
  
    private void  setKartaTyp(Karta typKarty){
        this.typKarty=typKarty;
    }

    public void kartaMenu(){
        Scanner skener = new Scanner(System.in);
        String vyber = "";
        boolean koniec=false;
        
        
        while(!koniec){
            BankAPP.clearScreen();
                        
            System.out.println("1) zmen PIN");
            System.out.println("2) zmen typ karty");
            System.out.println("x) Koniec");
            
            vyber = skener.nextLine();
            switch(vyber)
            {
                case "1":
                    BankAPP.clearScreen();
                    if (setKartaPIN()){
                        System.out.println("PIN bol zmeneny");
                    }else System.out.println("zadal si zly PIN");;
                    break;
                    
                case "2":
                    BankAPP.clearScreen();
                    System.out.println(java.util.Arrays.asList(typKarty.values()));
                    vyber = skener.nextLine();
                    setKartaTyp(Karta.valueOf(vyber));
                    break;
                    
                case "x":
                    koniec=true;
                    break;
                        
            }
        }
    }
    
    
    
    
}
