public class Artwork{

	private String title;
	private int year;
	Artist a1;

	Artwork(String title, int year, Artist a1){

	this.title = title;
	this.year = year;
	this.a1 = a1;
} 


	Artwork(String title, int year){
	
	this.title = title;
	this.year = year;
	this.a1 = new Artist("Default Artist");
	
}

	public String getTitle(){
	
	return title;
}

	public int getYear(){

	return year;
}

	public Artist getArtist(){
	
	return a1;
}

public String toString(){

	return title + " \n" + year + " \n" + a1;
}


} 