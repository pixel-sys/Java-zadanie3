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
            System.out.println("cislo k: "+karta[i].getCisloKarty());
        }
    }

//setters

    
    
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
            System.out.println("x) Koniec");
            
            vyber = skener.nextLine();
            switch(vyber)
            {
                case "1":
                    vyber = skener.nextLine();
                    priratajHotovost(Integer.parseInt(vyber));
                    break;
                    
                case "2":
                    vyber = skener.nextLine();
                    odratajHotovost(Integer.parseInt(vyber));    
                    break;
                    
                case "3":
                    vyber = skener.nextLine();
                    setUrok(Double.valueOf(vyber));
                    break;
                    
                case "4":
                    vypisKarty();
                    break;
                    
                case "x":
                    koniec=true;
                    break;
                        
            }
        }
    }
}

    
    

