package src;



public class Hypoteka extends Ucet
{   int dobaSplacania;
    double vyskaSplatky;
    
    
    public Hypoteka(int id,String typUctu, int cisloUctu, int hotovost,int dobaSplacania)
    {
        super (id,typUctu, cisloUctu, hotovost);
        this.dobaSplacania=dobaSplacania;
        vyskaSplatky=hotovost/dobaSplacania;
               
    }
}