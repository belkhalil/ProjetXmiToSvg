package composant;
public class Finalnod {
	String nom,geometry,id;
	int cx,cy,r;
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
	public int getCx() {
		return cx;
	}
	public void setCx(int cx) {
		this.cx = cx;
	}
	public int getCy() {
		return cy;
	}
	public void setCy(int cy) {
		this.cy = cy;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public Finalnod(String nom, String geometry, String id, int cx, int cy,
			int r) {
		super();
		this.nom = nom;
		this.geometry = geometry;
		this.id = id;
		this.cx = cx;
		this.cy = cy;
		this.r = r;
	}
	public Finalnod() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}