package composant;

// TODO: Auto-generated Javadoc
/**
 * The Class Action.
 */
public class Action {
	
	/** The width. */
	int x,y,height,width;
	
	/** The id. */
	String nom,geometry,id;
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Sets the x.
	 *
	 * @param x the new x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets the y.
	 *
	 * @param y the new y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Sets the width.
	 *
	 * @param width the new width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Sets the nom.
	 *
	 * @param nom the new nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Gets the geometry.
	 *
	 * @return the geometry
	 */
	public String getGeometry() {
		return geometry;
	}
	
	/**
	 * Sets the geometry.
	 *
	 * @param geometry the new geometry
	 */
	public void setGeometry(String geometry) {
		this.geometry = geometry;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Instantiates a new action.
	 */
	public Action() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new action.
	 *
	 * @param x the x
	 * @param y the y
	 * @param height the height
	 * @param width the width
	 * @param nom the nom
	 * @param geometry the geometry
	 * @param id the id
	 */
	public Action(int x, int y, int height, int width, String nom,
			String geometry, String id) {
		super();
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.nom = nom;
		this.geometry = geometry;
		this.id = id;
	}
	

}
