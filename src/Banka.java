import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
    
    public class Banka
    {
    private String meno; 
    private ArrayList<Konto> klienti;
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
    
    public void vypisKlientov(){
        System.out.println("Zoznam klientov:");
            for(int i=0; i<klienti.size(); i++){
                System.out.println(i+"  - "+klienti.get(i).getName());
            }
    }
    
    public void vypisKlientovDetailed(){
        System.out.println("Zoznam klientov a ich uctov:");
            for(int i=0; i<klienti.size(); i++){
                System.out.println(i+"  - "+klienti.get(i).getName());
                klienti.get(i).vypisUcty();
            }
    }        
        
    
    public static int generateCisloUctu(){
        int min=1000000;
        int max=9999999;
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    
    private boolean existINarraylist(String index){
        return (Integer.parseInt(index)<=klienti.size()-1 
                && Integer.parseInt(index)>=0);
    }
    
    private void priratajUrokyALL(){
        for(int i=0; i<klienti.size(); i++){
            klienti.get(i).priratajUrokUctom();
        }
    }
 //setters
    private void zmazKlienta(String ID){
        klienti.remove(Integer.parseInt(ID));
    }
    
    public void bankaMenu(){
        Scanner skener = new Scanner(System.in);
        String vyber = "";
        String menoKlienta = "";
        boolean koniec = false;
        
        while(!koniec){
            System.out.println("Banka: "+getName());
            System.out.println("1: Vypíš klientov");
            System.out.println("11: Vypíš klientov-detailed");
            System.out.println("2: Konto(klient) manažment");
            System.out.println("3: Pridaj klieta");
            System.out.println("4: Zmaz klieta");
            System.out.println("5: pridaj vsetkym urok");
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
                case "11":
                    BankAPP.clearScreen();
                    vypisKlientovDetailed();
                    break;    
                case "2":
                    BankAPP.clearScreen();
                    vypisKlientov();
                    System.out.println("zadaj ID klienta");
                    vyber= skener.nextLine();
                    if(existINarraylist(vyber)){
                        klienti.get(Integer.parseInt(vyber)).kontoMenu();
                    }else System.err.println("Konto neexistuje");
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
                    }else System.err.println("Konto neexistuje");
                    break;    
                    
                case "5":
                    BankAPP.clearScreen();
                    priratajUrokyALL();
                    
                    
            }
        }
    }
    

}
