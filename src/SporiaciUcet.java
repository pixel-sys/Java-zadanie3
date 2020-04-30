
import java.util.Scanner;


public class SporiaciUcet extends BeznyUcet
{
//constructors    
    public SporiaciUcet(int id,String typUctu, int cisloUctu, int hotovost,double urok){
    
        super(id,typUctu,cisloUctu, hotovost,urok);
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

