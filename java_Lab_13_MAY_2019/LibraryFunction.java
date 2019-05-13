abstract class Item{

	private String u_id;
	private String title;
	private int no_of_copies;

	public String getId(){
		return this.u_id;
	}
	public void setId(String u_id){
		this.u_id = u_id;  
	}

	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;  
	}

	public int getCopies(){
		return this.no_of_copies;
	}
	public void setCopies(int amount){
		this.no_of_copies = amount;  
	}
}

abstract class WrittenItem extends Item{

	private String author_name;

	public String getAuthor(){
		return this.author_name;
	}
	public void setAuthor(String name){
		this.author_name = name;  
	}

}

class Book extends WrittenItem{

	// Book(String u_id, String title, int no_of_copies)
	// {
	

	// }

} 
class JournalPaper extends WrittenItem{

	private String y_of_publish;

	public String getPublishingYear(){
		return this.y_of_publish;
	}
	public void setPublishingYear(String year){
		this.y_of_publish = year;  
	}
}

abstract class MediaItem extends Item{
	private int runtime;

	public int getRuntime(){
		return this.runtime;
	}
	public void setRuntime(int time){
		this.runtime = time;  
	}


}

class Video extends MediaItem{

	private String director;
	private String genre;
	private String y_of_release;

	public String getDirector(){
		return this.director;
	}
	public void setDirector(String name){
		this.director = name;  
	}

	public String getGenre(){
		return this.genre;
	}
	public void setGenre(String name){
		this.genre = name;  
	}

	public String getReleasingYear(){
		return this.y_of_release;
	}
	public void setReleasingYear(String year){
		this.y_of_release = year;  
	}	
}
class CD extends MediaItem{

	private String artist_name;
	private String genre;

	public String getArtist_name(){
		return this.artist_name;
	}
	public void setArtist_name(String name){
		this.artist_name = name;  
	}

	public String getGenre(){
		return this.genre;
	}
	public void setGenre(String gen){
		this.genre = gen;  
	}	
}

class LibraryFunction{

	public static void main(String[] args) {
		
		Book c = new Book();

		c.setId("1000");
		System.out.print("The U_Id is : " + c.getId());
	}
}