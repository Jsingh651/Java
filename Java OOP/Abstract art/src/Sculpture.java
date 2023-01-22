
public class Sculpture extends Art {
	public String material;
	
	public Sculpture(String title, String author, String description, String material) {
		super(title, author,description );
		this.material = material;
	}
	
	
//	 GETTERS AND SETTERS

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
}