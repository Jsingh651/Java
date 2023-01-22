
public class Painting extends Art{
	public String paintType;
	
	public Painting(String title, String author, String description, String paintType) {
		super(title, author,description);
		this.paintType = paintType;		
}
	
//	GETTERS AND SETTERS

	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}
}
