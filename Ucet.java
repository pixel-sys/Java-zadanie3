import java.util.Random;
public abstract class Ucet
{
    private static int IDcounter=0;
    int id;
    int cisloUctu, hotovost;
    public Ucet(int id, int cisloUctu,int hotovost)
    {
        id=IDcounter++;
        cisloUctu=generateCisloUctu();
        this.hotovost=hotovost;
    }

    private static int generateCisloUctu() 
    {
        int min=1000000;
        int max=9999999;
	Random r = new Random();
	return r.nextInt((max - min) + 1) + min;
    }
}
