
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
    
    @Override
    public void vypisUcet(){
    System.out.println("ID uctu: "+getID()+" typ: "+getTypUctu()+
            " cislo u.: "+getCisloUctu() +" hotovost: "+ getHotovost()+
            " urok: "+ getUrok()+" firma: "+getMenoFirmy()+" ICO: "+ getICO());
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
            vypisUcet();
            
            System.out.println("1) vloz hotovost");
            System.out.println("2) vyber hotovost");
            System.out.println("3) zmen urok");
            System.out.println("4) zmen meno firmy");
            System.out.println("5) zmen ICO");
            System.out.println("6) vypis karty");
            System.out.println("7) karta management");
            System.out.println("x) Koniec");
            
            
            
            vyber = skener.nextLine();
            switch(vyber)
            {
                case "1":
                    BankAPP.clearScreen();
                    vyber = skener.nextLine();
                    priratajHotovost(Integer.parseInt(vyber));
                    break;
                    
                case "2":
                    BankAPP.clearScreen();
                    vyber = skener.nextLine();
                    odratajHotovost(Integer.parseInt(vyber));    
                    break;
                    
                case "3":
                    BankAPP.clearScreen();
                    vyber = skener.nextLine();
                    setUrok(Double.valueOf(vyber));
                    break;
                
                case "4":
                    BankAPP.clearScreen();
                    vyber = skener.nextLine();
                    setMenoFirmy(vyber);
                   break;
                
                case "5":
                    BankAPP.clearScreen();
                    vyber = skener.nextLine();
                    setICO(Integer.parseInt(vyber));
                   break;
                    
                case "6":
                    BankAPP.clearScreen();
                    vypisKarty();
                    break;
                
                case "7":
                    BankAPP.clearScreen();
                    vypisKarty();
                    System.out.println("vyber kartu podla ID:");
                    vyber = skener.nextLine();
                    if(kotrolaVyberuKarty(vyber)){
                        karta[Integer.parseInt(vyber)].kartaMenu();
                    }else System.err.println("zadali ste zly vstup!");
                    break;
                    
                case "x":
                    koniec=true;
                    break;
                        
            }
        }
    }    
        
    
}
