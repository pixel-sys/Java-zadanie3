import java.util.Scanner;
import java.util.ArrayList;

public class BankAPP
{
    private static int bankaID=0;
    private static ArrayList<Banka> banky=new ArrayList<Banka>();
    
    
    public static void clearScreen() {
        System.out.print('\u000C');
    }

//constructors    
    public static void pridajBanku(){
     banky.add(new Banka("bez_mena",bankaID));  
     bankaID++;
    }
    
    public static void pridajBanku(String meno){
     banky.add(new Banka(meno, bankaID));  
     bankaID++;
    }

//getters
    public static void vypisBanky(){
        System.out.println("Zoznam bank:");
            for(int i=0; i<banky.size(); i++){
                System.out.println(i+"  - "+banky.get(i).getName());
            }
    }

    private static boolean existINarraylist(String index){
        return (Integer.parseInt(index)<=banky.size()-1 
                && Integer.parseInt(index)>=0);
    }
    
//setters 
    public static void vymazBanku(String ID){
        banky.remove(Integer.parseInt(ID));
    }
    
//menu    
    public static void main(String[] args){
        Scanner skener = new Scanner(System.in);
        boolean koniec = false;
        String vyber;
        String vstup = "";
                
        pridajBanku();
        pridajBanku("MamkaBanka");
        
        while(!koniec) 
        {   System.out.println("Vyberte si z moznosti: ");
            System.out.println("1: Vyber banku");
            System.out.println("2: pridaj banku (bez mena)");
            System.out.println("3: pridaj banku (s menom)");
            System.out.println("4: Vymaz banku");
            System.out.println("x: exit");
            vyber = skener.nextLine();
                      
                switch (vyber) 
                {
                    case "x":
                        koniec = true;
                        break;
                    
                    case "1":
                        clearScreen();
                        vypisBanky();
                        System.out.println("x: exit");
                        vyber = skener.nextLine();
                        if(vyber=="x"){break;}
                        if(existINarraylist(vyber)){
                            banky.get(Integer.parseInt(vyber)).bankaMenu();
                        }else System.out.println("Banka sa nenasla!");
                        break;
                     
                    case "2": 
                        clearScreen();
                        pridajBanku();
                        System.out.println("banka bola pridana");
                        break;
                    case "3":
                        clearScreen();
                        System.out.println("Zadaj meno banky:");
                        vyber = skener.nextLine();
                        pridajBanku(vyber);
                        System.out.println("banka bola pridana");
                        break;
                    case "4":
                        clearScreen();
                        vypisBanky();
                        System.out.println("x: exit");
                        vyber = skener.nextLine();
                        if(vyber=="x"){break;}
                        if(existINarraylist(vyber)){
                            vymazBanku(vyber);
                        }else System.out.println("Banka sa nenasla!");
                        break;
            }       
                
        }
                
    }
}

