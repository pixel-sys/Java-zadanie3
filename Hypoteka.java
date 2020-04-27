

public class Hypoteka extends Ucet
{   int dobaSplacania;
    double vyskaSplatky;
    
    
    public Hypoteka(int id, int cisloUctu, int hotovost,int dobaSplacania)
    {
        super (id, cisloUctu, hotovost);
        this.dobaSplacania=dobaSplacania;
        vyskaSplatky=hotovost/dobaSplacania;
               
    }
}