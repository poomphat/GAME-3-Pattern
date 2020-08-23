package aa;

import java.util.ArrayList;
import java.util.List;

public class EnermyPool {
	List<String> Pool = new ArrayList<String>();
    List<String> UsePool = new ArrayList<String>();
    String pop;
	int MaxPool = Pool.size();
	public EnermyPool(){
		Pool.add("Boss");
	    Pool.add("Monster");
	    Pool.add("Boss");
	    Pool.add("Monster");
	    Pool.add("Boss");
	    MaxPool = Pool.size();
	}
	
    
    Monster mon1 = new Monster();
    
    
    
    
    public int getMaxPool() {
    	return MaxPool;
    }
    public String borrow() {
    	return Pool.remove(0);
    }
    public void back(String type) {
    	Pool.add(type);
    }
}
