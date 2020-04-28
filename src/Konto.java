package src;


import java.util.Scanner;

public class Konto 
{
    private int id;
    String meno;
    protected static int ucetID=0;
    Ucet [] ucty;
    
    
    public Konto(String meno, int id)
    {
        this.id=id;
        ucty= new Ucet [10];
        this.meno=meno;
    }
    
    
    public int getID(){
        return id;
    }
    
    public String getName(){
        return meno;
    }
    
    private void vypisUcty(){
        //BankAPP.clearScreen();
        System.out.println("Zoznam uctov:");
           for(int i=0; i<ucty.length; i++){
               if(ucty[i]!=null){
              System.out.println(ucty[i].getID()+" - "+ucty[i].getCisloUctu()+" - "+ucty[i].getTypUctu() +" - "+ucty[i].getHotovost());
               }
            }
    }
    
    public void kontoMenu(){
        Scanner skener = new Scanner(System.in);
        String vyberUcet = "";
        String menoKlienta = "";
        boolean koniec = false;
        
        BankAPP.clearScreen();       
        while(!koniec)
        {
            
            System.out.println("Nazov konta:");
            System.out.println(getName()+":");
        
            System.out.println("1: Vypíš uctov");
            System.out.println("2: Ucet manažment");
            System.out.println("3: Pridaj ucet");
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
                /*not yet */
                    vypisUcty();
                    System.out.println("zadaj ID uctu:");
                    vyberUcet= skener.nextLine();
                    for(int i=0; i<ucty.length; i++){
                        if(ucty[i]!=null && ucty[i].getID()==Integer.parseInt(vyberUcet)){
                            ucty[i].ucetMenu(ucty[i].getTypUctu());
                            break;
                        }
                    }        
                    break;
                                
                case "3":
                    System.out.println("Pridaj ucet:");
                    pridajUcetMenu();
                    menoKlienta= skener.nextLine();
                    break;
                    
            }
        }
    }    
        
    private void pridajUcetMenu(){
        Scanner skener = new Scanner(System.in);
        String vyber="";
        boolean koniec = false;
        int hotovost=0;
        double urok=0;
        String menoFirmy="";
        int ICO=0;
        int dobaSplacania=0;
       BankAPP.clearScreen();
       while(!koniec){
            System.out.println("vyber typ uctu ucetu:");
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
                    ucty[ucetID]=new BeznyUcet(ucetID,"Bezny",Banka.generateCisloUctu(),hotovost);
                    ucetID++;
                    break;
                                
                case "11":
                    System.out.println("zadaj hotovost:");
                    hotovost= skener.nextInt();
                    System.out.println("zadaj urok:");
                    urok= skener.nextDouble();
                    ucty[ucetID]=new SporiaciUcet(ucetID,"Sporiaci",Banka.generateCisloUctu(),hotovost,urok);
                    ucetID++;
                    break;
                
                case "12":
                    System.out.println("zadaj hotovost:");
                    hotovost= skener.nextInt();
                    System.out.println("zadaj nazov firmy:");
                    menoFirmy= skener.nextLine();
                    System.out.println("zadaj ICO:");
                    ICO= skener.nextInt();
                    ucty[ucetID]=new FiremnyUcet(ucetID,"Firemny",Banka.generateCisloUctu(),hotovost,menoFirmy,ICO);
                    ucetID++;
                    break;
                    
                case "2":
                    System.out.println("zadaj hotovost:");
                    hotovost= skener.nextInt();
                    System.out.println("zadaj dobu splacania:");
                    dobaSplacania= skener.nextInt();
                    ucty[ucetID]=new Hypoteka(ucetID,"Hypo",Banka.generateCisloUctu(),hotovost,dobaSplacania);
                    ucetID++;
                    break;
                    
                case "x":
                    koniec=true;
                    break;    
            }   
        
       }
    }
}
