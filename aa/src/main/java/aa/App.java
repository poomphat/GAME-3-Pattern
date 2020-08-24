package aa;


import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App extends JPanel implements ActionListener{
	static boolean playing = true,IsDead=false;
	JTextArea textArea = new JTextArea(150, 25);
	PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
	JButton attack,heal,exit,start;

	JPanel p1;
	
	PrintStream standardOut;
	
	static JFrame frame=new JFrame();
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
		
		standardOut = System.out;
		System.setOut(printStream);
        System.setErr(printStream);
        textArea.setEditable(false);
	//	p1 = new JPanel();
	   //  p2 = new JPanel();
		
		
		
		
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
        
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.anchor = GridBagConstraints.WEST;
        add(start, constraints);
        
        constraints.gridx = 1;
        add(attack, constraints);
        constraints.gridx = 2;
        add(heal,constraints);
        constraints.gridx = 3;
        add(exit,constraints);
        
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        
        add(new JScrollPane(textArea), constraints);
        
        //frame.setLayout(new GridLayout(1,));
      // p1.setLayout(new GridLayout(1, 1));
	//	p2.setLayout(new GridLayout(1,4));
        
        
	//	p1.add(new JScrollPane(textArea));
	/*	frame.add(attack);
		frame.add(heal);
		frame.add(start);
		frame.add(exit);
		frame.add(new JScrollPane(textArea));
		
        
     */   
       // frame.add(p1);
      //  frame.add(p2); 
       
    //   frame.setLayout(new FlowLayout());
	        //}
	   
	    
	   
		//super();
		
	}

    public static void main(String[] args) throws IOException {   
        
    	//JFrame frame = new JFrame();
    	
        frame.getContentPane().add(new App());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 600);
    //    frame.setMaximumSize(new Dimension(650,700));   //useless code -.-
        frame.setMinimumSize(new Dimension(440,400));      
        frame.setTitle("Gamenaja");
        frame.setVisible(true);
        System.out.println("\t\t"+"|||||||||||||||||||||||||||||||||||");
        System.out.println("\t\t"+"||  Start Adventure  ||");
        System.out.println("\t\t"+"|||||||||||||||||||||||||||||||||||");
        
        //Scanner scanner = new Scanner(System.in);
       
    }
 
//}
    @Override
	    public void actionPerformed(ActionEvent e) {
    	
        if(playing) {
        	if(!IsDead) {											//Is dead=false 
        	if(count<3) {											
	            if (hero.getHp() == 0) {
	            	System.out.println(">>"+"Game over!!!");
	            	
	            }
	           // System.err.println("\t>>"+"count = "+count);
	      		
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
        		System.out.println(">>"+"game is over!!! press start or exit");
        		if(e.getSource().equals(start)) {
        			
        			for(int u = 0;u<count;u++) {
        				pool.back(TombOfBoss.get(u));
        			}
        			startNew();
        			showMonster();
        		}
}
        	
        }
      //  System.err.println("\t>>"+"Bug??? naniiiiiiiiiiiii");
    }
    void showMonster() {
    	if(nmonster>=1) {
    	System.out.println(">>"+"Found Monster : Hp is " + monster.getHp());
    	System.out.println(">>"+"Hero Hp now is " + hero.getHp());
        System.out.println(">>"+"What do you do : Attack(A) Heal(H)");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        }
    }
    void attMonster() {
    	 hero.Attack(monster);
         System.out.println(">>"+"Monster Hp now is " + monster.getHp());
         monster.Attack(hero);
         System.out.println(">>"+"Hero Hp now is " + hero.getHp());
         System.out.println("-----------------------------------------------------------------------------------------------------------");
    }
    void heroHeal() {
    	hero.heal();
        System.out.println(">>"+"Heal!!!!!!!, Hero Hp now is " + hero.getHp());
        System.out.println("-----------------------------------------------------------------------------------------------------------");
    }
    void showBoss() {
    	
    	System.out.println(">>"+"Found Boss : Hp is " + boss.getHp());
    	System.out.println(">>"+"Hero Hp now is " + hero.getHp());
    	System.out.println("-----------------------------------------------------------------------------------------------------------");
    }
    void startNew() {
    	System.out.println(">>"+"Game Start!!!");
    	IsDead=false;
    	hero.Hp=100;
    	nmonster=2;
    	count=0;
    	
    }
    void gameOver() {
    	System.err.println("\t>>"+"Game over");
    	IsDead=true;
    }
    void attBoss() {
    	
    	  hero.Attack(boss);
          System.out.println("\t>>"+"Boss Hp now is " + boss.getHp());
          boss.Attack(hero);
          System.out.println("\t>>"+"Hero Hp now is " + hero.getHp());
          System.out.println("-----------------------------------------------------------------------------------------------------------");
    }
    void checkMonDead() {
    	if(monster.getHp() <= 0 && nmonster>0) {
      	  nmonster--;monster = mon1.clone();   
  	      //System.err.println("\t>>"+"nmonter = " + nmonster);
  	      System.err.println("\t"+"                   |||  Wow Monster Defeated!   |||");
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
         	System.err.println("\t"+"                   |||  Hooo! Boss Defeated!   |||");
		 }else {
			 System.out.println(">>"+"Win!!!");
			 gameOver();
		 }
    }

}