import java.util.Scanner;
import java.util.ArrayList;
public class Banka
{
  String meno; 
  ArrayList<Konto> klienti;
  private static int IDcounter=0;
  private int id;
    public Banka(String meno)
    {
        id=IDcounter++;
        klienti=new ArrayList<Konto>();
        this.meno=meno;
    }
    
    
    
    public void vypisKont()
    {
        
       for (int i = 0; i < klienti.size(); i++) 
       {
            //System.out.println(klienti.get(i));
            System.out.println("Vypisujem konto: " + i);
       }
    }
    
    public void bankaMenu()
    {
        Scanner skener = new Scanner(System.in);
        String vyberBM = "";
        boolean koniec = false;
        System.out.flush();
        while(!koniec)
        {
            System.out.println("1: Vypíš kontá");
            System.out.println("2: Konto manažment");
            System.out.println("3: Priadj konto;");
            System.out.println("0: Koniec");
            vyberBM = skener.nextLine();
            switch(vyberBM)
            {
                    case "0": 
                        koniec=true;
                    break;
                    case "1":
                        vypisKont();   
                    break;
                    case "2":
                        
                    break;
                    case "3":
                        klienti.add(new Konto("Jožko"));
                    break;
                    
            }
        }
    }
    
}
