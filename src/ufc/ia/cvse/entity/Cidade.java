package ufc.ia.cvse.entity;

public class Cidade {
	
	private float x;
	private float y;
	private String nome;
	
	public Cidade(String nome, float x2, float y2) {
		this.nome = nome;
		this.x = x2;
		this.y = y2;
	}
	
	public float getX() {	return x; }
	public float getY() {	return y; }
	public String getNome() { return nome; }
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getDistancia(Cidade cidade){
		double x = this.getX()-cidade.getX();
		double y = this.getY()-cidade.getY();
		
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	public String toString(){
		return this.nome;
	}
	
}
