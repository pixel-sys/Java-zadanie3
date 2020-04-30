
import java.util.Scanner;

public class Konto 
{
    private int id;
    private String meno;
    private int ucetID=0;
    Ucet [] ucty;
    
//constructor    
    public Konto(String meno, int id){
        this.id=id;
        ucty= new Ucet [10];
        this.meno=meno;
    }
 
//getters    
    public int getID(){
        return id;
    }
    
    public String getName(){
        return meno;
    }
    
    private void vypisUcty(){
        System.out.println("Zoznam uctov:");
           for(int i=0; i<ucty.length; i++){
               if(ucty[i]!=null){
                System.out.println(i
                +" - "+ucty[i].getCisloUctu()
                +" - "+ucty[i].getTypUctu() 
                +" - "+ucty[i].getHotovost());
               }
            }
    }
    
    private int findFreeSpot(){
        int spot=-1;
        for(int i=ucty.length-1; i>=0; i--){
            if(ucty[i]==null)spot=i;
        }
        return spot;
    }
    
//setters
    private void zmazUcet(String spot){
        ucty[Integer.parseInt(spot)]=null;
    }
    
//menu    
    public void kontoMenu(){
        Scanner skener = new Scanner(System.in);
        String vyberUcet = "";
        String menoKlienta = "";
        boolean koniec = false;
        
        BankAPP.clearScreen();       
        while(!koniec)
        {
            
            System.out.println("Konto:"+ getName());        
            System.out.println("1: Vypíš uctov");
            System.out.println("2: Ucet manažment");
            System.out.println("3: Pridaj ucet");
            System.out.println("4: Zmaz ucet");
            System.out.println("x: Koniec");
            
            vyberUcet = skener.nextLine();
            switch(vyberUcet)
            {
                case "x": 
                    koniec=true;
                    break;
                    
                case "1":
                    vypisUcty();
                    break;
                case "2":
                    vypisUcty();
                    System.out.println("zadaj ID uctu:");
                    vyberUcet= skener.nextLine();
                    if(ucty[Integer.parseInt(vyberUcet)]!=null)
                        ucty[Integer.parseInt(vyberUcet)].ucetMenu();
                    break;
                    
                case "3":
                    System.out.println("Pridaj ucet:");
                    if(findFreeSpot()>-1){
                        pridajUcetMenu(findFreeSpot());
                    }else System.out.println("Mas dosiahnuty maximalny pocet uctov!");
                    break;
                    
                case "4":
                    vypisUcty();
                    System.out.println("zadaj ID uctu(ktory chces zmazat):");
                    vyberUcet= skener.nextLine();
                    if(ucty[Integer.parseInt(vyberUcet)]!=null 
                        && Integer.parseInt(vyberUcet)<ucty.length-1 
                        && Integer.parseInt(vyberUcet)>-1)
                            {zmazUcet(vyberUcet);
                             System.out.println("ucet boz zmazany");}
                        
                    break;
            
                       
                    
            }
        }
    }    
        
    private void pridajUcetMenu(int spot){
        Scanner skener = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        String vyber="";
        boolean koniec = false;
        int hotovost=0;
        double urok=0;
        String menoFirmy="";
        int ICO=0;
        int dobaSplacania=0;
       BankAPP.clearScreen();
       while(!koniec){
            System.out.println("vyber typ uctu:");
            System.out.println("1:  Bezny ucet:");
            System.out.println("11: Sporiaci ucet ");
            System.out.println("12: Firemny ucet");        
            System.out.println("2:  Hypoteka");
            System.out.println("x: koniec");
            
            vyber= skener.nextLine();
            switch(vyber){
                case "1":
                    System.out.println("zadaj hotovost:");
                    hotovost= skener.nextInt();
                    ucty[spot]=new BeznyUcet(ucetID,"Bezny",Banka.generateCisloUctu(),hotovost);
                    ucetID++;
                    koniec=true;
                    break;
                    
                                
                case "11":
                    System.out.println("zadaj hotovost:");
                    hotovost= skener.nextInt();
                    System.out.println("zadaj urok:");
                    urok= skener.nextDouble();
                    ucty[spot]=new SporiaciUcet(ucetID,"Sporiaci",Banka.generateCisloUctu(),hotovost,urok);
                    ucetID++;
                    koniec=true;
                    break;
                
                case "12":
                    System.out.println("zadaj hotovost:");
                    hotovost= skener.nextInt();
                    System.out.println("zadaj nazov firmy:");
                    menoFirmy=  scanner.nextLine();
                    System.out.println("zadaj ICO:");
                    ICO= skener.nextInt();
                    ucty[spot]=new FiremnyUcet(ucetID,"Firemny",Banka.generateCisloUctu(),hotovost,menoFirmy,ICO);
                    ucetID++;
                    koniec=true;
                    break;
                    
                case "2":
                    System.out.println("zadaj hotovost:");
                    hotovost= skener.nextInt();
                    System.out.println("zadaj dobu splacania:");
                    dobaSplacania= skener.nextInt();
                    ucty[spot]=new Hypoteka(ucetID,"Hypo",Banka.generateCisloUctu(),hotovost,dobaSplacania);
                    ucetID++;
                    koniec=true;
                    break;
                    
                case "x":
                    koniec=true;
                    break;    
            }   
        
       }
    }
}
