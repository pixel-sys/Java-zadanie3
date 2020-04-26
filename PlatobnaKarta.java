
import java.util.Random;
public class PlatobnaKarta implements KartaAble
{
    int cisloKarty,PIN;
    
    public PlatobnaKarta(int PIN,Karta typKarty)
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
        int min=10000;
        int max=99999;
	Random r = new Random();
	return r.nextInt((max - min) + 1) + min;
    }
    
    public int getCisloKarty()
    {
        return cisloKarty;
    }
    
    public boolean setKartaPIN(int oldPIN, int newPIN)
    {
        oldPIN=PIN;
        if (oldPIN==newPIN)
            {
                return false;
            }
        else PIN=newPIN;    
        return true;
    }
    
}
