public class Museum {

	public static void main(String[] args) {
		Painting painting1 = new Painting("The first painting", "Jang", "It's a painting", "Colors");
		Painting painting2 = new Painting("The second painting", "Chris", "It's a second painting", "Crayons");
		Painting painting3 = new Painting("The third painting", "Jason", "It's a third painting", "Pencils");
		
		Sculpture sculpture1 = new Sculpture("The first Sculture", "Kaylee", "Its a Sculpture", "Grass");
		Sculpture sculpture2 = new Sculpture("The second Sculture", "brown", "Its a second Sculpture", "Water");

		System.out.println(painting1.getTitle());
		System.out.println(painting2.getTitle());
		System.out.println(painting3.getDescription());
		System.out.println(sculpture1.getAuthor());
		System.out.println(sculpture2.getMaterial());

	}
}
