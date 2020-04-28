package src;


import java.util.Scanner;


public class BeznyUcet extends Ucet
{
    PlatobnaKarta [] karta;
    
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
    

    public void setHotovost(int hotovost){
        this.hotovost=hotovost;
    }
    
    public void setUrok(double urok){
        this.urok=urok;
    }
//    
//    
    
     
    public  void beznyUcetMenu(){
        Scanner skener = new Scanner(System.in);
        String vyber = "";
        boolean koniec=false;
        
        
        while(!koniec)
        {   BankAPP.clearScreen();
            System.out.println("ID uctu: "+getID()+" typ: "+getTypUctu()+
                    " cislo u.: "+getCisloUctu() +" hotovost: "+ getHotovost()+
                    " urok: "+ getUrok());
            
        
            
            vyber = skener.nextLine();
            
            switch(vyber)
            {
                case "x":
                    koniec=true;
                    break;
                        
            }
        }
    }
}

    
    

