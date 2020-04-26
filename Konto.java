    import java.util.Scanner;

public class Konto 
{
    private static int IDcounter=0;
    private int id;
    String meno;
    Ucet [] ucty;
    
    public Konto(String meno)
    {
        id=IDcounter++;
        ucty= new Ucet [10];
        for(int i=0; i<ucty.length; i++){
            ucty[i]= new BeznyUcet();
           }
        this.meno=meno;
    }
    
    public void kontoMenu()
    {
        Scanner skener = new Scanner(System.in);
        String vyberUcet = "";
        String menoKlienta = "";
        boolean koniec = false;
        
        BankAPP.clearScreen();       
        while(!koniec)
        {
            
            System.out.println("Nazov konta:");
            System.out.println(getName()+":");
        
            System.out.println("1: Vypíš uctov");
            System.out.println("2: Ucet manažment");
            System.out.println("3: Pridaj ucet");
            System.out.println("x: Koniec");
            vyberUcet = skener.nextLine();
            
            switch(vyberUcet)
            {
                case "x": 
                    koniec=true;
                    break;
                    
                case "1":
                    vypisUcty();
                    break;
                case "2":
                    vypisUcty();
                    System.out.println("zadaj ID uctu:");
                    vyberUcet= skener.nextLine();
                    ucty[Integer.parseInt(vyberUcet)].ucetMenu();
                    break;
                /*                
                case "3":
                    System.out.println("Pridaj ucet:");
                    System.out.println("Zadaj hotovost:");
                    menoKlienta= skener.nextLine();
                    klienti.add(new Konto(menoKlienta));
                    break;
                  */  
            }
        }
    }    
    
    public int getID(){
        return id;
    }
    
    public String getName(){
        return meno;
    }
    
    private void vypisUcty(){
        //BankAPP.clearScreen();
        System.out.println("Zoznam uctov:");
           for(int i=0; i<ucty.length; i++){
              System.out.println(ucty[i].getID()+" - "+ucty[i].getCisloUctu()+" - "+ucty[i].getHotovost());
           }
    }
}
