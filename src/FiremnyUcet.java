
import java.util.Scanner;


public class FiremnyUcet extends BeznyUcet
{
    String menoFirmy;
    int ICO;
    
    
//constructors    
    public FiremnyUcet(int id,String typUctu, int cisloUctu, int hotovost, String menoFirmy, int ICO){
        super(id,typUctu, cisloUctu, hotovost);
        this.menoFirmy=menoFirmy;
        this.ICO=ICO;
        
    }
    

//getters
    protected String getMenoFirmy(){
        return menoFirmy;
    }
    
    protected int getICO(){
        return ICO;
    }
    
    
//setters 
    protected void setMenoFirmy(String menoFirmy){
        this.menoFirmy=menoFirmy;        
    }
    
    protected void setICO(int ICO){
        this.ICO=ICO;
    }
    
//menu
    @Override
    public void ucetMenu(){
        Scanner skener = new Scanner(System.in);
        String vyber = "";
        boolean koniec=false;
        
        
        while(!koniec){
            BankAPP.clearScreen();
            
            System.out.println("ID uctu: "+getID()+" typ: "+getTypUctu()+
                    " cislo u.: "+getCisloUctu() +" hotovost: "+ getHotovost()+
                    " urok: "+ getUrok()+" firma: "+getMenoFirmy()+" ICO: "+ getICO());
            
            System.out.println("1) vloz hotovost");
            System.out.println("2) vyber hotovost");
            System.out.println("3) zmen urok");
            System.out.println("4) zmen meno firmy");
            System.out.println("5) zmen ICO");
            System.out.println("6) vypis karty");
            System.out.println("x) Koniec");
            
            
            
            vyber = skener.nextLine();
            switch(vyber)
            {
                case "1":
                    vyber = skener.nextLine();
                    priratajHotovost(Integer.parseInt(vyber));
                    break;
                    
                case "2":
                    vyber = skener.nextLine();
                    odratajHotovost(Integer.parseInt(vyber));    
                    break;
                    
                case "3":
                    vyber = skener.nextLine();
                    setUrok(Double.valueOf(vyber));
                    break;
                
                case "4":
                    vyber = skener.nextLine();
                    setMenoFirmy(vyber);
                   break;
                
                case "5":
                    vyber = skener.nextLine();
                    setICO(Integer.parseInt(vyber));
                   break;
                    
                case "6":
                    vypisKarty();
                    break;
                    
                case "x":
                    koniec=true;
                    break;
                        
            }
        }
    }    
        
    
}
