import java.util.Scanner;
import java.util.ArrayList;

public class BankAPP
{
    public static void clearScreen() {
        System.out.print('\u000C');
    }
    
    public static void main(String[] args)
    {
        Scanner skener = new Scanner(System.in);
        boolean koniec = false;
        String vyber = "";
        String vyber2="";
        String vstup = "";
        ArrayList<Banka> banky=new ArrayList<Banka>();
        banky.add(new Banka("FajkaBanka"));
        banky.add(new Banka("MamkaBanka"));
        
        clearScreen();
        while(!koniec) 
        {
            System.out.println("Vyberte si moznost: ");
            System.out.println("0: END PROGRAM");
            System.out.println("1: Vyber banku");
            vyber = skener.nextLine();
            
            
                switch (vyber) 
                {
                    case "0":
                        koniec = true;
                    break;
                    
                    case "1":// vyber = "";
                    while(!koniec)
                    {
                        System.out.println("Vyberte si moznost: ");
                        System.out.println("0: END PROGRAM");
                        System.out.println("1: FajkaBanka");
                        System.out.println("2: MamkaBanka");
                        vyber2 = skener.nextLine();
                        switch(vyber2)
                        {   
                            case "0":
                                koniec=true;
                            break;
                            case "1":
                                System.out.println("FajkaBanka");
                                banky.get(Integer.parseInt(vyber2)).bankaMenu();
                            break;
                            case "2":
                                System.out.println("MamkaBanka");
                                banky.get(Integer.parseInt(vyber2)).bankaMenu();
                            break;                            
                        }                        
                    }   
                    break;
            }        
        }
                
    }
}

