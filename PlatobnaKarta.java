
import java.util.Random;
import java.util.Scanner;


public class PlatobnaKarta implements KartaAble
{
    int cisloKarty;
    String PIN;
    
    public PlatobnaKarta(){
     cisloKarty=generateCardNumber();
     PIN="0000";
    }
    
    public PlatobnaKarta(String PIN,Karta typKarty)
    {
        cisloKarty=generateCardNumber();
        this.PIN=PIN;
        switch (typKarty) 
        { 
        case VISA: 
            System.out.println("VISA");
            break; 
        case MASTERCARD: 
            System.out.println("MASTERCARD"); 
            break; 
        case MAESTRO:
            System.out.println("MAESTRO");
            break; 
        } 
    }
    
    private static int generateCardNumber() 
    {
        int min=100;
        int max=999;
    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
    }
    
    public int getCisloKarty()
    {
        return cisloKarty;
    }
    
    public boolean checkOldPIN(){
        Scanner skener = new Scanner(System.in);
        String in="";
        System.out.println("zadaj stare heslo:");
        in = skener.nextLine();
           
        if(in==PIN) return true;
            else return false; 
    }
    
    public boolean setKartaPIN()
    {   Scanner skener = new Scanner(System.in);
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
    
}
