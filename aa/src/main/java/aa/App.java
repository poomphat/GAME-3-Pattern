package aa;



import java.util.*;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App extends JPanel implements ActionListener{
	static boolean playing = true,IsDead=false;
	JButton attack,heal,exit,start;
	
	List<Boss> TombOfBoss = new ArrayList<Boss>();
	
	static Hero hero = Hero.GetHero();
	static Monster mon1 = new Monster();
	static EnemyPool pool = new EnemyPool();
	static int nmonster=2;
	static int count=0;
	static Boss boss=pool.borrow();
	private static String att = "";static Monster monster = mon1.clone();
	static boolean firstTime=true,firstTimeBoss=true;
	public App() {
		super();
		start=new JButton("start");
		 attack = new JButton("Attack");
		 heal = new JButton("Heal");
		 exit = new JButton("Exit");
		 start.addActionListener(this);
		attack.addActionListener(this);     
        heal.addActionListener(this);
        exit.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) { System.exit(0);; }
		});
        add(start);
        add(attack);
        add(heal);
        add(exit);
        setLayout(new FlowLayout(FlowLayout.CENTER));
	        //}
	   
	    
	   
		//super();
		
	}
	public void paintComponent(Graphics g0) {
		
	}
	
    public static void main(String[] args) throws IOException {   
        
    	JFrame frame = new JFrame();
        frame.getContentPane().add(new App());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 640, 600);
        frame.setTitle("Gamenaja");
        frame.setVisible(true);
        System.out.println("|||||||||||||||||||||||");
        System.out.println("||  Start Adventure  ||");
        System.out.println("|||||||||||||||||||||||");
        
        //Scanner scanner = new Scanner(System.in);
       
    }
 
//}
    @Override
	    public void actionPerformed(ActionEvent e) {
    	
        if(playing) {
        	if(!IsDead) {											//Is dead=false 
        	if(count<3) {											
	            if (hero.getHp() == 0) {
	            	System.out.println("Game Over!!!");
	            	
	            }
	           // System.err.println("count = "+count);
	      		
	            if(nmonster>0) {
	                
	            	if(firstTime) {
	            		showMonster();
	            		
	                firstTime=false;
	            	}
	                if(monster.getHp() > 0) {					
	                    //String att = scanner.nextLine();
	                	//while(att.equals(""))
	                    if (e.getSource().equals(attack)) {
	                    	attMonster();
	                    	checkMonDead();
	                    	checkHeroHP();
	                        
	                    }
	                    else if (e.getSource().equals(heal)) {
	                    	heroHeal();
	                    }
	                    
	               }
	            
	            }	            
	            else if(boss.getHp()>0&&nmonster==-1) {	
	            	
	            	 if (e.getSource().equals(attack)) {
	            		 attBoss();
	            		 checkBoss(); 
	            		 }
	            	 
	            	 checkHeroHP();
	            	 
	            	 if (e.getSource().equals(heal)) {
	            		 heroHeal();
                }
	            }/*else if(nmonster==-1||boss.getHp()<=0){
	            	pool.back(boss);
	            	nmonster=2;
	            	count++;
	            	firstTimeBoss=true;
	            } */
	           
        }
	            
}	
        	else {													// dead (Isdead = true)
        		System.out.println("game is over!!! press start or exit");
        		if(e.getSource().equals(start)) {
        			
        			for(int u = 0;u<count;u++) {
        				pool.back(TombOfBoss.get(u));
        			}
        			startNew();
        			showMonster();
        		}
}
        	
        }
      //  System.err.println("Bug??? naniiiiiiiiiiiii");
    }
    void showMonster() {
    	if(nmonster>=1) {
    	System.out.println("Found Monster : Hp is " + monster.getHp());
    	System.out.println("Hero Hp now is " + hero.getHp());
        System.out.println("What do you do : Attack(A) Heal(H)");
        System.out.println("---------------------------------");
        }
    }
    void attMonster() {
    	 hero.Attack(monster);
         System.out.println("Monster Hp now is " + monster.getHp());
         monster.Attack(hero);
         System.out.println("Hero Hp now is " + hero.getHp());
         System.out.println("---------------------------------");
    }
    void heroHeal() {
    	hero.heal();
        System.out.println("Heal!!!!!!!, Hero Hp now is " + hero.getHp());
        System.out.println("---------------------------------");
    }
    void showBoss() {
    	
    	System.out.println("Found Boss : Hp is " + boss.getHp());
    	System.out.println("Hero Hp now is " + hero.getHp());
        System.out.println("What do you do : Attack(A) Heal(H)");
    }
    void startNew() {
    	System.out.println("Game Start!!!");
    	IsDead=false;
    	hero.Hp=100;
    	nmonster=2;
    	count=0;
    	
    }
    void gameOver() {
    	System.err.println("Game over");
    	IsDead=true;
    }
    void attBoss() {
    	
    	  hero.Attack(boss);
          System.out.println("Boss Hp now is " + boss.getHp());
          boss.Attack(hero);
          System.out.println("Hero Hp now is " + hero.getHp());
          System.out.println("---------------------------------");
    }
    void checkMonDead() {
    	if(monster.getHp() <= 0 && nmonster>0) {
      	  nmonster--;monster = mon1.clone();   
  	      //System.err.println("nmonter = " + nmonster);
  	      System.out.println("Wow Monster Defeated");
  	      showMonster();   
  	      checkLastMon();
      }
    }
    void checkLastMon() {			//check nmonsters are 2? boss start:nothing; 
    	if(nmonster==0) {
      		boss = pool.borrow();
      		showBoss();
      		nmonster=-1;
      		}
    }
    void checkHeroHP() {
    	if (hero.getHp() == 0) {
      		gameOver();
        }
    }
    void checkBoss() {				//check boss dead
    	if(boss.getHp()<=0) {
        	nmonster=2;
        	count++;
        	firstTimeBoss=true;
        	TombOfBoss.add(boss);
        	checkLastBoss();
    }
    	}
    void checkLastBoss() {			// there are last boss??
    	if(count<3) {
         	showMonster();
		 }else {
			 System.out.println("Win!!!");
			 gameOver();
		 }
    }

}