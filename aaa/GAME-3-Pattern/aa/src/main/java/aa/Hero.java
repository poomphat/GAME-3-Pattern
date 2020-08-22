package aa;

public class Hero extends Character{
	private String name;
	private static Hero instance;
	public Hero(){

	}
	public static Hero GetHero(){
		if(instance == null) {
			instance = new Hero();
			instance.name = "Hero";
			instance.Hp = 100;
			instance.Atk =30;
		}
		return instance;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return this.Hp;
	}
}
