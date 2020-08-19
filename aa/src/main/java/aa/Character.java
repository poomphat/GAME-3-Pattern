package aa;

public abstract class Character implements Cloneable {
	public Integer Hp, Atk;
	public void Attack(Character target) {
		target.Hp -= this.Atk;
	}
}
