

public class BeznyUcet extends Ucet
{
    //int [] karta;
    public BeznyUcet(int hotovost)
    {
        this.hotovost=hotovost;
        cisloUctu= generateCisloUctu();
        id= IDcounter;        
    }
    
    public BeznyUcet()
    {
        cisloUctu= generateCisloUctu();
        id= IDcounter;
        hotovost=0;
    }
}
