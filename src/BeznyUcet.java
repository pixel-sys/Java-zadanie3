import java.util.Scanner;

public class BeznyUcet extends Ucet
{
     PlatobnaKarta [] karta;

// constructors    
    public BeznyUcet(int id,String typUctu, int cisloUctu, int hotovost)
    {
        super (id,typUctu, cisloUctu, hotovost);
        karta = new PlatobnaKarta [5];
        for(int i=0; i<karta.length; i++){
            karta[i]= new PlatobnaKarta();
           }
        
          
    }
    
    public BeznyUcet(int id,String typUctu, int cisloUctu, int hotovost, double urok)
    {
        super (id,typUctu, cisloUctu, hotovost,urok);
        karta = new PlatobnaKarta [5];
        for(int i=0; i<karta.length; i++){
            karta[i]= new PlatobnaKarta();
           }      
          
    }
    
//getters

    protected void vypisKarty(){
        for(int i=0; i<karta.length; i++){
            System.out.println("cislo k: "+karta[i].getCisloKarty()+" typ karty: "
                    + karta[i].getTypKarty());
        }
    }
    
    protected boolean kotrolaVyberuKarty(String vstup){
        int vyber = Integer.parseInt(vstup);
        if(karta.length-1>vyber
            && vyber>-1 
            && karta[vyber]!=null)
            {return true;}else return false;
    }

    private int findFreeSpot(){
        int spot=-1;
        for(int i=karta.length-1; i>=0; i--){
            if(karta[i]==null)spot=i;
        }
        return spot;
    }
//setters
    protected void pridajKartu(){
        
    }
    protected void vymazKartu(){
        
    }
    
    
//menu

    @Override
    public void ucetMenu(){
        Scanner skener = new Scanner(System.in);
        String vyber = "";
        boolean koniec=false;
        
        
        while(!koniec){
            BankAPP.clearScreen();
            
            System.out.println("ID uctu: "+getID()+" typ: "+getTypUctu()+
                    " cislo u.: "+getCisloUctu() +" hotovost: "+ getHotovost()+
                    " urok: "+ getUrok());
            
            System.out.println("1) vloz hotovost");
            System.out.println("2) vyber hotovost");
            System.out.println("3) zmen urok");
            System.out.println("4) vypis karty");
            System.out.println("5) karta management");
            System.out.println("6) pridaj kartu");
            System.out.println("7) zmaz kartu");
            System.out.println("x) Koniec");
            
            vyber = skener.nextLine();
            switch(vyber)
            {
                case "1":
                    BankAPP.clearScreen();
                    System.out.println("Zadaj kolko chces vlozit:");
                    vyber = skener.nextLine();
                    priratajHotovost(Integer.parseInt(vyber));
                    break;
                    
                case "2":
                    BankAPP.clearScreen();
                    System.out.println("Zadaj kolko chces vybrat");
                    vyber = skener.nextLine();
                    odratajHotovost(Integer.parseInt(vyber));    
                    break;
                    
                case "3":
                    BankAPP.clearScreen();
                    System.out.println("Zadaj vysku uroku:");;
                    vyber = skener.nextLine();
                    setUrok(Double.valueOf(vyber));
                    break;
                    
                case "4":
                    BankAPP.clearScreen();
                    vypisKarty();
                    break;
                
                case "5":
                    BankAPP.clearScreen();
                    vypisKarty();
                    System.out.println("vyber kartu podla ID:");
                    vyber = skener.nextLine();
                    if(kotrolaVyberuKarty(vyber)){
                        karta[Integer.parseInt(vyber)].kartaMenu();
                    }else System.err.println("zadali ste zly vstup!");
                    break;
                    
                case "6":
                    System.out.println("Pridaj kartu:");
                    if(findFreeSpot()>-1){
                        (findFreeSpot());
                    }else System.out.println("Mas dosiahnuty maximalny pocet kariet!");
                    break;
                
                case "7":
                    BankAPP.clearScreen();
                    vypisKarty();
                    System.out.println("vyber kartu podla ID:");
                    vyber = skener.nextLine();
                    if (kotrolaVyberuKarty(vyber)) {
                        karta[Integer.parseInt(vyber)].kartaMenu();
                    } else {
                        System.err.println("zadali ste zly vstup!");
                    }
                    break;
                    
                case "x":
                    koniec=true;
                    break;
                        
            }
        }
    }
    

}

    
    

