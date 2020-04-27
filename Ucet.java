
public abstract class Ucet
{
    private int id;
    int cisloUctu, hotovost;
    double urok;

    public Ucet(int id, int cisloUctu, int hotovost){
        this.id=id;
        this.cisloUctu=cisloUctu;
        this.hotovost=hotovost;
        urok=1;
    }
    
        public Ucet(int id, int cisloUctu, int hotovost,double urok){
        this.id=id;
        this.cisloUctu=cisloUctu;
        this.hotovost=hotovost;
        this.urok=urok;
    }
            
    public static void ucetMenu(){
        System.out.println("Upravuj dany ucet:");
        
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
