package aa;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App {
	static boolean playing = true;
    public static void main(String[] args) {   
        
        System.out.println("Hello");
        Scanner scanner = new Scanner(System.in);
        Hero hero = Hero.GetHero();
        Monster mon1 = new Monster();
        EnermyPool pool = new EnermyPool();
        while(playing) {
	        for (int i = 0; i < pool.getMaxPool(); i++) {
	            if (hero.getHp() == 0) {
	            	System.out.println("Game Over!!!");
	            	break;
	            }
	            for (int o = 0;o<2;o++) {
	        		Monster monster = mon1.clone();
	                System.out.println("Found Monster : Hp is " + monster.getHp());
	                System.out.println("What do you do : Attack(A) Heal(H)");
	                while (monster.getHp() != 0) {
	                    String att = scanner.nextLine();
	                    if (att.equals("A")) {
	                        hero.Attack(monster);
	                        System.out.println("Monster Hp now is " + monster.getHp());
	                        monster.Attack(hero);
	                        System.out.println("Hero Hp now is " + hero.getHp());
	                        if (hero.getHp() == 0) {
	                        	break;
	                        }
	                    }
	                    if (att.equals("H")) {
	                    	hero.heal();
	                        System.out.println("Heal!!!!!!!, Hero Hp now is " + hero.getHp());
	                    }
	               }
	            }
	
	            	Boss boss = pool.borrow(); 
	                System.out.println("Found Boss : Hp is " + boss.getHp());
	                System.out.println("What do you do : Attack(A) Heal(H)");
	                while (boss.getHp() != 0) {
	                    String att = scanner.nextLine();
	                    if (att.equals("A")) {
	                        hero.Attack(boss);
	                        System.out.println("Boss Hp now is " + boss.getHp());
	                        boss.Attack(hero);
	                        System.out.println("Hero Hp now is " + hero.getHp());
	                        if (hero.getHp() == 0) {
	                        	break;
	                        }
	                    }
	                    if (att.equals("H")) {
	                        hero.heal();
	                        System.out.println("Heal!!!!!!!, Hero Hp now is " + hero.getHp());
	                    }
	                }
	                pool.back(boss);
	           
	        }
	        if (hero.getHp() > 0) {
	        	System.out.println("You win!!!");
	        }
	        System.out.println("Play again (P) or End (Some key)");
	        String key = scanner.nextLine();
	        if (key.equals("P")) {
	        	hero.Hp = 100;
	        	playing = true;
	        }else {
	        	playing = false;
	        	System.out.println("Goodbye");
	        }
        }


    }
}
