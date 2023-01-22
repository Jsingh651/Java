import java.util.ArrayList;
import java.util.Collections;

public class Museum {

	public static void main(String[] args) {
//		Painting painting1 = new Painting("The first painting", "Jang", "It's a painting", "Colors");
//		Painting painting2 = new Painting("The second painting", "Chris", "It's a second painting", "Crayons");
//		Painting painting3 = new Painting("The third painting", "Jason", "It's a third painting", "Pencils");
//		
//		Sculpture sculpture1 = new Sculpture("The first Sculture", "Kaylee", "Its a Sculpture", "Grass");
//		Sculpture sculpture2 = new Sculpture("The second Sculture", "brown", "Its a second Sculpture", "Water");
//
//		System.out.println(painting1.getTitle());
//		System.out.println(painting2.getTitle());
//		System.out.println(painting3.getDescription());
//		System.out.println(sculpture1.getAuthor());
//		System.out.println(sculpture2.getMaterial());
		
		
		ArrayList<Art> museum = new ArrayList<Art>();
		museum.add(new Painting("The first painting","Jang","It's a painting","Colors"));
		museum.add(new Painting("The second painting","Chris","It's a second painting","Crayons"));
		museum.add(new Painting("The third painting","kaylee","It's a third painting","marble"));
		museum.add(new Sculpture("The first Sculpture","noednjwc","It's a first scupl","water"));
		museum.add(new Sculpture("The second Sculpture","the artis","It's a second scupl","pudding"));

		
		
		Collections.shuffle(museum);
			for (Art artwork : museum) {
				artwork.viewArt();
			}
		
		

		



	}
}
