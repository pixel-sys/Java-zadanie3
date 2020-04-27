
public class BeznyUcet extends Ucet
{
    PlatobnaKarta [] karta;
    
    public BeznyUcet(int id, int cisloUctu, int hotovost)
    {
        super (id, cisloUctu, hotovost);
        karta = new PlatobnaKarta [5];
        for(int i=0; i<karta.length; i++){
            karta[i]= new PlatobnaKarta();
           }      
          
    }
    
    public BeznyUcet(int id, int cisloUctu, int hotovost, double urok)
    {
        super (id, cisloUctu, hotovost,urok);
        karta = new PlatobnaKarta [5];
        for(int i=0; i<karta.length; i++){
            karta[i]= new PlatobnaKarta();
           }      
          
    }
    

    
    
}
