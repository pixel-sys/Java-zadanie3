package src;


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
    

    
    
}
