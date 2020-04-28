import java.util.Scanner;
import java.util.ArrayList;

public class BankAPP
{
    private static int bankaID=0;
    private static ArrayList<Banka> banky=new ArrayList<Banka>();
    
    
    public static void clearScreen() {
        System.out.print('\u000C');
    }
    
    public static void pridajBanku(){
     banky.add(new Banka("bez_mena",bankaID));  
     bankaID++;
    }
    
    public static void pridajBanku(String meno){
     banky.add(new Banka(meno, bankaID));  
     bankaID++;
    }
    
    public static void main(String[] args)
    {
        Scanner skener = new Scanner(System.in);
        boolean koniec = false;
        String vyber = "";
        String vyber2="";
        String vstup = "";
                
        pridajBanku();
        pridajBanku("MamkaBanka");
        
        clearScreen();
        while(!koniec) 
        {
            System.out.println("Vyberte si moznost: ");
            System.out.println("x: exit");
            System.out.println("1: Vyber banku");
            
            vyber = skener.nextLine();
                      
                switch (vyber) 
                {
                    case "x":
                        koniec = true;
                        break;
                    
                    case "1":
                        clearScreen();
                        System.out.println("Zoznam bank:");
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
                                                
            }        
        }
                
    }
}

