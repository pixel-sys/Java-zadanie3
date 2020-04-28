

    import java.util.Scanner;

public abstract class Ucet
{
    Scanner skener = new Scanner(System.in);
    private static int id;
    int cisloUctu, hotovost;
    double urok;
    String typUctu="";
   

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
            
    public static int getID(){
        return id;
    }
    
    public  String getTypUctu(){
        return typUctu;
    }
    
    protected int getCisloUctu(){
        return cisloUctu; 
    }
    
    protected int getHotovost(){
        return hotovost;
    }
    
    protected double getUrok(){
        return urok;
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
    
}
