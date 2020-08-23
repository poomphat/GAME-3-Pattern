package aa;

public class Boss extends Character{
	private String name;
	private static Boss BossNaja;
	
	public Boss(){

	}
	public static Boss GetBoss(){
		if(BossNaja == null) {
			BossNaja = new Boss();
			BossNaja.name = "BossNaja";
			BossNaja.Hp = 200;
			BossNaja.Atk =20;
		}
		return BossNaja;
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
