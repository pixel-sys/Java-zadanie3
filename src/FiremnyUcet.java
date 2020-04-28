package src;





public class FiremnyUcet extends BeznyUcet
{
    String menoFirmy;
    int ICO;
    
    
    
    public FiremnyUcet(int id,String typUctu, int cisloUctu, int hotovost, String menoFirmy, int ICO)
    {
        super(id,typUctu, cisloUctu, hotovost);
        this.menoFirmy=menoFirmy;
        this.ICO=ICO;
        
    }
}
