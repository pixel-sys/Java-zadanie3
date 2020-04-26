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
        String vyberKonto = "";
        String menoKlienta = "";
        boolean koniec = false;
        
    
        
        /*
        System.out.println("Zoznam kont:");
        for(int i=0; i<banky.size(); i++){
            System.out.println(banky.get(i).getID()+"  - "+banky.get(i).getName());
        }
                        System.out.println("x: exit");
                        while(!koniec)
                        { 
                            vyber2 = skener.nextLine();
                            if(vyber2!="x"){
                                banky.get(Integer.parseInt(vyber2)).bankaMenu();
                                break;
                            }else {koniec=true;
                                    break;}
                        }
        */
        
        
        while(!koniec)
        {
            BankAPP.clearScreen();
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
                        System.out.println(klienti.get(i).getID()+"  - "+klienti.get(i).getName());
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
                    klienti.add(new Konto(menoKlienta));
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
