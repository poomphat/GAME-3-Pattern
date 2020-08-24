package aa;

import java.util.ArrayList;
import java.util.List;

public class EnemyPool {
	List<Boss> Pool = new ArrayList<Boss>();
    List<String> UsePool = new ArrayList<String>();
    String pop;
    

    
	int MaxPool = 3;
	public EnemyPool(){
			
		
	}
	
    public int getMaxPool() {
    	return MaxPool;
    }
    public Boss borrow() {
    	if ((Pool.size() == 0)&&(UsePool.size()<=MaxPool)) { 
    		UsePool.add("Boss");
    		return new Boss();
    	}
    	else {
    		UsePool.add("Boss");
    		return Pool.remove(0);
    	}
    }
    public void back(Boss boss) {
    	boss.Hp = 200;
    	UsePool.remove(0);
    	Pool.add(boss);
    }
}
