
public class Konto 
{
    private static int IDcounter=0;
    private int id;
    String meno;
    int [] ucty;
    
    public Konto(String meno)
    {
        id=IDcounter++;
        this.meno=meno;
        this.ucty= new int[10];
    }
    
    public void kontoMenu()
    {
        
    }
    
    public int getID(){
        return id;
    }
    
    public String getName(){
        return meno;
    }
    
}
