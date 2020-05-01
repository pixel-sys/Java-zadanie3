
import java.util.Scanner;


public class SporiaciUcet extends BeznyUcet
{
//constructors    
    public SporiaciUcet(int id,String typUctu, int cisloUctu, int hotovost,double urok){
    
        super(id,typUctu,cisloUctu, hotovost,urok);
    }

//getters
    @Override
    public void vypisUcet(){
        System.out.println("ID uctu: "+getID()+" typ: "+getTypUctu()+
            " cislo u.: "+getCisloUctu() +" hotovost: "+ getHotovost()+
            " urok: "+ getUrok());
    }
    
    
//setters
    
    @Override
    protected void odratajHotovost(int vklad){
        if((int)(hotovost/2)>vklad){
            this.hotovost-=vklad;
        }else System.out.println("nemozes vybrat viac ako hotovosti");
        
    }    
    
//menu
    @Override
    public void ucetMenu(){
        
        Scanner skener = new Scanner(System.in);
        String vyber = "";
        boolean koniec=false;
        
        
        while(!koniec){
            vypisUcet();
            
            System.out.println("1) vloz hotovost");
            System.out.println("2) vyber hotovost");
            System.out.println("3) zmen urok");
            System.out.println("4) vypis karty");
            System.out.println("5) karta management");
            System.out.println("x) Koniec");
            
            vyber = skener.nextLine();
            switch(vyber)
            {
                case "1":
                    BankAPP.clearScreen();
                    vyber = skener.nextLine();
                    priratajHotovost(Integer.parseInt(vyber));
                    break;
                    
                case "2":
                    BankAPP.clearScreen();
                    vyber = skener.nextLine();
                    odratajHotovost(Integer.parseInt(vyber));    
                    break;
                    
                case "3":
                    BankAPP.clearScreen();
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
                    
                case "x":
                    koniec=true;
                    break;
                        
            }
        }
    }    
    
    
}

