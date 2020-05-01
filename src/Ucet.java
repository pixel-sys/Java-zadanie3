import java.util.Scanner;


public abstract class Ucet
{
    Scanner skener = new Scanner(System.in);
    private  int id;
    protected int cisloUctu;
    protected int hotovost;
    protected double urok;
    protected String typUctu="";
   
// constructors
    public Ucet(int id,String typ, int cisloUctu, int hotovost){
        this.id=id;
        this.typUctu=typ;
        this.cisloUctu=cisloUctu;
        this.hotovost=hotovost;
        urok=1;
    }
    
    public Ucet(int id,String typ, int cisloUctu, int hotovost,double urok){
        this.id=id;
        this.typUctu=typ;
        this.cisloUctu=cisloUctu;
        this.hotovost=hotovost;
        this.urok=urok;
    }
     
    
 //getters    
    public int getID(){
        return id;
    }
    
    public  String getTypUctu(){
        return typUctu;
    }
    
    protected int getCisloUctu(){
        return cisloUctu; 
    }
    
    protected int getHotovost(){
        return hotovost;
    }
    
    protected double getUrok(){
        return urok;
    }

//setters
    protected void setUrok(double urok){
        this.urok=urok;
    }

    protected void setHotovost(int hotovost){
        this.hotovost=hotovost;
    }
    
    protected void priratajHotovost(int vklad){
        this.hotovost+=vklad;
    }
    
    public void priratajUrok(){
        int newHotovost=(int)(getHotovost()*(1+(getUrok()/100)));
        setHotovost(newHotovost);
        
    }
    
    protected void odratajHotovost(int vklad){
        this.hotovost-=vklad;
    }

//menu   
    public abstract void ucetMenu();
           
}
