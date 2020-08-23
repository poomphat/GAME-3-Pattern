package aa;

public abstract class Character implements Cloneable {
	public Integer Hp, Atk;
	public void Attack(Character target) {
        target.Hp -= this.Atk;
        if (target.Hp < 0){
        	target.Hp = 0;
        }
	}
}
