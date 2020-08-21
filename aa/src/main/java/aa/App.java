package aa;
import java.util.*;
/**
 * Hello world!
 *
 */
public class App 
{
	
    

	public static void main( String[] args ){
		Thread t1 = new Thread(new MyThread());
        t1.start();
    	System.out.println("Hello");
    	Scanner scanner = new Scanner(System.in);
    	Hero hero = Hero.GetHero();
    	Monster mon1 = new Monster();
    	Monster mon2 = mon1.clone();
    	Monster mon3 = mon1.clone();
    	Monster mon4 = mon1.clone();
    	Monster mon5 = mon1.clone();
    	Boss boss = Boss.GetBoss(); 
    	System.out.println(boss.getName());
    	System.out.println("Found Monster : Hp is " +mon1.getHp());
	    	System.out.println("What do you do : Attack(A)");
	    	String input = scanner.nextLine();
	    	if(input.equals("A")){
	    		hero.Attack(mon1);
	    		if(mon1.getHp() == 0) {
	    			System.out.println("Monster Dead");
	    		}
	    		else {
	    			mon1.Attack(hero);
	    			System.out.println("Hero Hp now is " +hero.getHp());
	    		}
	    	}
    	
    }
    
} 
class MyThread extends Thread {
	public static int sec;

    @Override
    public void run() {
    	int sec = 0;
        while (true){       	
         try {
           sec++;
           System.out.println(sec+" seconds");
           Thread.sleep(1000L); 
          }
          catch (InterruptedException e) {
          }
        }
        
    }


}

