package aa;

import java.util.ArrayList;
import java.util.List;

public class EnermyPool {
	List<Boss> Pool = new ArrayList<Boss>();
    List<Boss> UsePool = new ArrayList<Boss>();
    String pop;
    

    
	int MaxPool = 3;
	public EnermyPool(){
			
		
	}
	
    
    Monster mon1 = new Monster();
    
    
    
    
    public int getMaxPool() {
    	return MaxPool;
    }
    public Boss borrow() {
    	if ((Pool.size() == 0)&&(UsePool.size()<MaxPool))   			
    		return new Boss();
    	else
    		return Pool.remove(0);
    }
    public void back(Boss boss) {
    	Pool.add(boss);
    }
}
