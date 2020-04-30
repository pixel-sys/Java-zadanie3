
import java.util.Scanner;


public class Hypoteka extends Ucet
{   int dobaSplacania;
    int vyskaSplatky;
    
//constructors    
    public Hypoteka(int id,String typUctu, int cisloUctu, int hotovost,int dobaSplacania)
    {
        super (id,typUctu, cisloUctu, hotovost);
        this.dobaSplacania=dobaSplacania;
        vyskaSplatky=hotovost/dobaSplacania;
               
    }
    
//getters
    protected int getDobaSpalcania(){
        return dobaSplacania;
    }
    
    protected int getVyskaSplatky(){
        return vyskaSplatky;
    } 
    
        
//setters        
    protected void setDobaSplacania(int dobaSplacania){
        this.dobaSplacania=dobaSplacania;
        prepocitajVyskuSplatky();
    }
    
    protected void setVyskaSplatky(int vyskaSplatky){
        this.vyskaSplatky=vyskaSplatky;
        prepocitajDobuSplacania();
        
    }
    
    protected void prepocitajVyskuSplatky(){
        this.vyskaSplatky=(int)Math.ceil(getHotovost()/dobaSplacania);
    }
    
    protected void prepocitajDobuSplacania(){
        this.dobaSplacania=(int)Math.ceil(getHotovost()/getVyskaSplatky());
    }
    
//menu
    //skus
    @Override
    public void ucetMenu(){
        Scanner skener = new Scanner(System.in);
        String vyber = "";
        boolean koniec=false;
        
        
        while(!koniec){
            BankAPP.clearScreen();
            
            System.out.println("ID uctu: "+getID()+" typ: "+getTypUctu()+
                    " cislo u.: "+getCisloUctu() +" hotovost: "+ getHotovost()+
                    " urok: "+ getUrok()+ " vyska splatky: "+getVyskaSplatky()+
                    " doba splacania: "+getDobaSpalcania());
            
            System.out.println("1) vloz splatku");
            System.out.println("2) zmen vysku splatky");
            System.out.println("3) zmen dobu splacania");
            System.out.println("x) Koniec");
            
            
            vyber = skener.nextLine();
            switch(vyber)
            {
                case "1":
                    odratajHotovost(getVyskaSplatky());
                    break;
                    
                case "2":
                    vyber = skener.nextLine();
                    setVyskaSplatky(Integer.parseInt(vyber));
                    break;
                    
                case "3":
                    vyber = skener.nextLine();
                    setDobaSplacania(Integer.parseInt(vyber));
                    break;
                    
                case "x":
                    koniec=true;
                    break;
                        
            }
        }
    }  
}