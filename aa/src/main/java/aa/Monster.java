package aa;

public class Monster extends Character implements Cloneable{
	private String name;
	public Monster() {
		this.Hp = 50;
		this.Atk = 10;
	}
	public Monster(Monster m) {
		this.Hp = 50;
		this.Atk = 10;
	}
	public Monster clone() {
		return new Monster(this);
	}
	public int getHp() {
		return this.Hp;
	}
	public String getName() {
		return name;
	}
}
