package src;

    import java.util.Scanner;

public abstract class Ucet
{
    Scanner skener = new Scanner(System.in);
    private int id;
    int cisloUctu, hotovost;
    double urok;
    private String typUctu="";
   

    public Ucet(int id,String typ, int cisloUctu, int hotovost){
        this.id=id;
        this.typUctu=typ;
        this.cisloUctu=cisloUctu;
        this.hotovost=hotovost;
        urok=1;
    }
    
        public Ucet(int id,String typ, int cisloUctu, int hotovost,double urok){
        this.id=id;
        this.typUctu=typ;
        this.cisloUctu=cisloUctu;
        this.hotovost=hotovost;
        this.urok=urok;
    }
            
    public static void ucetMenu(String typUctu){
        
        /*
        System.out.println("Upravuj dany ucet:");
        BankAPP.clearScreen();       
        */
        switch(typUctu)
        {
            case "Bezny": 
                    System.out.println("Som v beznom ucete!!!!!!");
            case "Sporiaci":
                             
            case "Firemny":
                         
            case "Hypo":
                
        }
        
    }
    
    public int getID(){
        return id;
    }
    
    public String getTypUctu(){
        return typUctu;
    }
    
    public int getCisloUctu(){
        return cisloUctu; 
    }
    
    public int getHotovost(){
        return hotovost;
    }
    
}
