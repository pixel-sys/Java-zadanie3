import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
    
    public class Banka
    {
    String meno; 
    ArrayList<Konto> klienti;
    private static int kontoID=0;
    private int id;
    
    public Banka(String meno,int id)
    {
        this.id=id;
        klienti=new ArrayList<Konto>();
        this.meno=meno;
    }
    
    public static int generateCisloUctu() 
    {
        int min=1000000;
        int max=9999999;
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
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
        String vyberKonto = "";
        String menoKlienta = "";
        boolean koniec = false;
        
    
        BankAPP.clearScreen();
        while(!koniec)
        {
            
            System.out.println(getName()+":");
        
            System.out.println("1: Vypíš klientov");
            System.out.println("2: Konto(klient) manažment");
            System.out.println("3: Pridaj klieta");
            System.out.println("x: Koniec");
            vyberBM = skener.nextLine();
            switch(vyberBM)
            {
                case "x": 
                    koniec=true;
                    break;
                case "1":
                    System.out.println("Zoznam klientov:");
                    for(int i=0; i<klienti.size(); i++){
                        System.out.println(klienti.get(i).getID()+"  - "
                                +klienti.get(i).getName());
                    }
         
                                           break;
                case "2":
                    System.out.println("zadaj ID klienta");
                    vyberKonto= skener.nextLine();
                    klienti.get(Integer.parseInt(vyberKonto)).kontoMenu();
                    break;
                case "3":
                    System.out.println("Pridaj klienta:");
                    System.out.println("Zadaj meno klienta:");
                    menoKlienta= skener.nextLine();
                    klienti.add(new Konto(menoKlienta,kontoID));
                    kontoID++;
                    break;
                    
            }
        }
    }
    
    public int getID(){
        return id;
    }
    
    public String getName(){
        return meno;
    }
    
}
