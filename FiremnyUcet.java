

public class FiremnyUcet extends BeznyUcet
{
    String nazovFirmy;
    int ICO;
    
    
    public FiremnyUcet(int id, int cisloUctu, int hotovost, String nazovFirmy, int ICO)
    {
        super(id, cisloUctu, hotovost);
        this.nazovFirmy=nazovFirmy;
        this.ICO=ICO;
        
    }
}
