package Book;

public class Book {

	private String name;
	private int index;
	
	private boolean rental=false;

	public Book(String name, int index) {
		this.name = name;
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}
	public String getName() {
		return name;
	}
	
	public void setRental() {
		rental=true;//借りられた;
	}
	
	public void returnRental() {
		rental=false;
	}
	
	public boolean getRental() {
		return rental;
	}
}
