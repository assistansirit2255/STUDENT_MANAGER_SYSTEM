package util;
public class Loader implements Runnable{
    public void run(){
        try{
            System.out.print("Loading");
            for(int i=0;i<5;i++){ Thread.sleep(500); System.out.print("."); }
            System.out.println("\nDone!");
        } catch(Exception e){}
    }
}