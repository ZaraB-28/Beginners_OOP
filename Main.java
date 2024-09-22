public class Main{

	public static void main(String[] args){

		Artist a1 = new Artist("Henry");
		Artwork art1 = new Artwork("Silver Lining", 2005, a1);
		Artwork art2 = new Artwork("Moon Light", 2016);

		// Simple copy

		Artwork temp = art1;

		// Shallow copy

		Artwork art3 = new Artwork(art2.getTitle(),art2.getYear(),art2.getArtist());

		// Deep copy 

		Artwork art4 = new Artwork(art2.getTitle(),art2.getYear(), new Artist("William"));


	// Display	

	System.out.println(a1);
	System.out.println("************");
	System.out.println(art1);
	System.out.println("************");
	System.out.println(art2);
	System.out.println("************");


	System.out.println(temp);
	System.out.println("************");

	System.out.println(art3);
	System.out.println("************");

	System.out.println(art4);


}

}