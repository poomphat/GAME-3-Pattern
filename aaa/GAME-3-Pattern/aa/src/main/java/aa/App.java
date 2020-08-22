package aa;

import java.util.*;
import static javax.swing.text.html.HTML.Tag.I;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread());
        t1.start();
        List<String> Pool = new ArrayList<String>();//เก็บบอส
        List<String> UsePool = new ArrayList<String>();
        String pop;
        Pool.add("Boss");
        Pool.add("Boss");
        Pool.add("Boss");
        final int MaxPool = Pool.size();

        System.out.println("Hello");
        Scanner scanner = new Scanner(System.in);
        Hero hero = Hero.GetHero();
        Monster mon1 = new Monster();
        Monster mon2 = mon1.clone();
        Monster mon3 = mon1.clone();
        Monster mon4 = mon1.clone();
        Monster mon5 = mon1.clone();
        
        
//        System.out.println(boss.getName());
//        System.out.println("Found Monster : Hp is " + boss.getHp());
//        System.out.println("What do you do : Attack(A)");
//        String input = scanner.nextLine();
//        if (input.equals("A")) {
//            hero.Attack(boss);
//            if (boss.getHp() == 0) {
//                System.out.println("Monster Dead");
//            } else {
//                boss.Attack(hero);
//                System.out.println("Hero Hp now is " + hero.getHp());
//            }
//        }

        System.out.println("you need call boss!!!  Call(I)");
        String inputcallboss = scanner.nextLine();
        if (inputcallboss.equals("I")) {
            for (int i = 0; i < MaxPool;i++){
                pop = Pool.remove(0);
                UsePool.add(pop);
                if (pop.equals("Boss")) {
//                            เรียกบอส
                    Boss boss = Boss.GetBoss();
                    boss.Hp = 200;
//                    Boss boss = Boss.GetBoss();
                    System.out.println(boss.getName());
                    System.out.println("Found Monster : Hp is " + boss.getHp());
                    System.out.println("What do you do : Attack(A)");
                    while (boss.getHp() != 0){
                        String att = scanner.nextLine();
                        if (att.equals("A")) {
                            hero.Attack(boss);
                            System.out.println("Boss Hp now is " + boss.getHp());
                        }else {
                            boss.Attack(hero);
                            System.out.println("Hero Hp now is " + hero.getHp());
                        }
                    }
                    
                }
            }
        }
        
        System.out.println("play again!!!  Call(k)");
        String keepboss = scanner.nextLine();
        if (keepboss.equals("k")) {
            for (int i = 0; i < MaxPool;i++){
                pop = UsePool.remove(0);
                Pool.add(pop);
            }
        }


    }

}

class MyThread extends Thread {

    public static int sec;

    @Override
    public void run() {
        int sec = 0;
        while (true) {
            try {
               sec++;
                System.out.println(sec + " seconds");
               Thread.sleep(1000L);
            } catch (InterruptedException e) {
            }
        }

    }

}
