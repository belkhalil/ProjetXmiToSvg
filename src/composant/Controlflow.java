package composant;

public class Controlflow {
	int x1,x2,y1,y2,ye1;
	String nom, geometry,id;
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getX2() {
		return x2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	public int getY2() {
		return y2;
	}
	public void setY2(int y2) {
		this.y2 = y2;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getGeometry() {
		return geometry;
	}
	public void setGeometry(String geometry) {
		this.geometry = geometry;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public int getYe1() {
		return ye1;
	}
	public void setYe1(int ye1) {
		this.ye1 = ye1;
	}
	public Controlflow(int x1, int x2, int y1, int y2, String nom,
			String geometry, String id) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.nom = nom;
		this.geometry = geometry;
		this.id = id;
	}
	public Controlflow() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
