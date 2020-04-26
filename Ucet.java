import java.util.Random;
public abstract class Ucet
{
    protected static int IDcounter=0;
    int id;
    int cisloUctu, hotovost;
    /*
    public Ucet(int hotovost)
    {
        id=IDcounter++;
        cisloUctu=generateCisloUctu();
        this.hotovost=hotovost;
    }

    public Ucet()
    {
        id=IDcounter++;
        cisloUctu=generateCisloUctu();
        hotovost=0;
    }
    */
    protected static int generateCisloUctu() 
    {
        int min=1000000;
        int max=9999999;
    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
    }
    
    public void ucetMenu(){
        System.out.println("vypis ucet MENU");
    }
    
    
    public int getID(){
        return id;
    }
    
    public int getCisloUctu(){
        return cisloUctu; 
    }
    
    public int getHotovost(){
        return hotovost;
    }
    
}
