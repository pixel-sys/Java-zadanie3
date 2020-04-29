import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
    
    public class Banka
    {
    private String meno; 
    private static ArrayList<Konto> klienti;
    private static int kontoID=0;
    private int id;
    
 //constructors   
    public Banka(String meno,int id)
    {
        this.id=id;
        klienti=new ArrayList<Konto>();
        this.meno=meno;
    }
    
//getters    
    public int getID(){
        return id;
    }
    
    public  String getName(){
        return meno;
    }
    
    public static void vypisKlientov(){
        System.out.println("Zoznam klientov:");
            for(int i=0; i<klienti.size(); i++){
                System.out.println(i+"  - "+klienti.get(i).getName());
            }
    }
    
    public static int generateCisloUctu(){
        int min=1000000;
        int max=9999999;
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    
    private static boolean existINarraylist(String index){
        return (Integer.parseInt(index)<=klienti.size()-1 
                && Integer.parseInt(index)>=0);
    }
    
    
 //setters
    private static void zmazKlienta(String ID){
        klienti.remove(Integer.parseInt(ID));
    }
    
    public void bankaMenu()
    {
        Scanner skener = new Scanner(System.in);
        String vyber = "";
        String menoKlienta = "";
        boolean koniec = false;
        
        while(!koniec){
            System.out.println("Banka: "+getName());
            System.out.println("1: Vypíš klientov");
            System.out.println("2: Konto(klient) manažment");
            System.out.println("3: Pridaj klieta");
            System.out.println("4: Zmaz klieta");
            System.out.println("x: Koniec");
            vyber = skener.nextLine();
            switch(vyber)
            {
                case "x": 
                    koniec=true;
                    break;
                case "1":
                    BankAPP.clearScreen();
                    vypisKlientov();
                    break;
                case "2":
                    BankAPP.clearScreen();
                    System.out.println("zadaj ID klienta");
                    vyber= skener.nextLine();
                    if(existINarraylist(vyber)){
                        klienti.get(Integer.parseInt(vyber)).kontoMenu();
                    }else System.out.println("Konto neexistuje");
                    break;
                case "3":
                    BankAPP.clearScreen();
                    System.out.println("Pridaj klienta:");
                    System.out.println("Zadaj meno klienta:");
                    menoKlienta= skener.nextLine();
                    klienti.add(new Konto(menoKlienta,kontoID));
                    kontoID++;
                    break;
                case "4":
                    BankAPP.clearScreen();
                    System.out.println("zadaj ID klienta");
                    vyber= skener.nextLine();
                    if(existINarraylist(vyber)){
                        zmazKlienta(vyber);
                    }else System.out.println("Konto neexistuje");
                    break;    
                    
                    
            }
        }
    }
    

}
